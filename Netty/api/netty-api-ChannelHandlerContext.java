--------------------------------
ChannelHandlerContext			|
--------------------------------
	# interface ChannelHandlerContext extends AttributeMap, ChannelInboundInvoker, ChannelOutboundInvoker
	# ��ʾ�ͻ��˵�����

--------------------------------
�ӿڷ���						|
--------------------------------

    ChannelFuture write(Object msg);
		* д�����ݵ�ͨ��,���ǻᱻ���浽������

    ChannelFuture write(Object msg, ChannelPromise promise);

    ChannelFuture writeAndFlush(Object msg);
		* д�벢��ˢ��������
	
    ChannelFuture writeAndFlush(Object msg, ChannelPromise promise);
		* ���� futrue

	ChannelOutboundInvoker flush();
		* �ѻ������е�����ˢ��
	
	ByteBufAllocator alloc();
		* �õ�һ����ǰ��ByteBufAllocator,�Ӷ�����һ��Buffer
			ByteBuf intBuf = ctx.alloc().buffer(4);