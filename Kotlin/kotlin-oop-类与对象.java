------------------------
��						|
------------------------
	# ��Ķ���
		class User(
			val name:String,
			val age:Int
		)

		* �﷨: class [������] (val [������]:[��������]);

		* ���Եķ���Ȩ��Ĭ��Ϊ: public
	
	
	# ���� getter/setter
		* �� js һ������,getter ��ֵ�Ǽ��������
			class User(){
				val name : String get(){
					return "KeviniBlandy";
				}
			}
			println(user.name);
		
		* �﷨: 
			val [��������] : [��������] get(){ 
				[�������]
				return [�����ķ���ֵ] 
			}
		
		* Ҳ����ʡ�� {} ,ʹ�ü򵥵ı��ʽ
			val old : Boolean get() = this.age > 25;

			val old get() = this.age > 25;

			* ͬ��,��������ʡ����������,�������ݱ��ʽ�ķ���ֵ�Զ��Ƶ�����������
	

------------------------
����					|
------------------------
	