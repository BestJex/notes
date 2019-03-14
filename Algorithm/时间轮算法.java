# ʱ�����㷨
	*  ��ʱ�����������,һ���ǿ������߳�,��һ���ǿ�һ���������Ȼ����ɨ��
	*  �Զ��׼������ַ�ʽ�ı׶˺�����,ǰ�߶��߳����Ĺ���,���߶�ʱ�����Ĺ���(�ܶ�δ��ʱ�������ᱻ����ظ�ɨ����������)

# �ο�
	https://github.com/wolaiye1010/zdc-java-script

# ʱ�����㷨�ǻ���ѭ���������ݽṹ

# �����ؼ��ĸ���
	ticksPerWheel	
		* һ�ֵ�tick��

	tickDuration
		* һ��tick�ĳ���ʱ��
		* timeUnit
	



import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TimingWheel<E> {
	// һ��tick�ĳ���ʱ��
	private final long tickDuration;
	// tick����
	private final int ticksPerWheel;
	// ��ǰtick��ָ��
	private volatile int currentTickIndex = 0;

	// ���ڵ�����
	private final CopyOnWriteArrayList<ExpirationListener<E>> expirationListeners = new CopyOnWriteArrayList<ExpirationListener<E>>();
	
	// �̶Ȳ��
	private final ArrayList<Slot<E>> wheel;
	
	// ָʾ��
	private final Map<E, Slot<E>> indicator = new ConcurrentHashMap<E, Slot<E>>();

	// �Ƿ�shutdown
	private final AtomicBoolean shutdown = new AtomicBoolean(false);
	
	// ��
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	
	// �����߳�
	private Thread workerThread;

	/**
	 * @param tickDuration ÿһ�̶Ⱥ���
	 * @param ticksPerWheel �̶ȶ���
	 * @param timeUnit ��λ
	 */
	public TimingWheel(int tickDuration, int ticksPerWheel, TimeUnit timeUnit) {
		if (timeUnit == null) {
			throw new NullPointerException("unit");
		}
		if (tickDuration <= 0) {
			throw new IllegalArgumentException("tickDuration must be greater than 0: " + tickDuration);
		}
		if (ticksPerWheel <= 0) {
			throw new IllegalArgumentException("ticksPerWheel must be greater than 0: " + ticksPerWheel);
		}
		
		// ʵ�������
		this.wheel = new ArrayList<Slot<E>>();
		this.tickDuration = TimeUnit.MILLISECONDS.convert(tickDuration, timeUnit);
		this.ticksPerWheel = ticksPerWheel + 1;

		for (int i = 0; i < this.ticksPerWheel; i++) {
			// ��Ӳ������Ķ���
			wheel.add(new Slot<E>(i));
		}
		
		wheel.trimToSize();

		// ʵ���������߳�
		workerThread = new Thread(new TickWorker(), "Timing-Wheel");
	}

	public void start() {
		if (shutdown.get()) {
			throw new IllegalStateException("Cannot be started once stopped");
		}

		if (!workerThread.isAlive()) {
			// ���������߳�
			workerThread.start();
		}
	}

	public boolean stop() {
		if (!shutdown.compareAndSet(false, true)) {
			return false;
		}

		boolean interrupted = false;
		while (workerThread.isAlive()) {
			workerThread.interrupt();
			try {
				workerThread.join(100);
			} catch (InterruptedException e) {
				interrupted = true;
			}
		}
		if (interrupted) {
			Thread.currentThread().interrupt();
		}

		return true;
	}

	public void addExpirationListener(ExpirationListener<E> listener) {
		expirationListeners.add(listener);
	}

	public void removeExpirationListener(ExpirationListener<E> listener) {
		expirationListeners.remove(listener);
	}

	public long add(E e) {
		synchronized (e) {
			checkAdd(e);
			int previousTickIndex = getPreviousTickIndex();
			Slot<E> slot = wheel.get(previousTickIndex);
			slot.add(e);
			indicator.put(e, slot);
			return (ticksPerWheel - 1) * tickDuration;
		}
	}

	private void checkAdd(E e) {
		Slot<E> slot = indicator.get(e);
		if (slot != null) {
			slot.remove(e);
		}
	}

	private int getPreviousTickIndex() {
		lock.readLock().lock();
		try {
			int cti = currentTickIndex;
			if (cti == 0) {
				return ticksPerWheel - 1;
			}

			return cti - 1;
		} finally {
			lock.readLock().unlock();
		}
	}

	public boolean remove(E e) {
		synchronized (e) {
			Slot<E> slot = indicator.get(e);
			if (slot == null) {
				return false;
			}

			indicator.remove(e);
			return slot.remove(e) != null;
		}
	}

	private void notifyExpired(int idx) {
		
		// ��ȡ��ǰ��۵�Slot
		Slot<E> slot = wheel.get(idx);
		
		// ��ȡ����Slot�е�����Set
		Set<E> elements = slot.elements();
		
		for (E e : elements) {
			// ��Slot���Ƴ�����
			slot.remove(e);
			synchronized (e) {
				// ��ָʾ����ȡ���������
				Slot<E> latestSlot = indicator.get(e);
				if (latestSlot.equals(slot)) {
					indicator.remove(e);
				}
			}
			for (ExpirationListener<E> listener : expirationListeners) {
				// ���������¼�
				listener.expired(e);
			}
		}
	}

	private class TickWorker implements Runnable {

		private long startTime;
		
		private long tick;

		@Override
		public void run() {
			// ʱ���ֿ�ʼʱ��
			startTime = System.currentTimeMillis();
			tick = 1;
			for (int i = 0; !shutdown.get(); i++) {
				if (i == wheel.size()) {
					// ����ָ��
					i = 0;
				}
				lock.writeLock().lock();
				try {
					// ͬ������ָ��λ��
					currentTickIndex = i;
				} finally {
					lock.writeLock().unlock();
				}
				
				// ���ѵ�������
				notifyExpired(currentTickIndex);
				
				waitForNextTick();
			}
		}
		
		// �ƶ�����һ���̶�
		private void waitForNextTick() {
			for (;;) {
				long currentTime = System.currentTimeMillis();
				// �߳���ͣʱ�� = ÿ���̶Ⱥ�ʱ * �̶� - (��ʼʱ�� - ����ʱ��)
				long sleepTime = tickDuration * tick - (currentTime - startTime);

				if (sleepTime <= 0) {
					break;
				}

				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					return;
				}
			}

			tick++;
		}
	}

	private static class Slot<E> {

		private int id;
		private Map<E, E> elements = new ConcurrentHashMap<E, E>();

		public Slot(int id) {
			this.id = id;
		}

		public void add(E e) {
			elements.put(e, e);
		}

		public E remove(E e) {
			return elements.remove(e);
		}

		public Set<E> elements() {
			return elements.keySet();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			@SuppressWarnings("rawtypes")
			Slot other = (Slot) obj;
			if (id != other.id)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Slot [id=" + id + ", elements=" + elements + "]";
		}
	}
}

public interface ExpirationListener<E> {
	
	void expired(E expiredObject);
}
