-------------------------
���ü���				 |
-------------------------
	# ���ü���
		* �����ü��������Ķ���,�ܹ���ʾ�ı���������,����ʼ����ʱ��,������������ٵ�0�����ᱻ��ʾ����
		* �ٴη��ʱ����յ���Щ���󽫻��׳��쳣
		*  ���һ������ʵ����ReferenceCounted,���Ұ�������������Ҳʵ����ReferenceCounted,������������Ϊ0�����յ�ʱ��,�������Ķ���ͬ����ͨ��release()�ͷŵ�

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
	# ���� ReferenceCounted �Ĳ���������
		
	