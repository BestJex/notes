-verbose:gc -Xms20m -Xmx20m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
-verbose:class -XX:+TraceClassLoading -XX:+TraceClassUnloading
-verbose:class -XX:+TraceClassLoading -XX:+TraceClassUnloading

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

