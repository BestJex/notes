
-------------------------
ApplicationPidFileWriter |
-------------------------
	# ��sbӦ��������, ���ڰѽ���idд�뵽�ļ��ļ�����

	# ���ü�����
		SpringApplication springApplication = new SpringApplication(MyApplication.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
	
	# ��������
		spring.pid.file=D://app.pid
			* д��pid���ļ�

		spring.pid.fail-on-write-error=D://app.error
			* ���pid�ļ�д��ʧ��, �����쳣��Ϣд�뵽����ļ�
		
	