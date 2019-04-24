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
	
	# ʧ�ܵĿ�����Ӧ������
		* �ڷ���������ʱ��,����Ƚϸ���,���ܻ����������÷�����,�������õĹ����кķѴ�����ʱ��
		* ����ͨ��һ������,�����⵱ConfigServer���������ʱ��,��Ҫ��ȴ�ǰ�õ�һЩ����ʱ��
		* ʵ���˿��ٷ���ʧ����Ϣ(�׳��쳣)

			spring.cloud.conifg.fail-fast=true
		
		* �ڿ�����'���ٷ���ʧ����Ϣ'�������,���ṩ��һ�����Ի���
		* ��Ϊ���÷��������쳣,����ֻ����Ϊ���粨����ɵ�,���ǿ��Իָ���һ���쳣
		* �ڿͻ����������
			<dependency>
				<groupId>org.springframework.retry</groupId>
				<artifactId>spring-retry</artifactId>
			</dependency>
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-aop</artifactId>
			</dependency>
		
		* �����������,����Ҫ���κε�����
		* �ͻ������������÷�����ʧ�ܵ������,����������6�ε���������
		* �����ʧ�ܵ������,�Ż��׳��쳣
		* ����ͨ���������ԵĴ����Լ����ʱ��(������:RetryProperties)
			spring:
			  cloud:
				config:
				  retry:
					# ��ʼ���Ե�ʱ��,Ĭ��Ϊ: 1000ms
					initial-interval: 1000
					# ��һ����ĳ���,Ĭ��Ϊ: 1.1
					multiplier: 1.1
					# ������Դ���,Ĭ��Ϊ 6
					max-attempts: 6
					# �����ʱ��,Ĭ��Ϊ: 2000 ms
					max-interval: 2000


--------------------------------
��̬ˢ������					|
--------------------------------
	# �ڿͻ������,acuator���ģ��
		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
	
	# �ڿͻ��˵� /form ·�����Կ�������
		* ʵ��û��Ч
	
	# �����޸�Git�ֿ�������ļ�(commit)

	# ����ͻ��˵�ˢ��·�� /refresh
		* ��ʱ������Ϣ�Ѿ�������Ϊ�����޸ĵ�����
	

	# ����ʹ��Git�ֿ�Ĺ��ӳ���(web hook),������ /refresh �ӿ�����Զ�ˢ��
		
	# ʵ�ʵĿ���,��������ʹ�����ַ�ʽ�������ø���,����ͨ����Ϣ������: springcloud-bus

	


