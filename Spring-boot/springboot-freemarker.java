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
    # ָ��ʹ��ģ�����ͼ�б�����
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
    # �Ƿ��request���������ӵ�ģ�����棬Ĭ��:false
    expose-request-attributes: true
    # �Ƿ��session���������ӵ�ģ�����棬Ĭ��:false
    expose-session-attributes: true
    # request�������Ƿ���Ը���controller��model��ͬ���Ĭ��:false
    allow-request-override: true
    # session�������Ƿ���Ը���controller��model��ͬ���Ĭ�� false
    allow-session-override: false
    # Ĭ��:true
    expose-spring-macro-helpers: true
    # ģ���������Ŀ¼��Ĭ��:classpath:/templates/
    template-loader-path:
      - classpath:/templates/
    # �Ƿ����ȴ��ļ�ϵͳ����ģ�����棬֧���ȼ��ء�Ĭ��:true
    prefer-file-system-access: true
    # freemarker��Configuration���õ����á�Ҳ���Ƕ�����:freemarker.coreConfigurable �е���Щ��̬����ֵ
    settings:
      datetime_format: yyyy-MM-dd HH:mm:ss

	
	# һ������
spring:
  freemarker:
    enabled: true
    cache: true
    content-type: text/html
    charset: utf-8
    suffix: .ftl
    # ���� request �����Ե�ǰ׺
    request-context-attribute: reqeust
    # ��� request ������Ե�model
    expose-request-attributes: true
    # ��� session ������Ե�model
    expose-session-attributes: true
    # ���� request ������Ը���model������
    allow-request-override: true
    # ���� session ������Ը���model������
    allow-session-override: false
    check-template-location: true
    template-loader-path:
      - classpath:/templates/
    settings:
      datetime_format: yyyy-MM-dd HH:mm:ss
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