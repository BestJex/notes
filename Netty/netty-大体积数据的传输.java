--------------------
�㿽��				|
--------------------
	# NIO ��"zero-copy(�㿽��)"����,�����ƶ�һ���ļ������ݴ��ļ�ϵͳ�������ջ�ĸ��Ʋ���

	# ֱ�Ӵ���һ���ļ�������,û��ִ�е�����Ӧ�ó���Ĵ���
		// ��ȡ FileInputStream
		FileInputStream in = new FileInputStream(file); 

		// ����һ���µ� DefaultFileRegion �����ļ�����������
		FileRegion region = new DefaultFileRegion(in.getChannel(), 0, file.length()); 

		// ���� DefaultFileRegion ����ע��һ�� ChannelFutureListener
		channel.writeAndFlush(region).addListener(new ChannelFutureListener() { 
			@Override
			public void operationComplete(ChannelFuture future) throws Exception {
				// ������ʧ��
				if (!future.isSuccess()) {
					Throwable cause = future.cause(); 
				}
			}
		});


--------------------
�ֶδ���			|
--------------------
	# ���
		ChunkedInput
			ChunkedFile
				ƽ̨��֧�� zero-copy ��������Ҫת������,���ļ���һ��һ��Ļ�ȡ����
			ChunkedNioFile
				�� ChunkedFile ����,����ʹ����NIOFileChannel
			ChunkedStream
				�� InputStream ��һ��һ���ת������
			ChunkedNioStream
				�� ReadableByteChannel ��һ��һ���ת������
