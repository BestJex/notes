--------------------------
recaptcha
--------------------------
	# ע���ַ����Ҫ��ǽ��
		https://www.google.com/recaptcha/admin/create
	
	# �������̨
		https://www.google.com/recaptcha/admin/site/350006937
	
	# �ĵ���ַ
		https://developers.google.com/recaptcha/intro

----------------------------------------------
recaptcha v2 - �������˻������֤����ѡ��
----------------------------------------------
	# ע�����ѡ������
		* �������˻������֤����ѡ�� ��
		* ���� reCAPTCHA ����
		* reCAPTCHA Android
	

	# �Զ���ȾreCAPTCHAС����
		<script src="https://www.google.com/recaptcha/api.js" async defer></script>
			* ����ʹ��https����

		<div class="g-recaptcha" data-sitekey="your_site_key"></div>
	

	# �ֶ���ȾreCAPTCHAС����
		<script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit" async defer></script>
			* onload��������Ϊonload�ص����������ƣ�������ص��������Լ�����api�������Ⱦ
			* ����render��������Ϊexplicit��
	
	# ���ڵ��û�����Ҫ��js��ĵ�ַ����Ϊ: https://www.recaptcha.net/recaptcha/api.js
	
	# js��Ĳ�ѯ����
		onload	��ѡ������ָ���ص�����������
		render	��ѡ�ġ��Ƿ���ʽ���ִ���С������Ĭ��ֵΪonload��������g-recaptcha�ҵ��ĵ�һ����ǩ�г��ִ���С������
		hl		��ѡ�ġ�ǿ�ƴ���С�������ض����Գ��֡����δָ�������Զ�����û������ԡ�
	
	# ��ǩ������
		data-sitekey			վ����Կ��

		data-theme				��ѡ�ġ�С��������ɫ���⡣
			dark
				* ��ɫ������
			light��Ĭ�ϣ�

		data-size				��ѡ�ġ�С�����Ĵ�С��
			compact				
				* ���������
			normal��Ĭ�ϣ�

		data-tabindex			��ѡ�ġ�С��������ѯ��tabindex�����ҳ���е�����Ԫ��ʹ��tabindex����Ӧ��������Ϊʹ�û����������ס�
			Ĭ��0

		data-callback			��ѡ�ġ���֤��Ļص����������token��Ϊ�������ݽ���
		data-expired-callback	��ѡ�ġ����Ļص����������ƣ���reCAPTCHA��Ӧ�������û���Ҫ������֤ʱִ�С�
		data-error-callback		��ѡ�ġ��ص����������ƣ���reCAPTCHA��������ͨ�����������ӣ�ʱִ�У������ڻָ�����֮ǰ�޷�����ִ�С�����ڴ˴�ָ�����ܣ�����֪ͨ�û�Ӧ���ԡ�
	
	# js��api
		grecaptcha.render(container,parameters)
			* ��Ⱦ����
				container Ԫ�ص�id������dom����
				parameters ��ʼ�����������Ǳ�ǩ�����ԣ������� {'siteKey': 'balababaaaa'}
			
			* ���᷵��һ��Ψһ��id������С������id(opt_widget_id)��

		grecaptcha.reset(opt_widget_id)
			* ������֤��
			* ��ѡ��С����id�����ûָ���������õ�һ��

		grecaptcha.getResponse(opt_widget_id)
			* ��ȡС��������Ӧ
			* ��ѡ��С����id�����ûָ�������ȡ��һ��
	
	

--------------------------
recaptcha v3
--------------------------
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

	
	# ����
		* �����ڿ���̨�ֶ�����js��api����token����tokenҲ����ͨ������˵���֤
		* ���һֱ�����ó���ȥ��ȡtoken��������˻���֤����ʧȥ�����ˣ�

--------------------------
����˽���
--------------------------
	#  POST �ӿ�
		https://www.google.com/recaptcha/api/siteverify
			secret			����˵� secret
			response		�ͻ������ɵ�token
			remoteip		��ѡ�Ĳ������ͻ���ip��ַ
		
		* (Fuck GFW)���ڵ��û�����Ҫ��api��ַ����Ϊ: https://www.recaptcha.net/recaptcha/api/siteverify
		

		* v2�汾����Ӧ
			{
				success: true							�Ƿ���֤ͨ��
				challenge_ts: "2020-02-28T03:52:03Z"
				hostname: "localhost"
			}
		
		* v3�汾����Ӧ
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

	

----------------------------------------------
recaptcha v2 - ǰ��demo
----------------------------------------------
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>�ȸ�ReCaptcha</title>
        <script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit" async defer></script>
	</head>
	<body>
		 <div id="recaptcha"></div>
         <button>����������֤</button>

	<script type="text/javascript">
        var id = null;
        function onloadCallback (){
            id = grecaptcha.render('recaptcha', {
                sitekey: '{{ clientSecret }}',
                callback: (token) => {
                    console.log('��֤��ص�:' + token);
                },
                theme: 'light',
            });
        }

        window.onload = () => {
            document.querySelector('button').addEventListener('click', () => {
                const token = grecaptcha.getResponse(id);
                if (!token){
                    alert('���ȵ�����������˻������֤��');
                    return;
                }
                fetch('/validate?token=' + token, {
                    method: 'GET'
                }).then(response => {
                    if (response.ok) {
                        response.json().then(message => {
                           console.log(message);
                           grecaptcha.reset(id);
                        });
                    }else {
                        //TODO
                    }
                })
            });
        }
	</script>
	</body>
</html>