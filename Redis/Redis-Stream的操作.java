------------------------
Stream					|
------------------------
	# redis5��������, ������һ��MQϵͳ, Stream��Redis��������������ӵ�

	# ������ݵ�stream
		XADD [stream] MAXLEN [maxLen] [id] [key] [value] [key] [value]
			stream
				* ָ��stream����
			
			MAXLEN [maxLen]
				* ��ѡ�Ĳ���
				* stream�����洢����Ŀ, �Զ�����ɵ���Ŀ
					XADD mystream MAXLEN 2 * value 1
				* ����ʹ��һ���м����(~), ��ʾ���ٱ���n����Ŀ����(000����1010����1030)
				* ͨ��ʹ���������, �����Ƴ������ڵ��ʱ���ִ������, ��ʹ���������Ч
					XADD mystream MAXLEN ~ 1000 * value 1

			id
				* ָ����Ϣid, �����Ҫϵͳ����, ����ʹ��: * (������)
				* ������Զ���id, �����������, ��СIDΪ: 0-1, ����������ܵ��ڻ�С��ǰһ��ID��ID
			
			key, value
				* Stream��Ŀ���Ǽ򵥵��ַ���, ������һ��������ֵ����ɵ�
				* �����ж��key,value
			
			* demo
				XADD mystream * sensor-id 1234 temperature 19.8
				// ����Ϊmystream��Stream�������һ����Ŀsensor-id: 123, temperature: 19.8��ʹ�����Զ����ɵ���ĿID��Ҳ��������ص�ֵ
			
			* ���������Ϣ��id
				1574131352064-0

				* id��2�������, һ�����ǵ�ǰ��������ʱ���, һ���־�������(��ͬʱ���������)������id
				* ����ID��������Ŀ��ʱ�����, ��˿��Ժ����׵ذ�ʱ�䷶Χ���в�ѯ


	# ��ȡstream�е���Ŀ����
		XLEN [stream]


	# ��ѯ����
		 XRANGE [stream] [start] [end] COUNT [count]
			start, end
				* ��ʼʱ����ͽ���ʱ���(id��ǰһ����)
					XRANGE mystream 1518951480106 1518951480107
				* ��������ķ���:-,+ �ֱ��ʾ���ܵ���СID�����ID
			
			COUNT [count]
				* ���ص�����, �Ǳ������
					XRANGE mystream - + COUNT 1
			
			* ���ص�ÿ����Ŀ����������Ԫ�ص�����: ID�ͼ�ֵ���б�
				1) 1) "1574131352064-0" [0][0]
				   2) 1) "sensor-id"	[0][1]
					  2) "1234"
					  3) "temperature"
					  4) "19.8"
				2) 1) "1574132679725-0"	[1][0]
				   2) 1) "sensor-id"	[1][1]
					  2) "12345"
					  3) "temperature"
					  4) "19.81"
			
			* ͨ��ѡ�����һ����¼��id, ���е���
				XRANGE mystream 1574132679725-0 + COUNT 2
			
			* XRANGE�Ĳ��Ҹ��Ӷ���O(log(N)), ���O(M)����M��Ԫ��, ���������count��Сʱ, ���ж���ʱ�临�Ӷ�
			* ����ζ��ÿһ�������ٶȶ��ܿ�, ����XRANGEҲ����ʵ�ϵ������������Ҳ���ҪXSCAN����
	
	# �����ѯ����
		XREVRANGE [stream] [end] [start] COUNT [count]

		* ��XRANGE��ͬ, �������෴��˳�򷵻�Ԫ��
		* ���XREVRANGE��ʵ����;�Ǽ��һ��Stream�е����һ����ʲô
			XREVRANGE [stream] + - COUNT 1
	
	# ɾ������Ԫ��
		XDEL [stream] ID [ID ...]
			ID [ID ...]
				* Ҫɾ����id, �����Ƕ��
	
	# �޼�stream������
		XTRIM [stream] MAXLEN [maxLen]
			MAXLEN [maxLen]
				* ɾ��ָ��stream�е�����, ֻ���µ� maxLen ��
		

	# ��������
		XREAD COUNT [count] BLOCK [milliseconds] STREAMS [stream...] ID [id...]

			COUNT [count]
				* �Ǳ���Ĳ���
			
			BLOCK [milliseconds]
				* �Ǳ���Ĳ���
				* �����Ӹò���, ��ʾ��ǰ�ͻ�����������
				* �����Ǻ�����, ���Ϊ0, ��ʾ����ʱ
					
			STREAMS [stream...]
				* ָ��stream, �����ж��, �ո�ָ�
				* ע��, ����ж�� stream, �����Ҫ�ж�� id, һһ��Ӧ, ��ʾͬʱ�Ӳ�ͬ��Stream�ж�ȡ��ͬkey������
			
			ID [id...]
				* �Ǳ���Ĳ���
				* ָ�����ѵĴ��ڸ�id(��벿�ּ���)����Ϣ, �����ж��
					XREAD COUNT 2 STREAMS mystream 1574131352064-0
				
				* ע��, ����ж�� id, �� STREAMS ����ָ�����stream, һһ��Ӧ, ��ʾͬʱ�Ӳ�ͬ��Stream�ж�ȡ��ͬkey������
					STREAMS mystream otherstream 0 0
				
				* id������ֵ: $ , ��������ID��˼��XREADӦ��ʹ�����Ѿ��洢�����ID��Ϊ���һ��ID, �Ա����ǽ����մ����ǿ�ʼ����ʱ���Ժ������Ϣ
				* ����ĳ�̶ֳ���������Unix����tail -f(��������)
					XREAD BLOCK 0 STREAMS mystream $

				* ����һ���Լ���N��stream��n��id, ֻҪ����һ�����µ�����, �ͻ᷵��
					XREAD BLOCK 0 STREAMS mystream foo $ $
	
				
	# ����������
		XGROUP [CREATE key groupname id-or-$] [SETID key id-or-$] [DESTROY key groupname] [DELCONSUMER key groupname consumername]
		XGROUP CREATE [stream] [group] [id]
			[stream]
				* ָ��stream������
			
			[group]
				* ָ��group������
			
			[id]
				* ��ʾ�Ӵ���������Ϣ��ʼ����
				* �������Ϊ��0, ��ʾ��ͷ��ʼ����, ����Ϊ $ , ֻ�������������鴴���Ժ����Ϣ
			
			

			* ����һ��������(Ŀǰ����������, stream�������)
				 XGROUP CREATE mystream mygroup $
			
	
	
	# ���������ʽ��������
		XREADGROUP GROUP [group] [consumer] COUNT [count] BLOCK [milliseconds] STREAMS [stream...] ID [id...]
			GROUP [group]
				* ָ�������������
			
			consumer
				* ָ����������, ��ǰ�����ߵ�����
			
			ID [id...]
				* �������е�id, ��һ���������: >
				* ��������IDֻ���������������������Ч, ����˼��: ��ĿǰΪֹ��δ���ݸ����������ߵ���Ϣ
				* ���id����Ϊ��:> ��ʾ, �������ѵ�ǰ��������, ����������δ���ѵ���Ϣ, ͨ���������id,�ﵽ: ͬһ����������, ֻ��һ�����������������Ϣ


			* �� XREAD һ��, ����������: GROUP [group], consumer
			* һ����Ϣ, һ����ֻ�ܱ�ͬһ����������һ������������
		
	# �������е�������, ȷ����Ϣ����
		 XACK [stream] [greoup] ID [ID ...]
			[stream]
				* ָ��stream
			
			[greoup]
				* ָ��group
			
			ID [ID ...]
				* ָ�����id, ��ʾ�Ѿ�����
		
	

	# ��ȡָ����������, �����ѵ���Ϣ
		XPENDING [stream] [group] [start] [end] [count] [consumer]
		
		* �������ݵ���ϸ��Ϣ: 
			1) 1) 1526569498055-0			// ��Ϣid
			   2) "Bob"						// ����������
			   3) (integer) 74170458		// ���еĺ���ֵ
			   4) (integer) 1				// ��Ϣ�����ݵĴ���
			2) 1) 1526569506935-0
			   2) "Bob"
			   3) (integer) 74170458
			   4) (integer) 1
	
	# �ı���Ϣ��������
		XCLAIM [stream] [greoup] [consumer] [min-idle-time] [ID ...] [IDLE ms] [TIME ms-unix-time] [RETRYCOUNT count] [force] [justid]
			[stream] [greoup] [consumer]
				* �ֱ�ָ��stream, ������, �Լ��������е�������(Ҳ������Ϣ������)
			
			[justid]
				* ִ�гɹ������������Ϣ��id, ��������Ϣ������
	

	
	# stream�������Ϣ
		XINFO [CONSUMERS key groupname] [GROUPS key] [STREAM key] [HELP]
		
		* �鿴stream����Ϣ
			XINFO STREAM [stream]
				 1) "length"
				 2) (integer) 12
				 3) "radix-tree-keys"
				 4) (integer) 1
				 5) "radix-tree-nodes"
				 6) (integer) 2
				 7) "groups"
				 8) (integer) 1
				 9) "last-generated-id"
				10) "1574135225847-0"
				11) "first-entry"
				12) 1) "1574131352064-0"
					2) 1) "sensor-id"
					   2) "1234"
					   3) "temperature"
					   4) "19.8"
				13) "last-entry"
				14) 1) "1574135225847-0"
					2) 1) "name"
					   2) "KevinBlandy"
					   3) "age"
					   4) "23"574135225847-0"
		
		* �鿴stream���������Ϣ
			XINFO GROUPS [stream]
				1) 1) "name"
				   2) "group-1"
				   3) "consumers"
				   4) (integer) 1
				   5) "pending"
				   6) (integer) 6
				   7) "last-delivered-id"
				   8) "1574135225847-0"
		
		* �鿴stream�������������ߵ���Ϣ
			XINFO CONSUMERS [stream] [group]
				1) 1) "name"
				   2) "consumer-1"
				   3) "pending"
				   4) (integer) 6
				   5) "idle"
				   6) (integer) 2916753
		

		* ����
			XINFO HELP
				1) XINFO <subcommand> arg arg ... arg. Subcommands are:
				2) CONSUMERS <key> <groupname>  -- Show consumer groups of group <groupname>.
				3) GROUPS <key>                 -- Show the stream consumer groups.
				4) STREAM <key>                 -- Show information about the stream.
				5) HELP                         -- Print this help.
		
