
----------------------------
Scheduler					|
----------------------------
	# �ӿڷ���
		void addCalendar(String calName, Calendar calendar, boolean replace, boolean updateTriggers)
		void addJob(JobDetail jobDetail, boolean replace)
		void addJob(JobDetail jobDetail, boolean replace, boolean storeNonDurableWhileAwaitingScheduling)
		boolean checkExists(JobKey jobKey) 
		boolean checkExists(TriggerKey triggerKey)
		void clear() 
		boolean deleteCalendar(String calName) 
		boolean deleteJob(JobKey jobKey)
		boolean deleteJobs(List<JobKey> jobKeys)
		Calendar getCalendar(String calName)
		List<String> getCalendarNames()
		SchedulerContext getContext()

		void start()
			* ����

		void startDelayed(int seconds) 
			* ��ָ���������

		boolean isStarted()
		void standby()
			* ��ͣ

		boolean isInStandbyMode()
		void shutdown()
			* �ر�Ӧ��

		void shutdown(boolean waitForJobsToComplete)
		boolean isShutdown()
		SchedulerMetaData getMetaData()
		List<JobExecutionContext> getCurrentlyExecutingJobs()
		void setJobFactory(JobFactory factory)
			* ���� Job ʵ���Ĵ���������

		ListenerManager getListenerManager()

		Date scheduleJob(JobDetail jobDetail, Trigger trigger)
		Date scheduleJob(Trigger trigger)
		void scheduleJobs(Map<JobDetail, Set<? extends Trigger>> triggersAndJobs, boolean replace) 
		void scheduleJob(JobDetail jobDetail, Set<? extends Trigger> triggersForJob, boolean replace)
		boolean unscheduleJob(TriggerKey triggerKey)
		boolean unscheduleJobs(List<TriggerKey> triggerKeys)
		Date rescheduleJob(TriggerKey triggerKey, Trigger newTrigger)
		void addJob(JobDetail jobDetail, boolean replace)
		void addJob(JobDetail jobDetail, boolean replace, boolean storeNonDurableWhileAwaitingScheduling)
		boolean deleteJob(JobKey jobKey)
		boolean deleteJobs(List<JobKey> jobKeys)
		void triggerJob(JobKey jobKey)
		void triggerJob(JobKey jobKey, JobDataMap data)
		void pauseJob(JobKey jobKey)
		void pauseJobs(GroupMatcher<JobKey> matcher)
		void pauseTrigger(TriggerKey triggerKey)
		void pauseTriggers(GroupMatcher<TriggerKey> matcher) 
		void resumeJob(JobKey jobKey)
		void resumeJobs(GroupMatcher<JobKey> matcher)
		void resumeTrigger(TriggerKey triggerKey)
		void resumeTriggers(GroupMatcher<TriggerKey> matcher) 
		void pauseAll()
		void resumeAll()
		List<String> getJobGroupNames() 
		Set<JobKey> getJobKeys(GroupMatcher<JobKey> matcher)
		List<? extends Trigger> getTriggersOfJob(JobKey jobKey)
		List<String> getTriggerGroupNames()
		Set<TriggerKey> getTriggerKeys(GroupMatcher<TriggerKey> matcher)
		Set<String> getPausedTriggerGroups()
		JobDetail getJobDetail(JobKey jobKey)
		Trigger getTrigger(TriggerKey triggerKey)
		TriggerState getTriggerState(TriggerKey triggerKey)
		void resetTriggerFromErrorState(TriggerKey triggerKey)
		void addCalendar(String calName, Calendar calendar, boolean replace, boolean updateTriggers)
		boolean deleteCalendar(String calName)
		Calendar getCalendar(String calName)
		List<String> getCalendarNames()
		boolean interrupt(JobKey jobKey)
		boolean interrupt(String fireInstanceId)
		boolean checkExists(JobKey jobKey)
		boolean checkExists(TriggerKey triggerKey)
		void clear()



----------------------------
SchedulerFactory			|
----------------------------
	# ������ӿ�,  ���𴴽�Schedulerʵ������
		Scheduler getScheduler() throws SchedulerException;
		Scheduler getScheduler(String schedName) throws SchedulerException;
		Collection<Scheduler> getAllSchedulers() throws SchedulerException;

	# ʵ������
		DirectSchedulerFactory
		StdSchedulerFactory
	

	
----------------------------
StdSchedulerFactory			|
----------------------------
	# ��̬����
		Scheduler getDefaultScheduler();
			* ����Ĭ�ϵ� Scheduler
			* new StdSchedulerFactory().getScheduler();

		
----------------------------
DirectSchedulerFactory		|
----------------------------