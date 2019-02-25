----------------------------------
freemarker						  |
----------------------------------
	# �ٷ�����
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-freemarker</artifactId>
		</dependency> 
	
	# ������
spring:
  freemarker:
    # �Ƿ�����Ĭ��:true
    enabled: true
    # �Ƿ���ģ�����滺�棬Ĭ��:false
    cache: true
    # Ĭ��:text/html
    content-type: text/html
    # ���룬Ĭ��: urf-8
    charset: utf-8
    # ���Խ�������ͼ�б�����
    view-names:
      - views
    # �Ƿ���ģ������Ŀ¼�Ƿ���ڣ�Ĭ��:true
    check-template-location: true
    # ��ͼǰ׺
    prefix: /temp
    # ��ͼ��׺ 
    suffix: .ftl
    # ʹ��ָ�������Է��� request ���е�����
    request-context-attribute: req
    # Ĭ��:false
    expose-request-attributes: true
    # Ĭ��:false
    expose-session-attributes: true
    # Ĭ��:false
    allow-request-override: true
    # Ĭ��:true
    expose-spring-macro-helpers: true
    # Ĭ�� false
    allow-session-override: false
    # ģ���������Ŀ¼��Ĭ��:classpath:/templates/
    template-loader-path:
      - classpath:/templates/
    # Ĭ��:true
    prefer-file-system-access: true
    # freemarker��Configuration���õ����á�Ҳ���Ƕ�����:freemarker.coreConfigurable �е���Щ��̬����ֵ
    settings:
      datetime_format: yyyy-MM-dd HH:mm:ss
	
	# һ������
spring:
  freemarker:
    enabled: true
    request-context-attribute: request
    expose-request-attributes: true
    expose-session-attributes: true
    suffix: .ftl
    content-type: text/html
    # ��������ģ��,ģ�����治����
    cache: false
    template-loader-path:
      - classpath:/templates/
    charset: UTF-8
    template-encoding: UTF-8
    settings:
      datetime_format: yyyy-MM-dd HH:mm:ss
      # ģ��������ģ��仯ʱ���
      # template_update_delay: 0

----------------------------------
����							  |
----------------------------------
	import javax.annotation.PostConstruct;
	import javax.servlet.ServletContext;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Configuration;

	import freemarker.template.TemplateModelException;

	@Configuration
	public class FreemarkerConfiguration {

		@Autowired
		private ServletContext servletContext;
		
		@Autowired
		private freemarker.template.Configuration configuration;
		
		@PostConstruct
		public void configuration() throws TemplateModelException {
			//�Զ���������Ϣ
			this.configuration.setSharedVariable("ctx", this.servletContext.getContextPath());
		}
	}