-------------------
Serializer<T>	   |
-------------------
	# ��Ϣ�����л��ӿ�
	# ���󷽷�
		void configure(Map<String, ?> configs, boolean isKey);

		byte[] serialize(String topic, T data);
			*  ִ�����л�����

		default byte[] serialize(String topic, Headers headers, T data) {
			return serialize(topic, data);
		}

		@Override
		void close();