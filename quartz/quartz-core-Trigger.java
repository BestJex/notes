----------------------------
Trigger						|
----------------------------
	# �ӿ��ڲ���ö�ٺͳ���
		public enum TriggerState { NONE, NORMAL, PAUSED, COMPLETE, ERROR, BLOCKED }
		public enum CompletedExecutionInstruction { NOOP, RE_EXECUTE_JOB, SET_TRIGGER_COMPLETE, DELETE_TRIGGER, 
			SET_ALL_JOB_TRIGGERS_COMPLETE, SET_TRIGGER_ERROR, SET_ALL_JOB_TRIGGERS_ERROR }
		public static final int MISFIRE_INSTRUCTION_SMART_POLICY = 0;
		public static final int MISFIRE_INSTRUCTION_IGNORE_MISFIRE_POLICY = -1;
		public static final int DEFAULT_PRIORITY = 5;

	# �ӿڷ���
		public TriggerKey getKey();
		public JobKey getJobKey();
		
		public String getDescription();

		public String getCalendarName();

		public JobDataMap getJobDataMap();
		public int getPriority();

		public boolean mayFireAgain();
		public Date getStartTime();

		public Date getEndTime();

		public Date getNextFireTime();

		public Date getPreviousFireTime();

		public Date getFireTimeAfter(Date afterTime);

		public Date getFinalFireTime();

		public int getMisfireInstruction();
		public TriggerBuilder<? extends Trigger> getTriggerBuilder();
		
		public ScheduleBuilder<? extends Trigger> getScheduleBuilder();

		public boolean equals(Object other);
		
		public int compareTo(Trigger other);


	# ���õ��ӽӿ�
		SimpleTrigger
		CronTrigger
		CalendarIntervalTrigger
		DailyTimeIntervalTrigger

	# �������(misfire Instructions)
		
----------------------------
TriggerBuilder				|
----------------------------
	# Trigger ������
	
	# ��̬����
		static TriggerBuilder<Trigger> newTrigger()
		
	# ʵ������
		T build()
		TriggerBuilder<T> endAt(Date triggerEndTime)
			* ��ʾtriggerʧЧ��ʱ���

		TriggerBuilder<T> forJob(JobDetail jobDetail)
		TriggerBuilder<T> forJob(JobKey keyOfJobToFire)
		TriggerBuilder<T> forJob(String jobName)
		TriggerBuilder<T> forJob(String jobName, String jobGroup)
		TriggerBuilder<T> modifiedByCalendar(String calName)
		TriggerBuilder<T> startAt(Date triggerStartTime)
			* ����trigger��һ�δ�����ʱ��

		TriggerBuilder<T> startNow()
			* ������, ������������

		TriggerBuilder<T> usingJobData(JobDataMap newJobDataMap)
		TriggerBuilder<T> usingJobData(String dataKey, Boolean value)
		TriggerBuilder<T> usingJobData(String dataKey, Double value)
		TriggerBuilder<T> usingJobData(String dataKey, Float value)
		TriggerBuilder<T> usingJobData(String dataKey, Integer value)
		TriggerBuilder<T> usingJobData(String dataKey, Long value)
		TriggerBuilder<T> usingJobData(String dataKey, String value)

		TriggerBuilder<T> withDescription(String triggerDescription)

		TriggerBuilder<T> withIdentity(String name)
		TriggerBuilder<T> withIdentity(String name, String group)
		TriggerBuilder<T> withIdentity(TriggerKey triggerKey)
			* name, ��ʾtriggerΨһ������
			* group, ��ʾtrigger�����ķ���
			
			* ���û���� group, Ĭ��Ϊ: DEFAULT

		TriggerBuilder<T> withPriority(int triggerPriority)
			* ���ȼ�, �����Ͼ����������̵߳����ȼ�
			* ���û��Ϊtrigger�������ȼ���triggerʹ��Ĭ�����ȼ���ֵΪ5
			* priority���Ե�ֵ��������������������������������
			* ע�⣺ֻ��ͬʱ������trigger֮��Ż�Ƚ����ȼ���


		<SBT extends T> TriggerBuilder<SBT> withSchedule(ScheduleBuilder<SBT> schedBuilder)
			* �������ȹ���

----------------------------
ScheduleBuilder				|
----------------------------
	# ���ȽӿڵĹ����ӿ�, ���󷽷�
		  protected abstract MutableTrigger build();

	# ����
		CalendarIntervalScheduleBuilder
		CronScheduleBuilder
		DailyTimeIntervalScheduleBuilder
		SimpleScheduleBuilder


----------------------------
SimpleTrigger				|
----------------------------
	# ͨ�� SimpleScheduleBuilder ����
	# ��̬��������
		SimpleScheduleBuilder simpleSchedule()

		SimpleScheduleBuilder repeatMinutelyForever()
		SimpleScheduleBuilder repeatMinutelyForever(int minutes)
			* ���ն��ٷ��ظ�ִ��, Ĭ��1��

		SimpleScheduleBuilder repeatSecondlyForever() 
		SimpleScheduleBuilder repeatSecondlyForever(int seconds)
			* ���ն������ظ�ִ��, Ĭ��1��

		SimpleScheduleBuilder repeatHourlyForever()
		SimpleScheduleBuilder repeatHourlyForever(int hours)
			* ���ն���Сʱ�ظ�ִ��, Ĭ��1Сʱ

		SimpleScheduleBuilder repeatMinutelyForTotalCount(int count)
		SimpleScheduleBuilder repeatMinutelyForTotalCount(int count, int minutes)

		SimpleScheduleBuilder repeatSecondlyForTotalCount(int count)
		SimpleScheduleBuilder repeatSecondlyForTotalCount(int count, int seconds)

		SimpleScheduleBuilder repeatHourlyForTotalCount(int count)
		SimpleScheduleBuilder repeatHourlyForTotalCount(int count, int hours)

	# ʵ������
		MutableTrigger build()
		SimpleScheduleBuilder withIntervalInMilliseconds(long intervalInMillis)
		SimpleScheduleBuilder withIntervalInMilliseconds(long intervalInMillis)
		SimpleScheduleBuilder withIntervalInSeconds(int intervalInSeconds)
		SimpleScheduleBuilder withIntervalInMinutes(int intervalInMinutes)
		SimpleScheduleBuilder withIntervalInHours(int intervalInHours)
		SimpleScheduleBuilder withRepeatCount(int triggerRepeatCount)
		SimpleScheduleBuilder repeatForever()
		SimpleScheduleBuilder withMisfireHandlingInstructionIgnoreMisfires()
		SimpleScheduleBuilder withMisfireHandlingInstructionFireNow() 
		SimpleScheduleBuilder withMisfireHandlingInstructionNextWithExistingCount()
		SimpleScheduleBuilder withMisfireHandlingInstructionNextWithRemainingCount()
		SimpleScheduleBuilder withMisfireHandlingInstructionNowWithExistingCount()
		SimpleScheduleBuilder withMisfireHandlingInstructionNowWithRemainingCount()
		


----------------------------
CronTrigger					|
----------------------------

----------------------------
TriggerKey					|
----------------------------
	# ����trigger��name��grouo���Զ���
		
	# ��JobKeyһ��һ��, ����������ͬ

