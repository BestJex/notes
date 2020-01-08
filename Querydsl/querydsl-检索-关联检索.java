-----------------------
��������
-----------------------
	# ����������
		queryFactory.selectFrom(QUser.user)		
			.innerJoin(QUser.user.userSeting)		// һ��һ
			.leftJoin(QUser.user.roles)				// ��Զ�
			.fetch();
		
		// SQL
		SELECT
			user0_.id AS id1_2_,
			user0_.NAME AS name2_2_,
			user0_.version AS version3_2_ 
		FROM
			USER user0_
			INNER JOIN user_seting userseting1_ ON user0_.id = userseting1_.id
			LEFT OUTER JOIN user_role roles2_ ON user0_.id = roles2_.user_id
			LEFT OUTER JOIN role role3_ ON roles2_.role_id = role3_.id
		

		* join��ʱ��, ���Զ���ӹ�����ϵ, ȥ���ѿ�����
		* ���Զ����ж϶�Զ��ϵ, �Զ���ȥ�����м��ȥ����

	
	# ����������, where ��������
		queryFactory.selectFrom(QUser.user)
			.innerJoin(QUser.user.userSeting)
			.leftJoin(QUser.user.addresses)
			.leftJoin(QUser.user.roles)
			.where(QUser.user.id.eq(1), QUser.user.roles.any().name.eq("role"))  // ���ݽ�ɫ���ƺ��û�id����
			.fetch();

			
		// SQL
		SELECT
			user0_.id AS id1_2_,
			user0_.NAME AS name2_2_,
			user0_.version AS version3_2_ 
		FROM
			USER user0_
			INNER JOIN user_seting userseting1_ ON user0_.id = userseting1_.id
			LEFT OUTER JOIN address addresses2_ ON user0_.id = addresses2_.user_id
			LEFT OUTER JOIN user_role roles3_ ON user0_.id = roles3_.user_id
			LEFT OUTER JOIN role role4_ ON roles3_.role_id = role4_.id 
		WHERE
			user0_.id =? 
		AND (
			EXISTS (
					SELECT
						1 
					FROM
						user_role roles5_,
						role role6_ 
					WHERE
						user0_.id = roles5_.user_id 
						AND roles5_.role_id = role6_.id 
						AND role6_.NAME =? 
				) 
			)
		
		* ��Զ���, ��һ������������, �Ǹ����Ӳ�ѯ����
	
	# ������ϼ���, join ��������
		queryFactory.selectFrom(QUser.user)
					.innerJoin(QUser.user.userSeting).on(QUser.user.userSeting.notify.eq(true)).on(QUser.user.userSeting.notify.eq(true))
					.leftJoin(QUser.user.addresses)
					.leftJoin(QUser.user.roles)
					.where(QUser.user.id.eq(1))
					.fetch();
		
		
		//SQL
		from
			user user0_ 
		inner join
			user_seting userseting1_  on user0_.id=userseting1_.id 	and (userseting1_.notify= ? and userseting1_.notify=?) 

		* join��ʱ��, ���˻��Զ���ӹ�����ϵ, ȥ���ѿ�����, �������һ������������
	
