--------------------
Buffer				|
--------------------
	# �漰�����
		ReferenceCounted
			|-ByteBuf
				|-CompositeByteBuf
			|-ByteBufHolder
			|-FileRegion
				|-DefaultFileRegion
		ByteBufProcessor
		ByteBufAllocator
		Unpooled
		ByteBufUtil

	# Netty ���� API �ṩ�˼�������
		* �����Զ��建������
		* ͨ��һ�����õĸ��ϻ�������ʵ���㿽��
		* ��չ�Ժ�,���� StringBuilder
		* ��ȡ��д�������ֿ�,����Ҫ���� flip() ���л���/дģʽ
		* ������
		* ���ü���
		* Pooling(��)
	
	# Netty ʹ�� reference-counting(���ü���)��ʱ��֪����ȫ�ͷ� Buf ��������Դ
	
	# ByteBuf ��Ĭ��������������� Integer.MAX_VALUE
	
	# Buffer����صĿ�
		ByteBufAllocator
			|-PooledByteBufAllocator
			|-UnpooledByteBufAllocator
		Unpooled
		CompositeByteBuf
		ByteBufUtil
		ByteBufHolder



--------------------
Buffer				|
--------------------
	capacity	�ܴ�С
	readindex	���Ǳ�
	wirteindex	д�Ǳ�

--------------------
Heap Buffer(�ѻ�����)|
--------------------
	# ��õ������� ByteBuf �����ݴ洢�� JVM �Ķѿռ�
		* �ṩ��ֱ�ӷ�������ķ���,ͨ�� ByteBuf.array()����ȡ byte[]����
	
	# ���ʷǶѻ����� ByteBuf ������ᵼ�� UnsupportedOperationException
		* ����ʹ�� ByteBuf.hasArray()������Ƿ�֧�ַ�������
	
------------------------
Direct Buffer(ֱ�ӻ�����)|
------------------------
	# �ڶ�֮��ֱ�ӷ����ڴ�,ֱ�ӻ���������ռ�öѿռ�����
	# ֱ�ӻ�������ȱ�����ڷ����ڴ�ռ���ͷ��ڴ�ʱ�ȶѻ�����������,�� Netty ʹ���ڴ�����������������,��Ҳ�� Netty ʹ���ڴ�ص�ԭ��֮һ
	# ֱ�ӻ�������֧�������������,���ǿ��Լ�ӵķ�����������
		ByteBuf directBuf = Unpooled.directBuffer(16);
		// ֱ�ӻ�����
		if(!directBuf.hasArray()){
			// �ɶ������ݳ���
			int len = directBuf.readableBytes();
			// ������ͬ���ȵ�����
			byte[] arr = new byte[len];
			// �ѻ����������ݶ�ȡ������
			directBuf.getBytes(0, arr);
		}



