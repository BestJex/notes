------------------------
4�汾�İ�װ				|
------------------------
1,��������
	https://redis.io/
2,��ѹ
3,�����ѹĿ¼
4,ָ����װĿ¼,����,��װ
	make PREFIX=/usr/local/redis install
	* ע��:PREFIX�Ǵ�д
	* ����ָ��Ŀ¼������Ŀ¼
	bin
		redis-benchmark
		redis-check-aof
		redis-check-rdb
		redis-cli
		redis-sentinel -> redis-server
		redis-server
5,���������ļ���Ŀ¼
	��Դ�ļ�Ŀ¼�¸���
	redis.conf
	* cp ./redis.conf /usr/local/redis/conf/

6,����Ϊ����,���������ļ�
	��ԴĿ¼�¸����ļ��� /etc/ini.d Ŀ¼��,����Ϊredis
	cp ./utils/redis_init_script /etc/init.d/redis

7,�༭����
	vim /etc/init.d/redis

------------------------
5.x�汾�İ�װ			|
------------------------
	# ��װ��������
		yum install -y gcc

	# ׼��Ŀ¼
		mkdir /usr/local/redis
		mkdir /usr/local/redis/bin
		mkdir /usr/local/redis/conf

	# ����Դ��,��ѹ
		https://redis.io/

	# ����Ŀ¼ִ��
		make

	# ���Ƴ����ļ���Ŀ¼
		cd ./redis-5.0.3/src

		cp ./mkreleasehdr.sh /usr/local/redis/bin
		cp ./redis-benchmark /usr/local/redis/bin
		cp ./redis-check-aof /usr/local/redis/bin
		cp ./redis-check-rdb /usr/local/redis/bin
		cp ./redis-cli /usr/local/redis/bin
		cp ./redis-sentinel /usr/local/redis/bin
		cp ./redis-server /usr/local/redis/bin
		cp ./redis-trib.rb /usr/local/redis/bin
	
	# ���������ļ���Ŀ¼
		cp ./redis-5.0.3/redis.conf /usr/local/redis/conf

	
