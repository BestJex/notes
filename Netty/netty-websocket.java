---------------------------------
websocket						 |
---------------------------------
	# ���
		WebSocketFrame
			|-BinaryWebSocketFrame			
			|-CloseWebSocketFrame
			|-ContinuationWebSocketFrame
			|-PingWebSocketFrame
			|-PongWebSocketFrame
			|-TextWebSocketFrame
		WebSocketProtocolHandler(�Զ�����webSocket��ping pong����Ϣ)
			|-WebSocketServerProtocolHandler(�򻯿����ṩ��handler)
		WebSocketServerCompressionHandler(WebSocket��Ϣѹ��)
		WebSocketServerProtocolHandshakeHandler(WebSocketЭ�������ʵ��)
		WebSocketServerHandshaker(���ִ�����)
		WebSocketServerHandshakerFactory(�����������Ĺ�����)

	# WebSocketFrame
		* ws��Ϣ���͵ĳ�����,�ṩ��N��ʵ��,��ʾ��ͬ����Ϣ����
		* ������,������֪����ɶ��Ϣ��ʵ����
	
	# WebSocketServerCompressionHandler
		* �ṩ�˶�websocket��Ϣ��ѹ��


-------------------------------------
WebSocketServerProtocolHandler		 |
-------------------------------------
	# ���ص�һ����װ,�����N��Ĺ���
	# ������:����,����֡(ping/pong/close),�ı���Ϣ,��������Ϣ....
	# ���캯��
		WebSocketServerProtocolHandler(String websocketPath)
		WebSocketServerProtocolHandler(String websocketPath, boolean checkStartsWith)
		WebSocketServerProtocolHandler(String websocketPath, String subprotocols)
		WebSocketServerProtocolHandler(String websocketPath, String subprotocols,boolean allowExtensions) 
		WebSocketServerProtocolHandler(String websocketPath, String subprotocols,boolean allowExtensions, int maxFrameSize)
		WebSocketServerProtocolHandler(String websocketPath, String subprotocols,boolean allowExtensions, int maxFrameSize, boolean allowMaskMismatch)
		WebSocketServerProtocolHandler(String websocketPath, String subprotocols,boolean allowExtensions, int maxFrameSize, boolean allowMaskMismatch, boolean checkStartsWith)
		WebSocketServerProtocolHandler(String websocketPath, String subprotocols,boolean allowExtensions, int maxFrameSize, boolean allowMaskMismatch, boolean checkStartsWith, boolean dropPongFrames)
		
		websocketPath
			* �ṩ�����uri
		subprotocols
			* ֧�ֵ���Э���б�
		allowExtensions
			* �Ƿ�������չ
		maxFrameSize
			* ��Ϣ֡����ֽ���

		allowMaskMismatch
			* �Ƿ�Ҫ����δʵ�ֱ�׼�淶������֡

		checkStartsWith
			* ���Ϊtrue, ��ʹ��startWith ��� uri, ����ʹ��quals
			* ���Ϊfalse, �����Ҫ��uri��websocketһ��һ��
			
		dropPongFrames
			* ����pong��Ϣ
	
	# �����websocket�����ݱ���Ϊ WebSocketFrame ����,������һ��Handlerȥ����

	
---------------------------------
�����							 |
---------------------------------
import java.util.Locale;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class Server {
	public static void main(String[] args) throws InterruptedException {
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(bossGroup, workerGroup);
			serverBootstrap.channel(NioServerSocketChannel.class);
			serverBootstrap.handler(new LoggingHandler(LogLevel.INFO));
			serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel socketChannel) throws Exception {
					ChannelPipeline pipeline = socketChannel.pipeline();
					pipeline.addLast(new HttpServerCodec());
					pipeline.addLast(new ChunkedWriteHandler());
					pipeline.addLast(new HttpObjectAggregator(65536));
					pipeline.addLast(new WebSocketServerCompressionHandler());
					pipeline.addLast(new WebSocketServerProtocolHandler("/websocket", null, true));	// uri,��Э��,�Ƿ�֧����չ
					pipeline.addLast(new SimpleChannelInboundHandler<WebSocketFrame>() {
						@Override
						protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame msg) throws Exception {
							if (msg instanceof TextWebSocketFrame) { // �ı���Ϣ����
								String request = ((TextWebSocketFrame) msg).text();
								System.out.println("���յ���Ϣ:" + request);
								ctx.channel().writeAndFlush(new TextWebSocketFrame(request.toUpperCase(Locale.CHINA)));
							} else {	// �������͵���Ϣ
								String message = "��֧�ֵ���Ϣ����: " + msg.getClass().getName();
								throw new UnsupportedOperationException(message);
							}
						}
						// ���ֽ���¼�֪ͨ
						@Override
						public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
							if(evt instanceof HandshakeComplete) {
								HandshakeComplete handshakeComplete = (HandshakeComplete) evt;
								String uri = handshakeComplete.requestUri();
								HttpHeaders httpHeaders = handshakeComplete.requestHeaders();
								String selectedSubprotocol = handshakeComplete.selectedSubprotocol();
								LOGGER.debug("HandshakeComplete uri={},headers={},selectedSubprotocol={}",uri,httpHeaders,selectedSubprotocol);
							}
							super.userEventTriggered(ctx, evt);
						}
					});
				}
			});
			Channel channel = serverBootstrap.bind(1024).sync().channel();
			channel.closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}

	
---------------------------------
������ǰ����uri�����ȵ�			 |
---------------------------------
	# ˼·
		* �� HttpObjectAggregator ֮�����һ��Handler,���ڻ�ȡ��������http������Ϣ:FullHttpRequest
		* ����ͨ��FullHttpRequest��ȡ��uri,header,method,query param����Ϣ
		* �Լ����Ծ�������Ӧ�쳣��Ϣ,����ִ����һ��handler,Ҳ����ws����

	# ����
		pipeline.addLast(new HttpObjectAggregator(65536));
		pipeline.addLast(new ChannelInboundHandlerAdapter() {
			@Override
			public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
				if(msg instanceof FullHttpRequest) {
					FullHttpRequest fullHttpRequest = (FullHttpRequest) msg;
					
					// ��ȡ�������uri,�������������·�����������
					String uri = fullHttpRequest.uri();

					fullHttpRequest.setUri(ENDPOINT); // һ��Ҫ����uri��websocket�Ķ˵�ƥ��
				}
				super.channelRead(ctx, msg);
			}
		});
		pipeline.addLast(new WebSocketServerCompressionHandler());
		pipeline.addLast(new WebSocketServerProtocolHandler(ENDPOINT, null, true));	// uri,��Э��,�Ƿ�֧����չ
