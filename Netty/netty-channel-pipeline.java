----------------------------
ChannelPipeline				|
---------------------------
	# һ�� ChannelPipeline ���������������һ�� Channel ��ChannelHandler
		* �����޸� ChannelPipeline ͨ����̬��Ӻ�ɾ�� ChannelHandler
		* ChannelPipeline ���ŷḻ��API���ö�������Ӧ��վ�ͳ�վ�¼�
	
	
	# ��Ҳ���Ը��ͻ�����Ӧ����
		ChannelPipeline pipeline = ctx.pipeline();
		pipeline.write(Unpooled.copiedBuffer("netty in action", CharsetUtil.UTF_8));

		* ��api������Ϣ�� ChannelPipeline ��β����ʼ,Ҳ�Ǵ�ͷ��ʼ�����������ִ����