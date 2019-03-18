--------------------------------
ConsumerRecord<K,V>				|
--------------------------------
	# ���������ѵ���Ϣ����
	# ���캯��
		ConsumerRecord(String topic,int partition,long offset,K key,V value)
		ConsumerRecord(String topic,int partition,long offset,long timestamp,TimestampType timestampType,Long checksum,int serializedKeySize,int serializedValueSize,K key,V value,Headers headers)
		ConsumerRecord(String topic,int partition,long offset,long timestamp,TimestampType timestampType,Long checksum,int serializedKeySize,int serializedValueSize,K key,V value,Headers headers,Optional<Integer> leaderEpoch)
		ConsumerRecord(String topic,int partition,long offset,long timestamp,TimestampType timestampType,long checksum,int serializedKeySize,int serializedValueSize,K key,V value)

		timestampType
			* ʱ���������,ö��ֵ
				NO_TIMESTAMP_TYPE(-1, "NoTimestampType") // ûʱ���
				CREATE_TIME(0, "CreateTime")			//  ��Ϣ����ʱ��
				LOG_APPEND_TIME(1, "LogAppendTime");	//  ׷�ӵ���־�ļ���ʱ��
		
		headers
			* ��Ϣͷ,�������ڴ���ҵ�����������������Ϣ
			* Headers��һ���ӿ�,ʵ����:RecordHeaders

	# ʵ������
		private final String topic;						// ����
		private final int partition;					// ������
		private final long offset;						
		private final long timestamp;					// ʱ���
		private final TimestampType timestampType;
		private final int serializedKeySize;
		private final int serializedValueSize;
		private final Headers headers;					// ��Ϣͷ
		private final K key;							// ��
		private final V value;							// ֵ
		private final Optional<Integer> leaderEpoch;
		private volatile Long checksum;

	# ʵ������
		