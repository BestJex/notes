--------------------------------
quartz	����					|
--------------------------------
	# ��������
		<dependency>
		   <groupId>org.springframework.boot</groupId>
		   <artifactId>spring-boot-starter-quartz</artifactId>
		</dependency>
	
	# ����:QuartzProperties(������)
spring:
  quartz:
    # ö��:MEMORY(Ĭ��),JDBC
    job-store-type:
    scheduler-name:
    auto-startup:
    startup-delay:
    wait-for-jobs-to-complete-on-shutdown: false
    overwrite-existing-jobs: false
    properties:
    jdbc:
      schema: classpath:org/quartz/impl/jdbcjobstore/tables_@@platform@@.sql
      # ö��:EMBEDDED(Ĭ��),ALWAYS,NEVER
      initialize-schema: 
      comment-prefix: --


	# ������̳�:QuartzJobBean 
