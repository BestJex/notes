------------------------
ConsumerRecord<K, V>	|
------------------------
	# ���������ѵ���Ϣ����
	# ��̬����
		public static final long NO_TIMESTAMP = RecordBatch.NO_TIMESTAMP;
		public static final int NULL_SIZE = -1;
		public static final int NULL_CHECKSUM = -1;
	
	# ���캯��
		KafkaConsumer(Map<String, Object> configs)
		KafkaConsumer(Map<String, Object> configs,Deserializer<K> keyDeserializer,Deserializer<V> valueDeserializer)
		KafkaConsumer(Properties properties)
		KafkaConsumer(Properties properties,Deserializer<K> keyDeserializer,Deserializer<V> valueDeserializer)
	