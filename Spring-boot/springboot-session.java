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

	
	# Cookie��Ϣ���Զ���
		* ���ǿ���ͨ��: server.servlet.session.cookie ������Cookie���������Ե���Ϣ
		* Ҳ����ͨ������, �Զ�����: CookieSerializer

		@Bean
		public CookieSerializer cookieSerializer() {
			DefaultCookieSerializer serializer = new DefaultCookieSerializer();
			serializer.setCookieName("JSESSIONID"); 
			serializer.setCookiePath("/"); 
			serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$"); 
			return serializer;
		}
			

	# Session�����spring�¼�
		SessionCreatedEvent				����
		SessionDestroyedEvent
			|-SessionExpiredEvent		����
			|-SessionDeletedEvent		ɾ��
		
		* ���ں�ɾ���¼�, ������REDIS��֪ͨ�¼�
			notify-keyspace-events "Egx"
		
		* ���ʹ����: @EnableRedisHttpSession, SessionMessageListener����Զ���ɹ�������ñ�Ҫ��Redis Keyspace�¼�
		* �ڰ�ȫ��Redis������, �����config����, ����ζ��Spring Session�޷�Ϊ����Redis Keyspace�¼�
		* Ҫ�����Զ�����, �������
			@Bean
			public static ConfigureRedisAction configureRedisAction() {
				return ConfigureRedisAction.NO_OP;
			}
	

	# �Զ���Session�Ľ�����ʽ
		* Session�Ľ���������һ���ӿ�: HttpSessionIdResolver

			CookieHttpSessionIdResolver	ʹ��Cookie(Ĭ��)
			HeaderHttpSessionIdResolver	ʹ��Header

			List<String> resolveSessionIds(HttpServletRequest request)
				* ���������ȡ���Ựid

			void setSessionId(HttpServletRequest request, HttpServletResponse response,String sessionId)
				* ���ûỰid

			void expireSession(HttpServletRequest request, HttpServletResponse response);
				* ���ڻỰid

		* ͨ���Զ�����������ʵ���Զ���Ľ���
			@Bean
			public HttpSessionIdResolver httpSessionIdResolver() {
				return HeaderHttpSessionIdResolver.xAuthToken();  // ʹ�� X-Auth-Token ����Cookie
			}
		
		* HeaderHttpSessionIdResolver ��N�������������ز�ͬ��ʵ��

			HeaderHttpSessionIdResolver xAuthToken()
				* ʹ��: X-Auth-Token ͷ��Ϊsession��id

			HeaderHttpSessionIdResolver authenticationInfo()
				* ʹ��: Authentication-Info ͷ��Ϊsession��id

		* Ҳ�����Զ�������ͷ, ͨ�����췽������
			HeaderHttpSessionIdResolver(String headerName)

			


			
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

	
	* ���ʹ����ע��: @EnableRedisHttpSession, �������ʧЧ, Ĭ��ʹ��ע�����������


-------------------------------------
SessionRepository<S extends Session> |
-------------------------------------
	# Session�Ĺ���ӿ�
		S createSession();
			* ����һ��
		void save(S session);
			* �洢/����
		S findById(String id);
			* ����id����
		void deleteById(String id);
			* ����idɾ��
	
	# ����ʵ��
		SessionRepository
			|-MapSessionRepository
			|-FindByIndexNameSessionRepository
				|-RedisOperationsSessionRepository
				|-RedissonSessionRepository

--------------------------------
FindByIndexNameSessionRepository|
--------------------------------
	# ͨ�׵�˵, ���ǿ��Ը����û���ȡ������Session
	# �û���¼��Ҫ����һ�����ݵ�Session���洢������Ϣ
		String username = "username";
		this.session.setAttribute(FindByIndexNameSessionRepository.PRINCIPAL_NAME_INDEX_NAME, username);

		* һ�������ID֮������ݹ���, ��һ����name
	
	# �����û���Ϣ�����û�
		@Autowired
		FindByIndexNameSessionRepository<? extends Session> sessions;

		@RequestMapping("/")
		public String index(Principal principal, Model model) {
			Collection<? extends Session> usersSessions = this.sessions.findByPrincipalName(principal.getName()).values();
			model.addAttribute("sessions", usersSessions);
			return "index";
		}
	
	# FindByIndexNameSessionRepository �ķ���������

		String PRINCIPAL_NAME_INDEX_NAME = FindByIndexNameSessionRepository.class.getName().concat(".PRINCIPAL_NAME_INDEX_NAME");

		Map<String, S> findByIndexNameAndIndexValue(String indexName, String indexValue);
			* ����ָ����key/value����session

		default Map<String, S> findByPrincipalName(String principalName) {
			return findByIndexNameAndIndexValue(PRINCIPAL_NAME_INDEX_NAME, principalName);
		}
			
	
	# ԭ��
		* FindByIndexNameSessionRepository ���������ṩ��һ��api, ���и���key��value������session
			findByIndexNameAndIndexValue(key, value)
		
		* ���Խ������������, ����ʵ���û��ͻỰ�İ�

	

	