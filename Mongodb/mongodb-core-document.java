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
			
	db.[collection].remove([condition], [config]);
		* ���������Ƴ�����
		* ���û������, ���Ƴ���������
		
		* config
			{
				justOne: false,
					* �����Ϊ true �� 1����ֻɾ��һ���ĵ�
					* ��������øò�������ʹ��Ĭ��ֵ false����ɾ������ƥ���������ĵ���
				writeConcern: <document>
					* ��ѡ���׳��쳣�ļ���
			}
		
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
	
	db.[collection].save([document], [config]);
		* ͨ��������ĵ����滻�����ĵ�

		* config ѡ��
			{
				writeConcern: <document>
					* ��ѡ���׳��쳣�ļ��� 
			}
		
	
