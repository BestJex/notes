------------------------
���õĹؼ���			|
------------------------
	echo
		# ��ӡ���ֵ���Ļ 
		# ����
			-n
				* ��ĩβ����ӻ��з�
			-e
				* ����������е�ת���ַ���������ת���ַ���Ч��
	type
		* �û�����ĳ��ָ�������
			type echo
			echo is a shell builtin (echo ��shell���ýű�)

			type ls
			ls is /usr/bin/ls  (type �� /usr/bin Ŀ¼�µĳ���)
		
		* ����
			-a
				* �鿴��������ж���
					type -a echo (echo������������Ҳ�ж�Ӧ���ⲿ����)
					echo is a shell builtin
					echo is /usr/bin/echo
			-t
				* �������ݵ�����
					alias		����
					keyword		�ؼ���(����: type -t if)
					function	����
					builtin		��������
					file		�ļ�
				* ��������⼸������, �򲻻᷵���κζ���
			

	exec
		ִ����һ�� Shell �ű� 

	read
		����׼���� 
	
	source 
		* ִ����һ���ű�, ͨ���������¼���һ�������ļ���
		* �����ص����ڵ�ǰ Shell ִ�нű�, ����ֱ��ִ�нű�ʱ�����½�һ���� Shell
		* ����, source����ִ�нű�ʱ, ����Ҫexport����

		* ����ͨ���ⷽʽ���������ⲿ�ű��ı���, ����

		* ��д, ����ʹ��һ���㣨.������ʾ
			. .bashrc

	alias 
		* Ϊһ������ָ������
			alias search=grep # Ϊgrep������һ��search�ı�����

		* ��������Ϊ������ָ��һ�����̵ı���
			$ alias today='date +"%A, %B %-d, %Y"'
			$ today # Tuesday, June 23, 2020

		* Ϊ�˷�ֹ��ɾ���ļ�������ָ��rm����ı���
			alias rm='rm -i'
		* ���Խ��ܲ�����������ֱ�Ӵ���ԭʼ����
		* ֱ�ӵ���alias���������ʾ���б���
			alias
		
		* unalias������Խ������
			unalias lt
		
	expr
		�������ͱ��������������� 

	test
		���ڲ��Ա����Ƿ����,�Ƿ�Ϊ��,�ļ����͵� 

	exit
		�˳�
	
	sleep
		�߳���ͣN��
	