-----------------------------
List
-----------------------------
	# ���ϵĳ�ʼ��
		var arr = [];				
		List arr = [1, 2, 3, '4'];	
		List arr = new List(2);  
			* ͨ������ָ��List�ĳ���, Ĭ��ʹ�� null ���
			* ��ʹ�ù��췽����ʼ����
	
		* �ڲ�ʹ�÷��͵������, һ��list�п��Դ洢��ͬ���͵�Ԫ��
	
	# List ��Ĺ��췽��
		// TODO

	# ����ĳ���
		* ͨ�� length ���Ի�ȡ��
		* ʹ������������ʽ��ʼ��, ���鳤�Ȼ�����Ԫ�ص�����������
			var arr = [];
			arr.add(1);
			arr.add(2);
			arr.add(3);
			print(arr);		// [1, 2, 3]
		
		* �̶��������length (ͨ�����췽��), ������ʹ�� add ����, ֻ��ͨ���±�ȥ����Ԫ��
			var arr = new List(1);
			arr.add(1);// Unsupported operation: Cannot add to a fixed-length list
			print(arr);
		
		* ������������±������Ԫ��, �ᷢ��Խ���쳣
			var arr = [];
			arr[0] = 1;  // RangeError (index): Invalid value: Valid value range is empty: 0
			print(arr);
			
	
	# ���͵� List
		* ���� list �Ķ������Ҫͨ������ List �������������, ����ʹ�� var ���� dynamic
			List<String> arr = ['123', '123']; // ok

			List<String> arr = new List(2);
			arr[0] = 1; // Error: A value of type 'int' can't be assigned to a variable of type 'String'.

		* �洢�������������, ���׳��쳣
		

-----------------------------
List - ʵ������
-----------------------------

-----------------------------
List - ��̬����
-----------------------------
