-------------------------
lambda					 |
-------------------------
	# �������﷨
		* ʹ�ô����Ű����������ʽ: {[�β�]:[����] -> ������ }

			var func = {x:Int -> x * x}
			println(func(5))

		* lambda���ʽ���Ա���ֵ��һ������, ���յ���һ��������ִ��(�������һ������)
	
		* lambda���ʽ,֧��ֱ�ӵ���,�е�����js���﷨: (function(){})()
			{ println("KevinBlandy") }()

			{ value:String -> println(value) }("KevinBlandy")
		
		* lambda ���������ڵ��д���, �����ж��д����
		* ���һ�д���Ľ��, ����lambda���ʽ�Ľ��
			 var func = {x:String -> {
				var x = 15
				println("Hello World")
				x
			}}
		

	# ��� lambda ���ʽ�Ǻ��������һ��ʵ��, ��ô����д����������
		rrayOf("").maxBy() { i:String -> i.length }

		* ���﷨�ֵֹ�


	# ��� lambda ���ʽ�Ǻ�����Ψһʵ��, ��ô�����Ŷ����Բ�Ҫ��
		arrayOf("").maxBy { i:String -> i.length }

	
	# ������������ǿ����Ƶ���, ��ô���������Ͷ��ǿ��Ժ��Ե�
		arrayOf("").maxBy { i:String -> i.length }
		arrayOf("").maxBy { i  -> i.length }

		* arraOf(""), ���ص���һ�� Array<String>, �����Ƶ�����, ���е��������Ͷ����ַ���, ������� lambda ����ʡ�Բ�������������
		* Ҳ�п����Ƶ���������������, ����һ������: �ȱ��Ƶ�, զ��զд, ���뱨����, �ٸ�(���Ͻ̵�)
	
	# ʹ��Ĭ�ϵĲ�������
		* ����Ǽ򻯵�����߼��ĵز���
		* ���lambdaֻ��һ������, ���ҿ����Ƶ�����������, ��ôʡ��lambda����������, ʹ��Ĭ�ϵı������ƴ���
		* ʹ��Ĭ�ϵĲ�������: it ����ʾ����������, it ����������ƴ�������

			arrayOf("").maxBy { it.length }
		
	
	# ���������з��ʱ���
		* ��Java��ͬ ,Kotlin�� lambda ���ʽ�������Է����ⲿ�� final ����, �����������޸�����

			fun foo(list:Collection<String>,prefix:String):Int{
				var count = 0
				list.forEach {
					println("$prefix$it")
					count ++  // ��lambda�޸�����ľֲ�����
				}
				return count
			}
			fun main(){
				var result = foo(arrayListOf("1","2","3"), "-")
				println(result)
			}

		* ��������һ���ⲿ�� final ����ʱ, ����ֵ�ᱻ��������, �� lambda ���ʽ�洢��һ��(JavaҲ�����ԭ��)

		* ��������һ���ⲿ�ķ� final ������ʱ��, ����ֵ�ᱻ��Ϊ Raf ʵ�������һ�����Ա�������, Raf �� final ���ε�, ���Ա����׵Ĳ�׽
		* Ȼ�� Raf �洢��ֵ, �Ϳ����� lambda ִ��ʱ�����޸�


-------------------------
��Ա����				 |
-------------------------
	# �� Javaһ��, ���԰�ĳЩ�Ѿ�����õķ���, ��Ϊһ�� lambda

	# ��Ա���õĴ���: [��]::[��Ա]
		var length = String::length
		arrayOf("").maxBy(length)

		arrayOf("").maxBy(String::length)
	
	# ���������õ����㺯��: ::[����]
		fun foo(){
			println("Hello")
		}
		fun main(){
			var f = ::foo // ��ȡ�����㺯��������
			run(f)
		}

		* ��Ϊû����, ���Բ���Ҫǰ���������
	

	# ���췽��������: ::[��]
		data class User(val name:String)

		// ��ȡ��ָ����Ĺ�������
		var userCreate = ::User
		fun main(){

			// ִ��
			var result = userCreate("12345")
			println(result) // User(name=12345)
		}

	
	# Kotlin 1.1 ��ǰ, ��Ҫ�ֶ���ָ�����к������õ�ʵ������
		* �е�������ڷ������˼, �һ�ȡ��ִ�к���, ���Ǹ����ĸ�����������ִ���������, ��Ҫ�ֶ���ָ��
			data class User(val name:String) {
				fun foo(value:String) {
					println("$name,$value")
				}
			}
			fun main(){
				// ��ȡָ����� foo, 
				var foo = User::foo
				// ִ�и����õ�ʱ��, ��һ������Ϊ�����õ������Ķ���(this)
				foo(User("KevinBlandy"),"Hello")
			}
		
		* ע������, �����������, ��ͨ��������ȡ����
	
	# Kotlin 1.1 �Ժ�, ֧�ִ�ʵ�������ȡ����������
		* ��ָ����ʵ����ȡ���ķ�������, ������������,���Կ���ֱ������, �������ֶ���ȥָ������ʱ�Ķ���

			data class User(val name:String) {
				fun foo(value:String) {
					println("$name,$value")
				}
			}
			fun main(){
				var user = User("KevinBlandy")
				// ��ȡָ������ķ�������
				var foo = user::foo
				foo("Hello")
			}

		* ע������, �����������, ��ͨ����������ȡ����




		

