---------------------------
mongod.conf
---------------------------
	# �ļ�����
		mongod.conf

	# ������Ŀ�ο�
		https://docs.mongodb.com/manual/reference/configuration-options/

	
	# ע��
		* mongodb���Զ��������ļ��е�˫���ŵ����ݽ���ת��
			

---------------------------
mongod.conf - ����
---------------------------
processManagement:
  fork: true	# �Ƿ��ں�̨����
  pidFilePath: /var/run/mongodb/mongod.pid  # pid �ļ�·��
  
net:
  port: 27017		# �����˿�
  bindIp: 127.0.0.1  # �󶨵�ip
  maxIncomingConnections: 65535 # ������������������ Ĭ��ֵΪ65536
  wireObjectCheck: true # ���ͻ���д������ʱ ������ݵ���Ч��(BSON) Ĭ��ֵΪtrue
  ipv6: false 			# Ĭ��ֵΪfalse
 
storage:
  dbPath: /var/lib/mongo # ָ���洢Ŀ¼
