----------------
JPQL����
----------------
	# �����İ�
		* ͨ��λ�ð�	WHERE id = ?1
		* ͨ�����ư�	WHERE id = :id
	
----------------
JPQL�����﷨
----------------
	# �﷨
		* �������Ƕ��� @Entity, ���Ǳ�, �������Ƕ�������, Ҳ�����ֶ�
		* Ĭ��Entity���������ƴ�д

		* ��֧��ʹ�� `` ����

	# ����
		FROM User u WHERE u.id = :id
	
	# LIKE
		FROM User u WHERE u.name LIKE %:name%
	
	# IN
		FROM User u WHERE u.id in :ids

		* ids��һ������
	
	# ORDER BY
		FROM User u WHERE u.id = :id ORDER BY id DESC
	
	
----------------
SPEL
----------------
	# ֧��ʹ��spel���ʽ���ж������Եĵ���
		@Query(value = "FROM user u WHERE u.id = :#{#user.id}")
		Page<UserEntity> testSelect (@Param("user")UserEntity userEntity, Pageable pageable);
	
	# ֧��ʹ��SPEL���ʽ��ȡĳЩ����ı���
		@Entity
		class User

		@Query("select u from #{#entityName} u where u.lastname = ?1")
		List<User> findByLastname(String lastname);

		#{#entityName}	
			* ��ȡ��entityʵ�������, Ĭ����ʵ�����Ƶ�Сд
			* Ҳ������ @Entity(name = "user")��, ͨ��name��������

----------------
JPQL����ע��
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
	
	# @Lock
		LockModeType value();

		* ����ģʽ
		* LockModeType ö��
			READ,
			WRITE,
			OPTIMISTIC,
			OPTIMISTIC_FORCE_INCREMENT,
			PESSIMISTIC_READ,
			PESSIMISTIC_WRITE,
			PESSIMISTIC_FORCE_INCREMENT,
			NONE

