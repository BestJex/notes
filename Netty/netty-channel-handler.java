-----------------------------
ChannelHandler				 |
-----------------------------
	# �ṩ������Handler�¼�
	# ���
		ChannelHandler
			|-ChannelHandlerAdapter
			|-ChannelInboundHandler
			|-ChannelOutboundHandler

	# Handler����������
		handlerAdded	ChannelHandler ��ӵ� ChannelPipeline
		handlerRemoved	ChannelHandler �� ChannelPipeline �Ƴ�
		exceptionCaught	ChannelPipeline ִ���׳��쳣

-----------------------------
ChannelInboundHandler		 |
-----------------------------
	# ��ȡ�¼�
	# ���
		|-ChannelInboundHandler
			|-ChannelInboundHandlerAdapter
				* ��ʵ���� ChannelInboundHandler �����з���
				* ���þ��Ǵ�����Ϣ������Ϣת���� ChannelPipeline �е���һ�� ChannelHandler

				|-ByteToMessageDecoder
					|-ReplayingDecoder<S> 
					|-LineBasedFrameDecoder
					|-LengthFieldBasedFrameDecoder
					|-DelimiterBasedFrameDecoder
					|-FixedLengthFrameDecoder
					|-SslHandler
				|-MessageToMessageDecoder
					|-StringDecoder
				|-ChannelInitializer
				|-SimpleChannelInboundHandler<I>

	# �¼�(�ӿڷ���)
		channelRegistered	channel	ע�ᵽһ�� EventLoop,��״̬���Գ��ֶ��,�����ظ���ע��ȡ��ע��
		channelActive		channel	��Ϊ��Ծ״̬(���ӵ���Զ������),���ڿ��Խ��պͷ���������,��״ֻ̬�����һ��
		channelInactive		channel	���ڷǻ�Ծ״̬,û�����ӵ�Զ������,��״ֻ̬�����һ��
		channelUnregistered	channel	�Ѵ�����δע�ᵽһ�� EventLoop	(���ߴ�EventLoop���Ƴ�),��״̬���Գ��ֶ��,�����ظ���ע��ȡ��ע��

		channelReadComplete			channel ��ȡ���
		channelRead					channel ���Զ�ȡ
		userEventTriggered			
		channelWritabilityChanged	channle ��д״̬�ı�,����ʹ�� Channel.isWritable()���
		exceptionCaught

	# SimpleChannelInboundHandler<T>
		* ������,��Ҫ��д���󷽷�: channelRead0(ChannelHandlerContext ctx, T msg)
		* �Զ�ǿ��ת������,�����Զ����ͷ�buf��Դ
	
	# һ��ʹ�õĺͳ���
		ChannelInboundHandlerAdapter	�������¼�����״̬�ı�
		SimpleChannelInboundHandler		������Ϣ


-----------------------------
ChannelOutboundHandler		 |
-----------------------------
	# д���¼�
	# ���
		|-ChannelOutboundHandler
			|-ChannelOutboundHandlerAdapter
				|-MessageToByteEncoder<I>
				|-MessageToMessageEncoder<I>
					|-LengthFieldPrepender
					|-StringEncoder

-----------------------------
ChannelPromise ����			 |
-----------------------------
	# ChannelPromise
		* ���̳���ChannelFuture
	
	# ����
		* ����� ChannelFuture,������� ChannelPromise ���� ���� �ɹ���ʧ��
		* �����κ�ʱ��������� Channel.write(...) һ���µ� ChannelPromise ���ᴴ������ͨ�� ChannelPipeline ����
		* ���д���������᷵�� ChannelFuture, ����ֻ������õ�һ�β�����ɵ�֪ͨ
		* Netty ����ʹ�� ChannelPromise ��Ϊ���ص� ChannelFuture ��֪ͨ,��ʵ���ڴ����ʱ����� ChannelPromise ����
		* ChannelPromise ��չ�� ChannelFuture
		* ��ǰ����,ChannelOutboundHandlerAdapter �ṩ��һ��ʵ���� ChannelOutboundHandler ���л���������ʵ�ֵĿ�ܡ�
		* ��Щ���¼�ת������һ�� ChannelOutboundHandler �ܵ�ͨ������ ChannelHandlerContext ��صĵ�Ч����,���Ը�����Ҫ�Լ�ʵ����Ҫ�ķ���


-----------------------------
�����Handler				 |
-----------------------------
	# ChannelHandler ʵ��������� @Sharable ע������Ա���ӵ����ChannelPipeline
		* Ҳ����˵���� ChannelHandler ʵ�������ж�� ChannelHandlerContext
		* ��˿��Ե��ò�ͬ ChannelHandlerContext ��ȡͬһ�� ChannelHandler 
		* �����Ӳ��� @Sharable ע��� ChannelHandler ʵ������� ChannelPipeline ����׳��쳣
		* ʹ�� @Sharable ע���� ChannelHandler �����ڲ�ͬ���̺߳Ͳ�ͬ��ͨ���ϰ�ȫʹ��
	
	# ʹ�� @Sharable ע�⹲��һ�� ChannelHandler ��һЩ�����л����кܺõ����õ�
		* ��ʹ��һ�� ChannelHandler ��ͳ����������������һЩȫ�����ݵȵ�
