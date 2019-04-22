------------------------
zuul					|
------------------------
	# �������,ʵ�ֽӿ�: com.netflix.zuul.ZuulFilter
		@Bean		//ע��ioc����Ч
		public class DemoFilter extends ZuulFilter {
			@Override
			public boolean shouldFilter();
				* �жϵ�ǰ�������Ƿ�ִ��,������� true,��ִ��:run() ����

			@Override
			public Object run();
				* ִ��У��ķ���
				* Ŀǰ��ܲ���ȥ������ֵ(�����˷���ֵ)

			@Override
			public String filterType();
				* ���������������,�������˹�������������ĸ�����������ִ��,ö���ַ���
					pre(FilterConstants.PRE_TYPE)
						* ������·��֮ǰִ��
					error(FilterConstants.ERROR_TYPE)
						* �������쳣ʱ����
					post(FilterConstants.POST_TYPE)
						* �����(route��error֮��)����
					route(FilterConstants.ROUTE_TYPE)
						* ������·��ʱ����
					

			@Override
			public int filterOrder();
				* �����ڶ����������ʱ��,��ֵ�����˹�������ִ��˳��
				* ��ֵԽС,���ȼ�Խ��
		}
	
	# У��СDemo
		@Override
		public Object run() {
			RequestContext requestContext = RequestContext.getCurrentContext();
			HttpServletRequest httpServletRequest = requestContext.getRequest();
			if(httpServletRequest.getHeader("auth") == null) {
				//������·��
				requestContext.setSendZuulResponse(false);
				//������Ӧ״̬��Ϊ401
				requestContext.setResponseStatusCode(HttpServletResponse.SC_UNAUTHORIZED);
				return null;
			}
			return null;
		}


------------------------
�쳣����				|
------------------------
	# ʹ�� SendErrorFilter ������
		SendErrorFilter
			* ���������쳣,�������Ƿ�ִ�е�������,�������д����쳣,������δת����errorPath
				@Override
				public boolean shouldFilter() {
					RequestContext ctx = RequestContext.getCurrentContext();
					return ctx.getThrowable() != null && !ctx.getBoolean("sendErrorFilter.ran", false);
				}

		* ������ִ�й����������쳣,������SendErrorFilter�����쳣����
			RequestContext requestContext = RequestContext.getCurrentContext();
			requestContext.setThrowable(new Exception());

		* Ҳ����������µĲ���
			// �������
			requestContext.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			// �쳣����
			requestContext.set("error.exception",new Exception());
			// ������Ϣ
			requestContext.set("error.message","������Ϣ");
	
	# ��Ϊ���������������:pre,post,route �����׶���,ֻҪ���쳣�׳�������뵽erro�׶εĴ���,���Կ����Զ���ErrorFilter
		
	
		

------------------------
FilterProcessor			|
------------------------
	FilterProcessor getInstance()
	void setProcessor(FilterProcessor processor)



------------------------
RequestContext			|
------------------------
	# ����������
	# RequestContext
		HttpServletResponse getResponse();
        StringBuilder getFilterExecutionSummary();
        getOriginContentLength();
        getOriginResponseHeaders();
        getZuulResponseHeaders();
        getZuulEngineRan();
        getResponseGZipped();
        getResponseDataStream();
        getRequestQueryParams();
        getResponseStatusCode();
        getRouteHost();
        getResponseBody();

