--------------------------------
Hook
--------------------------------
	# React 16.8 ���������ԡ������ڲ���д class �������ʹ�� state �Լ������� React ����
	
	# Hook ������ class �����ʹ�� 
		* ��ʹ�� class Ҳ��ʹ�� React�������Ƽ������е����ȫ����д�����ǿ�����������￪ʼʹ�� Hook����

--------------------------------
State Hook
--------------------------------
	function App (props){
		const[count, setCount] = React.useState(0);  // [0, function(fiber, queue, action)){.....}]
		return (
			<div>
				<div>����ˣ� { count } �� </div>
				<button onClick={ () => setCount(count + 1) }>�����</button>
			</div>
		)
	}

	
	# ͨ��Ψһ�Ĳ���, ����һ����ʼ��ֵ, ��������������
	# useState �᷵��һ��ֵ: ��ʼֵһ���������ĺ���
	# ������һ������ж��ʹ�� State Hook
		* ��ε��� useState ��ʱ���ܱ�֤ÿ����Ⱦʱ���ǵĵ���˳���ǲ����

	#  state ֻ������״���Ⱦ��ʱ�򱻴���
		* ����һ��������Ⱦʱ��useState ���ظ����ǵ�ǰ�� state
	
	
	

--------------------------------
Effect Hook
--------------------------------
	
	function App (props){
		const[count, setCount] = React.useState(0);
		React.useEffect(() => {    // �൱�� componentDidMount �� componentDidUpdate:
			window.document.title = `����� ${count} ��`;
			return () => {
				console.log('�ҽ����������ж�ص�ʱ��ִ��');
			}
		});
		return (
			<div>
				<div>����ˣ� { count } �� </div>
				<button onClick={ () => setCount(count + 1) }>�����</button>
			</div>
		)
	}
	
	# ���� class ����е� componentDidMount��componentDidUpdate ������ͬ����;��ֻ�������ϲ�����һ�� API	
		* ���ڵ�һ����Ⱦ֮���ÿ�θ���֮�󶼻�ִ��
		* ÿ������ effect ��ͬʱ��DOM ���Ѿ�������ϡ�

		* �� componentDidMount �� componentDidUpdate ��ͬ��ʹ�� useEffect ���ȵ� effect �������������������Ļ������Ӧ�ÿ�������Ӧ����
		* ���������£�effect ����Ҫͬ����ִ�С��ڸ�������£�����������֣����е����� useLayoutEffect Hook ��ʹ�ã��� API �� useEffect ��ͬ��
	
	# ��� effect ����һ��������React ������ִ���������ʱ���������� componentWillUnmount ������ͬ����;
		* ���� effect ��ѡ��������ơ�ÿ�� effect �����Է���һ�����������
		*  React �������ж�ص�ʱ��ִ���������
			React.useEffect(() => {
				return () => {
					console.log('�ҽ����������ж�ص�ʱ��ִ��');
				}
			});
		
		* �������Ҫ����߼�����ô�Ͳ��÷����������
	





