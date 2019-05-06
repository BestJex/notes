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
	
	# �ڽű�������Է��� db ����,��������ȫ�ֱ���,����Shell��һЩ��������,��js�ļ����治��ֱ��ʹ��,���ǿ����ú���������
		// �л�DB,�ǵ�Ҫ��db�������½��ո�ֵ
		db.getSisterDB(db);					// use db
			db = db.getSisterDB(db);

		// �鿴DBS
		db.getMongo().getDBs();				// show dbs
			{
				"databases" : [{
						"name" : "admin",
						"sizeOnDisk" : 32768,
						"empty" : false
					}
				}],
				"totalSize" : 241664,
				"ok" : 1
			}

		// �鿴collections
		db.getCollectionNames();			// show collections
			[ "c1", "c2", "c3" ]
		

------------------------------
Shell ȫ��ָ��/����			  |
------------------------------	
	help
		* �鿴����
	cls
		* ������
	exit
		* �˳�shell
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

------------------------------
���� Shell ��ʾ				  |
------------------------------
	# ���� prompt ����Ϊһ���ַ���,����һ������(�����ַ���),�Ϳ�������Ĭ�ϵ�Shell��ʾ
		* prompt ���������е�ǰ׺
	

	# ����Ϊ��ǰ��ʱ��
		var prompt = function(){
			return new Date().getTime() + '>';
		}
				
	
	# ����Ϊ��ǰ��db
		var prompt = function(){
			if (typeof db == 'undefined'){
				return '(no db)>';
			}
			try{
				db.runCommand({getLastError:1});
			}catch (e) {
				print(e);
			}
			return db + '>';
		}

------------------------------
�༭���ϱ���				  |
------------------------------
	TODO
