------------------------
ϵͳԤ����Filter		|
------------------------
	ServletDetectionFilter
		* ����ִ��˳��Ϊ: -3;
		* ����ִ��ʱ��Ϊ: pre
		* ������ִ�е�Filter
		* ��Ҫ�����þ��Ǽ��,��ǰ��������Spring�� DispatcherServlet ���� ZuulServlet ���������е�
		* ���ļ�����ᱣ����һ�������Ĳ�����:String IS_DISPATCHER_SERVLET_REQUEST_KEY = "isDispatcherServletRequest";
			RequestUtils.isZuulServletRequest();
			RequestUtils.isDispatcherServletRequest();

	Servlet30WrapperFilter
		* ����ִ��˳��Ϊ: -2
		* ����ִ��ʱ��Ϊ: pre
		* ���ǵڶ���ִ�й�����
		* ��Ҫ�����þ��ǰ� HttpServletRequest ��װΪ:Servlet30RequestWrapper(װ�������ģʽ)

	FormBodyWrapperFilter
		* ����ִ��˳��Ϊ: -1
		* ����ִ��ʱ��Ϊ: pre
		* ���ǵ�����ִ�е�Filter
		* ��������������Ч:
			Content-Type = application/x-www-form-urlencoded
			Content-Type = multipart/form-data
		* ����Ŀ�ľ���Ϊ���������װΪ:FormBodyRequestWrapper ����

	DebugFilter
		* ����ִ��˳��Ϊ: 1
		* ����ִ��ʱ��Ϊ: pre
		* ���ǵ��ĸ�ִ�е�Filter
		* ��Filter�����ϵͳ����:zuul.debug.request �������е�debug�����������Ƿ�Ҫִ�й���������
		* ���ľ�����˲������ݾ���,�ѵ�ǰ�����������е� debugRouting �� debugRequest ��������Ϊtrue
		* ��ͬһ�����������������,�����Է��ʵ����ֵ,���Ժ�����Filer���Ը����������ֵ������һЩdbug��Ϣ
		* ������������е�debug������,����ͨ������������:zuul.debug.parameter


	PreDecorationFilter
		* ����ִ��˳��Ϊ: 5
		* ����ִ��ʱ��Ϊ: pre
		* ����ϵͳԤ�����pre�׶������ִ�е�Filter
		* �����жϵ�ǰ�������������Ƿ����:forward.to �� serviceId ����
		* �������,��ô���ͻ�ִ�й��˲���(ֻ��һ���������ڵĻ�,˵����ǰ�����Ѿ����������,��Ϊ��������Ϣ���Ǹ��ݵ�ǰ�����·����Ϣ���ؽ�����)
		* ���ľ�����˲�������,Ϊ��ǰ������һЩԤ����,�������·�ɹ����ƥ��,�����������������ø�����Ļ�����Ϣ�ȵ�
		* ��Щ��Ϣ�Ǻ������������д������Ҫ����,����ͨ��:RequestContext.getCurrentContext() ������

		* �����ڸ�ʵ���п���һЩ��HTTPͷ������ӵ��߼�:
			X-Forwarded-Prefix
			X-Forwarded-Host
			X-Forwarded-Port
			X-Forwarded-Proto
			....

		* ����ͨ������������,�Ƿ������Щ����ͷ(X-Forwarded-*):zuul.addProxyHeaders=true
		


	RibbonRoutingFilter
		* ����ִ��˳��Ϊ: 10
		* ����ִ��ʱ��Ϊ: route
		* ����route�׶ε�һ��ִ�еĹ�����
		* �ù�����ֻ�������������д���serviceId������������д���(Ҳ����ֻ��ͨ��serviceId����·�ɹ����������Ч)
		* �ù�������ִ���߼���������·�ɺ���,��ͨ��ʹ��Ribbon��Hystrix�������ʵ����������,��������ʵ����ִ�н������

	SimpleHostRoutingFilter
		* ����ִ��˳��Ϊ: 100
		* ����ִ��ʱ��Ϊ: route
		* ����route�׶εڶ���ִ�еĹ�����
		* �ù�����ֻ�������������д��� routeHost ������������д���(Ҳ����ͨ�� url ����·�ɹ����������Ч)
		* ����ִ���߼�����,ֱ�Ӷ� url ��������,ʹ�õ��� httpclient ��ʵ�ֵ�,û��ʹ��Hystrix������а�װ(����û���̸߳������Ͷ�·���ı���)

	SendForwardFilter
		* ����ִ��˳��Ϊ: 500
		* ����ִ��ʱ��Ϊ: route
		* ����route�׶ε�����ִ�еĹ�����
		* ��ֻ�������������д���:forward.to������������д���,����������·�ɹ����е�forward������ת����

	SendErrorFilter
		* ����ִ��˳��Ϊ: 0
		* ����ִ��ʱ��Ϊ: post
		* ����post�׶ε�һ��ִ�еĹ�����
		* �����������������а����� error.status_code ����(��֮ǰִ�еĹ��������õĴ������),���һ�û�б���ǰ�������������ʱ��ִ��
		* �����߼�����,ʹ�������������еĴ�����Ϣ�����һ�� forward �� api ���� /error ����˵������,������������Ӧ

	SendResponseFilter
		* ����ִ��˳��Ϊ: 1000
		* ����ִ��ʱ��Ϊ: post
		* ����post�׶ε����һ��ִ�еĹ�����
		* �ù����������������������Ƿ����������Ӧ��ص�ͷ��Ϣ,��Ӧ������������Ӧ��
		* ֻ���ڰ�����������һ����ʱ��ִ�д����߼�
		* �����߼�����:�������������ĵ���Ӧ��Ϣ����֯��Ҫ���ͻؿͻ��˵���Ӧ����

------------------------
ϵͳԤ����Filter		|
------------------------