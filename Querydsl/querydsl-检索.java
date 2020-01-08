--------------------
����������			|
--------------------
	# ���ݵ�����������
		User user = queryFactory.selectFrom(QUser.user).where(QUser.user.id.eq(1)).fetchFirst();
		json(user);
	
	# ���ݶ����������
		BooleanExpression expression1 = QUser.user.name.eq("KevinBlandy");
		BooleanExpression expression2 = QUser.user.version.lt(1);

		BooleanExpression expression3 = QUser.user.id.eq(1);
		
		queryFactory.selectFrom(QUser.user).where(expression1.or(expression2), expression3).fetchFirst();

		// ���ɵ�����SQL
		where (user0_.name=? or user0_.version<? ) and user0_.id=?

		* Ĭ�� where �еĶ��������ϵ��Ϊ and
	


--------------------
��ҳ
--------------------
	# ��ҳ����
		QueryResults<User> results = queryFactory.selectFrom(QUser.user)
						.offset(1)
						.limit(2)
						.fetchResults();
		
		offset(1)	����ҳ��, ��0��ʼ
		limit(10)	����ÿҳ��ʾ��¼��

		* ֻҪ��ʹ���� fetchResults(), �ͻ������������ͳ�Ʋ�ѯ
	
	# ����� QueryResults, ����������
		private final long limit, offset, total;
		private final List<T> results;
	
	
	# ����countͳ��
		Long count = queryFactory.selectFrom(QUser.user)
				.offset(2)
				.limit(1)
				.fetchCount();
	
	# ������ҳ, ��ͳ�Ƽ���
		List<User> results = queryFactory.selectFrom(QUser.user)
				.offset(2)
				.limit(1)
				.fetch();

--------------------
����
--------------------
	# ͨ�� OrderSpecifier ����
		List<User> results = queryFactory.selectFrom(QUser.user)
					.orderBy(new OrderSpecifier(Order.DESC, QUser.user.name),
							new OrderSpecifier(Order.DESC, QUser.user.id, OrderSpecifier.NullHandling.NullsFirst))
					.fetch();
	
	# OrderSpecifier ���캯��
		OrderSpecifier(Order order, Expression<T> target, NullHandling nullhandling)
		OrderSpecifier(Order order, Expression<T> target)
			order 
				* ����ʽ, ö��
					ASC
					DESC
			
			target
				* �����ֶ�, ���������
			
			nullhandling
				* nullֵ�Ĵ���, ö��
					Default			Ĭ��
					NullsFirst		null��¼����ǰ��
					NullsLast		null��¼���ں���
		
	# ͨ��������������
		List<User> results = queryFactory.selectFrom(QUser.user)
			.orderBy(QUser.user.name.asc(),
					QUser.user.id.desc())
			.fetch();
		
		* ���ܶ� null ֵ���д���
	

--------------------
����
--------------------
	# ����
		queryFactory.selectFrom(QUser.user).where()
			.setLockMode(LockModeType.PESSIMISTIC_WRITE)
			.fetchResults();
		

		LockModeType ö��
			READ
			WRITE
			OPTIMISTIC
			OPTIMISTIC_FORCE_INCREMENT
			PESSIMISTIC_READ
			PESSIMISTIC_WRITE
			PESSIMISTIC_FORCE_INCREMENT
			NONE

--------------------
����JPA��ѯ
--------------------
	Query query = queryFactory.select(QUser.user).createQuery();

--------------------
����
--------------------
	//TODO

	SELECT 'CONST MNAME' AS `name` ...

