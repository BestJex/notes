-----------------------
����spring				|
-----------------------

	   <!-- ����FreeMark��ͼ -->
		<bean id="freeMarkerViewResolver" class="org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver">
			<property name="contentType" value="text/html;charset=UTF-8"/>      
			<property name="viewClass" value="org.springframework.web.servlet.view.freemarker.FreeMarkerView"/>
			<property name="suffix" value=".ftl"/>
			<!-- ����freemarker -->
			<property name="cache" value="true"/>
			<!-- �������session -->
			<property name="exposeSessionAttributes" value="true"/>
			<property name="exposeRequestAttributes" value="true"/>     
			<property name="exposeSpringMacroHelpers" value="true"/>
			<!-- ��ҳ����ʹ��${request.contextPath}�Ϳɻ��contextPath -->
			<property name="requestContextAttribute" value="request"/>
			<property name="order" value="0"/>
		</bean>
		 
		
		<!-- freemarker�����ļ� -->
		<bean id="freemarkConfig" class="org.springframework.beans.factory.config.PropertiesFactoryBean">
			<property name="location" value="classpath:freemark.properties"/>
		</bean>
		 
		<bean id="fmXmlEscape" class="freemarker.template.utility.XmlEscape"/>
		 
		<bean id="FreeMarkerConfigurer" class="org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer">
			<property name="templateLoaderPath" value="/WEB-INF/templates"/>  
			<property name="defaultEncoding" value="UTF-8"/>
			<property name="freemarkerSettings" ref="freemarkConfig"/>
			<property name="freemarkerVariables">
				<map>
					<entry key="xml_escape" value-ref="fmXmlEscape"/>
				</map>
			</property>
		</bean>

