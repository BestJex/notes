---------------------
�̳й�ϵ
---------------------
	@MappedSuperclass
		* ��ʶ��ʵ����ĸ���, ����JPAע��ļ̳�
		* һ�����ڳ�����, ��ȡ������ʵ���๫�õ��ֶ�
		* ʹ�ø�ע���ʶ����, ��������  @Entity ע���ʶ

	@AttributeOverride
		String name();
		Column column();
	
	@AssociationOverride
		String name();
		JoinColumn[] joinColumns() default {};
		ForeignKey foreignKey() default @ForeignKey(PROVIDER_DEFAULT);
		JoinTable joinTable() default @JoinTable;

---------------------
�̳в���
---------------------
	@Inheritance
		* ָ��ʵ��ļ̳в���
			InheritanceType strategy() default SINGLE_TABLE;
				SINGLE_TABLE			���м̳е�ʵ�嶼������ͬһ�����ݿ����
				TABLE_PER_CLASS			�м̳й�ϵ������ʵ���඼�������ڵ����ı���
				JOINED					ÿ��ʵ�����඼��������һ�������ı���
		
	
	* һ������ָ�� entity �� entity ֮��ļ̳й�ϵ
