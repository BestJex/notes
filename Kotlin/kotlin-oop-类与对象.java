------------------------
��						|
------------------------
	# �򵥵���Ķ���
		class User(
			val name:String,
			val age:Int
		)

		* �﷨: class [������] (val [������]:[��������]);

		* ���Եķ���Ȩ��Ĭ��Ϊ: public
	
	
	# ���� getter/setter
		* �� js һ������,getter ��ֵ�Ǽ��������
			class User {
				var name : String
					get() {
						return "����Ƕ�ȡ��name����"
					}
					set(value: String ){
						println("��������õ�name����:$name")
					}
			}
			println(user.name);
		
		* �﷨: 
			val [��������] : [��������] get(){ 
				[�������]
				return [�����ķ���ֵ] 
			}
		
		* ����������� getter, ��ô���Ե�����������: val
		* �����Ҫ���� setter, ��ô���Ե�����������: var 
		* Ҳ����ʡ�� {} ,ʹ�ü򵥵ı��ʽ
			val old : Boolean get() = this.age > 25;

			val old get() = this.age > 25;

			* ͬ��,��������ʡ����������,�������ݱ��ʽ�ķ���ֵ�Զ��Ƶ�����������
	

------------------------
����					|
------------------------
	