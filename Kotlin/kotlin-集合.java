-----------------
����			 | 
-----------------
	# �������ϵĺ���
		var list = listOf(1,2,3,4)								java.util.Arrays$ArrayList
			* Arrasys.asList()

		var list = arrayListOf(1,2,3,4);						ArrayList

		var set = setOf()
			* Collections.singleton()							java.util.Collections$SingletonSet

		var set = hashSetOf(1,2,3,4);							HashSet
	
		<A,B> mapOf(pairs:Pair<A,B>)							LinkedHashMap
			

		var map = hashMapOf(1 to "1", 2 to "2", 3 to "3")		HashMap
	
	# list/set/map ֧�ֵ�һЩ����(��չ����)
		last();
		min();
		max();
	
		withIndex(): Iterable<IndexedValue<T>>
			* list ���ݽṹ��һ��api
			* ����һ��������, ��������������±��ֵ
				public data class IndexedValue<out T>(public val index: Int, public val value: T)
		
		filter()
			* ����, ���� true �Ľ��ᱻ����
				arrayListOf(1,2,3,4,5).filter {it % 2 == 0} // [2, 4]
			* ���ִ�ж����� map, ��ô��������һ��: entry
				mapOf("1" to "2").filter { it -> it.key == it.value }
				mapOf("1" to "2").filter { (k,v) -> k == v}
		
		filterValues()
		filterKeys()
			* map��key �� value ������
		
		mapValues()
		mapKeys()
			* map �ṹ�����Ѻ���
				mapOf("1" to "2").mapKeys { println("${it.key},${it.value}") }
				mapOf("1" to "2").mapValues { println("${it.key},${it.value}") }
		
		map()
			* һ�����Ѻ��� ,py/java����
				arrayListOf(1,2,3,4,5).map {it * 2} // [2, 4, 6, 8, 10]
			
		
		all()
		anly()
			* �жϺ���, ���� boolean
			* ������ж���������/�������κ�һ����������, ���� true
			

		find()
			* ����ƥ��ɹ��ĵ�һ��Ԫ��
				listOf(1,4,3,4).find {it % 2 ==0} // 4
		
		count()
			* ͳ�� ,��Ҳ֧�ֹ���, ���ط�������������
				listOf(1,2,3,4).count {it % 2 ==0} // 2
			
		groupBy()
			* �ۺ�,���صĽ����һ�� map<?,List<?>>, �� java ��streamһ��
			* �Ѵ�����һ�������ݷŵ�һ������,����Ľ����Ϊkey
				var result = listOf("a","bb","ccc","d","ee","fff").groupBy { it.length }
				println(result) // {1=[a, d], 2=[bb, ee], 3=[ccc, fff]}
		
		flatMap()
			* �ѽ���ϲ�Ϊһ����
			* �Ȱ�ÿ��Ԫ�����任, Ȼ���ٺϲ�Ϊһ����
				arrayOf(
				Book("Java���˼��", arrayListOf("Kevin","Litch")),
				Book("Python���˼��", arrayListOf("Ruby","xjp")),
				Book("Javascript���˼��", arrayListOf("Zy","Litch")),
				Book("C���˼��", arrayListOf("Kevin","Rocco")))

				.flatMap { it.authors }.forEach {println(it)} // �����е�������Ϣ, ����ϳ���һ����
		

		

		* ��Щ����֮�������ʽ����, �� Java8�� Stream һ��
	
	# ��Ϊ��Ч�� asSequence 
		* һ��������Ĵ���
			arrayOf("1","2").map { it.length }.filter { it >= 1 }

			* ִ�е� map ��ʱ��, �ᴴ��һ������
			* ִ�е� filer ��ʱ��, �ᴴ��һ������

			* ��������, ÿһ��ִ�ж��ᴴ���µ�����,�����������, ��ô����Ӱ������
		
		* �����Ȱ���Ҫ������Ԫ�����л�, ʹ�÷���: asSequence() ,������ռ����
			arrayOf("1","2").asSequence().map { it.length }.filter { it >= 1 }.toList()

			* ���м䲻�ᴴ���κεļ���, ֻ��������ռ���ʱ��Żᴴ��
			* ����͸�Java��Streamһ��һ����, ������û��ִ���ռ�����, ��ô�м��������Ҳ����ִ��
			
		
		* asSequence ���� Java �� .stream()
		* ����һ�����������չ����, ���ֶ���Ҳ����Ϊ������ֵ
	
	# ���� sequence
		* ֮ǰ�� sequence ����ͨ�����ϵ� asSequence ����ȡ,
		* Ҳ�����Լ�ȥ����, ������py��������
			var sequence = generateSequence(0) {it + 1}
			var result = sequence.takeWhile { it <= 100 }.sum()
			println(result) // 5050
			
			* generateSequence() ����һ����ʼԪ��, �Լ���Ԫ�صĲ���lamdba
		


	
	# ������һЩ��غ���
		var pari = Pair(v1,v2)
			* ����һ�� pair ����,һ�����ڹ��� Map ��һ��ӳ��
			* ��������������(���Ƿ���)
				public val first: A
				public val second: B
			
			* �ö�����Ա��⹹��ֵ
				var (key, value) = Pair("name", "KevinBlandy")
				println("key=$key, value=$value")