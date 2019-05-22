--------------------------
jvm����					  |
--------------------------

--------------------------
jvm����	ͳ��			  |
--------------------------

-verbose:gc -Xms20m -Xmx20m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
-verbose:class -XX:+TraceClassLoading -XX:+TraceClassUnloading

-Xmn
-Xss
-Xms
-Xmx

-Xnoclassgc
-verbose:gc
-verbose:class

-XX:PermSize
-XX:MetaspaceSize
-XX:MaxPermSize
-XX:MaxMetaspaceSize
-XX:MaxDirectMemorySize
-XX:MinMetaspaceFreeRatio
-XX:MaxMetaspaceFreeRatio
-XX:ParallelGCThreads
	* ���� ParNew �ռ������ռ��߳�����

-XX:MaxGCPauseMillis
	* ����������ռ�ͣ��ʱ��, ����ֵ��һ������ 0 ������
	* �ռ����ڹ���ʱ, ����� Java �Ѵ�С��������һЩ����,�����ܵذ�ͣ��ʱ������� MaxGCPauseMillis ����
	* ͣ��ʱ�������, ��������������(��ǰ10sһ��100ms��GC, ����5sһ��70ms��GC)���������ռ�(�����С���ڴ��ռ��ȽϿ�)������, ��Ҳ����GC�����ø��ӵ�Ƶ��
	* ��С�Ļ�, GCͣ��ʱ��ȷʵ�½���,������������Ҳ�½���

-XX:GCTimeRatio
	* ������������С, ����ֵ��һ������ 0 С�� 100 ֮�������
	* �������Ϊ: �����ռ�ʱ��ռ��ʱ��ı���
	* Ĭ�� GCTimeRatio ��ֵΪ 99, ��ôϵͳ�����Ѳ����� 1 / (1 + 99) = 1% ��ʱ�����������ռ�

-XX:+HeapDumpOnOutOfMemoryError
-XX:+PrintGCDetails
-XX:+TraceClassLoading
-XX:+TraceClassUnLoading


-XX:SurvivorRatio
-XX:PretenureSizeThreshold
-XX:HandlePromotionFailure

-XX:+UseConMarkSweepGC
	* ʹ��Concurrent Mark Sweep(CMS)��Ϊ������ռ���
	* ���ʹ�øò���, Ĭ�Ͼͻ�ʹ��: ParNew ��Ϊ���������ռ���

-XX:+UseParNewGC
	* ǿ��ϵͳʹ�� ParNew ��Ϊ���������ռ���

-XX:+UseAdaptiveSizePolicy
	* ������Ӧ GC ����, ������ģʽ��, ������һЩ���Բ���Ҫ�Լ�ȥ����, �����ᱻ�Զ�����, �Դﵽ�ڶѴ�С, ��������ͣ��ʱ��֮���ƽ���
		-Xmn(��������С)
		-XX:+SuivivorRatio(Eden��Survivor���ı���)
		-XX:+PretenureSizeThreshold(�����������������)
	* ʹ������ӦGC����, ֻ��Ҫ�ѻ������ڴ��������ú�,������ڴ��Сֵ
	* Ȼ�������ע/�������ͣ��ʱ��:-XX:MaxGCPauseMillis 
	* ���߸�JVM����һ����������� -XX:GCTimeRatio ���Ż�Ŀ��, ����Ĺ���ϸ�ھ���jvm���
