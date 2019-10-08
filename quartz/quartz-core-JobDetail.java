--------------------------------
JobDetail						|
--------------------------------
	# �ӿڷ���
		public JobKey getKey();
		public String getDescription();
		public Class<? extends Job> getJobClass();
		public JobDataMap getJobDataMap();
		public boolean isDurable();
		public boolean isPersistJobDataAfterExecution();
		public boolean isConcurrentExectionDisallowed();
		public boolean requestsRecovery();
		public Object clone();
		public JobBuilder getJobBuilder();

--------------------------------
JobBuilder						|
--------------------------------
	# ���ڹ��� JobDetail �Ĺ�����

	# ��̬����
		static JobBuilder newJob()
		static JobBuilder newJob(Class <? extends Job> jobClass)
	
	# ʵ������
		JobDetail build()
		JobBuilder ofType(Class <? extends Job> jobClazz)
			* ָ��Jobʵ����

		JobBuilder requestRecovery()
		JobBuilder requestRecovery(boolean jobShouldRecover)
			* ���һ��job�ǿɻָ���, ��������ִ�е�ʱ��, scheduler����Ӳ�ر�(hard shutdown), �������еĽ��̱����ˣ����߹ػ���)
			* ��scheduler����������ʱ��, ��job�ᱻ����ִ��
			* Ĭ�� true
			* ��ʱ, ��job�� JobExecutionContext.isRecovering() ����true


		JobBuilder storeDurably()
		JobBuilder storeDurably(boolean jobDurability)
			* ���һ��job�Ƿǳ־õ�, ��û�л�Ծ��trigger��֮������ʱ��, �ᱻ�Զ��ش�scheduler��ɾ��
			* Ҳ����˵, �ǳ־õ�job������������trigger�Ĵ�����������
			* Ĭ��: true


		JobBuilder setJobData(JobDataMap newJobDataMap)

		JobBuilder usingJobData(JobDataMap newJobDataMap)
		JobBuilder usingJobData(String dataKey, Boolean value)
		JobBuilder usingJobData(String dataKey, Double value)
		JobBuilder usingJobData(String dataKey, Float value)
		JobBuilder usingJobData(String dataKey, Integer value)
		JobBuilder usingJobData(String dataKey, Long value)
		JobBuilder usingJobData(String dataKey, String value)
		
		JobBuilder withDescription(String jobDescription)

		JobBuilder withIdentity(JobKey jobKey)
		JobBuilder withIdentity(String name)
		JobBuilder withIdentity(String name, String group)
		



