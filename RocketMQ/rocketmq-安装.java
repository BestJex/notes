
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



## Ĭ�϶˿�
mqnamesrv:9876
mqbroker - mqnamesrv:10909
mqbroker - client:10911

## ����
### ����namesrc
nohup ./bin/mqnamesrv -n "0.0.0.0:9876" > /dev/null &

### �޸������ļ������ñ�����ip���Ա������ߣ������߷��ʵ�
echo 'brokerIP1=192.168.0.3' > conf/broker.properties

### ����broker 
nohup ./bin/mqbroker -n localhost:9876 -c conf/broker.properties autoCreateTopicEnable=true > /dev/null &