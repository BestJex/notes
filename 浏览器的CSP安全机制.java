------------------------
CSP����					|
-----------------------
	# �ο���ַ
		http://www.ruanyifeng.com/blog/2016/09/csp.html
		https://developer.mozilla.org/zh-CN/docs/Web/HTTP/CSP
	
	# ������ͨ�� meta ��ǩ������
		<meta http-equiv="Content-Security-Policy" content="script-src 'self'; object-src 'none'; style-src cdn.example.org third-party.org; child-src https:">
	
	# ͨ��HttpHeader������
		Content-Security-Policy
	
	# �����Ƶ���Դ�б�
		script-src		�ⲿ�ű�
		style-src		��ʽ��
		img-src			ͼ��
		media-src		ý���ļ�����Ƶ����Ƶ��
		font-src		�����ļ�
		object-src		��������� Flash��
		child-src		���
		frame-ancestors	Ƕ����ⲿ��Դ������<frame>��<iframe>��<embed>��<applet>��
		connect-src		HTTP ���ӣ�ͨ�� XHR��WebSockets��EventSource�ȣ�
		worker-src		worker�ű�
		manifest-src	manifest �ļ�
		form-action		Form����action
		frame-src		ʹ��Ԫ��(��<frame>��<iframe>)���ص�Ƕ�����������ָ����Ч��Դ

	# default-src Ĭ��ֵ
		* default-src���������������ѡ���Ĭ��ֵ
			Content-Security-Policy: default-src 'self'
		
		* ���ͬʱ����ĳ����������,��ô�Ḳ��Ĭ�ϵ�ֵ
	
	# URL ����
		frame-ancestors	����Ƕ���ܵ���ҳ
		base-uri		����<base#href>
		form-action		����<form#action>
	
	
	# ��������
		block-all-mixed-content		HTTPS ��ҳ���ü��� HTTP ��Դ��������Ѿ�Ĭ�Ͽ�����
		upgrade-insecure-requests	�Զ�����ҳ�����м����ⲿ��Դ�� HTTP ���ӻ��� HTTPS Э��
		plugin-types				���ƿ���ʹ�õĲ����ʽ
		sandbox						�������Ϊ�����ƣ����粻���е������ڵȡ�
	
	# report-uri ����
		* report-uri�����������������Ӧ�ð�ע����Ϊ������ĸ���ַ
			report-uri /csp_report_parser;
		
		* �������ʹ��POST����������һ��JSON����
			{
			  "csp-report": {
				"document-uri": "http://example.org/page.html",	//����Υ����ĵ���URI��
				"referrer": "http://evil.example.com/",	//referrer
				"blocked-uri": "http://evil.example.com/evil.js",	//��CSP��ֹ����ԴURI���������ֹ��URI���Բ�ͬ��Դ�����ĵ�URI����ô����ֹ����ԴURI�ᱻɾ����������Э�飬�����Ͷ˿ںš�
				"violated-directive": "script-src 'self' https://apis.google.com", //Υ���Ĳ������ơ�
				"original-policy": "script-src 'self' https://apis.google.com; report-uri http://example.org/my_amazing_csp_report_parser" // �� Content-Security-Policy HTTP ͷ����ָ����ԭʼ���ԡ�
			  }
			}

	# Content-Security-Policy-Report-Only
		* ��ִ������ѡ�ֻ�Ǽ�¼Υ�����Ƶ���Ϊ
		* ��Ϊֻ��¼,������������report-uriѡ�����ʹ��
			Content-Security-Policy-Report-Only: default-src 'self'; ...; report-uri /my_amazing_csp_report_parser;
	
	# �������Ƶ�ѡ��ֵ
		������: 
			example.org
			https://example.com:443

		·����: 
			example.org/resources/js/

		ͨ���: 
			*.example.org,	��ʾ����Э��
			*://*.example.com:* ����������,����˿�
		Э����:
			https:
			data:
		�ؼ���: 'self' ��ǰ��������Ҫ������
		�ؼ���: 'none' ��ֹ�����κ��ⲿ��Դ����Ҫ������
	
		* �����ж��ֵ,ʹ�ÿո�ָ�,ÿ��ѡ��ʹ��;�ָ�
			Content-Security-Policy: default-src 'none'; img-src 'self' data:; script-src 'self'

		* ���ͬһ������ѡ��ʹ�ö��,ֻ�е�һ�λ���Ч

	# script-src ������ֵ
		* ע�⣬������Щֵ��������ڵ���������

		'unsafe-inline':����ִ��ҳ����Ƕ��<script>��ǩ���¼���������

		unsafe-eval:�����ַ�����������ִ�У�����ʹ��eval��setTimeout��setInterval��Function�Ⱥ�����

		nonceֵ:ÿ��HTTP��Ӧ����һ����Ȩtoken��ҳ����Ƕ�ű����������token���Ż�ִ��
			Content-Security-Policy: script-src 'nonce-EDNnf03nceIOfn39fn3e9h3sdfa'
			<script type="text/javascript" nonce="EDNnf03nceIOfn39fn3e9h3sdfa">
				console.log('��������ִ��');
			</script>

		hashֵ:�г�����ִ�еĽű������Hashֵ��ҳ����Ƕ�ű��Ĺ�ϣֵֻ���Ǻϵ�����£�����ִ�С�
			Content-Security-Policy: script-src 'sha256-qznLcsROx4GACP2dm0UCKCzCG-HiZ1guq6ZZDob_Tng='
		
		* nonce��hash����������style-src
	
	# script-src��object-src�Ǳ���ģ�����������default-src
		* object-src��������Ϊ Flash �������ִ���ⲿ�ű�
	
	# script-src����ʹ��unsafe-inline�ؼ��֣����ǰ���һ��nonceֵ����Ҳ������������data:URL��
		<img src="x" onerror="evil()">					//unsafe-inline �ᵼ����ִ��
		<script src="data:text/javascript,evil()"></script>	//���� data:Э��,�ᵼ����ִ��
	
	# ��Ҫע��jsonpҲ�п��ܵ���xss
		<script
			src="/path/jsonp?callback=alert(document.domain)//">
		</script>


------------------------
CSP����	�ܽ�			|
-----------------------
	# httpͷ����
		Content-Security-Policy
	
	# �������õ�ѡ��
		script-src		�ⲿ�ű�
		style-src		��ʽ��
		img-src			ͼ��
		media-src		ý���ļ�����Ƶ����Ƶ��
		font-src		�����ļ�
		object-src		��������� Flash��
		child-src		���
		frame-ancestors	Ƕ����ⲿ��Դ������<frame>��<iframe>��<embed>��<applet>��
		connect-src		HTTP ���ӣ�ͨ�� XHR��WebSockets��EventSource�ȣ�
		worker-src		worker�ű�
		manifest-src	manifest �ļ�
		default-src		����ѡ���Ĭ��ѡ��(���Ա�����)
		form-action		Form����action

	# �������õ�ֵ
		* ������: 
			example.org
			https://example.com:443

		* ·����: 
			example.org/resources/js/

		* ͨ���: 
			*.example.org,				//��ʾ����Э��
			*:/\/\*.example.com:*			//����Э��,����������,����˿�

		* Э����:
			https:
			data:

		* �ؼ���: 'self' ��ǰ��������Ҫ������
		* �ؼ���: 'none' ��ֹ�����κ��ⲿ��Դ����Ҫ������
	
	# script-src ������ֵ
		* ע�⣬������Щֵ��������ڵ���������

		'unsafe-inline':����ִ��ҳ����Ƕ��<script>��ǩ���¼���������

		unsafe-eval:�����ַ�����������ִ�У�����ʹ��eval��setTimeout��setInterval��Function�Ⱥ�����

		nonceֵ:ÿ��HTTP��Ӧ����һ����Ȩtoken��ҳ����Ƕ�ű����������token���Ż�ִ��
			Content-Security-Policy: script-src 'nonce-EDNnf03nceIOfn39fn3e9h3sdfa'
			<script type="text/javascript" nonce="EDNnf03nceIOfn39fn3e9h3sdfa">
				console.log('��������ִ��');
			</script>

		hashֵ:�г�����ִ�еĽű������Hashֵ��ҳ����Ƕ�ű��Ĺ�ϣֵֻ���Ǻϵ�����£�����ִ�С�
			Content-Security-Policy: script-src 'sha256-qznLcsROx4GACP2dm0UCKCzCG-HiZ1guq6ZZDob_Tng='
		
		* nonce��hash����������style-src
	
	# ��������ѡ��(û��ֵ)
		block-all-mixed-content		HTTPS ��ҳ���ü��� HTTP ��Դ(������Ѿ�Ĭ�Ͽ���)
		upgrade-insecure-requests	�Զ�����ҳ�����м����ⲿ��Դ�� HTTP ���ӻ��� HTTPS Э��
		plugin-types				���ƿ���ʹ�õĲ����ʽ
		sandbox						�������Ϊ������,���粻���е������ڵ�

	
	# report-uri ����
		* report-uri���������������,Ӧ�ð�ע����Ϊ������ĸ���ַ
			report-uri /csp_report_parser;
		
		* �������ʹ��POST����������һ��JSON����
			{
			  "csp-report": {
				"document-uri": "http://example.org/page.html",	//����Υ����ĵ���URI��
				"referrer": "http://evil.example.com/",	//referrer
				"blocked-uri": "http://evil.example.com/evil.js",	//��CSP��ֹ����ԴURI���������ֹ��URI���Բ�ͬ��Դ�����ĵ�URI����ô����ֹ����ԴURI�ᱻɾ����������Э�飬�����Ͷ˿ںš�
				"violated-directive": "script-src 'self' https://apis.google.com", //Υ���Ĳ������ơ�
				"original-policy": "script-src 'self' https://apis.google.com; report-uri http://example.org/my_amazing_csp_report_parser" // �� Content-Security-Policy HTTP ͷ����ָ����ԭʼ���ԡ�
			  }
			}