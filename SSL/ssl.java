-----------------------------
java ssl					 |
-----------------------------
	# keytool ָ��һ��
		 -certreq            ����֤������
		 -changealias        ������Ŀ�ı���
		 -delete             ɾ����Ŀ
		 -exportcert         ����֤��
		 -genkeypair         ������Կ��
		 -genseckey          ������Կ
		 -gencert            ����֤����������֤��
		 -importcert         ����֤���֤����
		 -importpass         �������
		 -importkeystore     ��������Կ�⵼��һ����
		 -keypasswd          ������Ŀ����Կ����
		 -list               �г���Կ���е���Ŀ
		 -printcert          ��ӡ֤������
		 -printcertreq       ��ӡ֤�����������
		 -printcrl           ��ӡ CRL �ļ�������
		 -storepasswd        ������Կ��Ĵ洢����
	
	# ����֤�鵽keystore
		keytool -genkey -deststoretype [pkcs12] -alias [alias] -validity [100] -keystore [server.keystore] -keyalg [RSA] -storepass [����]
			-genkey
				* ����֤���ָ��
			-deststoretype	
				* ָ��֤������,һ��̶�ֵ:pkcs12
			-alias
				* ָ��֤����keystore�еı���
			-validity
				* ��Ч��,��λ����
			-keystore
				* ָ�� keystore ����(���keystore������,���½�)
			-keyalg
				* ָ��֤��ķǶԳƼ����㷨,һ��̶�:RSA
			-storepass
				* keystore������
	
	# ��֤���е�����Կ
		keytool -export -alias [alias] -file [name.cer] -keystore [name.keystore] -storepass [����]

			-export
				* ������Կ��ָ��
			-alias
				* keystore ��֤��ı���
			-file
				* ��Կ֤����ļ�����
			-keystore
				* keystore
			-storepass
				* keystored������
	
	# ���빫Կ�� keystore
		keytool -import -file [name.cer] -alias [alias] -keystore [name.keystore] -storepass [����]

			-import
				*  ����ָ��
			-file
				* ��Կ֤���ļ�
			-alias
				* ���� ��֤����Ŀ��keystore�еı���(Ĭ����:mykey),���ܳ�ͻ
			-keystore
				* ���뵽��Ŀ�� keystore(���keystore������,���½�)
			-storepass
				* Ŀ�� keystore������
			
	
	# ��keystoreɾ����Կ
		keytool -delete -alias [alias] -keystore [name.keystore] -storepass [����]
			-delete
				* ɾ��ָ��
			-alias
				* ��Կ�ı���
			-keystore
				* Ŀ��keystore�ļ�
			-storepass
				* keystore������
				
	# �鿴keystore�е�֤����Ŀ
		keytool -list -v -keystore [name.keystore] -storepass [����]

			-list
				* �г�ָ��
			-v
				* ��ʾ����
			-keystore
				* ָ����keystore
			-storepass
				* keystore������
	
	# ����֤������
		keytool -certreq -alias [alias] -file [name.csr] -keystore [name.keystore] -storepass [����]
		
			-certreq
				* ��������ָ��
			-alias
				* ֤����keystore�еı���
			-file
				* ���ɵ������ļ�����
			-keystore
				* ֤�����ڵ�keystore
			-storepass
				* keystore������
			
	
	# ����֤����������֤��
		keytool -gencert -alias [alias] -infile [name.csr] -outfile [name.cer] -keystore [name.keystore] -storepass [����]
			
			-gencert
				* ��������֤��ָ��
			-alias
				* ����ǩ����֤���֤�����(root֤�����)
			-infile
				* �����ļ�
			-outfile
				* ���ɵ�֤������
			-keystore
				* ����ǩ����֤���֤�����ڵ�keystore(root֤��)
			-storepass
				* ����ǩ����֤���֤�����ڵ�keystore������(root֤��)

------------------------------------------
keytool����CA��֤���Լ��䷢����֤��		  |
------------------------------------------
	# ����
		1,����CA֤��
			keytool -genkey

		2,�ͻ�������֤��
			keytool -genkey

		3,�ͻ������������ļ�
			keytool -certreq

		4,ʹ��CA֤�����ǩ��
			keytool -gencert

		5,�ͻ��˻�ȡ��CAǩ����֤��,�����Լ��Ŀ�
			keytool -import


	# �ȳɸ�֤��
		keytool -genkey -deststoretype pkcs12 -alias rootca -keystore rootca.keystore -keyalg RSA -storepass 123456
		
		keytool -export -alias rootca -file root.cer -keystore rootca.keystore -storepass 123456

	# ������ǩ��֤��,�������������ļ�
		keytool -genkey -deststoretype pkcs12 -alias app1 -keystore app1.keystore -keyalg RSA -storepass 123456
	
		keytool -certreq -alias app1 -file app1.csr -keystore app1.keystore -storepass 123456
	
	# ʹ�ø�֤�������֤
		keytool -gencert -alias rootca -infile app1.csr -outfile app1.cer -keystore rootca.keystore -storepass 123456

		keytool -import -file app1.cer -alias app2 -keystore app2.keystore -storepass 123456

		keytool -list -v -keystore app1.keystore -storepass 123456