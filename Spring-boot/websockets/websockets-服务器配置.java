------------------------------
����������
------------------------------
	# ÿ��������WebSocket���涼������������ʱ�������������ԣ�������Ϣ��������С�Ĵ�С�����г�ʱ��

------------------------------------------------------
ServletServerContainerFactoryBean
------------------------------------------------------
	#  ServletServerContainerFactoryBean implements FactoryBean<WebSocketContainer>, ServletContextAware, InitializingBean
	
	# ����
		@Nullable
		private Long asyncSendTimeout;

		@Nullable
		private Long maxSessionIdleTimeout;

		@Nullable
		private Integer maxTextMessageBufferSize;

		@Nullable
		private Integer maxBinaryMessageBufferSize;

		@Nullable
		private ServletContext servletContext;

		@Nullable
		private ServerContainer serverContainer;
	
	# ���õ�IOC
		@Bean
		public ServletServerContainerFactoryBean createWebSocketContainer() {
			ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
			container.setMaxTextMessageBufferSize(8192);
			container.setMaxBinaryMessageBufferSize(8192);
			return container;
		}


------------------------------------------------------
����� Jetty������
------------------------------------------------------
	# Jetty��������Ҫ���������
		@Configuration
		@EnableWebSocket
		public class WebSocketConfig implements WebSocketConfigurer {

			@Override
			public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
				registry.addHandler(echoWebSocketHandler(), "/echo").setHandshakeHandler(handshakeHandler());
			}

			@Bean
			public DefaultHandshakeHandler handshakeHandler() {

				WebSocketPolicy policy = new WebSocketPolicy(WebSocketBehavior.SERVER);
				policy.setInputBufferSize(8192);
				policy.setIdleTimeout(600000);

				return new DefaultHandshakeHandler(
						new JettyRequestUpgradeStrategy(new WebSocketServerFactory(policy)));
			}

		}