--------------------
Buffer				|
--------------------
	# �漰�����
		ByteBuf
		ByteBufHolder
			* ���� Netty �ĸ߼�����,�绺���
		CompositeByteBuf
			* ����bufer
		ByteBufProcessor
			* ����buffer��һЩ����
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
	
	# ByteBuf ������
		capacity	�ܴ�С
		readindex	���Ǳ�
		wirteindex	д�Ǳ�

--------------------
Buffer����			|
--------------------
	# ByteBufAllocator

	# Unpooled (�ǳػ�)����

		

