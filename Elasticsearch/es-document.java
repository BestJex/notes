--------------------
document			|
--------------------


--------------------
document - ����		|
--------------------
	# �����Ĵ���
		PUT /<index>/_doc/<id>?pretty
		{...}

		{
		  "_index" : "customer",
		  "_type" : "_doc",
		  "_id" : "1",
		  "_version" : 4,
		  "result" : "updated",
		  "_shards" : {
			"total" : 2,
			"successful" : 1,
			"failed" : 0
		  },
		  "_seq_no" : 3,
		  "_primary_term" : 1
		}
		
		_shards.total
			* ִ�����������ķ�Ƭ����(����Ƭ�͸�����Ƭ)������

		_shards.successful
			* �����ɹ��ĸ�������

		_shards.failed
			* ����ʧ�ܵĸ�������

		

		* ���Index������, ���Զ��Ĵ���
		* PUT��ʽ, �����ֶ���ָ��id����

	# ʹ��POST����
		POST /<index>/_doc
		{...}

		* POST��ʽ, �����ָ��id�Ļ�, ϵͳ�Զ�Ϊdoc����һ��uuid(VMVNQGsBor31qRgUZwnr)

	# ǿ�ƴ���
		* ���ֻ���½��ĵ�,�����滻�ĵ�,��ô����Ҫǿ�ƴ���(���ַ�ʽ)

		PUT /<index>/_doc/<id>?op_type=create

		PUT /<index>/_doc/<id>/_create
			* ���ַ�ʽ�Ƚϳ���
	
		* �����id��document�Ѿ�����,��ô����PUT�ɹ�,���׳��쳣


--------------------
document - ����		|
--------------------
	# �����ĸ���id����
		GET /<index>/_doc/<id>

		{
		  "_index" : "customer",
		  "_type" : "_doc",
		  "_id" : "1",
		  "_version" : 4,
		  "_seq_no" : 3,
		  "_primary_term" : 1,
		  "found" : true,
		  "_source" : {
			...
		  }
		}
	
	# ����id�ж��Ƿ����, ʹ�� HEAD ����
		HEAD /<index>/_doc/<id>

		����:200 - OK
		����:404 - Not Found

	
------------------------------------
document ·��						|
------------------------------------
	# document ·�ɵ� shard
		* index ���ݻᱻ��Ƭ������shard���Ǹ�,����һ��documentֻ�����һ��shard
		* ����� document Ӧ���ڴ����ĸ�shard,��ʵ����·��

	# ·���㷨
		* shard = hash(routing) % number_of_primary_shards
			> routing Ĭ��Ϊ document�� id(�����ֶ�ָ��)
			> hash�㷨
			> number_of_primary_shards : primary shad������

		* �ֶ�ָ�� routing
			PUT /<index>/<id>?routing=15
			GET /<index>/<id>?routing=15

			> ͨ�������ֶ�ָ��routing value������,���Ա�֤,ĳһ��documentһ����·�ɵ�һ��shard��
			> ��ô�ں�������Ӧ�ü���ĸ��ؾ���,�Լ�����������ȡ���ܵ�ʱ��,�Ǻ��а�����

	# primary shard �������ɱ�
		* һ�������仯��,��ô��ȡģ�㷨ʱ,�ͻ�������,���ӵ������ݶ�ʧ
		* ���� replica shard����������ɾ

----------------------------
 �ֹ�����������				|
----------------------------
	# �ĵ�
		https://www.elastic.co/guide/en/elasticsearch/reference/current/optimistic-concurrency-control.html


	# �����Ľ���л��������Ԫ����
		{
		  ...
		  "_seq_no" : 28,
		  "_primary_term" : 1
		}
	
		
	# CAS����
		PUT /<index>/_doc/<id>?if_seq_no=<_seq_no>&if_primary_term=<_primary_term>
		
		POST /<index>/_doc/<id>?if_seq_no=<_seq_no>&if_primary_term=<_primary_term>

		POST /<index>/_update/<id>?if_seq_no=<_seq_no>&if_primary_term=<_primary_term>


		* ͨ����ѯ����: if_seq_no �� if_primary_term �����ư汾��,�������ʧ��, �׳��쳣
			{
			  "error": {
				"root_cause": [
				  {
					"type": "version_conflict_engine_exception",
					"reason": "[1]: version conflict, required seqNo [8], primary term [1]. current document has seqNo [9] and primary term [1]",
					"index_uuid": "NhO0l2JpRW-MwwnQpjexcA",
					"shard": "0",
					"index": "goods"
				  }
				],
				"type": "version_conflict_engine_exception",
				"reason": "[1]: version conflict, required seqNo [8], primary term [1]. current document has seqNo [9] and primary term [1]",
				"index_uuid": "NhO0l2JpRW-MwwnQpjexcA",
				"shard": "0",
				"index": "goods"
			  },
			  "status": 409
			}
		
		* ����ǲ��ָ���, ��ôֻ���ڸ��³ɹ�(���µ��������޸�)��ʱ��Ż�ȥ�жϰ汾��

----------------------------
�汾����					|
----------------------------
	# ÿ��doc����һ�� version �ֶ�
		{
		  "_version" : 20,
		}

		 * Ĭ�ϴ�1��ʼ, ����ÿ�θ���ʱ����, ����ɾ��
		 
	# ִ���޸�ʱ, ʹ�ð汾��
		PUT /<index>/_doc/<id>?version=<_version>&version_type=<version_type>
		{
			"message" : "elasticsearch now has versioning support, double cool!"
		}

		* CAS����,���ʹ��doc�ڲ��İ汾����, ʹ�� if_seq_no �� if_primary_term 
		* CAS����,���ʹ���ⲿ�İ汾��, ��ʹ�� version
	
	# version_type ,ö��ֵ
		internal
			* ���ڸ����汾��洢�ĵ��İ汾��ͬʱ�Ŷ��ĵ���������
			* �Ѿ���֧����: internal versioning can not be used for optimistic concurrency control. Please use `if_seq_no` and `if_primary_term` instead

		external / external_gt
		external_gte

	# ���԰Ѱ汾�Ž����ⲿ�������, external version
		* es�ṩ��һ��feature,���Բ�ʹ�����ݲ���_version�汾�������в�������
		* ���Ի����Լ�ά����'version�汾��'�����в�������
		* ʹ�ó���
			��mysql��Ҳ����һ������,Ӧ��ϵͳ�����ά����һ���汾��,��ʱʹ���ֹ������Ƶ�ʱ��,����ʹ��es��version,������ʹ��Ӧ��ϵͳ�е�version
		
		* version�����﷨
			?version=<_version>&version_type=external

		* �� version_type=external ��ʱ��,version��������Ҫ���ڵ�ǰ��_version���ܸ��³ɹ�
		* ���޸ĳɹ���,���һ��document��_version�޸�Ϊversion������ֵ

---------------------------
���Ƭ				   |
---------------------------
	# ִ����ɾ�ĵ�ʱ��, ����ͨ����Ƭ�Ļ�Ծ������֤дһ����
	# ElasticSearch 5.0֮��ʹ�� wait_for_active_shards ������consistency ��ָ��дһ���Լ���
		POST /<index>/_doc/<id>?wait_for_active_shards=1

	# ��Чֵ��all���κ�������
		all
			* ���е�primary shard��replica shard���ǻ�Ծ��,�ſ���ִ��

		�κ�������
			* TODO

	# �����Ծ�ڵ���������ָ��������,���ܻᵼ���޷�ִ��д����
		* Ծ�ڵ���������ָ��������ʱ,Ĭ�� wait 1����(������Ծ��shard��������)
		* ����ͨ�� timeout ����������(��λĬ���Ǻ���,����ͨ�����s������Ϊ��)
			PUT /<index>/_doc/<id>?timeout=60s

---------------------------
����ˢ��				   |
---------------------------
	# д����ֻ��������Ƭִ��, ����Ƭд���, ��ͬ������������
		* ���ܵ��µ��������, ����Ƭ��δͬ����������Ƭ, ���Ѿ���Ӧ���ͻ��˳ɹ���Ϣ
		* �ͻ����ٴμ�����������Ƭ, ���ڻ�δͬ�����, ���Լ�����������
		
	# ����ͨ������������, �Ƿ�Ҫ�ȵ�����ͬ�����, �ŷ��ظ��ͻ��˳ɹ�

	# ͨ��query��������:refresh
		true (���ַ���Ҳ����)
			* ǿ��ִ��ˢ��
			* ���������ͻ���, �����ڿͻ��˵Ĳ�����Ӧ������ˢ����ص�����Ƭ�͸�����Ƭ

		wait_for
			* �ȴ�ˢ�µķ���
			* �������ͻ���, ����Ӧ֮ǰ, �ȴ�ˢ�����������ĸ���, �ⲻ��ǿ������ˢ��, ���ǵȴ�ˢ�·���
			* ES ��ÿ index.refresh_interval(Ĭ��ֵΪ1��)�Զ�ˢ���Ѿ����ĵ���Ƭ, ��������Ƕ�̬��
			* ����Refresh API�����κ�֧������API�Ͻ�refresh����ΪtrueҲ�ᵼ��ˢ��, �Ӷ������Ѿ����еĴ���refresh=wait_for��������Ӧ


		false (Ĭ��)
			* ���ȴ�ˢ��, ��������
	
		PUT  /<index>/_doc/<id>?refresh=false
	
	# refresh=wait_for Ҳ����ǿ��ˢ��
		* ����������� index.max_refresh_listener(Ĭ������Ϊ1000)
		* ����ȴ�ˢ�µ������, �Ǹ���Ƭ�ϳ���refresh=wait_for����, ��ô���������Ϊ�ͺ������Ѿ���refresh����Ϊtrueһ��
		* ����ǿ��ˢ��, �Ᵽ֤�˵�refresh=wait_for���󷵻�ʱ, ���ĸ��Ķ��������ǿɼ���, ͬʱ��ֹ�Ա�����������ʹ��δ������Դ

		* ���һ��������Ϊ�ľ��˼�������۶�ǿ��ˢ��, ��ô������Ӧ������"forced_refresh": true
