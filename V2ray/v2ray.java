----------------------------
v2ry						|
----------------------------
	# ��ַ
		https://www.v2ray.com
		https://github.com/v2ray/v2ray-core
	
----------------------------
�ٷ���װ					|
----------------------------
	# ���ز���װ V2Ray
		wget https://install.direct/go.sh
		bash go.sh

		* yum �� apt-get ���õ������,�˽ű����Զ���װ unzip �� daemon
		* ����������ǰ�װ V2Ray �ı�Ҫ���
		* ���ϵͳ��֧�� yum �� apt-get,�����а�װ unzip �� daemon
	
		* �˽ű����Զ���װ�����ļ�
			/usr/bin/v2ray/v2ray		V2Ray ����
			/usr/bin/v2ray/v2ctl		V2Ray ����
			/etc/v2ray/config.json		�����ļ�
			/usr/bin/v2ray/geoip.dat	IP �����ļ�
			/usr/bin/v2ray/geosite.dat	���������ļ�
		
		* ���нű�λ��ϵͳ������λ��
			/etc/systemd/system/v2ray.service: Systemd
			/etc/init.d/v2ray: SysV
		
		
		* �ű�������ɺ�����Ҫ��
	
	# �༭�ļ�
		/etc/v2ray/config.json
	
	# ������ά��
		systemctl start v2ray

		start
		stop
		status
		reload
		restart
		force-reload // ǿ�����¼���
	
	# �����͸���
		* �ٴ����ؽű�,���°�װ��OK
	
	# �ͻ��˵�����
		https://github.com/v2ray/v2ray-core/releases
						

----------------------------
v2ray	�����в���			|
----------------------------
	-version
		* ֻ�����ǰ�汾Ȼ���˳�,������ V2Ray ������



