---------------------------------
���ݷ���������					 |
---------------------------------
	# ʹ��find��ͷ
	# �����ѯ��������ж����Ҫʹ�� List<T> ��Ϊ��������ֵ
		* ��Ȼ��������ֶ����ʱ����׳��쳣: IncorrectResultSizeDataAccessException, NonUniqueResultException
	


---------------------------------
Demo							 |
---------------------------------
	findByName(String name);

	findByNameLike(String name);
		* LIKE����, �ؼ�����Ҫ�Լ����ͨ���
			findByNameLike("%keywords%");

	findByNameAndId(String name, Integer id);

	findByIdBetween(Integer startId, Integer endId);
	findByIdLessThan(Integer id);
		* ���� id �ֶ�С�� id �ļ�¼

	findByIdIn(List<Integer> ids);

	findByCreateDateAfter(LocalDateTime createDate);
		* ���� create_date �ֶδ��� createDate  �ļ�¼
	