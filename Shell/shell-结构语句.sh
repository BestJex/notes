---------------------
if then				 |
---------------------
	# �﷨
		if cmd 
		then
			cmds
		fi


		* cmd ��ʵ������һ�� bool���ʽ
		* �ϸ���˵,����һ��shell����
		* �������Ľ���״̬�������0,�ͻ�ִ�� cmds 
	
	# �������ŵ��﷨
		if cmd; then
			coms
		fi

		* ��cmd�����һ���ֺ�,�Ϳ��԰�thenд�ں�����
			if pwd > /dev/null;then
				echo "success"
			fi
	
---------------------
if then else		 |
---------------------
	# ����else�﷨
		if cmd; then
			coms
		else
			coms
		fi
	
	# ���elseif�﷨
		if cmd; then
			coms
		elif cmd; then
			coms
		else
			coms
		fi
	
	

	# С��ϰ
		testuser="kevinblandy"
		if grep ${testuser} /etc/passwd; then
			echo "�û� :${testuser} ��ϵͳ�д���"
		elif ls -d /home/${testuser}; then
			echo "�û� :${testuser} ��ϵͳ�в�����"
			echo "���Ǵ������ļ�Ŀ¼"
		else
			echo "�û������ڣ�Ҳû�����ļ�Ŀ¼"
		fi
	

---------------------
test				 |
---------------------
	# if then �����,����shell����ص�״̬����ȷ���Ƿ�Ҫִ�д����
	# ����if then�����ж�����״̬��֮�������,��ʱ����ʹ�� test ָ��
		if test condition;then
			cmds
		fi
		
		* condition ��һϵ�еĲ�����ֵ
	
	# ������� condition,��ô���ͻ��Է�0״̬�˳�,ִ��else��
		if test; then
			echo "success"
		else
			echo "error"	# ִ��
		fi
	
	# ���Ա����Ƿ�������
		var=" "
		test var	# false

		* ȫ�ǿհ��ַ�����ֵtest������Ϊfalse
	
	
	# �������ŵ�д��,ʹ��[]������ test ָ��
		if [ condition ]; then
			echo "success"
		else
			echo "error"
		fi

		* ע����,��һ��������֮��,�͵ڶ���������֮ǰ�������һ���ո�
	
	# test ��������ж���������
		* ��ֵ�ıȽ�
		* �ַ����ıȽ�
		* �ļ��ıȽ�

	
	# ������test������ʹ�ø�����

----------------------------
if-then �ĸ߼�����			|
----------------------------
	# ������ѧ���ʽ��˫����
		* ���ʽ
			(( expression ))
		
		* ����test�������ʹ�õ��������Ϊ,��(())���滹����ʹ�õ������
			val++				����
			varl--				���	
			++val				����
			--val				�ȼ�
			!					��
			~					λ��
			**					������
			<<					��λ��
			>>					��λ��
			&					λ����
			|					λ�ƻ�	
			&&					�߼���
			||					�߼���
	
		*  ˫�����е�><���㲻��Ҫת��
			val=10
			if (( $val ** 2 > 90 )); then
				(( val1=$val ** 2 ))	# ˫���Ÿ�ֵ
				echo "the square of ${val} is ${val1}"
			fi
		
		* ����������if�������˫��������,Ҳ�����ڽű�����ͨ������ʹ��˫��������ֵ
			val=10
			(( val1=$val ** 2 ))
			echo ${val1}
		
		* �������Ծ���,��������������ʹ�ø��ֱ��ʽ,�������е�shell��֧������˫����Ҫע��

	# ���ڸ߼��ַ��������ܵ�˫������
		* ���ʽ
			[[ expression ]]
		
		* expression ʹ�� test�����в��õı�׼�ַ����Ƚ�
		* ���ṩ����һ������:ģʽƥ��
			reg="r*"	# ������ʽ
			if [[ ${USER} == ${reg} ]] ; then
				echo "Hello ${user}"
			fi
		
		
		* �������Ծ��ǿ�����[[]]����ʹ��������ʽ
		* �������е�shell��֧��˫������


----------------------------
case						|
----------------------------
	