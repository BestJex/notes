------------------------
ProducerConfig			|
------------------------
	# ��Ϣ����������
	# �ṩ��N���������(���Ƕ���̬���������,��д,.ת��Ϊ�»���,������ CONFIG ��β)
		bootstrap.servers (BOOTSTRAP_SERVERS_CONFIG)
		client.dns.lookup
		buffer.memory
		retries
			* ���ڿ����Ե��쳣,��������� retries ����,��ôֻҪ�ڹ涨�����Դ��������лָ���,�Ͳ����׳��쳣(Ĭ��ֵΪ 0)
		
		acks
		compression.type
		batch.size
		linger.ms
		delivery.timeout.ms
		client.id
		send.buffer.bytes
		receive.buffer.bytes
		max.request.size
		reconnect.backoff.ms
		reconnect.backoff.max.ms
		retry.backoff.ms
		max.block.ms
		request.timeout.ms
		metadata.max.age.ms
		metrics.sample.window.ms
		metrics.num.samples
		metrics.recording.level
		metric.reporters
		max.in.flight.requests.per.connection
		key.serializer
		value.serializer
			* ����key/value�ı�����
			* ֵ�Ǳ���������·��

		connections.max.idle.ms
		partitioner.class
			* ���÷�������ʵ����

		interceptor.classes
			* ������������ʵ����

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
		enable.idempotence
		transaction.timeout.ms
		transactional.id

	
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