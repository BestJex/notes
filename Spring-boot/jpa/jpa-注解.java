--------------------
JPA��ע��			|
--------------------
	@EnableJpaRepositories
	@EntityScan
	@NoRepositoryBean
		* ��ʶ�� Repository ��,��ʾ�ýӿڲ���һ��Repository
		* ����Ҫ���ɶ�̬�������

	@Query
		* ��ʶ��ĳ�� repository �ķ�����,���ڶ���HQL���
		* ������ INSERT,CREATE,UPDATE,DELETE ���

	@Modifying
		* �� @Query ���ʹ��
		* ��ʶ��ĳ�� repository �ķ�����,��ʾ��ǰ�� @Query ��һ��UPDATE ���
		* �÷������ص� int ֵ��ǩ�ܵ�Ӱ�������

	@NamedQuery
		* ��ʶ�� Entity ��
		* name	Sring���͵�����,����ָ��������,���� "User.findByName"
		* query	String���������,����HQL,���� "FROM User WHERE name = :name"
		* �ڸ� Entity �Ľӿ��ж���� findByName ����,����ͨ�� query ���Ե�HQL�����м�����
	

--------------------
Entityע��			|
--------------------
	@Entity
	@Table
		String name() default "";
		String catalog() default "";

		String schema() default "";

		UniqueConstraint[] uniqueConstraints() default {};

		Index[] indexes() default {};

	@Column
		String name() default "";

		boolean unique() default false;

		boolean nullable() default true;

		boolean insertable() default true;

		boolean updatable() default true;

		String columnDefinition() default "";

		String table() default "";

		int length() default 255;

		int precision() default 0;

		int scale() default 0;

	@Id
	@GeneratedValue
		* ��ʶID�ֶ�,����ָ�������ɲ���
		* strategy ,ָ�����ɲ���
			GenerationType.TABLE		ʹ��һ���ض������ݿ��������������� 
			GenerationType.SEQUENCE		���ݵײ����ݿ����������������,���������ݿ�֧������
			GenerationType.IDENTITY		���������ݿ��Զ�����(��Ҫ���Զ������ͣ�)
			GenerationType.AUTO			�����ɳ������