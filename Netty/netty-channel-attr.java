-------------------------
attr					 |
-------------------------
	# ���
		Constant
			|-AbstractConstant
				|-AttributeKey
		
		AttributeMap
			|-DefaultAttributeMap
				|-AbstractChannel
				|-AbstractChannelHandlerContext
			|-Channel
			|-ChannelHandlerContext
		
		Attribute
	

	# ChannelHandlerContext �� Channel �� attr û������
		Channel.attr() == ChannelHandlerContext.attr()

		* ChannelHandlerContext.attr(),�Ѿ�����,����ʹ�� Channel �� attr
		


------------------------
AttributeKey			|
------------------------
	# ���ڴ���һ��key����,���ͱ�ʾ��key��Ӧ��Value����
	# AttributeKey�ǻ���ConstantPool���л����

	public static <T> AttributeKey<T> valueOf(String name)
		* �������ֹ����ķ�ʽ,�� constant != nullʱ,��ô�����Ѿ������ constant
		* ��� name �����ھʹ���һ��
		* �Ҷ��߳����ȴ�������˭

	public static <T> AttributeKey<T> newInstance(String name)
		* �������ֹ����ķ�ʽ,�� constant != nullʱ,ֱ���׳��쳣
		* ���name���ھ��׳��쳣
		* ���̴߳���,���˳ɹ��������Ǹ��߳���,�����߳��׳��쳣
	
	public static boolean exists(String name)

	public static <T> AttributeKey<T> valueOf(Class<?> firstNameComponent, String secondNameComponent)
		* �ײ㻹�ǵ��� valueOf(String name),
		* �� firstNameComponent �� secondNameComponent  ֮������� '#' �ַ���(�����ռ�ĸо�)

-------------------------
Attribute				 |
-------------------------
	# ��ʾValue

	AttributeKey<T> key();

    T get();

    void set(T value);

    T getAndSet(T value);

    T setIfAbsent(T value);

    boolean compareAndSet(T oldValue, T newValue);