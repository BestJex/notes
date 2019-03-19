---------------------------
KafkaConsumer<K, V>		   |
---------------------------
	# ��Ϣ������
	# ���캯��
		KafkaConsumer(Map<String, Object> configs)
		KafkaConsumer(Map<String, Object> configs,Deserializer<K> keyDeserializer,Deserializer<V> valueDeserializer)
		KafkaConsumer(Properties properties)
		KafkaConsumer(Properties properties,Deserializer<K> keyDeserializer,Deserializer<V> valueDeserializer) 
	
	# ʵ������
		Map<TopicPartition, Long> beginningOffsets(Collection<TopicPartition> partitions)
		Map<TopicPartition, Long> beginningOffsets(Collection<TopicPartition> partitions, Duration timeout)

		void close()
		void close(Duration timeout)

		void commitAsync()
		void commitAsync(final Map<TopicPartition, OffsetAndMetadata> offsets, OffsetCommitCallback callback)
		void commitAsync(OffsetCommitCallback callback)
		void commitSync()
		void commitSync(Duration timeout)
		void commitSync(final Map<TopicPartition, OffsetAndMetadata> offsets)
		void commitSync(final Map<TopicPartition, OffsetAndMetadata> offsets, final Duration timeout)

		OffsetAndMetadata committed(TopicPartition partition)
		OffsetAndMetadata committed(TopicPartition partition, final Duration timeout)

		Map<TopicPartition, Long> endOffsets(Collection<TopicPartition> partitions)
		Map<TopicPartition, Long> endOffsets(Collection<TopicPartition> partitions, Duration timeout)

		Map<String, List<PartitionInfo>> listTopics()
		Map<String, List<PartitionInfo>> listTopics(Duration timeout)

		Map<MetricName, ? extends Metric> metrics()

		Map<TopicPartition, OffsetAndTimestamp> offsetsForTimes(Map<TopicPartition, Long> timestampsToSearch)
		Map<TopicPartition, OffsetAndTimestamp> offsetsForTimes(Map<TopicPartition, Long> timestampsToSearch, Duration timeout)

		List<PartitionInfo> partitionsFor(String topic)
		List<PartitionInfo> partitionsFor(String topic, Duration timeout)
			* ����ָ����������з�����Ϣ,timeout ָ���ȴ�����Ԫ���ݵĳ�ʱʱ��
			* PartitionInfo ����һ��������Ϣ
					private final String topic;					// ����
					private final int partition;				// ��ǰ�ڵ���
					private final Node leader;					// leader�ڵ�
					private final Node[] replicas;				// ar�б�
					private final Node[] inSyncReplicas;		// isr�б�
					private final Node[] offlineReplicas;		// osr�б�
			* Node �����ڵ���Ϣ
				private final int id;
				private final String idString;
				private final String host;			//������
				private final int port;				// �˿�
				private final String rack;

		void pause(Collection<TopicPartition> partitions)
		Set<TopicPartition> paused()

		ConsumerRecords<K, V> poll(final Duration timeout)

		long position(TopicPartition partition)
		long position(TopicPartition partition, final Duration timeout)

		void resume(Collection<TopicPartition> partitions)

		void seek(TopicPartition partition, long offset)
		void seekToBeginning(Collection<TopicPartition> partitions)
		void seekToEnd(Collection<TopicPartition> partitions)
		
		Set<String> subscription()
		void subscribe(Collection<String> topics)
		void subscribe(Collection<String> topics, ConsumerRebalanceListener listener)
		void subscribe(Pattern pattern)
		void subscribe(Pattern pattern, ConsumerRebalanceListener listener)
			* ��������,����������ظ��ĵ���,��ô�����һ�ε��õ�Ϊ׼
			* ���ʹ��������ʽ�ķ�������������,���������ⲻ����Ҳ����,�����ⱻ������,��������������ᱻ�Զ��Ķ���
			* ���ؾ��������:ConsumerRebalanceListener 
				 void onPartitionsRevoked(Collection<TopicPartition> partitions);
				 void onPartitionsAssigned(Collection<TopicPartition> partitions);

			* ʹ�����ַ�ʽ���ж�����Ϣ�����Զ����ؾ���Ĺ���
			* �ڶ�������ߵ������,���Ը��ݷ�������������Զ��������������������Ĺ�ϵ
			* ���������������ߵ�����/����,���������ϵ���Զ�����ת,�Լ�ʵ�ֹ��ϵ��Զ�ת��

		
		void assign(Collection<TopicPartition> partitions)
		Set<TopicPartition> assignment()
			* ������ֱ�Ӷ���ָ�������ָ������
			* TopicPartition ����������������������
				private int hash = 0;			//hashֵ
				private final int partition;	// �������
				private final String topic;		// ������Ϣ
				TopicPartition(String topic, int partition)
			* ���ַ�ʽ����,���߱��Զ��ĸ��ؾ��⹦��

		void unsubscribe()
			* ȡ����������
			* Ҳ����ͨ�� subscribe ȥ����һ���յ����⼯�����ﵽȡ�����ĵ�Ч��
		
		void wakeup()