--------------------------
recaptcha
--------------------------
	# ע���ַ����Ҫ��ǽ��
		https://www.google.com/recaptcha/admin/create
	
	# �������̨
		https://www.google.com/recaptcha/admin/site/350006937
	
	# �ĵ���ַ
		https://developers.google.com/recaptcha/intro
	
	
	# �ͻ��˼���
		<script src="https://www.google.com/recaptcha/api.js?render=_reCAPTCHA_site_key"></script>
		<script>
			grecaptcha.ready(function() {
				grecaptcha.execute('_reCAPTCHA_site_key_', {action: 'homepage'}).then(function(token) {
				
				});
			});
		</script>
		

		* grecaptcha.ready ����reCAPTCHA�����ʱ����

		* '_reCAPTCHA_site_key_' ����ҳ��Կ

		* ͨ��ִ��: grecaptcha.execute(...) ������ִ����֤
	
		* action����, ��ʾ��֤�ĳ����������Զ��塣�ں�̨��������Բ�ͬ�ĳ�������ͬ������
			homepage		��ҳ
			login			��¼
			social			�罻
			e-commerce		����
		
		* token ��Ҫ�ύ����ˣ����ͨ����֤API�ж������Ƿ�Ϸ�

		* (Fuck GFW)���ڵ��û�����Ҫ��js��ĵ�ַ����Ϊ: https://www.recaptcha.net/recaptcha/api.js

			
	
	# ����˼̳�
		* POST �ӿ�
			https://www.google.com/recaptcha/api/siteverify
				secret			����˵� secret
				response		�ͻ������ɵ�token
				remoteip		��ѡ�Ĳ������ͻ���ip��ַ
		
		* (Fuck GFW)���ڵ��û�����Ҫ��api��ַ����Ϊ: https://www.recaptcha.net/recaptcha/api/siteverify
		
		* ��Ӧ
			{
			  "success": true|false,      // �������Ƿ���վ�����ЧreCAPTCHA����
			  "score": number             // ������ķ�����0.0-1.0�����˻��жϵĲο�ֵ��1 �����࣬0�ǻ�����
			  "action": string            // �������֤����
			  "challenge_ts": timestamp,  // ��ѯ���ص�ʱ�����ISO��ʽyyyy-MM-dd'T'HH:MM:ssZZ��
			  "hostname": string,         // ʹ��reCAPTCHA��վ���������
			  "error-codes": [...]        // ��ѡ�Ĵ������
			}
		
			* error-codes �쳣״̬��
				Error code				Description
				missing-input-secret	secret������ʧ��
				invalid-input-secret	secret������Ч���ʽ����
				missing-input-response	ȱ����Ӧ������
				invalid-input-response	��Ӧ������Ч���ʽ����
				bad-request	The request ��������Ч���ʽ����
				timeout-or-duplicate	��Ӧ������Ч��̫�ɻ���ǰʹ�ù���
	

	# ����reCAPTCHAͼ��
		* ���css
			.grecaptcha-badge { 
				display: none; 
			} 

	