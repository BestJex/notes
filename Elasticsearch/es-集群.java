----------------------------
��Ⱥ						|
----------------------------
	# �ĵ�
		https://www.elastic.co/guide/en/elasticsearch/reference/current/discovery-settings.html	
	
	# ES�����˷ֲ�ʽϵͳ�еĺܶิ������
		* ���ݷ�Ƭ����, ���ݻᱻ��ƬΪ���shard, �ֲ�ʽ�Ĵ洢�ڲ�ͬ�Ľڵ�
		* ��Ⱥ���ֻ���, �������½ڵ�ļ�����˳�
		* shard���ؾ���, shard Ҫƽ���ķ��䵽��ͬ�Ľڵ�
		* shard�����·���, �ڽڵ�������ʱ��, ���Զ��ľ���ÿ���ڵ�� shard
	
	# Shard
		* Primary Shard, �ֲ�ʽ�洢
			* һ��doc�϶�������һ�� Primary Shard
			* Primary Shard�ڴ�����ʱ����Ѿ�ȷ��, �����޸�, Ĭ����5��Primary Shard

		* Replica Shard, ����
			* ÿ��Primary Shard Ĭ����1�� Replica Shard, ����index������������޸�
		
		* Master Shard�������д����, Replica Shard�������������
		* Master Shard��Replica Shard������ͬһ���ڵ�, ����ڵ�崻�, ���Ӷ�����ʹ��, �����ݴ�
		* Master Shard崻�, ĳ��Replica Shard���Զ���ΪMaster Shard
	



----------------------------
��صĶ˵�					|
----------------------------
	GET /_cluster/health
	GET /_cat/health?
	GET /_cat/nodes?v







