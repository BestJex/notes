------------------------
ssl						|
------------------------
	# SSL
		* netscape ��˾���,Server Socket Layer
	
	# Java�İ�ȫ�׽�����չ JSSE(Java Secure Socket Extension)
		* Ϊ����SSL��TLSЭ���Java����Ӧ���ṩ��Java API�Ͳο�ʵ��
		* ֧�����ݼ���,������������,����������,�Լ���ѡ�Ŀͻ����������
	
	# TLS/SSL
		* Ŀǰ��˵TSL1.0��SSL3.0���ǳ�С
	


	# ���
		javax.net
		javax.net.ssl
		java.security.cert

		KeyStore
			* ��Կ֤��洢��ʩ
			* ����������ڴ�Ű�ȫ֤��,��ȫ֤��һ�����ļ���ʽ���
			* KeyStore ����֤����ص��ڴ�

		KeyManagerFactory
		KeyManager
			* ��Կ������
			* ��ѡ������֤ʵ�Լ���ݵİ�ȫ֤��,����ͨ����һ��
			* KeyManager ������ KeyManagerFactory ����������

		TrustManagerFactory
		TrustManager
			* ���ι�����
			* �����жϾ����Ƿ����ζԷ��İ�ȫ֤��
			* TrustManager ������ TrustManagerFactory ����������

			|-X509Certificate
				* �ӿڵ�ʵ��
				

		SSLContext
			* ������SSL/TLSЭ��ķ�װ,��ʾ�˰�ȫ�׽���Э���ʵ��
			* ��Ҫ�������ð�ȫͨ�Ź����еĸ�����Ϣ,�����֤����ص���Ϣ
			* ���Ҹ��𹹽� SSLSocketFactory,SSLServerSocketFactory �� SSLEngine �ȹ�����

		SSLServerSocketFactory
		SSLServerSocket(ServerSocket����)

		SSLSocketFactory
		SSLSocket(Socket����)

		SSLEngine
			* SSL����������
			* NIOͨ��,ʹ�������,����ͨ������֧�ַ������İ�ȫͨ��
				void setUseClientMode(true);
					* ��ǰ�ǿͻ���ģʽ���Ƿ����ģʽ

				void setNeedClientAuth(false);
					* �Ƿ�ҪУ��ͻ��˵�֤��

		SSLSession
			* SSL�Ự
			* ��ȫͨ�����ֹ�����Ҫһ���Ự,Ϊ�����ͨ�ŵ�Ч��
			* SSLЭ��������SSLSocket����ͬһ��SSL�Ự,��ͬһ���Ự��,ֻ�е�һ���򿪵� SSLSocket ��Ҫ����SSL����,����������Կ��������Կ,����SSLSocket��������Կ��Ϣ

		
			

		SecureRandom

		CertificateFactory

------------------------
ssl						|
------------------------

// JKS��֤������
char[] password = "123456".toCharArray();

// ����֤���ļ�
KeyStore keyStore = KeyStore.getInstance("JKS");
keyStore.load(Files.newInputStream(Paths.get("")),password);

// KeyManager��ѡ������֤��������ݵ�֤��,���뷢�͸��Է�
KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
keyManagerFactory.init(keyStore,password);
KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();

// TrustManager �����Ƿ����ζԷ���֤��
TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
trustManagerFactory.init(keyStore);
TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();

SSLContext sslContext = SSLContext.getInstance("TLS");
sslContext.init(keyManagers,trustManagers,null);

// ����nio
SSLEngine sslEngine = sslContext.createSSLEngine();

// ����bio
SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();