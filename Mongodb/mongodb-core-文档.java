--------------------------------
�ĵ�							|
--------------------------------


--------------------------------
��������						|
--------------------------------
	db.[colelction].insert([document])
		* ��ָ����colelction����һ�����߶�����¼
		* ����Ƕ�����¼,��ô����Ӧ����һ�������˶��document������
		* ����ü��ϲ��ڸ����ݿ���, MongoDB ���Զ������ü��ϲ������ĵ�
	
	db.[colelction].insertOne([document]) 
		* ����һ����¼,������һ��document
	
	db.[colelction].insertMany([document...]) 
		* ���������¼,������һ��document����
			db.collection.insertMany([{"b": 3}, {'c': 4}])

	db.[colelction].save([document]) 
		* �����ָ�� _id �ֶ� save() ���������� insert() ����
		* ���ָ�� _id �ֶ�,�����¸� _id ������
	

	db.[colelction].find()
		* �鿴ָ��collection���Ѳ����ĵ�
	

--------------------------------
����							|
--------------------------------
	
	# ���µ��﷨: query,update,config

		db.[colelction].update([query], [update],   {
			upsert: true,
			multi: true,
			writeConcern: <document>
		})
	
		query
			* update�Ĳ�ѯ����,����sql update��ѯ��where�����
		
		update
			* update�Ķ����һЩ���µĲ�����(��$,$inc...)��,Ҳ�������Ϊsql update��ѯ�ں����SET
		
		* config������ѡ��
			upsert
				* ��ѡ,�����������˼��,���������update�ļ�¼,�Ƿ����objNew,true Ϊ����
				* Ĭ���� false ������
			
			multi
				* �������·��������ĵ�һ��,���Ǹ�������
			
			writeConcern
				* �׳��쳣�ļ���
	


