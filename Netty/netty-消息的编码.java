--------------------------------
��Ϣ�ı���						|
--------------------------------

--------------------------------
LengthFieldPrepender			|
--------------------------------
	# ��������Ϣ��ӳ�����Ϣ��ͷ��
		public LengthFieldPrepender(int lengthFieldLength)
		public LengthFieldPrepender(int lengthFieldLength, boolean lengthIncludesLengthFieldLength) 
		public LengthFieldPrepender(int lengthFieldLength, int lengthAdjustment)
		public LengthFieldPrepender(int lengthFieldLength, int lengthAdjustment, boolean lengthIncludesLengthFieldLength)
		public LengthFieldPrepender(ByteOrder byteOrder, int lengthFieldLength, int lengthAdjustment, boolean lengthIncludesLengthFieldLength)

		
		lengthIncludesLengthFieldLength
			* length�ֶ�ֵ�Ƿ�Ҫ������length�ֶα���ĳ���
		
		lengthFieldLength
			* �ü����ֽڱ�ʾ���ݵĳ���
		
		lengthAdjustment
			* lengthAdjustment + ���ݳ���ȡֵ = ���ݳ����ֶ�֮��ʣ�°����ֽ���
			* ��ӵ������ֶεĲ���ֵ(0)
			* ����ĳЩЭ��,�����ֶλ���������Ϣͷ�ĳ���,������Ӧ�ó�����,������Ҫʹ��lengthAdjustment��������
			* ����������Ϣ(������Ϣͷ)�ĳ�������������Ϣ��ĳ���,������Ҫ����Ϊ����(���ݳ����ֶεĳ���ȡ��)