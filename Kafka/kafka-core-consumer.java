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
	
	# �������������(api)
	
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
	# λ���ύ
	# ���ƻ��߹ر�����
	# ָ��λ����Ϣ
	# ���ؾ���
	# ���߳�����
	