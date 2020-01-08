---------------------------
ͨ�õĽ����
---------------------------
	# Tuple ����ֵ��Ϊͨ�õĽ����
	
	# ͬʱ������������¼
		List<Tuple> tuples = queryFactory.select(QUser.user, QAddress.address)
			.innerJoin(QAddress.address).on(QUser.user.id.eq(QAddress.address.user.id))
			.fetch();
		
		* ��ʱ, Tuple ת��Ϊ�����������[User, Address]
	


---------------------------
���ӽ��ӳ��Ϊ�Զ������
---------------------------
	# ͨ�����캯����װΪ�Զ���Ķ���

		List<UserModel> userModels = queryFactory.select(Projections.constructor(UserModel.class, QUser.user.id, QUser.user.name))
					.from(QUser.user)
					.fetch();
			
		
		* ����ֻ�����ָ�����ֶ�, �������Ҫ�ж�Ӧ�Ĺ��캯��
	


		<T> ConstructorExpression<T> constructor(Class<? extends T> type, Expression<?>... exprs)
		<T> ConstructorExpression<T> constructor(Class<? extends T> type, Class<?>[] paramTypes, Expression<?>... exprs)
		<T> ConstructorExpression<T> constructor(Class<? extends T> type, Class<?>[] paramTypes, ImmutableList<Expression<?>> exprs)

		type
			* �Զ������
		paramTypes
			* ���캯��������
		exprs
			* ʵ�������
		
	# ͨ�����Է�װΪ�Զ������
		List<UserModel> list = queryFactory.select(Projections.bean(UserModel.class, QUser.user.name))
					.from(QUser.user)
					.fetch()
		

		* ����ֻ�����ָ�����ֶ�, �������Ҫ�пյĹ��캯��
		* ���Զ������������Ʒ�װ����
	

		
	
	# ��װ���Ϊ����
		List<Integer[]> result = queryFactory.select(Projections.array(Integer[].class, QUser.user.version, QUser.user.id))
				.from(QUser.user)
				.fetch();
		
		* �����ͬ���͵���, ��װΪ����
	
	