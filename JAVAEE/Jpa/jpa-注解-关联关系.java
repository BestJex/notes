---------------------
������ϵ
---------------------
	@JoinColumn
		String name() default "";
			* ����е�����
		String referencedColumnName() default "";
			* ��ǰʵ����ֶ�, �Ǳ���, Ĭ�ϵ����id
		boolean unique() default false;
			* ����Ƿ�Ψһ
		boolean nullable() default true;
			* �Ƿ����Ϊnull
		boolean insertable() default true;
			* �Ƿ����һ������
		boolean updatable() default true;
			* �Ƿ����һ���޸�
		String columnDefinition() default "";
			* ��Լ��
		String table() default "";
		ForeignKey foreignKey() default @ForeignKey(PROVIDER_DEFAULT);

		* ��Ҫ��� @OneToOne,@OneToMany,@ManyToOne,@ManyToMany ʹ��, ��Ȼû����

	@JoinColumns
		JoinColumn[] value();
		ForeignKey foreignKey() default @ForeignKey(PROVIDER_DEFAULT);

		* ����ͬʱ������ @JoinColumn
	
	@JoinTable

	@OneToOne
		Class targetEntity() default void.class;
		CascadeType[] cascade() default {};
			* ������������, ö��
				ALL				�������в���
				PERSIST			��������
				MERGE			��������
				REMOVE			����ɾ��
				REFRESH			����ˢ��
				DETACH			��������
			* Ĭ��Ϊ��, ���������������
				
		FetchType fetch() default EAGER;
			* �������ݵĻ�ȡ��ʽ, ö��
				LAZY	�ӳټ���
				EAGER	��������

		boolean optional() default true;
			* �Ƿ�����Ϊ��

		String mappedBy() default "";
			* ������ϵ��˭ά��, һ�㲻����д���ֶ�
			* ������ָ����, ��һ����ʵ������ @JoinColumn ���� @JoinTable �������ֶ�����, ���������ݿ��ֶ�, Ҳ����ʵ����������
			* ֻ�й�ϵά�������ܲ������߹�ϵ, ��ά������ʹ������ά�������Խ��д洢Ҳ��������������
			* ���ܺ� @JoinColumn ���� @JoinTable ͬʱʹ��

		boolean orphanRemoval() default false;
			* �Ƿ���ɾ��, �� cascade = CascadeType.REMOVE Ч��һ��
			* ֻҪ�����������������е�����һ��, ���ᱻ����ɾ��
		
		* һ��һ��ӳ���ϵ, ����˫�����, Ҳ����ֻ����һ��

	
	@ManyToMany
	@OrderBy
