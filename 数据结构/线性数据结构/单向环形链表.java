------------------------
����������			|
------------------------
	# ʵ��˼·
		* �ȴ�����һ���ڵ㣬��firstָ��ýڵ㣬�γɻ���
	
	# ������˼·
		
	# Լɪ������
		* ���ñ��Ϊ: 1, 2, 3...n����Χ����һȦ��
		* Լ�����Ϊk���˴�1��ʼ����������mλ�õ��˳���(1 <= k <= n)
		* m����һλ�ִ�1��ʼ����������m���Ǹ����ֳ���
		* �������ƣ�ֱ�����е��˶�����Ϊֹ���ɴ˲���һ�����ӱ�ŵ�����
	
	

------------------------
Python ʵ��				|
------------------------
	class Node(object):
		def __init__(self, value, next):
			self.value = value
			self.nex = next


	class Joseph(object):
		# ��ʼ��
		def __init__(self):
			self.first = None
			self.current = None

		# ��ӽڵ�
		def add(self, value):
			node = Node(value, None)
			if self.first is None:
				self.first = node
				self.first.next = self.first
				self.current = self.first
			else:
				self.current.next = node
				node.next = self.first
				self.current = node

		# �����ڵ�
		def forEach(self, handler):
			if self.first is None:
				return
			temp = self.first
			while True:
				handler(temp.value)
				# �������
				if temp.next == self.first:
					break
				temp = temp.next


	queue = Joseph()

	queue.add(1)
	queue.add(2)
	queue.add(3)
	queue.add(4)
	queue.add(5)
	queue.add(6)
	queue.add(7)


	queue.forEach(lambda x:print(x))





