------------------------
���ؾ���				|
------------------------
	# Producer�����㷨
		* kafka��Ⱥ�е��κ�һ��broker,��������producer�ṩmetadata��Ϣ
		* ��Щmetadata�а���"��Ⱥ�д���servers�б�"/"partitions leader�б�"����Ϣ(��ο�zookeeper�еĽڵ���Ϣ)
		* ��producer��ȡ��metadata��Ϣ֮��, producer�����Topic������partition leader����socket����
		
		* ��Ϣ��producerֱ��ͨ��socket���͵�broker,�м䲻�ᾭ���κ�"·�ɲ�"
		* ��ʵ��,��Ϣ��·�ɵ��ĸ�partition��,����producer�ͻ��˾���
		* ������Բ���"random","key-hash","��ѯ"��
		* ���һ��topic���ж��partitions,��ô��producer��ʵ��"��Ϣ����ַ�"�Ǳ�Ҫ��
		* ��producer�˵������ļ���,����ָ��partition·�ɵķ�ʽ
	

