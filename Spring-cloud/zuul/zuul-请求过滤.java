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
						* ��������֮ǰִ��
					error(FilterConstants.ERROR_TYPE)
					post(FilterConstants.POST_TYPE)
					route(FilterConstants.ROUTE_TYPE)
					

			@Override
			public int filterOrder();
				* �����ڶ����������ʱ��,��ֵ�����˹�������ִ��˳��
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
requestContext			|
------------------------
