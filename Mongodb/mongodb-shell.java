------------------------------
Shell						  |
------------------------------
	# ����shell�������ӵ�Զ�̵ķ�����
		mongo [host]:[port]/[db]

		* ��� db ������,�ᴴ��
	
		--nodb
			* ����ʱ,�������κε�mongodb
		--norc
			* ����ʱ��ִ�� .mongorc.js �ű�
	
	# ֱ��'ִ�к���'����,���Կ���������ʵ��Դ��

		db.createCollection;

		function (name, opt) {
			...
		}
	
	# ֱ��ִ���ⲿ��js�ű�
		mango [file0.js] [file1.js] [file2.js]

		* shell������ִ��jsȻ���˳�
		* ����ʹ�õ�ָ��
			--quiet [host]:[port]/[db] 

				* ��ָ���ķ�������ִ��js�ű�
	
	# �ڽű�������Է��� db ����,��������ȫ�ֱ���,����Shell��һЩ��������,��js�ļ����治��ʹ��
		use db;
		show dbs;
		show collections;

		* ���ǿ���ʹ�ú���������

		// �л�DB
		db.getSitsterDB(db);		// use db
		// �鿴DBS
		db.getMongo().getDBs();		// show dbs
		// �鿴collections
		db.getConnectionNames();	// show collections
		

------------------------------
Shell ȫ��ָ��/����			  |
------------------------------	
	help
		* �鿴����
	cls
		* ������
	print()
		* ��ӡ����
	load(file)
		* ����ָ����js�ű�,����ִ��
		* Ĭ�ϼ��ص�ǰĿ¼�Ľű�,Ҳ����ʹ�þ���·�����������ļ����µĽű�
	run(shell)
		* ִ��shell����
		* ִ�гɹ����� 0
	
------------------------------
Shell ���ö���				  |
------------------------------
	Mongo
		# ��ʾһ����������Ӷ���
			// ���������˵�����
			let connection = new Mongo('127.0.0.1:27017');

			// �����ӻ�ȡdbʵ��
			let db = connection.getDB('test');
		
			
			// �л�DB
			db.getSitsterDB(db);		// use db
			
			// �鿴DBS
			db.getMongo().getDBs();		// show dbs

			// �鿴collections
			db.getCollectionNames();	// show collections
	DB
		# db����

	DBCollection
		# ���϶���

------------------------------
.mongorc.js					  |
------------------------------
	# ��js�ļ����û���homeĿ¼��: ~/.mongorc.js 
	# ������ mongo �ͻ��˵�ʱ��,���Զ��ļ���ִ��
		mongo
	
	# ���������������һЩ��ʼ������(����ȫ�ֱ���ɶ��)

	# ��дΣ�յĺ���,��ֹ���󴥷�
		function no(args){
			print('Σ�պ���,����ִ��');
		}

		// ��ֹɾ�����ݿ�
		db.dropDatabase = DB.prototype.dropDatabase = no;

		// ��ֹɾ������
		DBCollection.prototype.drop = no;

		// ��ֹɾ������
		DBCollection.prototype.dropIndex = no;

