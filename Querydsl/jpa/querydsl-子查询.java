-------------------
�Ӳ�ѯ
-------------------
	# �����Ӳ�ѯ
		queryFactory.selectFrom(QUser.user)
				.where(QUser.user.id.eq(
					JPAExpressions.select(QUser.user.id).from(QUser.user).where(QUser.user.name.eq("KevinBlandy")))
				)
				.fetch();
		

	
	# ������Ӳ�ѯ
		//TODO
	
