------------------------
����������				|
------------------------
	# �����������Ƕ�����
	# ������������ÿ���ڵ�ֵ 
		* ��Ҫ���������������нڵ�ֵ
		* ��ҪС�������������нڵ�ֵ
		* �����ظ�

	# �洢�����е�������Ҫ������
	
	# �������������Ԫ�صķǵݹ�д��,���������
		
	# �����ظ�Ԫ�ص���
		* ������С����ڽڵ�,�������������ڵ��ڽڵ�

	// ���ֵݹ飬add����֮ǰ��Ҫ�ж�root�ڵ��Ƿ�Ϊnull
	private void addRecursion(Node node, E value) {
		int result = node.value.compareTo(value);
		if (result < 0) {
			// ����
			if (node.left == null) {
				node.left = new Node(value);
			} else {
				this.addRecursion(node.left, value);
			}
		} else if (result > 0) {
			// ����
			if (node.right == null) {
				node.right = new Node(value);
			} else {
				this.addRecursion(node.right, value);
			}
		}
		// ���
		return;
	}