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
	
	@QuerydslPredicate
		

--------------------
Entityע��			|
--------------------
	@Entity
	@Table
	@Column
	@Id
	@GeneratedValue
		* ��ʶID�ֶ�,����ָ�������ɲ���
		* strategy ,ָ�����ɲ���
			GenerationType.TABLE		ʹ��һ���ض������ݿ��������������� 
			GenerationType.SEQUENCE		���ݵײ����ݿ����������������,���������ݿ�֧������
			GenerationType.IDENTITY		���������ݿ��Զ�����(��Ҫ���Զ������ͣ�)
			GenerationType.AUTO			�����ɳ������