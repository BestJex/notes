--------------------------------
ConfigServer					|
--------------------------------
	# Maven
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-config-server</artifactId>
			</dependency>
	
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
				  # git���òֿ��λ��(������Ϊ / ��β)
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
	
