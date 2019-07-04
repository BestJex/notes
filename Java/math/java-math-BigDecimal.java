------------------------
BigDecimal				|
------------------------
	# ��̬����
		public final static int ROUND_UP =           0;
		public final static int ROUND_DOWN =         1;
		public final static int ROUND_CEILING =      2;
		public final static int ROUND_FLOOR =        3;
		public final static int ROUND_HALF_UP =      4;
		public final static int ROUND_HALF_DOWN =    5;
		public final static int ROUND_HALF_EVEN =    6;
		public final static int ROUND_UNNECESSARY =  7;

			* ��������ģʽ
	# ���캯��
		BigDecimal(char[] in)
		BigDecimal(char[] in, int offset, int len)
		BigDecimal(char[] in, int offset, int len, MathContext mc)
		BigDecimal(char[] in, MathContext mc)
		BigDecimal(double val)
		BigDecimal(double val, MathContext mc)
		BigDecimal(int val)
		BigDecimal(int val, MathContext mc)
		BigDecimal(String val)
		BigDecimal(String val, MathContext mc)
		BigDecimal(BigInteger val)
		BigDecimal(BigInteger unscaledVal, int scale)
		BigDecimal(BigInteger unscaledVal, int scale, MathContext mc)
		BigDecimal(BigInteger val, MathContext mc)
		BigDecimal(long val)
		BigDecimal(long val, MathContext mc)
	

------------------------
BigDecimal-��̬����		|
------------------------
	BigDecimal valueOf(double val)
	BigDecimal valueOf(long val)
	BigDecimal valueOf(long unscaledVal, int scale)


------------------------
BigDecimal-ʵ������		|
------------------------
	BigDecimal add(BigDecimal augend)
	BigDecimal add(BigDecimal augend, MathContext mc)
	
	BigDecimal subtract(BigDecimal subtrahend)
	BigDecimal subtract(BigDecimal subtrahend, MathContext mc)

	BigDecimal multiply(BigDecimal multiplicand)
	BigDecimal multiply(BigDecimal multiplicand, MathContext mc)

	BigDecimal divide(BigDecimal divisor)
	BigDecimal divide(BigDecimal divisor, int roundingMode)
	BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)
	BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode)
	BigDecimal divide(BigDecimal divisor, MathContext mc)
	BigDecimal divide(BigDecimal divisor, RoundingMode roundingMode)
		* �Ӽ��˳�
			newScale					��ʾ������С��λ��
			roundingMode				ָ������ģʽ(������int����ö��)
			mc							ͨ��ָ���� MathContext �����Ⱥ�����
	
	BigDecimal setScale(int newScale, int roundingMode)
		* ��ʽ��С��
			newScale		��ʾ������С��λ��
			roundingMode	����ģʽ
	

	String toString();
		* �б�Ҫʱʹ�ÿ�ѧ������

	String toPlainString();
		* ��ʹ���κ�ָ��

	String toEngineeringString();
		* �б�Ҫʱʹ�ù��̼�����
		* ���̼�������һ�ֹ��̼����о���ʹ�õļ�¼���ֵķ���, ���ѧ����������. ��Ҫ��10���ݱ�����3�ı���
