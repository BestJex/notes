------------------
Java��������
------------------
	# ������Ϊÿ��.proto�ļ����봴��һ����һ��.java�ļ�
		* .proto�ļ��ж������, ���ڲ������ʽ����
		* ����ļ�����һ����һ��outer class����,����һЩ��Ƕ��;�̬�ֶ�

	# ���ɵ���
		* ʵ�� Message �ӿ�, ���ұ���ʶΪ final
			public static final class Person extends com.google.protobuf.GeneratedMessageV3 implements PersonOrBuilder
	
	# �ֶ�
		* �»��߻�ת��Ϊ�շ�
			foo_bar_baz  -> fooBarBaz

		* ��������и���ǰ׺(�� "get"), ��һ����ĸ��д������Сд
		
		* ������Ϊÿ���ֶ�����һ�����������ֶα�ŵ����ͳ���
		* ��������: ת��Ϊ��д������ _FIELD_NUMBER �ֶ�����
				optional int32 foo_bar = 5 -> public static final int FOO_BAR_FIELD_NUMBER = 5;��


-----------------------
Outer��ľ�̬����
-----------------------
	Descriptor getDescriptor()
	void registerAllExtensions(ExtensionRegistry registry)
	void registerAllExtensions(ExtensionRegistryLite registry)


-----------------------
������ľ�̬����
-----------------------
	static T getDefaultInstance()
		* ���ص���

	Descriptor getDescriptor()
		* ��ȡ����

	Parser<T> parser()
		* ���ؽ�����

	T parseDelimitedFrom(InputStream input);
	T parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry)

	T parseFrom(byte[] data)
	T parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry)

	T parseFrom(ByteString input)
	T parseFrom(ByteString input, ExtensionRegistryLite extensionRegistry)

	T parseFrom(CodedInputStream input)
	T parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry)

	T parseFrom(InputStream input)
	T parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry)

	T parseFrom(ByteBuffer data)
	T parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry)
		* ��������Ϊ����

	Builder newBuilder(T prototype)
		* ����һ���µ�builder
		* �����ֶγ�ʼ��Ϊ����prototype��һ����ֵ, ǳ��¡����

	Builder newBuilder()
		* ����һ���µ�builder

-----------------------
ʵ����������
-----------------------
	void writeTo(CodedOutputStream output)
		* �ѵ�ǰ�����л���ָ����OutputStream
	
