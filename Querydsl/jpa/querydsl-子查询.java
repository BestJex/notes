-------------------
�Ӳ�ѯ
-------------------
	# �����Ӳ�ѯ
		queryFactory.selectFrom(QUser.user)
				.where(QUser.user.id.eq(
					JPAExpressions.select(QUser.user.id).from(QUser.user).where(QUser.user.name.eq("KevinBlandy")))
				)
				.fetch();
		
		* ����, ���е��м���

		QUser qUser = QUser.user;
		queryFactory.select(qUser)
				.from(qUser)
				.where(JPAExpressions.selectOne().from(QUserRole.userRole)
					.where(QUserRole.userRole.userId.eq(qUser.id).and(QUserRole.userRole.roleId.eq(1)))
					.exists()
				)
				.fetch();
			
		* ����, exists����
		
		QCategory qCategory = QCategory.category;
		QVideoCategory qVideoCategory = QVideoCategory.videoCategory;

		NumberExpression<Long> numberExpression = qVideoCategory.categoryId.count();
		
		QBean<CategoryDTO> categoryQBean = Projections.bean(CategoryDTO.class, 
				qCategory.id, qCategory.title, qCategory.poster, qCategory.describe, qCategory.sorted, qCategory.createdDate);
		
		
		JPAQuery<Tuple> jpaQuery = query.select(categoryQBean, 
				JPAExpressions.select(numberExpression)
					.from(qVideoCategory)
					.where(qVideoCategory.categoryId.eq(qCategory.id)))
				.from(qCategory);
		
		* ����, count����

	# ������Ӳ�ѯ
		//TODO
	
