--------------------
HashMap				|
--------------------
	# �洢�ṹ�ı仯
		* JDK 1.7����ǰʹ�� Hash �� + ����ʵ��
		* JDK 1.8���Ժ�ʹ�� Hash �� + �����ʵ��(�Ż��˲�ѯЧ��)
		* ��������һ����������,�������ת��Ϊ�����
	
	# ����ڵ�ı仯
		* JDK1.7�õ���ͷ�巨, ��JDK1.8��֮��ʹ�õĶ���β�巨
		* ��ΪJDK1.7���õ�������е���������, ������ͷ�巨�����ܹ���߲����Ч��, ����Ҳ�����׳��������һ���������ѭ������
		* ����JDK1.8֮������Ϊ�����˺����ʹ��β�巨, �ܹ��������������������ѭ��������
	
	# Hash��ĳߴ�������ǳ�����Ҫ
		* һ����˵,Hash�����������������Ҫ����ʱ,������������û�г����趨�� thredhold,�������,��Ҫ����hash��ĳߴ�
		* ��������һ��,����hash��������ض���Ҫ������һ��,���rehash,����ɱ��൱�Ĵ�
	
	# �ײ������� + ��������(�����)
		Node<K,V>[] table;
		class Node {
			final int hash;
			final K key;
			V value;
			Node<K,V> next;
		}

	# ���ĵ�����
		static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
			* Ĭ�ϵĴ洢Ͱ��(��С)

		static final int MAXIMUM_CAPACITY = 1 << 30;
			* ���Ĵ洢Ͱ����

		static final float DEFAULT_LOAD_FACTOR = 0.75f;
			* Ĭ�ϵĸ�������, ����ʲôʱ������
				������С x �������� = �������ݵĴ�С

		static final int TREEIFY_THRESHOLD = 8;
			* �����ж��Ƿ���Ҫ������ת��Ϊ���������ֵ
			* �������ĳ��ȴ����˸�ֵ,�����˸�ֵ�ͻ�ת��Ϊ�����

		static final int UNTREEIFY_THRESHOLD = 6;
			* �Ѻ����ת��Ϊ�������ֵ

		static final int MIN_TREEIFY_CAPACITY = 64;

		transient Node<K,V>[] table;
		transient Set<Map.Entry<K,V>> entrySet;
		int size;
			* �洢����������

		int modCount;
			* �޸ĵĴ���

		float loadFactor;
			* ��������
		
		int threshold;
			* ����Map��С����һ��ֵ

	
	# HashMap �ڲ���������ʹ��ʱ���׳������� 
		* ���߳�put������,get����������ѭ��(��˵jdk8�޸����������)
			HashMap<String, String> map = new HashMap<String, String>();
			for (int i = 0; i < 1000; i++) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						map.put(UUID.randomUUID().toString(), "");
					}
				}).start();
			}

			* HashMap ���ݵ�ʱ������ resize() ����
			* ����Ĳ�������������һ��Ͱ���γɻ�������
				* ����ȡһ�������ڵ� key ʱ,������� index �����ǻ���������±�ͻ������ѭ��

		
		* ���߳�put��nullԪ�غ�,get�����õ�nullֵ(����Ԫ�ض�ʧ,�������jdk8û���޸�)
		
	

	