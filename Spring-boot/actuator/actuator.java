----------------------------
actuator					|
----------------------------
	# �ο��ĵ�
		https://blog.csdn.net/alinyua/article/details/80009435
		https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready
	
	# ����
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
	
	

	# ��ص�������
		WebEndpointProperties
	
	# ���Է��ʵĵĶ˵�
		ID				����																															Ĭ������
		auditevents		��ʾ��ǰӦ�ó��������¼���Ϣ																									Yes
		beans			��ʾһ��Ӧ��������Spring Beans�������б�																						Yes
		conditions		��ʾ��������Զ�������(configuration and auto-configuration classes)��״̬�����Ǳ�Ӧ�û�δ��Ӧ�õ�ԭ��							Yes
		configprops		��ʾһ������@ConfigurationProperties�ļ����б�																					Yes
		env				��ʾ����Spring�� ConfigurableEnvironment������																					Yes
		flyway			��ʾ���ݿ�Ǩ��·��,����еĻ�																									Yes
		health			��ʾӦ�õĽ�����Ϣ(��ʹ��һ��δ��֤���ӷ���ʱ��ʾһ���򵥵�'status',ʹ����֤���ӷ�������ʾȫ����Ϣ����)							Yes
		info			��ʾ�����Ӧ����Ϣ																												Yes
		liquibase		չʾ�κ�Liquibase���ݿ�Ǩ��·��������еĻ�																						Yes
		metrics			չʾ��ǰӦ�õ�metrics��Ϣ																										Yes
		mappings		��ʾһ������@RequestMapping·���ļ����б�																						Yes
		scheduledtasks	��ʾӦ�ó����еļƻ�����																										Yes
		sessions		�����Spring�Ự֧�ֵĻỰ�洢�м�����ɾ��(retrieval and deletion)�û��Ự��ʹ��Spring Session�Է�Ӧ��WebӦ�ó����֧��ʱ������	Yes
		shutdown		����Ӧ�������ŵķ�ʽ�ر�(Ĭ������²�����)																						No
		threaddump		ִ��һ���߳�dump																												Yes

		heapdump		����һ��GZipѹ����hprof��dump�ļ�																								Yes
		jolokia			ͨ��HTTP��¶JMX beans(��Jolokia����·����ʱ��WebFlux������)																		Yes
		logfile			������־�ļ�����(���������logging.file��logging.path���ԵĻ�),֧��ʹ��HTTP Rangeͷ������־�ļ����ݵĲ�����Ϣ					Yes
		prometheus		�Կ��Ա�Prometheus������ץȡ�ĸ�ʽ��ʾmetrics��Ϣ																				Yes



	
	

