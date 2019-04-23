--------------------------------
ConfigClient					|
--------------------------------
	# Maven
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-config-client</artifactId>
		</dependency>
	
	# ����
		* ע��,Ҫ������ : bootstrap.yml ��

		spring:
		  application:
		    # �����ļ���ǰ׺��
			name: springcloud
		  cloud:
			config:
			  # �����ļ�������
			  uri: http://localhost:8015/
			  # ������ļ�,�����ļ��ĺ�׺
			  profile: dev
			  # ��֧
			  label: master
			
		* Ӧ��������ʱ������ application.name �� config.profile ���� config.label ȥ config.uri ��ȥ���������ļ���Ϣ
			{label} ==> {application}-{profile}.yml

	# �ڳ�������ʹ��
		// ֱ��ʹ�� @Value ע��
		@Value("${config.name}")
		private String configName;
		
		// ʹ�� environment
		@Autowired
		private Environment environment;
		environment.getProperty("config.name")