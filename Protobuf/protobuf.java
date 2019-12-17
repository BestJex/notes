
# Protobuf
	* һ�ָ����ܵ����л�Э��

# �ο�
	https://colobu.com/2017/03/16/Protobuf3-language-guide
	https://github.com/protocolbuffers/protobuf
	https://blog.csdn.net/u011518120/article/details/54604615


# ָ���汾��
	syntax
		* ���붨���ڵ�һ�У�ָ���汾��
			syntax = "proto3";
		* �����ָ����Ĭ��ʹ�ð汾��2.x

# ���ԵĹ���

	required
		* �������1��

	singular
		* ���Գ���0�λ���1��
	
	repeated
		* ���Գ���0�λ���N��, �ظ���ֵ��˳��ᱻ����
		* ����һЩ��ʷԭ��Ĭ������£���ֵ���͵Ŀ��ظ���repeated���ֶεı�������û�������еĺ�
		* ��Ӧ�������������ѡ�� [packed=true] �������Ի�ø���Ч�ı���
			repeated int32 samples = 4 [packed=true];
	
	optional
		


# �ֶα��
	* ÿ���ֶζ���һ��Ψһ�ı��
	* ��Щ�ֶκ����ڱ�ʶ��Ϣ�����Ƹ�ʽ���ֶ�, ��Messageʹ��(���л�/�����л�)�Ĺ�����, �����޸�

	* ����ȡֵ��Χ��: 1 - 536870911
	* ���ǲ���ʹ�� 19000 - 19999, ��ζ�protobuf����ʹ�õı�Ŷζ�

	* ��ΧΪ1��15���ֶα����Ҫһ���ֽ�������, �����ֶα�ź��ֶε�����
	* 16��2047֮����ֶα��ռ�������ֽ�
	* ���Ӧ��Ϊ�������ֵ���ϢԪ�ر�������1��15, Ϊ����������ӵ�Ƶ�����ֵ�Ԫ������һЩ�ռ�

# ��һ��.proto�ļ��п��Զ�������Ϣ����
	* �ڶ�������ص���Ϣ��ʱ��

# ע��
	* ˫б��ע��

# ������ʶ��
	* ���Ǳ�ʶһЩ�������ֶ����ƻ����ֶα��, ����ʹ�����ǵĿ�����, ������Ҫʹ����Щ���������ֶα��
		reserved 2, 15, 9 to 11;
		reserved "foo", "bar";
	
	* ������ͬһ��ͬʱָ�����, ʹ�ö��ŷָ��������ָ���������ֶα��, ��֧��ʹ�� to �ؼ�������ʾһ������
	* ͬһ���в���ͬʱ�����ֶ����ƺ��ֶα��

# ���������ļ���message
	* ֱ�ӵ���, Ĭ��ֻ�ᵼ��ָ���ļ��еĶ����message��ָ���ļ��е� import ���ᱻ����
		import "myproject/other_protos.proto";
	
	* ��������, �����ڵ�ǰ�ļ����� public ����������proto�ļ�, ��ǰ�ļ��� import ��ʱ��, ��� public �������ļ�Ҳһ����
		import public "new.proto";
	
	* ͨ���ڱ����������в�����ʹ�� -I/--proto_pathprotocal ����������ָ��Ŀ¼����Ҫ������ļ�
	* ���û�и�����־������������������������õ�Ŀ¼��ͨ��ֻҪָ��proto_path��־Ϊ��Ĺ��̸�Ŀ¼�ͺá�����ָ���õ������ȷ���ƾͺá�


# ��Ϣ��Ƕ�׶���
	* ��Ϣ����Ƕ�׵Ķ�����
		message Outer {                  // Level 0
		  message MiddleAA {  // Level 1
			message Inner {   // Level 2
			  int64 ival = 1;
			  bool  booly = 2;
			}
		  }
		  message MiddleBB {  // Level 1
			message Inner {   // Level 2
			  int32 ival = 1;
			  bool  booly = 2;
			}
		  }
		}

# Any
	* Any ����������û��ĳЩ��Ϣ���͵�.proto ����ʱ����ʹ����Ƕ����Ϣ����һ��ʹ������������Ϣ���͵��ֶ�
	* һ�� Any ���͵���Ϣ��һ�����������ֽ��������л���Ϣ��ӵ��һ�� URL ��ַ��Ϊȫ��Ψһ��ʶ���������Ϣ�����͡�
	* Ϊ��ʹ�� Any ���͵���Ϣ����Ҫimport google/protobuf/any.proto
		import "google/protobuf/any.proto";
		message ErrorStatus {
				string message = 1;
				repeated Any details = 2;
		}
	* Any ��Ϣ���͵�Ĭ�� URL ��: type.googleapis.com/packagename.messagename
	* ��ͬ������ʵ�ֶ���֧�����п����ͨ�����Ͱ�ȫ�ķ�ʽ��������� Any ���͵���Ϣ��
	* �� Java �����У�Any ������ר�ŵķ��ʺ��� pack()��unpack()

# OneOf
	* ��Ϣ�ж����˺ܶ��ֶΣ��������ÿ��ֻ����һ���ֶα����ø�ֵ����ô�������� Oneof ������ʵ��������Ϊ���ܽ�ʡ�ڴ档
	* Oneof �ֶγ���ӵ�г����ֶε�����֮�⣬�����ֶι���һƬ oneof �ڴ棬����ÿ�����ֻ����һ���ֶα����ø�ֵ��
	& ���� oneof���е�����һ����Ա��ֵʱ��������Ա��ֵ���Զ������
	* ������ case()�� WhickOneof()������� oneof �����ĸ���Ա��ֵ��������
		message SampleMessage {
			oneof test_oneof {
				  string name = 4;
				  SubMessage sub_message = 9;
			  }
		}
	
	* oneof ���ֶο���ʹ���κ����͵��ֶΣ����ǲ�Ҫʹ�� repeated ���ظ��ֶΡ�

	

