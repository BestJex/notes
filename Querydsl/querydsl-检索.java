--------------------
����������			|
--------------------
	# �����ĸ����ֶμ���
		UserEntity userEntity = jpaQueryFactory
			.from(qUserEntity)
			.where(qUserEntity.name.eq("Hello"))
			.fetchOne();


	# and����
		UserEntity userEntity = (UserEntity) jpaQueryFactory
			.from(qUserEntity)
			.where(qUserEntity.name.eq("Hello").and(qUserEntity.id.eq(1)))
			.fetchOne();
		
		* where �������������ж��, ��ʾ and ��ϵ
			.where(qUserEntity.name.eq("Hello"), qUserEntity.id.eq(1)) // ͬ��

	# or����
		UserEntity userEntity = (UserEntity) jpaQueryFactory
			.from(qUserEntity)
			.where(qUserEntity.name.eq("Hello").or(qUserEntity.id.eq(1)))
			.fetchOne();


--------------------
���Ӳ�ѯ			|
--------------------
	
	