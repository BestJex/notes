--------------------
JPA��ע��			|
--------------------
	@EnableJpaRepositories
	@EntityScan
	@NoRepositoryBean
		* ��ʶ�� Repository ��,��ʾ�ýӿڲ���һ��Repository
		* ����Ҫ���ɶ�̬�������

	@Modifying
		* ��ʶ�ڷ�����, ��ʾ�÷�����һ������/ɾ������

		boolean flushAutomatically() default false;
		boolean clearAutomatically() default false;