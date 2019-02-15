----------------------------
��������					|
----------------------------
	# ���
		TrafficCounter
			* ͳ�Ƶ�����

		AbstractTrafficShapingHandler
			|-ChannelTrafficShapingHandler
			|-GlobalChannelTrafficShapingHandler
			|-GlobalTrafficShapingHandler
	
	
	# �������ε�ԭ��
		���� -> ������� -> ����(����Ͱ) -> ��� -> ƽ������
	

----------------------------
ChannelTrafficShapingHandler|
----------------------------
	# ���� Channel �����IO����
		ChannelTrafficShapingHandler(long checkInterval)
		ChannelTrafficShapingHandler(long writeLimit,long readLimit)
		ChannelTrafficShapingHandler(long writeLimit,long readLimit, long checkInterval)
		ChannelTrafficShapingHandler(long writeLimit, long readLimit,long checkInterval, long maxTime)
	


-----------------------------------
GlobalChannelTrafficShapingHandler |
-----------------------------------
	# �����ĳ�������е����� Channel ��IO����
		GlobalChannelTrafficShapingHandler(ScheduledExecutorService executor)
		GlobalChannelTrafficShapingHandler(ScheduledExecutorService executor, long checkInterval)
		GlobalChannelTrafficShapingHandler(ScheduledExecutorService executor, long writeGlobalLimit, long readGlobalLimit, long writeChannelLimit, long readChannelLimit)
		GlobalChannelTrafficShapingHandler(ScheduledExecutorService executor,long writeGlobalLimit, long readGlobalLimit,long writeChannelLimit, long readChannelLimit, long checkInterval)
		GlobalChannelTrafficShapingHandler(ScheduledExecutorService executor,long writeGlobalLimit, long readGlobalLimit,long writeChannelLimit, long readChannelLimit, long checkInterval, long maxTime)


-----------------------------------
GlobalTrafficShapingHandler			|
-----------------------------------
	# ȫ�ּ����ͬʱ��ȫ��,�͵��� Channel ��IO����(������������)
		GlobalTrafficShapingHandler(EventExecutor executor)
		GlobalTrafficShapingHandler(ScheduledExecutorService executor, long checkInterval)
		GlobalTrafficShapingHandler(ScheduledExecutorService executor, long writeLimit,long readLimit)
		GlobalTrafficShapingHandler(ScheduledExecutorService executor, long writeLimit,long readLimit, long checkInterval)
		GlobalTrafficShapingHandler(ScheduledExecutorService executor, long writeLimit, long readLimit,long checkInterval, long maxTime)
