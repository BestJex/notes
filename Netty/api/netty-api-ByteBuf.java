-----------------------------
ByteBuf						 |
-----------------------------
	#  abstract class ByteBuf implements ReferenceCounted, Comparable<ByteBuf>

-----------------------------
����						 |
-----------------------------
	// �Ǳ�Ĳ���
	int readerIndex();
		* ���ض��Ǳ�
	
	ByteBuf readerIndex(int readerIndex);
		* �����µĶ��Ǳ�

	int writerIndex();
		* ����д�Ǳ�
	
	ByteBuf writerIndex(int writerIndex)
		* �����µ�д�Ǳ�
	
	ByteBuf setIndex(int readerIndex, int writerIndex);
		* ͬʱ���ö�д�Ǳ�

	// ���������Բ���
	int capacity();
		* ������������

	boolean isReadable();
		* �Ƿ�������1���ֽڵĿɶ��ռ�

	boolean isReadable(int size);
		* �Ƿ���ָ�����ȵĿɶ��ռ�
	
	boolean isWritable();
		* �Ƿ����뻹��1���ֽڵĿ�д�ռ�
	
	boolean isWritable(int size);
		* �Ƿ����뻹��ָ�����ֽڵĿ�д�ռ�

	int writableBytes();
		* ���ؿ�д�Ŀռ��С
	
	// ���ݶ�ȡ
	long  readUnsignedInt()
	ByteBuf retainedDuplicate()
	short readUnsignedByte()

	// ���ݶ���
	ByteBuf discardReadBytes();
		* ��� ByteBuf ���Ѷ�ȡ������,δ��������ǰ�ƶ�,�Ӷ�ʹ ByteBuf �ж���Ŀռ������µ�����
		* ���ܻ��漰�ڴ渴��,��Ϊ����Ҫ�ƶ� ByteBuf �пɶ����ֽڵ���ʼλ��,�����Ĳ�����Ӱ������
		* һ������Ҫ�����ͷ��ڴ��ʱ��ʹ�������Ƚϴ�

	ByteBuf discardSomeReadBytes();

	// ��ǲ���
	ByteBuf markReaderIndex()
		* ��Ƕ��Ǳ�

	ByteBuf resetReaderIndex()
		* ���ö��Ǳ�Ϊ��ǽǱ�


	// ����
	boolean hasArray()
		* �Ƿ�֧�ַ�������(����,�Ƕѵ�buf)
		* ���ʷǶѻ����� ByteBuf ������,���׳��쳣 UnsupportedOperationException