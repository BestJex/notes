--------------------------------
ChannelInboundHandlerAdapter	|
--------------------------------
	# class ChannelInboundHandlerAdapter extends ChannelHandlerAdapter implements ChannelInboundHandler
	# �����ʵ�ֵĶ�ȡ�¼�������

--------------------------------
����							|
--------------------------------
	public void channelActive(ChannelHandlerContext ctx)
		* ���ӱ���������׼������ͨ��ʱ������
	
	public void channelRead(ChannelHandlerContext ctx, Object msg)
		* ��ȡ�¼�

	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
		* �쳣ʱ����
	
	public void handlerAdded(ChannelHandlerContext ctx) 
		* handler�����ʱ����
	
	 public void handlerRemoved(ChannelHandlerContext ctx) 
		* handler���Ƴ�ʱ����
	
