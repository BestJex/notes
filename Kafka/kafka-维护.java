--------------------------------
kafka ά��						|
--------------------------------
	# ����Kafka
		kafka-server-start.bat ../../config/server.properties
	
	# �ر�
		kafka-server-stop.sh
	
	# ��������
		 bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
		
	# �򿪻��ڿ���̨����Ϣ������	
		bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
	
	# �򿪻��ڿ���̨����Ϣ������
		bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
	

	