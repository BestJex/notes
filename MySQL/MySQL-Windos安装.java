--------------------------------
Winddows ��װMySQL				|
--------------------------------
	# ����windowsѹ����,��ѹ
		https://dev.mysql.com/downloads/mysql/

		* ���Ե��: Looking for previous GA versions? ��������ǰ�İ汾(5.7.x)
	
	# ��ӻ�������
		MYSQL_HOME=D:\mysql-5.7.20-winx64
	
	# ���PATH����
		%MYSQL_HOME%\bin;

	# ����ini�����ļ�
		* ��mysql�Ľ�ѹ��Ŀ¼�����ļ�:my.ini
[mysqld]
basedir=D:\mysql-5.7.20-winx64
datadir=D:\mysql-5.7.20-winx64\data 
port=3306
max_connections=200
character_set_server=utf8
default_storage_engine=INNODB
sql_mode=NO_ENGINE_SUBSTITUTION,STRICT_TRANS_TABLES

	# ��ʼ��
		mysqld --initialize-insecure

		* ��ʼ���������root�û�
		* ��¼ʱ��������ֱ�ӻس�
		* ��¼�ɹ����޸�����
			set password for 'root'@'%' = password('root');
	
	# ��װ��ϵͳ����
		mysqld --install

		* ʹ��ϵͳ����ά��
			net start mysql
			net stop mysql





