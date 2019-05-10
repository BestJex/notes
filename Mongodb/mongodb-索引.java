----------------------------
����						|
----------------------------
	# ͨ�� explain() ���鿴����Ч��
		 db.users.find().explain();
			{
					"queryPlanner" : {
							"plannerVersion" : 1,
							"namespace" : "test.users",
							"indexFilterSet" : false,
							"parsedQuery" : {

							},
							"winningPlan" : {
									"stage" : "COLLSCAN",
									"direction" : "forward"
							},
							"rejectedPlans" : [ ]
					},
					"serverInfo" : {
							"host" : "KevinBlandy",
							"port" : 27017,
							"version" : "4.0.9",
							"gitVersion" : "fc525e2d9b0e4bceff5c2201457e564362909765"
					},
					"ok" : 1
			}
	
	# ��������
		db.users.createIndex({'name':1});
			* �ڼ��� users �ϵ� 'name' �ֶν�������
				{
						"createdCollectionAutomatically" : false,
						"numIndexesBefore" : 1,
						"numIndexesAfter" : 2,
						"ok" : 1
				}
					
			* 1 ��ʾ�������������,ʹ�� -1 ��ʾΪ�������������

		* mongobdһ������������� 64 ������
		* ��������߼���Ч��,������ִ���޸�,�����ʱ���ȥִ���޸�����.������ķѸ����ʱ��
		* Ҳ���Զ������ֶ�,Ϊ��������
			db.users.createIndex({'name':1,'age': 1});
		
		* ����������֧�ֵ����� options ����(JSON)
			background	Boolean			
				* ���������̻������������ݿ����,background��ָ���Ժ�̨��ʽ��������,������ "background" ��ѡ������
				* Ĭ��ֵΪfalse��
			unique	Boolean			
				* �����������Ƿ�Ψһ,ָ��Ϊtrue����Ψһ����,Ĭ��ֵΪfalse
			name	string			
				* ����������,���δָ��,MongoDB��ͨ�������������ֶ���������˳������һ����������
			dropDups	Boolean			
				* 3.0+�汾�ѷ���,�ڽ���Ψһ����ʱ�Ƿ�ɾ���ظ���¼,ָ�� true ����Ψһ����,Ĭ��ֵΪ false

			sparse	Boolean			
				* ���ĵ��в����ڵ��ֶ����ݲ���������
				* ���������Ҫ�ر�ע��,�������Ϊtrue�Ļ�,�������ֶ��в����ѯ����������Ӧ�ֶε��ĵ�,Ĭ��ֵΪ false
			expireAfter	Seconds	integer	
				* ָ��һ������Ϊ��λ����ֵ,��� TTL�趨,�趨���ϵ�����ʱ��
			v					
				* index version	�����İ汾��
				* Ĭ�ϵ������汾ȡ����mongod��������ʱ���еİ汾
			weights	document		
				* ����Ȩ��ֵ,��ֵ�� 1 �� 99,999 ֮��,��ʾ��������������������ֶεĵ÷�Ȩ��
			default_language	string			
				* �����ı�����,�ò���������ͣ�ôʼ��ʸɺʹ����Ĺ�����б�,Ĭ��ΪӢ��
			language_override	string			
				* �����ı�����,�ò���ָ���˰������ĵ��е��ֶ���,���Ը���Ĭ�ϵ�language,Ĭ��ֵΪ language
			
	
	# �鿴���ϴ���������
		db.[collection].getIndexes()
	
	# �鿴���������Ĵ�С
		db.[collection].totalIndexSize()
	
	# ɾ�����ϵ�����
		db.[collection].dropIndex(name)
			* ɾ��ָ�����Ƶ�����

		db.[collection].dropIndexes()
			* ɾ�����е�����
	

