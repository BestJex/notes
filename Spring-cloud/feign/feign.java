------------------------
feign					|
------------------------
	# ����һ������ʽ��WebService�ͻ���
		* ʹ��Feign���ñ�дWebService�ͻ��˸��ӵļ�
		* ����ʹ�÷����Ƕ���һ�����,Ȼ���ڽӿ�������ע��,ͬʱҲ֧��JAX-RS��׼��ע��
		* FeignҲ֧�ֿ��Ȱβ�ʽ�ı���ͽ�����

	# SpringCloud��Feign�����˷�װ,ʹ��֧����SpringMVC��׼ע���HttpMessageConverters

	# Feign���Ժ�Eureka,Ribbon���ʹ��,��֧�ָ��ؾ���
		* FeignĬ�ϼ�����Ribbon,Hystrix,����Ribbonά����΢�����ṩ�ߵ��б���Ϣ,����ͨ����ѯʵ���˿ͻ��˵ĸ��ؾ���
		* ��Ribbon��ͬ,feignֻ��Ҫ�������󶨽ӿ���������ʽ�ķ���,�򵥶������ŵ�ʵ���˷���ĵ���

	# ����
		<!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-feign -->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-feign</artifactId>
			<version>1.4.4.RELEASE</version>
		</dependency>

------------------------
��������				|
------------------------
	# ע�⿪��
		@EnableFeignClients
		@SpringBootApplicatoon
		@EnableEurekaClient

			* ͨ�� @EnableFeignClients ������Feign����

	# ����ӿ�
		@FeignClient("USER-SERVICE")
		public interface UserService {
			
			@GetMapping("/user/{userId}")
			User getById (@PathVariable("userId")Integer id);
		}
		
		* @FeignClient ͨ����ע��,ָ��΢���������
		* ʹ��·��ע��(@GetMapping)��ָ������·��,ͨ�� @PathVariable ���󶨲���
		* ��mybatis��mapperһ��,��̬����ʵ������IOC��
	

	# ����
		feign.hystrix.enabled: true
			* �����۶���,���������� fegin��������

	# ʹ�� FeignClient �ӿ�
		
		@Autowired
		private UserService userService;
		
		@GetMapping("/user")
		public User getUser(@RequestParam("id")int id){
			//�Խӿڵ���ʽ����΢����
			return this.userService.getById(id);
		}
	


------------------------
����ѹ��				|
------------------------
	# fegin֧�ֶ��������Ӧ����zipѹ��,���ٴ����Ĵ���
	# ��������
		feign.compression.request.enabled=true
		feign.compression.response.enabled=true
	
	# ��ϸ�µ�����
		fegin.compression.request.mime-types=text/xml.application/xml,application/json
			* ��Щ������Ҫѹ��
			*  Ĭ��ֵ:text/xml.application/xml,application/json

		fegin.compression.request.min-request-size=2048
			* �������ﵽ���ʱ����ѹ��
			* Ĭ��ֵ:2048

------------------------
��־����				|
------------------------
	# feign��Ϊ @FeignClient �����ͻ��˵�ʱ��,��Ϊÿһ���ͻ��˶�����һ��: feign.Logger ʵ������
		* �������ø���־�����DEBUGģʽ������Feign������ϸ��
	
	# ����ָ���ͻ��˵���־
		1,���ÿͻ��˵���־
			logging.level.<FeignClient>=DBUG

			* FeignClient���ǿͻ��˵Ľӿ�ȫ·��
		
		2,����ȫ�� Logger.Level
			@Bean
			public Logger.Level feignnLoggerLevel(){
				return Logger.Level.FULL;
			}

			* feignĬ�ϵ� Logger.Level ������ΪNONE,�����¼�κ�Feign���ù����е���Ϣ
	
		3,�����ָ������ָ�� Logger.Level
			@Configuration 
			public class FullLogConfiguration{
				@Bean
				public Logger.Level feignnLoggerLevel(){
					return Logger.Level.FULL;
				}
			}
			
			@FeignClient(value = "USER-SERVICE",configuration = {FullLogConfiguration.class})
		
	# Feign��Logger��Ҫ�� �ĸ�
		NONE
			* ����¼�κ���Ϣ
		BASIC
			* ������¼����ʽ,URL,��Ӧ״̬���ִ��ʱ��
		HEADERS
			* ����BASIC���⻹���¼����ͷ����Ӧͷ��Ϣ
		FULL
			* ��¼��ż

