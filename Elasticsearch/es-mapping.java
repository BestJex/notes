------------------------
mapping					|
------------------------
	# ����ϵ�����ݿ��DDLһ��, ����洢����������, ����ɶ��


	# �鿴ָ��������mapping
		GET /<index>/_mapping

	# mapping�Ľṹ
		{
			"<index>":{
				"mappings":{
					"properties":{
						"<field>":{

						}
					}
				}
			}
		}

		* properties �¾���ÿ���ֶζ�Ӧ��'����'
			- ��������
			- ��ηִ�
			- ... ...
		* properties �����¿���Ƕ�� properties
	

	
	# mapping �����ڴ��� index ֮ǰ����

	# mapping Ҳ�����ڴ��� index ֮���޸�

	
------------------------
mapping	�ֶ�����		|
------------------------
	# type
		* �ֶε���������, ������ֶ�����, ���Զ�����

		text
		date
		long

------------------------
mapping	�ֶ�����		|
------------------------
	{
	  "<index>" : {
		"mappings" : {
		  "properties" : {
			"<field>" : {
			  "properties" : {
				"<field>" : {
				  "type" : "text",
				  "fields" : {
					"keyword" : {
					  "type" : "keyword",
					  "ignore_above" : 256
					}
				  }
				}
			  }
			},
			"<field>" : {
			  "type" : "text",
			  "fields" : {
				"keyword" : {
				  "type" : "keyword",
				  "ignore_above" : 256
				}
			  }
			},
			"<field>" : {
			  "type" : "date"
			},
			"<field>" : {
			  "type" : "long"
			}
		  }
		}
	  }
	}
