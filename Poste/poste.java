-----------------------------
Poste						 |
-----------------------------
	# ����
		https://poste.io
	
	# ��������

mail.springcloud.io		A		[�ʼ�������ip]
springcloud.io			MX		mail.springcloud.io. 10
springcloud.io			IN TXT	"v=spf1 mx ~all"

[�ʼ�������ip]				PTR		mail.springcloud.io
	* ��û������


	# Docker ��װ
docker run \
-p 25:25 \
-p 80:80 \
-p 110:110 \
-p 143:143 \
-p 443:443 \
-p 587:587 \
-p 993:993 \
-p 995:995 \
-v /etc/localtime:/etc/localtime:ro \
-v /srv/poste/data:/data \
--name "PosteServer" \
-h "mail.springcloud.io" \
-t analogic/poste.io
	
	# ����admin����
		admin@springcloud.io

	# SSL����
		System settings -> TLS Certificate -> Let's Encrypt certificate
	
