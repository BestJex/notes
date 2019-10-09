----------------------------
session						|
----------------------------
	# �ο�
		https://docs.spring.io/spring-session/docs/current/reference/html5/
	
	# ����
		<dependency>
			<groupId>org.springframework.session</groupId>
			<artifactId>spring-session-data-redis</artifactId>
		</dependency>
	
	# ע������ @EnableRedisHttpSession (���Ǳ����)
		int maxInactiveIntervalInSeconds() default MapSession.DEFAULT_MAX_INACTIVE_INTERVAL_SECONDS;
			* session�������ʱ��, Ĭ������

		String redisNamespace() default RedisOperationsSessionRepository.DEFAULT_NAMESPACE;
			* redis�Ĵ洢�ռ�key����

		RedisFlushMode redisFlushMode() default RedisFlushMode.ON_SAVE;
			* ˢ��ģʽ, ö��
				ON_SAVE
					* ֻ�е� SessionRepository.save(Session)����������ʱ, �ŻὫsession�е�����ͬ����redis��.
					* ��web Ӧ����, �����������Ӧ��, �ſ�ʼͬ��. Ҳ����˵��ִ��response ֮ǰsession���ݶ��ǻ����ڱ��ص�.

				IMMEDIATE
					* ʵʱͬ��session ���ݵ�redis. 
					* ��ִ��SessionRepository.createSession()ʱ, �Ὣsession����ͬ����redis��; 
					* ����session��attribute����set/remove �Ȳ���ʱ, Ҳ��ͬ��session�е����ݵ�redis��

		String cleanupCron() default RedisHttpSessionConfiguration.DEFAULT_CLEANUP_CRON;
			* ִ��session�����cron���ʽ
			* Ĭ��: 0 * * * * * (һ����ִ��һ��)

	
	# ���ǿ���ͨ��: server.servlet.session.cookie ������Cookie���������Ե���Ϣ
		
----------------------------
����						|
----------------------------
spring:
  session:
    timeout: 1800
		* �Ự�ĳ�ʱʱ��, ��λ����,Ĭ��: 1800
		* ���������, Ĭ��ʹ��: server.servlet.session.timeout
    store-type: REDIS
		* ָ��session�Ĵ洢��ʽ, ö��
			REDIS
			MONGODB
			JDBC
			HAZELCAST
			NONE
    redis:
	  flush-mode: on-save
	  namespace: 


	
	

