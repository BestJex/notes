------------------------
EventLoop				|
------------------------
	# ���
		EventLoopGroup 
			* �̳нӿ�:ScheduledExecutorService, Iterable
			|-MultithreadEventLoopGroup
				|-EpollEventLoopGroup
				|-NioEventLoopGroup
			

	
	# �ܽ�
		* һ��EventLoopGroup���л����һ�����߶��EventLoop
		* һ��EventLoop�������������������ж�ֻ����Ψһһ��Thread���а�
		* ������EventLoop������ĸ���I/O�¼������������������Ǹ�Thread�Ͻ��д���
		* һ��Channel��������������������ֻ�ᱻע��һ��EventLoop��
		* һ��EventLoop�����й��̵���,�ᱻ�����һ�����߶��Cahnnel
	

