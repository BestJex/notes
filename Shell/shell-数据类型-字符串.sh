-----------------
���������ַ���	 |
-----------------
	# �ַ�����shell�������������õ���������(�������ֺ��ַ���,Ҳûɶ�������ͺ�����)
	# �ַ��������õ�����,Ҳ������˫����,Ҳ���Բ�������,��˫���ŵ������PHP����

	# ������
		str='this is a string'

		* ����������κ��ַ�����ԭ�����,�������ַ����еı�������Ч��
			name="KevinBlandy"
			echo 'Hello ${name}'	-> Hello ${name}
			
		* �������ִ��в��ܳ��ֵ���һ���ĵ�����(�Ե�����ʹ��ת�����Ҳ����)
				str='hello, \'' -> unexpected EOF while looking for matching `''

		* �����ſɳɶԳ���,��Ϊ�ַ���ƴ��ʹ��
			name='v'
			str='hello, '$name' !'	-> hello, v !
	
	# ˫����
		your_name='vin'
		str="Hello, I know you are \"$your_name\"! \n"
		echo -e $str
	
	# �ַ�����ƴ��
		name="vin"

		greeting="hello, "$name" !"		-> hello, vin !
		greeting_1="hello, ${name} !"	-> hello, vin !

		greeting_2='hello, '$name' !'	-> hello, vin !
		greeting_3='hello, ${name} !'	-> hello, ${name} !
	
	#  ��ȡ�ַ����ĳ���
		#!/bin/bash
		name="KevinBlandy"
		echo ${#name}			-> 11

		S="KevinBlandy"
		echo "${S} size = ${#S}"	-> 11
	
	# ��ȡ���ַ���
		string="KevinBlandy"
		echo ${string:1:4} -> evin

		* ${:x:y} ,x��ʾ��ʼ�ĽǱ�,y��ʾȡ���ٸ��ַ�
	
	# �������ַ����Ǳ�
		#!/bin/bash
		NAME="KevinBlandy"
		S="B"
		index=`expr index ${NAME} ${S}`
		echo "${index}"	# -> 6

		* ���صĿ�ʼλ���Ǵ�1��ʼ�����
		* ����Ҳ�������0
		* ʵ����ʹ�õ���shell����
			expr index "KevinBlandy" "B" 



