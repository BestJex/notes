-------------------------
Ŀ¼����ṹ			 |
-------------------------
	# ��������,��javaһ��,����˵

	# �������
		* Kotlin �Ա�����ɶ�Ĺ���λ�� package,Ҳ����˵ kt �ļ���������ɶ,�Եò���ô��Ҫ
		* Kotlinһ�� kt �ļ�������ܶ�����N�����,����,��Ҫʹ��ʲô,�͵���ʲô

			package io.kevinblandy.funcs
			fun max(a:Int, b:Int) = if (a > b) a else b;

			import io.kevinblandy.funcs.max
			fun main(args:Array<String>){
				println(max(1,2));
			}

		*  ��ͬ package �µ����� kt �ļ���,�����ظ�������ͬ���Ƶı���,�����쳣

		* ����ʹ��: * ����������

		* ������ı����뵱ǰ�������ı������Ƴ�ͻ��ʱ��

			* �����ʹ�� * ����ı�����ͻ,��ǰ���ı������ȼ���,��֮,�� import �ı������ȼ���

				import io.kevinblandy.funcs.x;
				import io.kevinblandy.funcs.*;
				var x = "inner";
				var y = "inner";
				fun main(args:Array<String>){
					print("x=$x, y=$y")		// x=outer, y=inner
				}
			
		