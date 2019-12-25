----------------
JPQL����
----------------
	# Query
		String value() default "";
			* ִ�����, ������CREUD, �����Ǳ���SQL, JPQL

		String countQuery() default "";
			* ��ѯ�����������
			* �������һ�������� Pageable , ����ֵ��: Page<T>
				@Query(value = "SELECT * FROM USERS WHERE LASTNAME = ?1",
					countQuery = "SELECT count(*) FROM USERS WHERE LASTNAME = ?1",
					nativeQuery = true)
				Page<User> findByLastname(String lastname, Pageable pageable);

		String countProjection() default "";
		boolean nativeQuery() default false;
			* �Ƿ��Ǳ���SQL��ѯ

		String name() default "";
		String countName() default "";

		* ֧��ʹ��SPEL���ʽ��ȡĳЩ����
			@Entity
			class User

			@Query("select u from #{#entityName} u where u.lastname = ?1")
			List<User> findByLastname(String lastname);

			#{#entityName}	
				* ��ȡ��entityʵ�������, Ĭ����ʵ�����Ƶ�Сд
				* Ҳ������ @Entity(name = "user")��, ͨ��name��������
			
	
	
	# @Param
		* ͨ�����������İ� , ���Ժ��Բ�����λ��
			@Query(value = "select * from #{#entityName} where id > :id", nativeQuery = true)
			Page<UserEntity> testSelect (@Param("id")Integer id, Pageable pageable);

		* �����JDK8�б����˲�������, ����ʡ�Ը�ע��
	
	
	# @Modifying
		boolean flushAutomatically() default false;
		boolean clearAutomatically() default false;

		* �� @Query ���ʹ��
		* ��ʶ��ĳ�� repository �ķ�����,��ʾ��ǰ�� @Query ��һ��UPDATE ���
		* �÷������ص� int ֵ��ǩ�ܵ�Ӱ�������

	# @NamedQuery
		String name();
		String query();
		LockModeType lockMode() default NONE;
		QueryHint[] hints() default {};

		* ��ʶ�� Entity ��
		* name	Sring���͵�����,����ָ��������,���� "User.findByName"
		* query	String���������,����HQL,���� "FROM User WHERE name = :name"
		* �ڸ� Entity �Ľӿ��ж���� findByName ����,����ͨ�� query ���Ե�HQL�����м�����
	
	# @QueryHint
		 String name(); 
		 String value();
		

	# @QueryHints
		QueryHint[] value() default {};
		boolean forCounting() default true;