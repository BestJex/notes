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
		String name() default "";
			* �м�������

		String catalog() default "";
		String schema() default "";

		JoinColumn[] joinColumns() default {};
			* ��ǰ�������м���е������Ϣ
				@JoinColumn
					|-name					�м����, ��ǰ�����id�ֶ�����
					|-referencedColumnName	��ǰ�����id�ֶ�����


		JoinColumn[] inverseJoinColumns() default {};
			* �Է��������м���е������Ϣ
				@JoinColumn
					|-name					�м����, �Է������id�ֶ�����
					|-referencedColumnName	�Է������id�ֶ�����

		ForeignKey foreignKey() default @ForeignKey(PROVIDER_DEFAULT);
			@ForeignKey
				|-String name()
				|-ConstraintMode value() default CONSTRAINT;
					CONSTRAINT
					NO_CONSTRAINT
					PROVIDER_DEFAULT
				|-String foreignKeyDefinition() default "";

		ForeignKey inverseForeignKey() default @ForeignKey(PROVIDER_DEFAULT);

		UniqueConstraint[] uniqueConstraints() default {};
			@UniqueConstraint
				|-String name() default "";
				|-String[] columnNames();

		Index[] indexes() default {};
			@Index
				|-String name()
				|-String columnList();
				|-boolean unique() default false;
		
	@OrderBy
		String value() default "";
