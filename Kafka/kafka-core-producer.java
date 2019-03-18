------------------------
producer				|
------------------------
	# Maven
		<dependency>
			<groupId>org.apache.kafka</groupId>
			<artifactId>kafka-clients</artifactId>
			<version>2.1.1</version>
		</dependency>
	
	# ��Ϣ�����ߵ��߼�
		1. ���ÿͻ��˲���,�Լ����ݲ���������Ӧ����Ϣ������ʵ��
		2. ������Ϣ
		4. ������Ϣ
		5. �رտͻ���(������ʵ��)

	# �����ķ�����ʾ
		Properties properties = new Properties();
		properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.setProperty("bootstrap.servers", "localhost:9092");
		properties.setProperty("client.id", "producer.client.id.demo");
		
		try(KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties)){
			ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("test", "��ð�");
			kafkaProducer.send(producerRecord);
		}

	# �쳣�Ŀ����Ի���
		* KafkaProducer �� һ��ᷢ���������͵��쳣 : �����Ե��쳣�Ͳ������Ե��쳣 
		* �����Ŀ������쳣
			NetworkException(�����쳣,����п�������������˲ʱ���϶����µ��쳣,����ͨ�����Խ��)
			LeaderNotAvailableException(������ leader ����������,����쳣ͨ�������� leader �������߶��µ� leader ����ѡ�����֮ǰ,����֮��������»ָ�)
			UnknownTopicOrPartitionException
			NotEnoughReplicasException
			NotCoordinatorException

		* �����Ĳ��������쳣
			RecordTooLargeException(���͵���Ϣ̫��,����ִ������,ֱ���׳�)

		* ��������� retries ����,��ôֻҪ�ڹ涨�����Դ��������лָ���,�Ͳ����׳��쳣(retries ������Ĭ��ֵΪ 0)
			props.put(ProducerConfig.RETRIES_CONFIG, 10);
	
	# ��Ϣ�����л�
		* ��Ҫ�õ����л�,����Ϣ���л�Ϊbyte[]
		* �������л��ӿ�:Serializer<T>


	# ��Ϣ�� key �� partition ��ѡ
		* partitionû��
			* key�����key���й�ϣ
			* ��ͬkeyȥһ��partition(�����չ��partition��������ô�Ͳ��ܱ�֤��)
		
		* keyû��
			* round-robin(��ѯ)��ѡpartition
	
	# produce������������,�����һ��,Ȼ��һ����,���ǵ�send()�ͽ������̽������緢��
		* ����ͬһ��partition������������,��һ��
		* Ȼ����һ���������߳�һ���Է���ȥ

