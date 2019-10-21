---------------------------
health					   |
---------------------------
	# app������״̬�ڵ�
	
	# ��ص���
		HealthAggregator
			|-OrderedHealthAggregator
		HealthContributorRegistry
				|-DefaultHealthContributorRegistry
		HealthContributor
		Status
	
	
	# Ԥ����� HealthIndicator 
		CassandraHealthIndicator
		CouchbaseHealthIndicator
		DiskSpaceHealthIndicator
		ElasticSearchRestHealthContributorAutoConfiguration
		HazelcastHealthIndicator
		InfluxDbHealthIndicator
		InfluxDbHealthIndicator
		JmsHealthIndicator
		MailHealthIndicator
		MongoHealthIndicator
		PingHealthIndicator
		RabbitHealthIndicator
		RedisHealthIndicator
		SolrHealthIndicator
		...
	
	# �Զ��� HealthIndicator
		

---------------------------
������					   |
---------------------------
# һ������
management.health.defaults.enabled=false
	* �Ƿ�����Ĭ�ϵĽ���������

management.endpoint.health.show-details=
	* �Ƿ���ʾapp״̬������

management.endpoint.health.show-components=
	* ö��ֵ: 
		never			������ʾ
		when-authorized	��ʾ����Ȩ�û�
		always			��ʾ�������û�
management.endpoint.health.roles=
management.endpoint.health.<name>.order=fatal,down,out-of-service,unknown,up
	* ����ָ���ڵ�״̬��������˳��

management.endpoint.health.<name>.http-mapping.<status>=503
	* ����ָ���ڵ�, ��ָ��״̬�µ�http״̬��

# ��Ⱥ����
management.endpoint.health.group.custom.include=db
management.endpoint.health.group.custom.show-details=when-authorized
management.endpoint.health.group.custom.roles=admin
management.endpoint.health.group.custom.status.order=fatal,up
management.endpoint.health.group.custom.status.http-mapping.fatal=500