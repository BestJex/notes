# frp��ַ
	https://github.com/fatedier/frp/releases
	https://github.com/fatedier/frp/blob/master/README_zh.md

# ����˰�װ
	* ���� & ��ѹ
		wget https://github.com/fatedier/frp/releases/download/v0.30.0/frp_0.30.0_linux_amd64.tar.gz

	* �����ļ��༭����������ļ�
		vi frps.ini
[common]
bind_port = 7000
# 80�˿ڵ�http����
vhost_http_port = 80
# �ͻ��˵�����token
token = aabbcc123456

log_file = ./frps.log
log_level = info
log_max_days = 3

# �������̨������
dashboard_port = 7500
dashboard_user = admin
dashboard_pwd = frV1n123456
		
	## ��������˽���
		 nohup ./frps -c ./frps.ini &
	
# �ͻ��˰�װ
	* ���� & ��ѹ
		https://github.com/fatedier/frp/releases/download/v0.30.0/frp_0.30.0_windows_amd64.zip
	
	* ���ÿͻ����ļ�
		frpc.ini
[common]
server_addr = [����������ip]
server_port = 7000
# ��������õ�token
token = aabbcc123456

[web]
type = http
# ���ص�http����˿�
local_port = 80
# ���������������Զ�������
custom_domains = frp.springboot.io
	
	* �����ͻ���
		frpc.exe -c frpc.ini