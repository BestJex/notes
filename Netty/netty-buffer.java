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
	
	# ���
		* Netty ʹ�� reference-counting(���ü���)���жϺ�ʱ�����ͷ� ByteBuf �� ByteBufHolder �����������Դ
		* �Ӷ��������óغ�����������������ܺͽ����ڴ������,��һ���ϲ���Ҫ������Ա���κ�����
		* �����ڿ��� Netty Ӧ�ó���ʱ,������ʹ�� ByteBuf �� ByteBufHolder ʱ,Ӧ�þ���������ͷų���Դ
	
	# Netty ���� API �ṩ�˼�������
		* �����Զ��建������
		* ͨ��һ�����õĸ��ϻ�������ʵ���㿽��
		* ��չ�Ժ�,���� StringBuilder
		* ����Ҫ���� flip() ���л���/дģʽ
		* ��ȡ��д�������ֿ�
		* ������
		* ���ü���
		* Pooling(��)
	
	# Netty ʹ�� reference-counting(���ü���)��ʱ��֪����ȫ�ͷ� Buf ��������Դ
	
	# ByteBuf ��Ĭ��������������� Integer.MAX_VALUE

	# ByteBuf ������
		capacity	�ܴ�С
		readindex	���Ǳ�
		wirteindex	д�Ǳ�
	
	# Buffer�ķ���
		ByteBufAllocator
			ByteBufAllocator.heapBuffer()
			ByteBufAllocator.directBuffer()
			ByteBufAllocator.compositeBuffer()

		Unpooled (�ǳػ�)����
			Unpooled.buffer();
			Unpooled.directBuffer();
			Unpooled.compositeBuffer();

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

----------------------------
Composite Buffer(���ϻ�����)|
----------------------------
	# ��ʵ���ǰѶ��Buffer��ͳ�һ��Buffer
	# CompositeByteBuf.hasArray()���Ƿ��� false,��Ϊ�����ܰ���һЩֱ�ӻ��ӵĲ�ͬ���͵� ByteBuf
	# ��Ҳʵ���� ByteBuf ,�������������ڴ�й©������
	# �򵥵�ʹ��
		// �������ϻ�����
		CompositeByteBuf compBuf = Unpooled.compositeBuffer();

		// ������buffer
		ByteBuf heapBuf = Unpooled.buffer(8);
		ByteBuf directBuf = Unpooled.directBuffer(16);

		//��� ByteBuf �� CompositeByteBuf
		compBuf.addComponents(heapBuf,directBuf);

		//ɾ����һ�� ByteBuf
		compBuf.removeComponent(0);

		// ���Ե������ϻ������е�ÿһ��������
		Iterator<ByteBuf> iter = compBuf.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next().toString());
		}

		//ʹ�������������
		if(!compBuf.hasArray()){
			int len = compBuf.readableBytes();
			byte[] arr = new byte[len];
			compBuf.getBytes(0, arr);
		}

----------------------------
ByteBufUtil					|
----------------------------
	# �ṩ�˺ܶ�ľ�̬API���Բ���buf

	String hexDump(ByteBuf buffer)
		* ����buffer��16�����ַ���,�����rindexȥ��ȡ

----------------------------
ByteBufAllocator			|
----------------------------
	# ByteBuf������,����һ���ӿ�,������ʵ��(�غͷǳ�)
		PooledByteBufAllocator
		UnpooledByteBufAllocator
	
	ByteBufAllocator DEFAULT = ByteBufUtil.DEFAULT_ALLOCATOR;

    ByteBuf buffer();
    ByteBuf buffer(int initialCapacity);
    ByteBuf buffer(int initialCapacity, int maxCapacity);
		* ����buffer
		* ����ָ����ʼ����С�����

    ByteBuf ioBuffer();
    ByteBuf ioBuffer(int initialCapacity);
    ByteBuf ioBuffer(int initialCapacity, int maxCapacity);
		* ����ֱ���ڴ�buffer
		* ����ָ����ʼ����С�����

    ByteBuf heapBuffer();
    ByteBuf heapBuffer(int initialCapacity);
    ByteBuf heapBuffer(int initialCapacity, int maxCapacity);
		* ����һ��heapBuffer

    ByteBuf directBuffer();
    ByteBuf directBuffer(int initialCapacity);
    ByteBuf directBuffer(int initialCapacity, int maxCapacity);
		* ����һ��directBuffer

    CompositeByteBuf compositeBuffer();
    CompositeByteBuf compositeBuffer(int maxNumComponents);
    CompositeByteBuf compositeHeapBuffer();
    CompositeByteBuf compositeHeapBuffer(int maxNumComponents);
		* �������Buffer

    CompositeByteBuf compositeDirectBuffer();
    CompositeByteBuf compositeDirectBuffer(int maxNumComponents);

    boolean isDirectBufferPooled();
		* �Ƿ�ʹ����ֱ���ڴ�

    int calculateNewCapacity(int minNewCapacity, int maxCapacity);
		

----------------------------
Unpooled					|
----------------------------
	ByteBuf copiedBuffer(CharSequence string, Charset charset)
		* ��ָ����string����ΪByteBuff


----------------------------
ByteBufHolder				|
----------------------------
	# ByteBufHolder �� ByteBuf ������
