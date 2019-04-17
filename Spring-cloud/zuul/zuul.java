----------------------------
zuul						|
----------------------------
	# Zuul�����˶������:·��,����,����  ...�Ⱥ��ĵ���Ҫ����
	# ·��
		* ������ⲿ����ת���������΢����ʵ����
		* ��ʵ���ⲿ����ͳһ��ڵĻ���

	# ����
		* ���������Ĵ�����̽��и�Ԥ
		* ��ʵ������У��,����ۺϵȹ��ܵĻ���
	
	# Zuul��Eureka����,��Zuul����ע��ΪEureka���������µ�Ӧ��,ͬʱ��Eureka�л�ȡ����΢�������Ϣ
		* �Ժ����΢����,����ͨ��Zuul��ת����
	
	# 'Zuul�������ջ��ǻ�ע���Eureka'

	# Maven
		<!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-zuul -->
		<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
        </dependency>

----------------------------
zuul-��������				|
----------------------------
	# ����
		* ��ҲҪ����һ������,ע�ᵽEureka��
		* ����,��Ҳ��Ҫ�����ṩ�ߵ���һ��eureka����

		spring:
		  application:
			name: zuul
		  security:
			user:
			  name: springcloud
			  password: 123456
		eureka:
		  client:
		    # ��Ҫ��ע�����Ļ�ȡ����
			fetch-registry: true
			# ��Ҫ���Լ�ע�ᵽע������
			register-with-eureka: true
			service-url:
			  defaultZone: http://${spring.security.user.name}:${spring.security.user.password}@localhost:8081/eureka/
	
	# ����ע��
		@EnableZuulProxy

		* ��ʶע��,û���κε�����
	
	# ͨ��·�ɽ��з���
		* Э��:��������:�˿�:��������/�ӿ�

		http://localhost:8081/user-service/user/1
		
		

