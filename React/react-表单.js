--------------------------
React ��
--------------------------
	# �ܿ����
		* ���� <input type="file" /> ����, ����������ܿ����
	
		* ��Ҫ�� value �󶨵������state/props
		* value���޸�, ��Ҫͨ���¼�����, ȥ�޸� state/props ���ﵽ
	
	# select ��ǩ
		* React ������ʹ�� selected ����, �����ڸ� select ��ǩ��ʹ�� value ����
		* ����Ƕ�ѡ��Ļ�, ����������
			<select multiple={true} value={['B', 'C']}>
	
	# ָ���� value, �������Կɱ༭
		* ����������ؽ� value ����Ϊ undefined �� null
			ReactDOM.render(<input value={null} />, mountNode);
	

