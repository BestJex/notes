-----------------------------
Handler						 |
-----------------------------
	# Handler����������
		handlerAdded	ChannelHandler ��ӵ� ChannelPipeline
		handlerRemoved	ChannelHandler �� ChannelPipeline �Ƴ�
		exceptionCaught	ChannelPipeline ִ���׳��쳣ʱ����

-----------------------------
ChannelPromise ����			 |
-----------------------------
	* ����� ChannelFuture,������� ChannelPromise ���� ���� �ɹ���ʧ��
	* �����κ�ʱ��������� Channel.write(...) һ���µ� ChannelPromise���ᴴ������ͨ�� ChannelPipeline����
	* ���д���������᷵�� ChannelFuture, ����ֻ������õ�һ�β�����ɵ�֪ͨ
	* Netty ����ʹ�� ChannelPromise ��Ϊ���ص� ChannelFuture ��֪ͨ,��ʵ���ڴ����ʱ����� ChannelPromise ����
	* ChannelPromise ��չ�� ChannelFuture
	* ��ǰ����,ChannelOutboundHandlerAdapter �ṩ��һ��ʵ���� ChannelOutboundHandler ���л���������ʵ�ֵĿ�ܡ�
	* ��Щ���¼�ת������һ�� ChannelOutboundHandler �ܵ�ͨ������ ChannelHandlerContext ��صĵ�Ч����,���Ը�����Ҫ�Լ�ʵ����Ҫ�ķ���

