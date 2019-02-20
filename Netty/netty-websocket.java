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
		WebSocketServerProtocolHandler
		WebSocketServerCompressionHandler

	# WebSocketFrame
		* ws��Ϣ���͵ĳ�����,�ṩ��N��ʵ��,��ʾ��ͬ����Ϣ����
		* ��������֪����ɶʵ����
	

-------------------------------------
WebSocketServerProtocolHandler		 |
-------------------------------------
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
		checkStartsWith
		dropPongFrames
	
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
						public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
							String id = ctx.channel().id().asLongText();
							System.out.println("�µ�����:" + id);
							super.handlerAdded(ctx);
						}
						@Override
						public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
							System.out.println("���ӶϿ�:" + ctx.channel().id().asLongText());
							super.channelInactive(ctx);
						}
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
