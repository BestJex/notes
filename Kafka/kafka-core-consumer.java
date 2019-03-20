------------------------
consumer				|
------------------------
	# ÿ�������߶���һ��������,һ����������N���������

	# һ��������������Ѷ����������Ϣ

	# ÿһ����������Ϣ,ֻ�ܱ�һ���������е�һ������������

	# ����������е����������������˷���������,�����Ļᵼ�¶��ȥ��������һֱ���ڿ���״̬
	
	# ͨ�׵����
		* һ��topic���Ա��������������,������Щ���������ѵĶ�����ͬ������
		* topic������������˵,�ǹ㲥,һ����Ϣ�ᷢ�͵������������

		* ���������ѵ���topic
		* ����topic��ʱ��,topic��������з���,������ȵķֲ������������������������
		* һ�������ڷ�������Ϣ,ֻ�ܱ�һ������������
		* ��Ϣ������������˵,�ǵ���,һ����Ϣֻ�ܱ��������е�һ������������
	
	# Maven
		<dependency>
			<groupId>org.apache.kafka</groupId>
			<artifactId>kafka-clients</artifactId>
			<version>2.1.1</version>
		</dependency>
	
	# �����߼�
		1. ���������߿ͻ��˵Ĳ���
		2. ���ݲ�������������ʵ������
		3. ��������
		4. ��ȡ��Ϣ��������
		5. �ύ����λ��
		6. �ر�������ʵ��

	# ����������
		Properties properties = new Properties();
		properties.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.setProperty("bootstrap.servers", "localhost:9092");
		properties.setProperty("group.id", "group.demo");

		try (KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties)) {
			kafkaConsumer.subscribe(Arrays.asList("test"));
			while (true) {
				ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofMillis(1000));
				for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
					String value = consumerRecord.value();
					System.out.println(value);
				}
			}
		}
	
	# �����߱�������һ��������
		* ͨ�� group.id ��������
			properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "group.demo");
		* ���������,Ĭ��Ϊ���ַ���
		* һ��������ֵ������Ҫ��һ����ҵ������
	
	# ���ⶩ��
		* ���api
			Set<String> subscription()
			void subscribe(Collection<String> topics)
			void subscribe(Collection<String> topics, ConsumerRebalanceListener listener)
			void subscribe(Pattern pattern)
			void subscribe(Pattern pattern, ConsumerRebalanceListener listener)
		
		* ��������,����������ظ��ĵ���,��ô�����һ�ε��õ�Ϊ׼
		* ���ʹ��������ʽ�ķ���(Pattern)����������,���������ⲻ����Ҳ����,�����ⱻ������,��������������ᱻ�Զ��Ķ���
		* ���ؾ��������:ConsumerRebalanceListener 
			 void onPartitionsRevoked(Collection<TopicPartition> partitions);
			 void onPartitionsAssigned(Collection<TopicPartition> partitions);

		* ʹ�����ַ�ʽ���ж�����Ϣ�����Զ����ؾ���Ĺ���
		* �ڶ�������ߵ������,���Ը��ݷ�������������Զ��������������������Ĺ�ϵ
		* ���������������ߵ�����/����,���������ϵ���Զ�����ת,�Լ�ʵ�ֹ��ϵ��Զ�ת��
	
	# ��������
		* ���api
			void assign(Collection<TopicPartition> partitions)
			Set<TopicPartition> assignment()

		* TopicPartition ����������������������
			private int hash = 0;			//hashֵ
			private final int partition;	// �������
			private final String topic;		// ������Ϣ
			TopicPartition(String topic, int partition)

		* ���ַ�ʽ����,���߱��Զ��ĸ��ؾ��⹦��
	
	# ���ⶩ��ģʽ�Ļ�����
		* ���ϵĶ��ķ�ʽ:AUTO_TOPICS
			subscribe(Collection<String> topics)
		* ������ʽ�Ķ��ķ�ʽ:AUTO_PATTERN
			subscribe(Pattern pattern)
		* ָ�������Ķ��ķ���:AUTO_ASSIGNED
			assign(Collection<TopicPartition> partitions)

		* �����ֶ��ķ�������ͬʱ����,ֻ��ѡ��һ��,��Ȼ���׳��쳣
	
	# ��Ϣ�Ľ�����
		* ͨ�� key.deserializer/value.deserializer ����key/value�Ľ�����
			properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"");
			properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"");
		
		* �������ӿ�:Deserializer
			void configure(Map<String, ?> configs, boolean isKey);
				* ����
			T deserialize(String topic, byte[] data);
				* ������Ϣ
			default T deserialize(String topic, Headers headers, byte[] data) {
				return deserialize(topic, data);
			}	
				* ���Ի�ȡ����Ϣͷ�Ľ��뷽��

			@Override
			void close();

		* ����ж��,ʹ�ö��ŷָ�
	
	# ��Ϣ����
		* ��Ϣ����ģʽΪ������topic��ȡ��Ϣ,����һ��������ѯ�Ĺ���
		* ���api
			ConsumerRecords<K, V> poll(final Duration timeout)
		* ��ֵ������ȡ���ڳ������Ӧ�ٶȵ�Ҫ��
		* �������Ϊ0,poll���������ض������Ƿ���ȡ��������
		* ����̵߳Ĺ���������Ϊ����ȡ����,��ô��ֵ��������Ϊ Long.MAX_VALUE


	# ���ƻ��߹ر�����
	# ָ��λ����Ϣ
	# ���ؾ���
	# ���߳�����
	