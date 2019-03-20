-----------------------------
ConsumerConfig				 |
-----------------------------
	# ��Ϣ����������
	# ������
		bootstrap.servers
			* kafka��Ⱥ�Ľڵ�
			* ip:port
			* ���Ӷ��ʹ�ö��ŷָ�

		client.dns.lookup
		group.id
			* ����������,Ĭ��ֵΪ���ַ���

		session.timeout.ms
		heartbeat.interval.ms
		partition.assignment.strategy
			* ��������topic֮��ķ����������

		metadata.max.age.ms
		enable.auto.commit
			* �Ƿ����Զ��ύ����λ��,Ĭ��ֵΪ:true

		auto.commit.interval.ms
			* * ��������λ�Ƽ�¼�ύ�ļ��,Ĭ��: 50000(ms) Ҳ����5��

		client.id
			* ��ǰ�����ߵ�id
			* ���������,���Զ�������һ���ǿ��ַ���(consumer-[���])
				consumer-1....consumer-x

		max.partition.fetch.bytes
		send.buffer.bytes
		receive.buffer.bytes
		fetch.min.bytes
		fetch.max.bytes
		fetch.max.wait.ms
		reconnect.backoff.ms
		reconnect.backoff.max.ms
		retry.backoff.ms
		auto.offset.reset
			* ���������Ҳ�������ƫ������¼��ʱ��,�����￪ʼ��������
			* ö��ֵ:
				earliest	����Ϊ�����ƫ����,��ͷ��ʼ����
				latest		��ƫ������Ϊ����ƫ����,ͨ�׵�˵���ǲ�������ǰ����Ϣ��,��������Ϣ��ʼ����(Ĭ��)
				none		���û���ҵ�ƫ������¼,�׳��쳣

			* �������ƫ����Խ����,Ҳ��ͨ�������õĲ�������������ƫ����


		check.crcs
		metrics.sample.window.ms
		metrics.num.samples
		metrics.recording.level
		metric.reporters
		key.deserializer
		value.deserializer
			* ����value��key�Ľ�����

		request.timeout.ms
			* Ĭ�ϵ���������ʱʱ��

		default.api.timeout.ms
		connections.max.idle.ms
		interceptor.classes
		max.poll.records
		max.poll.interval.ms
		exclude.internal.topics
		internal.leave.group.on.close
		isolation.level
		security.protocol
		ssl.protocol
		ssl.provider
		ssl.cipher.suites
		ssl.enabled.protocols
		ssl.keystore.type
		ssl.keystore.location
		ssl.keystore.password
		ssl.key.password
		ssl.truststore.type
		ssl.truststore.location
		ssl.truststore.password
		ssl.keymanager.algorithm
		ssl.trustmanager.algorithm
		ssl.endpoint.identification.algorithm
		ssl.secure.random.implementation
		sasl.kerberos.service.name
		sasl.kerberos.kinit.cmd
		sasl.kerberos.ticket.renew.window.factor
		sasl.kerberos.ticket.renew.jitter
		sasl.kerberos.min.time.before.relogin
		sasl.login.refresh.window.factor
		sasl.login.refresh.window.jitter
		sasl.login.refresh.min.period.seconds
		sasl.login.refresh.buffer.seconds
		sasl.mechanism
		sasl.jaas.config
		sasl.client.callback.handler.class
		sasl.login.callback.handler.class
		sasl.login.class

	# ���캯��
		ProducerConfig(Properties props)
		ProducerConfig(Map<String, Object> props)
	
	# ��̬����
		Map<String, Object> addSerializerToConfig(Map<String, Object> configs,Serializer<?> keySerializer, Serializer<?> valueSerializer)
		Properties addSerializerToConfig(Properties properties,Serializer<?> keySerializer,Serializer<?> valueSerializer)
		Set<String> configNames()
			* ���ؿ����õ�key

		void main(String[] args)
			* main����,��html��ʽ��ӡ���ú�˵��
		