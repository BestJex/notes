------------------------------
DSL							  |
------------------------------
	# �ĵ�
		https://www.elastic.co/guide/en/elasticsearch/reference/current/query-dsl.html
	
------------------------------
DSL	query					  |
------------------------------
	# ƥ������
		{"query": { "match_all": {} }}
	
	# �������(ȫ�ļ���)
		{
		  "query": { "match": { "<field>": <keyworlds> } }
		}

		* �������ƥ�����ֶ�, ��ô keyworlds �����ж��, ʹ�ö��ŷָ�
			{
			  "query":{"match": {"name":"Litch Rocck"}} //name = "Litch" or name = "Rocck"
			}
	
	# ��׼����
		* ������ȫ������key=value,�ŷ�������
			{
			  "query":{"match_phrase": {"name":"Litch Rocck"}} //name = "Litch Rocck"
			}
	
	# HTTPЭ��涨GETû��������,һ��Ҳ������GET�������body,��GET�����ʺ��ڼ�������
		* ���������֧�ֵĳ���,Ҳ����ʹ��POST���� +  _search �˵�
			POST /<index>/_search

------------------------------
DSL	bool					  |
------------------------------
	# �Ѷ������ʹ�ò����߼�����С�Ĳ�ѯ��ɸ���Ĳ�ѯ
	# and ��ϵ��:must
		{
		  "query": {
			"bool": {
			  "must": [
				{ "match": { "name": "KevinBlandy" } },
				{ "match": { "age": "23" } }
			  ]
			}
		  }
		}
		* ��bool����һ���ж�����:name = "KevinBlandy" and age = "23"
	
	# or��ϵ��:should
		{
		  "query": {
			"bool": {
			  "should": [
				{ "match": { "name": "Litch" } },
				{ "match": { "name": "Roccl" } }
			  ]
			}
		  }
		}
		* �� bool ����һ���ж�����:name = "Litch" or name = "Roccl"
		
	# ���ȡ����:must_not
		{
		  "query": {
			"bool": {
			  "must_not": [
				{ "match": { "name": "Litch" } },
				{ "match": { "name": "Roccl" } }
			  ]
			}
		  }
		}
		* �� bool ����һ���ж�����:name != "Litch" and name != "Roccl"
	
	# ��������������
		{
		  "query":{
			"bool":{
			  "should": [{
				  "match": {
				  "name": "Litch"
				}}
			  ],
			  "must_not": [{
				  "match": {
				  "age": 24
				}}
			  ]
			}
		  }
		}
		* �� bool ����һ���ж�����:name = "Litch" and 24 != 24

------------------------------
DSL	filter					  |
------------------------------
	# ����, ʹ�ò�ѯ�����ƽ��������Ӿ�ƥ����ĵ�, ��������ļ�������ķ�ʽ
		{
		  "query":{
			"bool":{
			  "must":{
				"match_all":{}
			  },
			  "filter":{
				"range":{
				  "<field>":{
					"<operation>": <value>
				  }
				}
			  }
			}
		  } 
		}

		* operation ������:
			gtlt
			le
			ge
			ne

------------------------------
DSL	��ҳ					  |
------------------------------
	# ʹ�� from & size		
		{"from":0,	"size":10}

------------------------------
DSL	����					  |
------------------------------
	# ʹ�� sort
		{"sort": { "<field>": { "order": "<desc/asc>" } }}

------------------------------
DSL	���ƽ����				  |
------------------------------
	# ʹ�� _source
		{
			"_source": ["<field1>", "<field2>"]
		}

		* ͨ�� _source ָ��n���Ҫ�������ֶ�, �ֶ�֧�ֶ��󵼺�


	