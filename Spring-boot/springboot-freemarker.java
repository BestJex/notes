----------------------------------
freemarker						  |
----------------------------------
	# �ٷ�����
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-freemarker</artifactId>
		</dependency> 
	
	# ������
		spring.freemarker.allow-request-override=false 
		spring.freemarker.allow-session-override=false
		spring.freemarker.cache=false
			* �Ƿ���ģ�����滺��
		spring.freemarker.charset=UTF-8
			* ģ������ı���
		spring.freemarker.check-template-location=true
			* ���Ŀ��Ŀ¼�Ƿ����
		spring.freemarker.content-type=text/html
			* Content-Type
		spring.freemarker.enabled=true
			* ����
		spring.freemarker.expose-request-attributes=false
			* �Ƿ��������request���е�model
		spring.freemarker.expose-session-attributes=false
			* �Ƿ��������session���е�model
		spring.freemarker.expose-spring-macro-helpers=true
		spring.freemarker.prefer-file-system-access=true
		spring.freemarker.prefix= 
		spring.freemarker.request-context-attribute= request
			* ����request��ı���
		spring.freemarker.settings.*= # Well-known FreeMarker keys which will be passed to FreeMarker's Configuration.
		spring.freemarker.suffix
			* # Suffix that gets appended to view names when building a URL.
		spring.freemarker.template-loader-path=classpath:/templates/
			*  һ�����߶��ģ�������·��
		spring.freemarker.view-names=
		spring.freemarker.template-encoding=UTF-8
	
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