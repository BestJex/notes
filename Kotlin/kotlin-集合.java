-----------------
����			 | 
-----------------
	# �������ϵĺ���
		var list = listOf(1,2,3,4)								java.util.Arrays$ArrayList
			* Arrasys.asList()

		var list = arrayListOf(1,2,3,4);						ArrayList

		var set = hashSetOf(1,2,3,4);							HashSet
	
		<A,B> mapOf(pairs:Pair<A,B>)								

		var map = hashMapOf(1 to "1", 2 to "2", 3 to "3")		HashMap
			* ʹ�� to �ؼ���,��� key �� value��ӳ��
	
	# list/set ֧�ֵ�һЩ����(��չ����)
		last();
		min();
		max();
	
	
	# ������һЩ��غ���
		var pari = Pair(v1,v2)
			* ����һ�� pair ����,һ�����ڹ��� Map ��һ��ӳ��
			* ��������������(���Ƿ���)
				public val first: A
				public val second: B
			
			* �ö�����Ա��⹹��ֵ
				var (key, value) = Pair("name", "KevinBlandy")
				println("key=$key, value=$value")