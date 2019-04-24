--------------------------------
ConfigServer					|
--------------------------------
	# Maven
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-config-server</artifactId>
			</dependency>
	
	# Ĭ��ʹ��Git�ֿ���Ϊ���òֿ�
		* �����ļ������Ѿ����汾����������
		* spring.config.server.git.uri ��ϵĸ�·��,����Ҫ�� .git �ļ���(�������õ���Ŀ¼)
		* ���������ļ���Ҫ�ύ���汾����
	
	# ע������
		@EnableConfigServer
	
	# ����������
		server:
		  port: 8015

		spring:
		  application:
			name: config-server
		  cloud:
			config:
			  server:
				git:
				  # git���òֿ��λ��(������Ϊ / ��β),��Ŀ¼�±���Ҫ��: .git Ŀ¼(˵����,������GIT�ĸ�Ŀ¼)
				  uri: https://github.com/KevinBlandy/temp-config.git
				  # ���òֿ��µ��������·��,�����ж��
				  search-paths:
					- config
				  # ���ʲֿ���˻�������
				  username: KevinBlandy
				  password: F8575532
	
	# ��������OK��,����ͨ�����������
		http://localhost:8015/config/springcloud.yml

		* ���Է��ʵ�·��
			/{application}/{profile}/{label}

			/{application}-{profile}.yml
			/{label}/{application}-{profile}.yml

			/{application}-{profile}.properties
			/{label}/{application}-{profile}.properties
			
			application
				* Ҫ�Կͻ��˵� spring.application.name ������
			profile
				* ����
			label
				* ����ָ����֧,Ĭ��ΪMASTER
		
		* ע��,Ҫ���� search-paths ·��
	
	# ConifgServer�����ڱ��ػ��������ļ�
		* ���ػ����Ŀ¼
			C:\Users\KevinBlandy\AppData\Local\Temp\config-repo-[hash]
		
		* ��ֹGit������崻����޷���������
	
	
	
	# ����ʹ�ñ��ص� git �ֿ���Ϊ���òֿ�
		spring.config.server.git.uri=file:D:\\config-rep\\springcloud-config

		* ʹ��:file: ��ͷ��ʾʹ�ñ��ص����òֿ�
	
	# ʹ��URIռλ�������ֲ�ͬ��Ӧ��
		* application,profile,label ���������Ա�ʶ�����ļ�����

		* ����������ConfigServer����Git�ֿ��Uri��ַ
			spring.config.server.git.uri=https://github.com/KevinBlandy/{application}-config.git
			
			application
				* ��ʾӦ����,���ͻ��˷��������ʱ��,Server����ݿͻ��˵� spring.application.name ��Ϣ�����URI
				* �Ϳ��Ը��ݲ�ͬ�ķ���,����̬�ļ��ز�ͬURI�µ���Դ
			
			label
				* ��������Ƚ��ر�,���Git��֧���ư����� '/' ,��ô��label������http��uri��Ӧ��ʹ�� '_' ������,����ı���URI�ĺ���

			* Ŀǰ����,����ռλ��{application}��֧�������� uri ������,���ʹ�� {application},��ConfigServer������ʱ��ᱻ�滻Ϊ : app,�Ӷ�����ϵͳ�쳣,��ʾ�����ڵ�Ŀ¼
				���� -> uri: 'https://github.com/KevinBlandy/{application}-config-rep.git'
				�쳣 -> Cannot clone or checkout repository: https://github.com/KevinBlandy/app-config-rep.git

			* ��ʵҲ���Խ��,�ײ�,��ConfigServer������ʱ��,���ڸ�·������Ŀ¼: {application},application�滻Ϊ app,���ҳ�ʼ��ΪgitĿ¼,������commit�ļ�
				���� -> uri: 'file:D:\\config-rep\\{application}-config'
				�½� -> D:\\config-rep\\app-config
		
		* ռλ��������ʹ��������·����,�Դ�������ͬһ���ֿ��µĲ�ͬ�ļ���
			spring
			  cloud:
			    config:
			      server:
				    # Git�ĸ�Ŀ¼
				    uri: 'file:D:\\config-rep'
				    search-paths:
					  # �����yml�Ļ�,Ҫʹ��˫����
					  - '{application}-config'

			* ���ݲ���Ӧ����,ȥ��ͬ����Ŀ¼������
			* �������,��������ûɶ����

		
