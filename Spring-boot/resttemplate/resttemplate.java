-----------------------
RestTemplate		   |
-----------------------
	# http�ͻ���
	# ������: InterceptingHttpAccessor ʵ��: RestOperations
	# ���ĵ����
		private final List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
			* ��Ϣת����
			
		private ResponseErrorHandler errorHandler = new DefaultResponseErrorHandler();
			* �쳣������

		private UriTemplateHandler uriTemplateHandler;
		private final ResponseExtractor<HttpHeaders> headersExtractor = new HeadersExtractor();
		private final List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
			* ����������

		private ClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
			* http���󹤳�

	# ���캯��
		public RestTemplate(ClientHttpRequestFactory requestFactory)
		public RestTemplate()
		public RestTemplate(List<HttpMessageConverter<?>> messageConverters)


