---------------------------------
Gson
---------------------------------
	# Maven
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			<exclusions>
				<exclusion>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-json</artifactId>
				</exclusion>
			</exclusions>
		</dependency>

		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
		</dependency>
	
	# ע������, ������Ĭ�ϵ�Jackson
		@SpringBootApplication(exclude = { JacksonAutoConfiguration.class })
	
	# ����(������: GsonProperties)
		spring.http.converters.preferred-json-mapper=gson
		spring.gson.date-format=
		spring.gson.disable-html-escaping=
		spring.gson.disable-inner-class-serialization=
		spring.gson.enable-complex-map-key-serialization=
		spring.gson.exclude-fields-without-expose-annotation=
		spring.gson.field-naming-policy=
		spring.gson.generate-non-executable-json=
		spring.gson.lenient=
		spring.gson.long-serialization-policy=
		spring.gson.pretty-printing=
		spring.gson.serialize-nulls=
	
	# SpringBoot ͨ�� GsonAutoConfiguration �����Զ���װ�� Gson
		* �����������ע��
			@Autowired
			Gson gson;
