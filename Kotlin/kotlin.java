------------------------
Kotlin					|
------------------------
	# �����վ
		https://kotlinlang.org/
		https://www.kotlincn.net/

	
	# һ������
		* �ֲ������� js/py һ��
		* �⹹��ֵ,[]չ���� py һ��
		* raw �ַ���, ��pyһ��

------------------------
Kotlin	- ��;			|
------------------------

	# Ϊʲô�ڷ����ڲ���չ���Ի�����쳣, �����ڷ����ڲ���չ������û�¶�
		val String.lastChar get() = this[this.length - 1]; // �����ⲿ��չ����, ����
		fun main(){
			// val String.lastChar get() = this[this.length - 1]; // �����ڲ���չ����, �쳣
			println("123".lastChar)

			fun String.foo(value: String) = this + "_" + value // �����ڲ���չ����, ����
			println("123".foo("321"))
		}
	
