--------------------------------
kafka ά��						|
--------------------------------
	# ����Kafka
		kafka-server-start.bat ../../config/server.properties
	
	# �ر�
		kafka-server-stop.sh
	
	# ��������
		 bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
			--create
				* ����ָ��
			--zookeeper
				* ָ��zk�ĵ�ַ
			--partitions
				* �������ٸ�partition
			--replication-factor
				* ÿ��partition���ٸ�����
			--topic
				* ����topic������
			
	# �鿴����������
		bin/kafka-topics.sh --zookeeper localhost:2181 --list
	
	# �鿴���������
		bin/kafka-topics.sh --zookeeper localhost:2181 --describe --topic test

		Topic:test      PartitionCount:1        ReplicationFactor:1     Configs:
        Topic: test     Partition: 0    Leader: 2       Replicas: 2     Isr: 2
	
	# ɾ������
		bin/kafka-topics.sh --zookeeper localhost:2181 --delete --topic test
		

	# �򿪻��ڿ���̨����Ϣ������	
		bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
			--broker-list
				* ָ����Ⱥ������ڵ�ĵ�ַ��Ϣ
			--topic
				* ָ��Ҫ���ĸ�topicд������
			

	# �򿪻��ڿ���̨����Ϣ������
		bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
			--bootstrap-server
				* ָ����Ⱥ�нڵ����Ϣ
			--topic
				* ֪��Ҫ�����ĸ��ڵ�
			
	