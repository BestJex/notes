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
			
			* ����ʹ�� pretty() ����, ��ʽ��json���
				db.foo.find().pretty;
			

	
	# ��ҳ
		db.[collection].find([condition]).skip([rows])
			* ��skip()����������ָ��������¼����������

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

-------------------------
document - �ۺϼ���
-------------------------

-------------------------
document - �������
-------------------------
	# ������ѯ����
		����				{<key>:<value>}			db.col.find({"by": "����̳�"}).pretty()		where by = '����̳�'
		С��				{<key>:{$lt:<value>}}	db.col.find({"likes":{$lt: 50}}).pretty()		where likes < 50
		С�ڻ����			{<key>:{$lte:<value>}}	db.col.find({"likes":{$lte: 50}}).pretty()		where likes <= 50
		����				{<key>:{$gt:<value>}}	db.col.find({"likes":{$gt: 50}}).pretty()		where likes > 50
		���ڻ����			{<key>:{$gte:<value>}}	db.col.find({"likes":{$gte: 50}}).pretty()		where likes >= 50
		������				{<key>:{$ne:<value>}}	db.col.find({"likes":{$ne: 50}}).pretty()		where likes != 50
	
	# $type ������
		* $type�������ǻ���BSON����������������ƥ����������ͣ������ؽ����
		
			����					����	��ע
			Double					1	 
			String					2	 
			Object					3	 
			Array					4	 
			Binary data				5	 
			Undefined				6		�ѷ�����
			Object id				7	 
			Boolean					8	 
			Date					9	 
			Null					10	 
			Regular	Expression		11	 
			JavaScript				13	 
			Symbol					14	 
			JavaScript	(with scope)15	 
			32-bit integer			16	 
			Timestamp				17	 
			64-bit integer			18	 
			Min key					255		Query with -1.
			Max key					127	 
		
		* ����ָ��key������ȥƥ������
			db.users.find({name: {$type: 'string'}});  // ����ƥ��name�������ַ����ļ�¼
			db.users.find({name: {$type: 2}});		// ͬ��

	
	# ������ϵ
		* AND ��ϵ, Ĭ�϶����е����Զ��� AND ����
			db.col.find({name: "1", age: 23}); // WHERE name = '1' AND age = 23;
		
		* OR ��ϵ
			db.col.find({$or: [{name: "v"}, {name: "z"}]}); // WHERE name = 'v' OR `name` = `z`
		
		* ��Ϲ�ϵ
			db.users.find({
				name: "KevinBlandy",
				$or: [{
					age: {
						$gt: 18
					}
				}, {
					age: {
						$lt: 50
					}
				}]
			});  // WHERE name = 'KevinBlandy' AND (age > 18 OR age < 50)
			