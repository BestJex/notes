-------------------------
document 
-------------------------

-------------------------
document - id
-------------------------
	# �ڼ����в����ĵ�ʱ�����û�����ֶ���������Ӵ���_id���ֶ����ƣ���MongoDB���Զ����һ��Object id�ֶ�
		{"_id": ObjectId("xxxxxxxxx")}
	



-------------------------
document - ��������
-------------------------
	db.[collection].insert([document]);
		* ��ָ����collection����һ�����߶��(����������)document
		* ��� collection ������, �ᴴ��

		* ִ�гɹ��󷵻ز���ɹ����ĵ�����
			WriteResult({"nInserted": 1});
			
	db.[collection].remove([condition]);
		* ���������Ƴ�����
		* ���û������, ���Ƴ���������


-------------------------
document - ����
-------------------------
	db.[collection].update([condition], [update], [config]);
		* ���� condition ִ�� update �޸�һ���ĵ�
			db.users.update({name: "KevinBlandy"}, {$set: {name: "new Name"}}); // UPDATE `users` SET `name` = 'new Name' WHERE `name` = 'KevinBlandy';
		
		* config ѡ��
			{
				upsert: true,
					*  ��ѡ�����������update�ļ�¼���Ƿ����objNew ,trueΪ���룬Ĭ����false�������롣

				multi: true,
					* ��ѡ��Ĭ����false,ֻ�����ҵ��ĵ�һ����¼������������Ϊtrue,�ͰѰ����������������¼ȫ�����¡�

				writeConcern: <document>
					* ��ѡ���׳��쳣�ļ���
			}
	
	
-------------------------
document - ��ѯ���
-------------------------
	# �����Ĳ�ѯ
		db.[collection].find([condition])
			* �����������������
			* ���û������, ����������е�����
			
			* �÷������صĶ�����һ�� '������', ����ʹ�� while �����е���
				const it = db.foo.find();
				while (it.hasNext()) {
					printjson(it.next());
				}
		
	
	# ��ҳ
		db.[collection].find([condition]).limit([rows])
			* ʹ�� limit ����, �����ƽ��������
	
	# ͳ������
		db.[collection].count([condition]);
			* ��������ͳ���ĵ�������
			* ���û������, ��ͳ�����е��ĵ�

	# ����
		db.[collection].find().sort([row])
			* ͨ�� sort ָ��������ֶ��Լ�����
				db.users.find().sort({name: -1}) // ����name�ֶΣ���������
			
			* ������ԡ�-1: ����1:����
		
	