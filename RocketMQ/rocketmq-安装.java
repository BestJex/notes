
# ������װ
	# ����,��ѹ
	# ���û�������
		export ROCKETMQ_HOME=/usr/local/rocketmq/alibaba-rocketmq

	# ����nameserver
		bin/mqnamesrv.sh
	
	# ����broker
		bin/mqbroker.sh

			-n 
				* ����ָ���󶨵������Ͷ˿�
				-n 0.0.0.0:9876
	
		
		mqbroker.cmd -n localhost:9876 autoCreateTopicEnable=true
	
		
		# �����쳣�޸Ľű�:runbroker.cmd

			set CLASSPATH=.;%BASE_DIR%conf;"%CLASSPATH%"