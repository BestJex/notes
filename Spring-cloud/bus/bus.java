---------------------
bus					 |
---------------------
	# �ĵ�
		https://cloud.spring.io/spring-cloud-bus/spring-cloud-bus.html
	
	# ��Ҫ������MQ�м��
		RabbitMQ
		Kafka
	
	# ģ��
		* �ͻ������,bus����,���ӵ� mq
		* �������ݱ��޸ĺ�,��������ͻ��˵� /actuator/bus-refresh
		* ��ʱ,�������ӵ�bus�Ŀͻ��˶��ᷢ�����²���

	# �ͻ��� Maven,bus��ʵ��,��ѡһ
		dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-bus-amqp</artifactId>
        </dependency>
			* amqp����Rabbitmq
		
		<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-bus-kafka</artifactId>
        </dependency>
			* ʹ��Kafka
		
		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
	
		* actuator ģ����������ṩ /actuator/bus-refresh �˵�,���ڴ�������ͻ��˵�ˢ��,�Ӷ�֪ͨ���������ӵ�Bus�Ŀͻ���
		* һ�����,����ִ��ˢ�²����Ŀͻ���һ�㶼�� : config-server
		* ������΢����ͻ��˲��سе�ˢ�����õĹ���,�Ӷ����˼�Ⱥ��һЩά������
		* ������΢����ͻ���Ҳ������Ҫ actuator ����

	# RabbitMQ�ͻ�������
spring:
  rabbitmq:
    host: 58.87.75.64
    port: 5671
    username: guest
    password: guest
    ssl:
      enabled: true


	# Kafka�ͻ�������
		TODO

	# ���𴥷�ˢ���¼��Ľڵ�,��Ҫ���� actuator,�ṩ /bus-refresh �˵�
management:
  endpoints:
    web:
      base-path: /actuator
	  # ��Ҫ����  /bus-refresh  �˵�
      exposure:
        include:
          - '*'