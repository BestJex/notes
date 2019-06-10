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

--------------------
document - ����		|
--------------------
	# ȫ���滻����(PUT)
		PUT /<index>/_doc/<id>
		{...}

		{
		  "_index" : "customer",
		  "_type" : "_doc",
		  "_id" : "1",
		  "_version" : 2,
		  "result" : "updated",
		  "_shards" : {
			"total" : 2,
			"successful" : 1,
			"failed" : 0
		  },
		  "_seq_no" : 1,
		  "_primary_term" : 1
		}
		
		* �൱��ִ����һ�θ���
		* ���id�Ѿ�����,��ôԭ����document���ᱻ����ɾ��,���ǻᱻ���Ϊ: delete
		* ��es������Խ��Խ���ʱ��,es���ں�̨�Լ����İѱ��Ϊ:delete ��document����ɾ����
		* _version ʼ�ջ� +1
	
	# ǿ�Ƹ���(ȫ������)
		POST /<index>/_doc/<id>
		{...}

		* ��������Ҫ�ύ�����ֶ�,�����ڵ��ֶλᱻɾ��
		* ���ܱ����ύ,�Ƿ��гɹ��޸��ֶ�,resultֵ��ԶΪ:'updated'
		* ���������޸�,_version�ֶαػ��1
		* �������Ϊǿ�Ƹ���
		* ���ָ��id�����ݲ�����(����δָ��id), ��ᴴ��, �� "result" = "created"
	
	# ��ǿ�Ƹ���(���ָ���)
		POST /<index>/_update/<id>
		{"doc":{...}}

		{
		  "_index" : "customer",
		  "_type" : "_doc",
		  "_id" : "1",
		  "_version" : 5,
		  "result" : "noop",
		  "_shards" : {
			"total" : 0,
			"successful" : 0,
			"failed" : 0
		  }
		}


		* ���ַ�ʽ,�ύ��JSON�������仯
			{
				"doc":{
					//��Ҫ�޸ĵ��ֶ�
				}
			}

		* ���Խ����ύ������Ҫ���µ��ֶ�
		* ��������ύδ�޸����ݵĻ�,��ôresult�ֶ�ֵΪ:'noop',����û��:'_seq_no'��'_primary_term'�ֶ�,
		* �����ύ���޸����ݵ���,��ǿ�Ƹ��µķ��ؽ����һ����
		* ֻ�����������޸ĵ�ʱ��,version +1
		* �������Ϊ��ǿ�Ƹ���
		* partial update(���ָ���)
	
	# Ҳ֧��ʹ�ýű����Ը���
		POST /<index>/_update/<id>
		{
		  "script" : "ctx._source.age += 5"
		}

		* ���忴�ű�
	
	# ����ʱ, Elasticsearch����ɾ�����ĵ�, Ȼ��һ���Զ�Ӧ���˸��µ����ĵ���������

	
--------------------
document - ɾ��		|
--------------------
	# �����ĸ���idɾ��
		DELETE /<index>/_update/<id>?pretty

		{
		  "_index" : "customer",
		  "_type" : "_doc",
		  "_id" : "11",
		  "_version" : 3,
		  "result" : "deleted",
		  "_shards" : {
			"total" : 2,
			"successful" : 1,
			"failed" : 0
		  },
		  "_seq_no" : 23,
		  "_primary_term" : 1
		}

		* ���ɾ�������ݲ�����, ��"result" = "not_found"
		* �����Ҫɾ�����е�doc, ����ֱ��ɾ����������,��������Ч
	
	
	# document���ᱻ����������ɾ��,ֻ�ᱻ���Ϊdelete,������Խ��Խ�������,�ں�̨�Զ���ɾ��
		
