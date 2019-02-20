----------------------
�����ļ�����		  |
----------------------
	{
	  "log": {},
	  "api": {},
	  "dns": {},
	  "stats": {},
	  "routing": {},
	  "policy": {},
	  "reverse": {},
	  "inbounds": [],
	  "outbounds": [],
	  "transport": {}
	}
	# �Ĵ���Э��
		HTTP,SOCKS,VMess,Shadowsocks,Dokodemo-door

	# ����Э���� 
		VMess,Shadowsocks,Blackhole,Freedom,SOCKS
	
	# ��־������
		*  "log" ����
			{
				"loglevel": "warning",
				"access": "/var/log/v2ray/access.log", 
				"error": "/var/log/v2ray/error.log"
			}

		* ��־����:loglevel
			debug	����ϸ����־��Ϣ��ר�����������
			info	�Ƚ���ϸ����־��Ϣ�����Կ��� V2Ray ��ϸ��������Ϣ
			warning	������Ϣ����΢��������Ϣ�����ҹ۲� warning �������Ϣ�������������Ƽ�ʹ�� warning
			error	������Ϣ���Ƚ����صĴ�����Ϣ�������� error ʱ����������Ӱ�� V2Ray ����������
			none	�ա�����¼�κ���Ϣ

	# alterId 
		* ���������Ҫ��Ϊ�˼�ǿ��̽������
		* ������ alterId Խ��Խ��,��Խ���Լռ�ڴ�(ֻ��Է��������ͻ��˲�ռ�ڴ�),��������֮����һ���м�ֵ������õ�
		* ��ô���������õģ���ʵ����Ƿֳ����ģ���û���ϸ���Թ�������������ݾ��飬alterId ��ֵ��Ϊ 30 �� 100 ֮��Ӧ���ǱȽϺ��ʵġ�
		* alterId �Ĵ�СҪ��֤�ͻ��˵�С�ڵ��ڷ������ġ�

----------------------
һ������			  |
----------------------
# ����������
{
  "inbounds": [
    {
      "port": 16823, // �����������˿�
      "protocol": "vmess",    // ������Э��
      "settings": {
        "clients": [
          {
            "id": "b831381d-6324-4d53-ad4f-8cda48b30811",  // �û� ID���ͻ����������������ͬ
            "alterId": 64
          }
        ]
      }
    }
  ],
  "outbounds": [
    {
      "protocol": "freedom",  // ������Э��
      "settings": {}
    }
  ]
}

 
# �ͻ�������
{
  "inbounds": [
    {
      "port": 1080, // �����˿�
      "protocol": "socks", // ���Э��Ϊ SOCKS 5
      "sniffing": {
        "enabled": true,
        "destOverride": ["http", "tls"]
      },
      "settings": {
        "auth": "noauth"  //socks����֤���ã�noauth ������֤������ socks ͨ���ڿͻ���ʹ�ã��������ﲻ��֤
      }
    }
  ],
  "outbounds": [
    {
      "protocol": "vmess", // ����Э��
      "settings": {
        "vnext": [
          {
            "address": "serveraddr.com", // ��������ַ�����޸�Ϊ���Լ��ķ����� IP ������
            "port": 16823,  // �������˿�
            "users": [
              {
                "id": "b831381d-6324-4d53-ad4f-8cda48b30811",  // �û� ID���������������������ͬ
                "alterId": 64 // �˴���ֵҲӦ�����������ͬ
              }
            ]
          }
        ]
      },
	  "mux": {"enabled": true}
    }
  ]
}

