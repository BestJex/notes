---------------------------
Thread						|
---------------------------
	# ���߳���������
	# ���췽��
		Thread t = new Thread();
		Thread t = new Thread(Runnable r);

---------------------------
Thread-����					|
---------------------------
	# ��̬����
	
	# ʵ������

---------------------------
Thread-����					|
---------------------------
	# ��̬����
		Thread currentThread();
			* ���ص�ǰ���̶߳���
		sleep(long l);
			* ��ǰ�߳�ֹͣ l ����

	# ʵ������
		
		getName();
			* �����߳�����
		
		void setPriority(int newPriority)
			* �����̵߳����ȼ�
			* Thread ���ṩ��N��ľ�̬����ֵ
		
		int getPriority()
			* ��ȡ�̵߳����ȼ�
		
		void interrupt()
			* �ж��߳�
		
		boolean isInterrupted()
			* �߳��Ƿ��ж�
		
		void join();
			* ���ø÷������̻߳�һֱ����,ֱ�����߳�(join ������ Thread �߳�)ִ����Ϻ������ִ��
		
		void setDaemon(boolean on)
			* ����Ϊ��ǰ�̵߳��ػ��߳�
			* �����ڵ��� start() ����֮ǰ����
		
		void stop();
			* ����ֹͣ���߳�

---------------------------
Thread ���жϻ���			|
---------------------------
	# ÿ���̶߳���һ�� "�ж�" ��־,������������
	
	# �߳���sleep��wait(����),join ....
		* ��ʱ�����Ľ��̵��ô˽���(Thread ����)�� interrupt()����,���̻߳ᱻ���Ѳ���Ҫ���� InterruptedException
		* (thread����IO����ʱҲ������������Ϊ,��java thread api)
		* �쳣������,�����������ʶλΪ false
	
	# ���߳���������
		* ��ʱ�����Ľ��̵��ô˽���(Thread ����)�� interrupt()����,�����յ�����,���Ǵ��̵߳� "�ж�" �ᱻ����Ϊ true
		* ����ͨ�� isInterrupted() �鿴����������
		

