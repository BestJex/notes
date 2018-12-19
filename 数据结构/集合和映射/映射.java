--------------------
ӳ��				|
--------------------
	# ��ʵ���� Map
	# ����ʹ��������߶���������ʵ��
		class Node<K,V>{
			K key;
			V value;
			Node next;
		}
		class Node<K,V>{
			K key;
			V value;
			Node left;
			Node right;
		}
	
	# �����ķ���
		add(k,v);
		v remove(k);
		boolean contains(k);
		v get(k);
		void set(k,v);
		int size();
		boolean isEmpty();

	
--------------------
��������ʵ�ֵ�Map	|
--------------------
import java.util.function.BiConsumer;

public class LinkedMap<K, V> {
	private class Node {
		private K key;
		private V value;
		private Node next;

		public Node(K key, V value, LinkedMap<K, V>.Node next) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public Node() {
			this(null, null, null);
		}

		@Override
		public String toString() {
			return "Node [key=" + key + ", value=" + value + ", next=" + next + "]";
		}
	}

	private int size;

	private Node dummyHead;

	public LinkedMap() {
		this.dummyHead = new Node();
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean empty() {
		return this.size == 0;
	}

	private Node getNode(K key) {
		Node node = this.dummyHead.next;
		while (node != null) {
			if (node.key.equals(key)) {
				return node;
			}
			node = node.next;
		}
		return null;
	}

	public boolean contains(K key) {
		return this.getNode(key) != null;
	}

	public V get(K key) {
		Node node = this.getNode(key);
		return node == null ? null : node.value;
	}

	public void add(K key, V value) {
		Node node = this.getNode(key);
		if (node != null) {
			// ����
			node.value = value;
		} else {
			// ֱ�Ӳ��뵽ͷ�ڵ�
			this.dummyHead.next = new Node(key, value, this.dummyHead.next);
			this.size++;
		}
	}

	public void set(K key, V value) {
		Node node = this.getNode(key);
		if (node != null) {
			node.value = value;
		}
		throw new IllegalArgumentException("key \"" + key + "\"not found");
	}

	public V remove(K key) {
		Node pre = this.dummyHead;
		while (pre.next != null) {
			if (pre.next.key.equals(key)) {// ��ȡ��Ҫɾ���ڵ����һ���ڵ�
				break;
			}
			pre = pre.next;
		}
		if (pre.next != null) {
			Node delNode = pre.next;
			pre.next = delNode.next;
			this.size--;
			return delNode.value;
		}
		// ���������Ҳû�ҵ�Ҫɾ���Ľڵ�
		throw new IllegalArgumentException("key \"" + key + "\"not found");
	}

	public void forEach(BiConsumer<K, V> consumer) {
		Node node = this.dummyHead;
		while (node.next != null) {
			consumer.accept(node.next.key, node.next.value);
			node = node.next;
		}
	}
}
