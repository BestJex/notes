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
	
	# ��׼ƥ��ָ�����ֶ�����
		{
		  "query": { "match": { "<field>": <value> } }
		}

		* �������ƥ�����ֶ�, ��ô value �����ж��, ʹ�ö��ŷָ�
			{
			  "query":{"match": {"name":"Litch Rocck"}} //name = "Litch" or name = "Rocck"
			}
		
		* �����������ȷʵ�пո�,��Ҫ��׼ƥ����ô��Ҫʹ��:match_phrase
			{
			  "query":{"match_phrase": {"name":"Litch Rocck"}} //name = "Litch Rocck"
			}

------------------------------
DSL	bool					  |
------------------------------
	# �Ѷ������ʹ�ò����߼�����С�Ĳ�ѯ��ɸ���Ĳ�ѯ
	# filter
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


	