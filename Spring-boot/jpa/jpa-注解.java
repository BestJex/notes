--------------------
JPA��ע��			|
--------------------
	@EnableJpaRepositories
		String[] value() default {};
		String[] basePackages() default {};
		Class<?>[] basePackageClasses() default {};
		Filter[] includeFilters() default {};
		Filter[] excludeFilters() default {};
		String repositoryImplementationPostfix() default "Impl";
		String namedQueriesLocation() default "";
		Key queryLookupStrategy() default Key.CREATE_IF_NOT_FOUND;
			* �����Ĳ�ѯ����, ö��
				CREATE
					* ���ݷ������ƴ�����ѯ, ����������Ʋ����Ϲ���, ����ʱ����׳��쳣
				USE_DECLARED_QUERY,
					* ����ʽ����, ʹ�� @Query ע������JPQL����SQL
					* ���������ʱ��, ����û�������Ϸ��� @Query , ����׳��쳣
				CREATE_IF_NOT_FOUND
					* �ۺϷ�ʽ, @Query ����, û��query, �͸��ݷ������ƴ�������


		Class<?> repositoryFactoryBeanClass() default JpaRepositoryFactoryBean.class;
		Class<?> repositoryBaseClass() default DefaultRepositoryBaseClass.class;
		String entityManagerFactoryRef() default "entityManagerFactory";
		boolean considerNestedRepositories() default false;
		boolean enableDefaultTransactions() default true;
		BootstrapMode bootstrapMode() default BootstrapMode.DEFAULT;
		char escapeCharacter() default '\\';

	@EntityScan
	@NoRepositoryBean
		* ��ʶ�� Repository ��,��ʾ�ýӿڲ���һ��Repository
		* ����Ҫ���ɶ�̬�������

	@Modifying
		* ��ʶ�ڷ�����, ��ʾ�÷�����һ������/ɾ������

		boolean flushAutomatically() default false;
		boolean clearAutomatically() default false;
	
