----------------------------
CountDownLatch				|
----------------------------
	# �����ĳЩ�����ʱ��,ֻ������������ȫ�����,��ǰ����Ż�ִ��
	# ����
		CountDownLatch countDownLatch = new CountDownLatch(5);
			* ������ʱ��,��ָ��һ������
	# ����
		countDown();
			* �ڻ����ϼ�1,��ֵΪ0��ʱ��,countDownLatch
		
		await();
			* ����,�ȴ������߳�ִ����,ֱ������ == 0
			* ��ʵ������Ǹ�ѭ�����
		
		boolean await(long timeout, TimeUnit unit)
			* ���ó�ʱʱ��
		
		long getCount()
			* ����count

	# demo
		
		CountDownLatch countDownLatch = new CountDownLatch(5);

		//�������߳�ִ��,�����߳�ִ����Ϻ�,ִ�и�api
		countDownLatch.countDown();

		
		
		//���߳�����,ֱ�� countDownLatch ���� == 0
		countDownLatch.await();