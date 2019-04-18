# ������:ZuulProperties

zuul:
  # ��ֹ��Ĭ�ϵķ�ʽ���ʷ���
  ignored-services: "*"
  # ·�ɱ�
  routes:
    # �Զ����·������
    api-user:
	  # ���ʵ�·��
      path: /user-api/***/
	  # ת�����ķ���
      service-id: USER-SERVICE
	  # ת����URL
	  url: https://springboot.io 
	  # ��·���Ƿ�����ʧ������
	  retryable: false
  
  # ͳһ��ǰ���ص�ǰ׺
  prefix: /api
  # �������غ��Ե�URI
  ignored-patterns:
    - /**/foo/****/
  # �������е�httpͷ
  sensitive-headers:
    - Cookie
    - Set-Cookie
    - Authorization
  # ��ӿͻ���(������)��HOST��httpͷ
  add-host-header: true
  # �Ƿ�����ʧ������
  retryable: false