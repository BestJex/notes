----------------------------
Netty����˵�����			|
----------------------------
	// �������ӵ��̳߳�
	EventLoopGroup bossGroup = new NioEventLoopGroup();
	// ����IO�¼����̳߳�
	EventLoopGroup workerGroup = new NioEventLoopGroup();
	try {
		// ��������˶���
		ServerBootstrap serverBootstrap = new ServerBootstrap();
		// �����̳߳�
		serverBootstrap.group(bossGroup, workerGroup);
		// ����ioģʽ
		serverBootstrap.channel(NioServerSocketChannel.class);
		// ������־handler
		serverBootstrap.handler(new LoggingHandler(LogLevel.INFO));
		// ���ÿͻ���handlder
		serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
			// ��ʼ����Ϣ����
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(new TimeServerHandler());
			}
		});
		// ���÷��������
		serverBootstrap.option(ChannelOption.SO_BACKLOG, 128);
		serverBootstrap.option(ChannelOption.SO_REUSEADDR, true);

		// ���ÿͻ�������
		serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);

		// �󶨶˿�,����ͬ��(����)����������
		ChannelFuture channelFuture = serverBootstrap.bind(1024).sync();
		channelFuture.channel().closeFuture().sync();
	} finally {
		bossGroup.shutdownGracefully();
		bossGroup.shutdownGracefully();
	}