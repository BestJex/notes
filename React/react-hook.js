--------------------------------
Hook
--------------------------------
	# React 16.8 ���������ԡ������ڲ���д class �������ʹ�� state �Լ������� React ����
	
	# Hook ������ class �����ʹ�� 
		* ��ʹ�� class Ҳ��ʹ�� React�������Ƽ��������е����ȫ����д�����ǿ�����������￪ʼʹ�� Hook����

--------------------------------
State Hook
--------------------------------

	const [count, setCount] = React.useState(0); // [0, function(fiber, queue, action)){.....}]
		
	
	# ͨ��Ψһ�Ĳ���, ����һ����ʼ��ֵ, ��������������
	# useState �᷵��һ��ֵ: ��ʼֵһ���������ĺ���
	# ������һ������ж��ʹ�� State Hook
		* ��ε��� useState ��ʱ���ܱ�֤ÿ����Ⱦʱ���ǵĵ���˳���ǲ����


--------------------------------
Effect Hook
--------------------------------
	// �൱�� componentDidMount �� componentDidUpdate:
	React.useEffect(() => {
		// ʹ��������� API ����ҳ�����
		document.title = `You clicked ${count} times`;
	});

	
	# ���� class ����е� componentDidMount��componentDidUpdate �� componentWillUnmount ������ͬ����;��ֻ�������ϲ�����һ�� API