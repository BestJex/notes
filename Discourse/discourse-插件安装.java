--------------------------------
�����װ						|
--------------------------------
	# �ٷ��̳�
		https://meta.discourse.org/t/install-plugins-in-discourse/19157
	
	# ����
		1. ��ȡ�������git��ַ(github/bitbucket)
		2. �������Ŀ¼, �༭: app.yml
			cd /var/discourse
			vim containers/app.yml
		
		3. ��Ӳ����ַ��hock
			hooks:
			  after_code:
				- exec:
					cd: $home/plugins
					cmd:
					  - git clone https://github.com/discourse/docker_manager.git
					  - git clone https://github.com/discourse/discourse-spoiler-alert.git
		4. �ع�����
			cd /var/discourse
			./launcher rebuild app
		
--------------------------------
һЩ���ͳ��					|
--------------------------------
	# �ٷ��Ĳ��ͳ��
		https://meta.discourse.org/c/plugin
	
	# ����/������
		https://github.com/discourse/discourse-solved.git
	
	# �ȸ�����
		https://github.com/discoursehosting/discourse-adsense.git

		* CSP������Ҫ�������������
			pagead2.googlesyndication.com
			adservice.google.com

base-uri 'none'; 
object-src 'none'; 
script-src 'unsafe-eval' 
'report-sample' 
https://forum.springboot.io/logs/ 
https://forum.springboot.io/sidekiq/ 
https://forum.springboot.io/mini-profiler-resources/ 
https://forum.springboot.io/assets/ 
https://forum.springboot.io/brotli_asset/ 
https://forum.springboot.io/extra-locales/ 
https://forum.springboot.io/highlight-js/ 
https://forum.springboot.io/javascripts/ 
https://forum.springboot.io/plugins/ 
https://forum.springboot.io/theme-javascripts/ 
https://forum.springboot.io/svg-sprite/ 
hm.baidu.com 
zz.bdstatic.com
push.zhanzhang.baidu.com 
pagead2.googlesyndication.com 
adservice.google.com; 
