------------------------
���ؾ���				|
------------------------
	# Consumer�����㷨
		* ��һ��group��,��consumer��������뿪(崻�,�ر�)ʱ,�ᴥ��partitions���ؾ���
		* ���ؾ��������Ŀ��,������topic�Ĳ�����������

			1 ����topic1,��������partitions: P0,P1,P2,P3
			2 ����group��,������consumer: C0,C1
			3 ���ȸ���partition�����Ŷ�partitions����: P0,P1,P2,P3
			4 ����consumer.id����: C0,C1
			5 ���㱶��:(partitions����������consumer������)
				M = [P0,P1,P2,P3].size / [C0,C1].size,����ֵ M = 2(����ȡ��)

			6 Ȼ�����η���partitions: 
				C0 = [P0,P1]
				C1 = [P2,P3]
				
				Ci = [P(i * M),P((i + 1) * M -1)]
				
				i = 0
				m = 2
				P(i * m) = P0
				P((i + 1) * m - 1) = P1
