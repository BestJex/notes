
--------------------
handler��ϵ			|
--------------------
	ChannelHandler
		* ���hanlder

		|-ChannelHandlerAdapter
		|-ChannelInboundHandler
			* ������ӿ�

			|-ChannelInboundHandlerAdapter
				|-ByteToMessageDecoder
					|-ReplayingDecoder<S> 
					|-LineBasedFrameDecoder
					|-LengthFieldBasedFrameDecoder
					|-DelimiterBasedFrameDecoder
					|-FixedLengthFrameDecoder
				|-MessageToMessageDecoder
					|-StringDecoder
				|-ChannelInitializer
				|-SimpleChannelInboundHandler<I>

		|-ChannelOutboundHandler
			* д����ӿ�

			|-ChannelOutboundHandlerAdapter
				|-MessageToByteEncoder<I>
				|-MessageToMessageEncoder<I>
					|-LengthFieldPrepender
					|-StringEncoder
		
		|-ChannelDuplexHandler
			* ͬʱʵ���˶�д����ӿ�

			|-ChunkedWriteHandler

			

ReferenceCounted
	|-ByteBuf


	