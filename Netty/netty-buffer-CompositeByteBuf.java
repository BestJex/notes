------------------------------
CompositeByteBuf			  |
------------------------------
	# ����Buffer,������Ҳ��ʵ����ByteBuf�ӿ�,�������������ڴ�й©������

		* ��ʵ���ǰѶ��Buffer��ͳ�һ��Buffer

	# CompositeByteBuf.hasArray()���Ƿ��� false,��Ϊ�����ܰ���һЩֱ�ӻ��ӵĲ�ͬ���͵� ByteBuf

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

