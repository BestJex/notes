--------------------
HashMap				|
--------------------
	# JDK 1.7����ǰʹ�� Hash �� + ����ʵ��
	# JDK 1.8���Ժ�ʹ�� Hash �� + �����ʵ��(�Ż��˲�ѯЧ��)
		* ��������һ����������,�������ת��Ϊ�����
	
	# Hash��ĳߴ�������ǳ�����Ҫ
		* һ����˵,Hash�����������������Ҫ����ʱ,������������û�г����趨��thredhold,�������,��Ҫ����hash��ĳߴ�
		* ��������һ��,����hash��������ض���Ҫ������һ��,���rehash,����ɱ��൱�Ĵ�
	
	# ���ĵĳ�Ա����
		static final int TREEIFY_THRESHOLD = 8;
			* �����ж��Ƿ���Ҫ������ת��Ϊ���������ֵ
			* �������ĳ��ȴ����˸�ֵ,�����˸�ֵ�ͻ�ת��Ϊ�����
		
		int size;
			* �洢����������

		int modCount;
			* �޸ĵĴ���

		float loadFactor;
			* ��������,������ʲôʱ��ᴥ������
				������С x �������� = �������ݵĴ�С
		
		int threshold;
			* ����Map��С����һ��ֵ

		Node<K,V>[] table;
			* ������ݵ�����

		Set<Map.Entry<K,V>> entrySet;
	
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
			

		
	
