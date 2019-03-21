----------------------------
Topic						|
----------------------------
	
----------------------------
�������					|
----------------------------
	# ��������
		 bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
			--zookeeper
				* ָ��zk
			--partitions
				* ��������
			--replication-factor
				* ÿ�������ĸ�������
			--topic
				* ��������,һ�㲻Ҫ���»��߿�ͷ,��Ϊkafka�ڲ�������ʹ���»��߿�ͷ
			--replica-assignment
				* �����Լ����Ʒ����ķ���
				* ���ַ�ʽ���ݷ����ŵ���ֵ��С���մ�С�����˳���������,���������֮���ö���","����
				* �����ڶ��������ð��":"����
				* ������ʹ�øò�����������ʱ����Ҫԭ���ر��� partitions �� replication-factor ����������
				* ͬһ�������ڵĸ����������ظ�,����ָ���� 0:0,1:1 ����,�ͻᱨ���쳣
				
				--replica-assignment 2:0,0:1,1:2,2:1

				2:0 ��ʾ�� 0 ������,����������,��broker.id Ϊ 2 �� 0 �Ľڵ���
				0:1 ��ʾ�� 1 ������,����������,��broker.id Ϊ 0 �� 1 �Ľڵ���
				1:2 ��ʾ�� 2 ������,����������,��broker.id Ϊ 1 �� 2 �Ľڵ���
				2:1 ��ʾ�� 3 ������,����������,��broker.id Ϊ 2 �� 1 �Ľڵ���

			--config
				* �Զ�������,���������Ĭ������
				* ����������Դ��ڶ��,��ʾ���Ƕ��ֵ
					--config kek=value
					--config cleanup.policy=compact --config max.message.bytes=l000
			
			--if-not-exists
				* ��������Ѿ�����,�����׳��쳣,Ҳ���ᴴ���ɹ�
	
	# ����ͨ�� ZooKeeper �ͻ�������ȡ broker���������ķ������
		get /brokers/topics/[������]

		{"version":1,"partitions":{"2":[1,2]}}

		partitions:
			* ��ʾ��ǰ����ķ���"2",����������,��������border.id ���� 1 �� 2 �Ľڵ���
			* json�����key��ʾ����ķ������,value�����ʾ�÷����ĸ�������������Щbroker�ڵ���
				
		
		
	# �鿴��������
		bin/kafka-topics.sh --zookeeper localhost:2181 --describe --topic test
			--zookeeper
				* ָ��zk
			--describe
				* �鿴����ָ��
			--topic
				* ��������
		
		Topic(������):test      PartitionCount(��������):1        ReplicationFactor(ÿ������������):1     Configs(�����������Ϣ):
        Topic: test     Partition(������): 0    Leader(��ǰ����Lader�������ڽڵ��broker.id): 2       Replicas(��ǰ�������и������ڽڵ��broker.id - AR): 2     Isr(��ǰ������ISR���� - ISR): 2
		
		Replicas
			* ��ǰ�������������Щ�ڵ���