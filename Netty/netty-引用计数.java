-------------------------
���ü���				 |
-------------------------
	# �ӿ� ReferenceCounted

	# �ӿڷ���
		int refCnt();
			* ����������

		ReferenceCounted retain();
			* ���һ������

		ReferenceCounted retain(int increment);
			* ���N������

		ReferenceCounted touch();
		ReferenceCounted touch(Object hint);

		boolean release();
			* �ͷ�һ������

		boolean release(int decrement);
			* �ͷ�n������


-------------------------
ReferenceCountUtil		 |
-------------------------
	