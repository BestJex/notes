-----------------------------
java ssl ֤������			 |
-----------------------------
	# ֤���ļ�����
		.der .cer
			* �ļ��Ƕ����Ƹ�ʽ,ֻ����֤��,������˽Կ

		.pem
			* һ�����ı���ʽ,�ɱ���֤��,�ɱ���˽Կ
		
		.crt
			* �����Ƕ����Ƹ�ʽ,�������ı���ʽ
			* �� .der ��ʽ��ͬ,������˽Կ
		
		.pfx .P12
			* �����Ƹ�ʽ,ͬʱ����֤���˽Կ,һ�������뱣��
			* pfx��������õ�

		.jks
			* �����Ƹ�ʽ,ͬʱ����֤���˽Կ,һ�������뱣��
			*  JAVA ��ר����ʽ(Java Key Storage)
		
	
	# ������˽Կ��֤���ļ���ʽ
		JKS
			* Java֧�ֵ�֤��˽Կ��ʽ
			* java�õĴ洢��Կ������,����ͬʱ����n����Կ��˽Կ,��׺һ����.jks����.keystore��.truststore��
		JCEKS
		PKCS12 
		BKS
		UBER
		PKCS12
			* �����˰���˽Կ�빫Կ֤��(public key certificate)���ļ���ʽ,��ҵ��׼
			* pfx ��ʵ������PKCS#12

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
		 -importkeystore     ��������Կ�⵼��һ����������Ŀ
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
	
	# ��ӡ֤��
		keytool -printcert -rfc -file [name.cer]

			-printcert 
				* ��ӡָ��
			-rfc 
			-file 
				* ֤���ļ�
	
	# ��������Կ�⵼��һ����������Ŀ
		keytool -importkeystore -v  -srckeystore [name.p12] -srcstoretype [pkcs12] -srcstorepass [����] -destkeystore [name.keystore] -deststoretype [pkcs12] -deststorepass [����] 
			
			-importkeystore
				* ����ָ��
			-v
			-srckeystore
			-srcstoretype
			-srcstorepass
				* Դ��Կ���ļ�,����(PCKS12),����
			-destkeystore
			-deststoretype
			-deststorepass
				* Ŀ����Կ���ļ�,����(PCKS12),����
		
		* OPENSSL ��cer/key֤��ת��Ϊ p12֤��
			openssl pkcs12 -export -in [name.cer] -inkey [name.key]-out [name.p12]
				-in
					* ֤��

				-inkey
					* ˽Կ
				
				-out
					* ���ɵ�p12֤���ļ�




------------------------------------------
keytool����CA��֤���Լ��䷢����֤��		  |
------------------------------------------
	# ����
		1,����CA֤��
			keytool -genkey
		
		2,����CA֤�鹫Կ
			keytool -export

		3,�ͻ�������֤��
			keytool -genkey
		
		4,�ͻ������������ļ�
			keytool -certreq

		5,ʹ��CA֤�����ǩ��
			keytool -gencert
		
		6,�ͻ��˵���CA֤��
			keytool -import

		7,�ͻ��˻�ȡ��CAǩ����֤��,�����Լ��Ŀ�
			keytool -import


	# �ȳɸ�֤��
		keytool -genkey -deststoretype pkcs12 -alias rootca -keystore rootca.keystore -keyalg RSA -storepass 123456
		
		keytool -export -alias rootca -file root.cer -keystore rootca.keystore -storepass 123456

	# ������ǩ��֤��,�������������ļ�
		keytool -genkey -deststoretype pkcs12 -alias app1 -keystore app1.keystore -keyalg RSA -storepass 123456
	
		keytool -certreq -alias app1 -file app1.csr -keystore app1.keystore -storepass 123456
	
	# ʹ�ø�֤�������֤
		* ��֤֤��

			keytool -gencert -alias rootca -infile app1.csr -outfile app1.cer -keystore rootca.keystore -storepass 123456
		
		* ����CA֤��
			keytool -import -file root.cer -alias root -keystore app1.keystore -storepass 123456
		
		* ����ǩ����֤��
			keytool -import -file app1.cer -alias app1 -keystore app1.keystore -storepass 123456
		
		*  �鿴kestore���֤���б�
			keytool -list -v -keystore app1.keystore -storepass 123456