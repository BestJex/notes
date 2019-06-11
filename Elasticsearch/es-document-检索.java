-------------------
�����ĸ����������� |
-------------------
	# ����
		GET /<index>/_search?q=<query>
			
		
		{
		  "took" : 2,
		  "timed_out" : false,
		  "_shards" : {
			"total" : 1,
			"successful" : 1,
			"skipped" : 0,
			"failed" : 0
		  },
		  "hits" : {
			"total" : {
			  "value" : 13,
			  "relation" : "eq"
			},
			"max_score" : 1.0,
			"hits" : [
			  {
				"_index" : "customer",
				"_type" : "_doc",
				"_id" : "TsVMQGsBor31qRgUxQmS",
				"_score" : 1.0,
				"_source" : {
				  "name" : "KevinBlandy"
				}
			  }
			]
		  }
		}

		* �������Ӽ�������q,���ƥ������еļ�¼
		* ���Ĭ��ֻ�����10����¼
	

-------------------
query����		   |
-------------------
	# ���˲���:q
		* 
			* ��������, q=*

		<field>:<value>
			* ��׼ƥ��, q=name:KevinBlandy
	
	# �������:sort
		sort=<field>:<asc/desc>

		* ����ж��, ʹ�ö��ŷָ�:sort=age:asc,_id:desc
	
	# ��ҳ����:size & from
		* size,ÿҳ��ʾ�ļ�¼����
		* from,�ӵڼ������ݿ�ʼ����,0��ʾ��һ��
	
		* deep paging����
			* deep paging,����˵,�����������ر���,����1000000������,ÿҳ��ʾ10��,��ʱ��Ҫ�������һҳ������
			* �������������,���ܴ����ڶ��primary shard,replica shard,���Ǿ�Ҫ���������ݻ��ܵ� coordinating node(Э���ڵ�)
			* ��Э���ڵ��������,ȡ�����������������,���շ�ҳ����
			* ������̺ķѴ���,�ڴ�,�������,�������deep paging����,���ǵĿ�������Ҫ����������

	
	# _source ���ݹ��˲���:
		_source
			* ���������Ƿ�ҪЯ�� _source ����, ֵ������ true/false
			* Ҳ����ͨ���ò�����ָ��Ҫ�������ֶ�
				GET /goods/_doc/1?_source=author.name,author.age
			
		_source_includes
		_source_excludes
			* ����/����ָ���� _source ����
		
		* ֧���ж��ֵ, ʹ�÷�ŷָ�
		* ֧��ͨ���:*
				GET /goods/_doc/1?_source=*.name
	
	# stored_fields
		//TODO
	

-------------------
Ԫ����			   |
-------------------

	took
		* ִ��������ʱ�䣨�Ժ���Ϊ��λ��
	timed_out 
		* �����Ƿ�ʱ
	
		_shards.id
			* �����˶��ٸ���Ƭ
		_shards.successful
			* �����ɹ��ķ�Ƭ����
		_shards.skipped
			* �����ķ�Ƭ����
		_shards.failed
			* ����ʧ�ܵķ�Ƭ����

		hits.total.value
			* �ڰ�������������ƥ����ĵ���������Ϣ�Ķ���
			* ����������ֵ

		hits.total.relation
			* hits.total.value�Ƿ���ȷ�е����м���
			* �����������������"eq"����������������(���ڻ����), �����������������gte

		hits.hits[x].sort
			* �Խ�����������
		
		hits.hits[x]._source
			* ʵ�ʵ��������

	