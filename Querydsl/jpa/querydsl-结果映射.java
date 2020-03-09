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
		* ���Զ������������Ʒ�װ����, ����������Ʋ�����, ����ʹ�ñ���
			QUser.user.name.as("name")
		

		* ��������������, ʹ�� Projections.bean ��װ�����ֶ�, ����Ҫ��������Ҫ��������(����), ����ֱ��дһ��Q��ѯ����, ����û����ѯ������

			// ���Ǳ�
            QStar qStar = QStar.star;
            
            // ���ǹ�������Ƶ��
            QVideoStar qVideoStar = QVideoStar.videoStar;
            
            // �Ѳ����������ݷ�װΪ StartDTO ����
            QBean<StarDTO> qBean = Projections.bean(StarDTO.class, qStar.id, qStar.name, qStar);
			// QBean<StarDTO> qBean = Projections.bean(StarDTO.class, qStar);	����
            
            JPAQuery<Tuple> jpaQuery = jpaQueryFactory.select(qBean,
                        JPAExpressions.select(qVideoStar.starId.count()).from(qVideoStar).where(qVideoStar.starId.eq(qStar.id)))
                    .from(qStar);

            QueryResults<Tuple> queryResults = jpaQuery.fetchResults();
            List<StarDTO> stars = queryResults.getResults().stream().map(i -> {
            	
            	// ��ȡ���Ǽ�¼����
            	StarDTO starDTO = i.get(qBean);
            	
            	// ��ȡ�Ӳ�ѯͳ������
                starDTO.setVideoCount(i.get(1, Long.class).intValue());
                
                return starDTO;
            }).collect(Collectors.toList());

	

		
	
	# ��װ���Ϊ����
		List<Integer[]> result = queryFactory.select(Projections.array(Integer[].class, QUser.user.version, QUser.user.id))
				.from(QUser.user)
				.fetch();
		
		* �����ͬ���͵���, ��װΪ����
	




---------------------------
�Խ��������group
---------------------------
	# Ҳ���ǹ�������������ķ�װ

