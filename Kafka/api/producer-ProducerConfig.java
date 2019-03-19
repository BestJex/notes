------------------------
ProducerConfig			|
------------------------
	# ��Ϣ����������
	# �ṩ��N���������(���Ƕ���̬���������,��д,.ת��Ϊ�»���,������ CONFIG ��β)
		bootstrap.servers (BOOTSTRAP_SERVERS_CONFIG)
		client.dns.lookup
		buffer.memory
			* ��Ϣ�ۼ���(RecordAccumulator)�Ļ����С
			* Ĭ��ֵΪ:33554432kb = 32MB

		retries
			* ���ڿ����Ե��쳣,��������� retries ����,��ôֻҪ�ڹ涨�����Դ��������лָ���,�Ͳ����׳��쳣(Ĭ��ֵΪ 0)
		
		acks
		compression.type
		batch.size
			* �� RecordAccumulator �� BufferPool �Ỻ��� ByteBuffer ��С
			* BufferPool ֻ����ض���С�� ByteBuffer ���й���,��������С�� ByteBuffer ���Ỻ��� BufferPool ��
			* Ĭ��:16384B,�� 16KB

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
			* ��send()api��������ʱ��(����������,û�пռ�����Ϣ,һ�㷢������Ϣ�����ٶ�,������Ϣ�ķ����ٶ�)
			* �����������ʱ��(����),������ʱ��ͻ��׳��쳣
			* Ĭ��Ϊ:60000(60s)

		request.timeout.ms
		metadata.max.age.ms
			* ������ʱ��δ����Ԫ����,�ͻ�ѡ������С��broker,����MetadataRequest������Ԫ������Ϣ
			* Ĭ��300000(ms) = 5����

		metrics.sample.window.ms
		metrics.num.samples
		metrics.recording.level
		metric.reporters
		max.in.flight.requests.per.connection
			* ��Ϣ��RecordAccumulator���͵�broker������,�ᱻ���浽 InFlightRequests ��,ֱ����Ӧ
			* ����������ÿ������(Ҳ���ǿͻ����� Node ֮�������)��໺���������
			* ���������,����Ϣ�Ѿ��ӻ����з���ȥ��,���ǻ�û�յ���Ӧ������
			* Ĭ��ֵΪ5,Ҳ����˵,��໺��5��δ��Ӧ������,һ��������ֵ,�Ͳ�����������ӷ��͸����������
			* ���ǻ����е�����,�յ�����Ӧ

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