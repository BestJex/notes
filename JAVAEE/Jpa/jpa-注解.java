---------------------
annotation
---------------------
	# ע�����ڰ�: javax.persistence

---------------------
һ��ע��
---------------------
	@Entity
		* ��ʾ��, ��EntityManager����
		String name() default "";
			* ʵ�������, ��������JPQL����
			* Ĭ���ǵ�ǰ����

	@Table
		String name() default "";
			* ���ݱ������

		String catalog() default "";

		String schema() default "";

		UniqueConstraint[] uniqueConstraints() default {};

		Index[] indexes() default {};
			* ������������
			* Index ע�������
				String name				��������
				String columnList		��������
				boolean unique			�Ƿ�ΨһԼ��

	@Column
		String name() default "";
			* �ֶε�����, �������������һ��, ����ʡ��

		boolean unique() default false;

		boolean nullable() default true;
			* �Ƿ����Ϊnull

		boolean insertable() default true;

		boolean updatable() default true;

		String columnDefinition() default "";
			* �����������Լ�Լ���Լ�ע��, ����: 
				columnDefinition = "int(20) unsigned COMMENT 'id'"
				columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��'"

		String table() default "";

		int length() default 255;

		int precision() default 0;

		int scale() default 0;
	
	@TemporalType
		TemporalType value();
			* ָ�������ֶε���������
			* ö��ֵ
				DATE
				TIME
				TIMESTAMP

	@Id
	@GeneratedValue
		* ��ʶID�ֶ�,����ָ�������ɲ���
		* strategy ,ָ�����ɲ���
			GenerationType.TABLE		ʹ��һ���ض������ݿ��������������� 
			GenerationType.SEQUENCE		���ݵײ����ݿ����������������,���������ݿ�֧������
			GenerationType.IDENTITY		���������ݿ��Զ�����(��Ҫ���Զ������ͣ�)
			GenerationType.AUTO			�����ɳ������

	@Embeddable
		
	
	@Transient
		* ��ʾ���ֶβ������ݱ��ӳ���ֶ�

	@Version
		* ��ʶ�汾���ֶ�
	
	@NamedStoredProcedureQuery
		String name();
			* JPA�ж���Ĵ洢��������
		String procedureName();
			* ���ݿ�����Ĵ洢���̵�����
		StoredProcedureParameter[] parameters() default {};
			* �洢���̵�IN/OUT����
		Class[] resultClasses() default {}; 
		String[] resultSetMappings() default {};
		QueryHint[] hints() default {};

		* �洢���̵Ķ���, �����붨���� Entity ����

	@NamedQuery
		String name();
			* query������:ʵ��.����
		String query();
			* �����JPQL���
		LockModeType lockMode() default NONE;
		QueryHint[] hints() default {};

		* Ԥ�����ѯ, ������ʵ������
		* ����ͨ��	@NamedQueries ע��ͬʱ������
			NamedQuery [] value ();

	@NamedNativeQuery
		String name();
		String query();
		QueryHint[] hints() default {};
		Class resultClass() default void.class; 
		String resultSetMapping() default "";

		* ���� @NamedQuery һ��, ֻ��ʹ�õ��Ǳ���SQL
	
	@QueryHint
		 String name(); 
		 String value();

		 * query hint ����

---------------------
����������ص�ע��
---------------------
	@PrePersist
	@PostPersist

		* ��saveǰ������
	
	@PreUpdate
	@PostUpdate 
		* ���޸�ǰ�����
	
	@PreRemove 
	@PostRemove 
		* ��ɾ��ǰ�����

	@EntityListeners
		* ָ���ⲿ���ڵ�ʵ����
	
	@PostLoad
		* entity��ӳ��(find, load....)֮�����
	
