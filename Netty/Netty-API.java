
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
				|-ChannelInitializer
				|-SimpleChannelInboundHandler<I>
		|-ChannelOutboundHandler
			* д����ӿ�

			|-ChannelOutboundHandlerAdapter
				|-MessageToByteEncoder<I>

ReferenceCounted
	|-ByteBuf


	