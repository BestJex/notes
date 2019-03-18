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
	
	# ��Ϣ�����л�(������)
		* ��Ҫ�õ����л�,����Ϣ(key��value)���л�Ϊbyte[]
		* �������л��ӿ�:Serializer<T>
			byte[] serialize(String topic, T data);
		* ������Ϣ������(�������õ�����)
			properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
			properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

	
	# ������
		* ��Ϣsend()��brokerʱ���ܻᾭ��������,���л���(������),������֮��Żᱻ���͵�broker
		* �����Ϣ����(ProducerRecord)ָ����partition����ֵ,��ô�Ͳ���Ҫ��������,��Ϊ�Ѿ�ָ������
		* ���δָ��partition����ֵ,��ô��Ҫ�����ڷ�����,����key�ֶ��������partitionֵ
		* �������ӿ�:Partitioner
			void configure(Map<String, ?> configs)
			int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster);
			void close();
		
		* Kafka�ṩĬ�ϵķ�����ʵ��
			DefaultPartitioner
				* ���key��Ϊnull,��ô���key����hash(����MurmurHash2�㷨,�߱����������ܺ͵���ײ��)����
				* �������յ�hashֵ�����������
				* Ҳ����˵��ͬ��key�ᱻ���͵�ͬһ������(�����չ��partition��������ô�Ͳ��ܱ�֤��)
				* ����õ��ķ����Ż������з����е�����һ��,���ܻ�ѡ�񵽲����õķ���
			
				* ���KeyΪnull,��ô��Ϣ�ᱻ����ѯ�ķ�ʽ���͵�ÿ�����õķ���
				* ����õ��ķ����Ž�Ϊ���÷����е�����һ��,����ѡ�񵽲����õķ���
				
		* ʹ���Զ���ķ�����
			properties.setProperty(ProducerConfig.PARTITIONER_CLASS_CONFIG, "org.apache.kafka.clients.producer.internals.DefaultPartitioner");
			
	
	# ������
		* ��������������Ϣ������֮ǰ��һЩ�����Ĺ���,����:����,���ݵ��޸�
		* Ҳ���������ڷ��ͻص��߼�ǰ��һЩ���ƻ�������,����:ͳ��
		* �������ӿ�:ProducerInterceptor<K,V>
			void configure(Map<String, ?> configs);
			ProducerRecord<K, V> onSend(ProducerRecord<K, V> record);
			void onAcknowledgement(RecordMetadata metadata, Exception exception);
			void close();
		
		* Kafka������Ϣ����,��������֮ǰ������������onSend����

		* һ����˵��ò�Ҫ�޸���Ϣ��:topic,partition,key����Ϣ
		* ����ȷ����׼ȷ���ж�,������ܻ������Ԥ��������ƫ��Ŀ���
		* �������ܻ�Ӱ������ļ���,������ӡ��broker����־��ѹ������
		
		* Kafka������Ϣ��Ӧ��(send api����)֮ǰ������Ϣ����ʧ��ʱ������������onAcknowledgement����
		* һ����,��Ҫ�ж� exception �Ƿ�Ϊnull,�Ӷ�ȷ����Ϣ�Ƿ��ͳɹ�
		* ���������� Callback ִ��
		* �������������Producer��I/O�߳���,����Խ��Խ��,�����Ӱ����Ϣ�ķ����ٶ�

		* close()������Ҫ���ڹر�������ʱִ��һЩ��Դ��������

		* �������м�������,��ִ�����׳����쳣,���ᱻ���񲢼�¼����־
		* ���ǲ������ϴ���(�����׳�)
		
		* �������������ö�,�γ�һ��������(�������������)
		* �����������ĳһ���������׳����쳣,���ᱻ����
		* ��һ���������������һ��ִ�гɹ�����������ʼִ��(�Թ�ִ���쳣��������)
		* ���������ʹ�ö��ŷָ�

		* ����������
			properties.setProperty(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, "io.javaweb.kafka.interceptor.SimpleInterceptor");
		
		* ������������
			properties.setProperty(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, "SimpleInterceptor1,SimpleInterceptor1");

		