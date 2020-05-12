-------------------------
document 
-------------------------
	# ��������
		* mongo�е�����, Ĭ���� double ��������, �����Ҫ�洢����, ����ʹ�ú��� NumberInt(val)
			db.user.insert({name: "n3", age: NumberInt(27)});
		
		* ���뵱ǰ����ʹ��: new Date();
		* ����ֶ�Ϊ null,  ��Ӧ������


-------------------------
document - id
-------------------------
	# �ڼ����в����ĵ�ʱ�����û�����ֶ���������Ӵ���_id���ֶ����ƣ���MongoDB���Զ����һ��Object id�ֶ�
		{"_id": ObjectId("xxxxxxxxx")}
	



-------------------------
document - ��������
-------------------------
	db.[collection].insert([document], [config]);
		* ��ָ����collection����һ�����߶��(����������)document
		* ��� collection ������, �ᴴ��

		* ִ�гɹ��󷵻ز���ɹ����ĵ�����
			WriteResult({"nInserted": 1});
		
		* config
			{
				writeConcern: <document>
					* ��ѡ���׳��쳣�ļ���
				ordered: true
					* Ĭ��Ϊ true, ����˳������ĵ�, ��������κ�һ���쳣, ����������, ʣ����ĵ����ᴦ��
					* ���Ϊ false, ��������ĵ��쳣, �������᷵��, �������������ĵ�
			}
			
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
		
		* �����ʹ�� $Set, ָ������ָ�����ֶν����޸�, ��ô�ͻ��ɸ����޸�, ʹ�����ĵ����׸��Ǿ��ĵ�
			db.users.update({name: "KevinBlandy"}, {name: "ff"}); // ��name=KevinBlandy���ĵ����޸ĳ�ֻ�� name=ff���ĵ�
		

		* config ѡ��
			{
				upsert: true,
					*  ��ѡ�����������update�ļ�¼���Ƿ����objNew ,trueΪ���룬Ĭ����false�������롣
				multi: true,
					* ��ѡ��Ĭ����false,ֻ�����ҵ��ĵ�һ����¼������������Ϊtrue,�ͰѰ����������������¼ȫ�����¡�
				writeConcern: <document>
					* ��ѡ���׳��쳣�ļ���
				collation: <document>,
				arrayFilters: [<filder-document>],
				hint: <document|string>
			}
	
	db.[collection].save([document], [config]);
		* �����޸�, ͨ��������ĵ����滻�����ĵ�
		* config ѡ��
			{
				writeConcern: <document>
					* ��ѡ���׳��쳣�ļ��� 
			}
		
	
	
	# ������ص�ָ��
		$set
			* ����ֵ
		
		$inc
			* �����ֶ�ֵ
				db.user.update({_id: ObjectId("5eba69c51e2bb3537a710e0b")}, {$inc: {age: 1}}); // ��age�ֶ� +1
			
