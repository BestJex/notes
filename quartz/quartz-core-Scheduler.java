
----------------------------
Scheduler					|
----------------------------
	# 接口方法
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
			* 启动

		void startDelayed(int seconds) 
			* 在指定秒后启动

		boolean isStarted()
		void standby()
			* 暂停

		boolean isInStandbyMode()
		void shutdown()
			* 关闭应用

		void shutdown(boolean waitForJobsToComplete)
		boolean isShutdown()
		SchedulerMetaData getMetaData()
		List<JobExecutionContext> getCurrentlyExecutingJobs()
		void setJobFactory(JobFactory factory)
			* 设置 Job 实例的创建工厂类

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
	# 工厂类接口,  负责创建Scheduler实例对象
		Scheduler getScheduler() throws SchedulerException;
		Scheduler getScheduler(String schedName) throws SchedulerException;
		Collection<Scheduler> getAllSchedulers() throws SchedulerException;

	# 实现类有
		DirectSchedulerFactory
		StdSchedulerFactory
	

	
----------------------------
StdSchedulerFactory			|
----------------------------
	# 静态方法
		Scheduler getDefaultScheduler();
			* 创建默认的 Scheduler
			* new StdSchedulerFactory().getScheduler();

		
----------------------------
DirectSchedulerFactory		|
----------------------------