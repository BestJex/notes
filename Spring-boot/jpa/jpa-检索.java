-----------------------------
�����ķ�ʽ					 |
----------------------------
	# JPA���ӿڶ���ļ�������
	# ���������������
	# JPQL����
	# ����SQL����
	# Specification ��̬��ѯ

-----------------------------
JPA���ӿڶ���ļ�������		 |
----------------------------

    List<UserEntity> findAllById(Iterable<Integer> integers);
    Optional<UserEntity> findById(Integer integer);
	UserEntity getOne(Integer integer);
	
	Optional<UserEntity> findOne(Specification<UserEntity> spec);
    <S extends UserEntity> Optional<S> findOne(Example<S> example);

	List<UserEntity> findAll();
    List<UserEntity> findAll(Sort sort);
    Page<UserEntity> findAll(Pageable pageable);

	<S extends UserEntity> List<S> findAll(Example<S> example);
    <S extends UserEntity> List<S> findAll(Example<S> example, Sort sort);
    <S extends UserEntity> Page<S> findAll(Example<S> example, Pageable pageable);

    List<UserEntity> findAll(Specification<UserEntity> spec);
    Page<UserEntity> findAll(Specification<UserEntity> spec, Pageable pageable);
    List<UserEntity> findAll(Specification<UserEntity> spec, Sort sort);
	
	long count();
	<S extends UserEntity> long count(Example<S> example);
    long count(Specification<UserEntity> spec); 

	<S extends UserEntity> boolean exists(Example<S> example);
	boolean existsById(Integer integer);
    
	
	* �޷Ǿ���, ��ҳ, Specification��̬����, Example����, Sort ������ϲ�ѯ
	* findOne ����������, getOne ���ӳټ���


-----------------------------
����						 |
-----------------------------
	# ���
		Sort
			|-JpaSort
		Sort.Order
		Sort.Direction

		* һ��Sort�������N��� Order ����
	
	# Sort.Order
		Order(@Nullable Direction direction, String property)
		Order(@Nullable Direction direction, String property, NullHandling nullHandlingHint)
		
		direction
			* �������,ö��
				ASC
				DESC
		property
			* �����ֶ�����
		nullHandlingHint	
			* ���ڿ�ֵ��������,ö��
				NATIVE				��DB����
				NULLS_FIRST			������ǰ��
				NULLS_LAST			���������
	
	# demo
		// ����name��������
		Sort nameAes = Sort.by(new Sort.Order(Sort.Direction.ASC,"name"));

		// ����age����,createDate���� ����
        Sort ageDesccreateDateAes = Sort.by(Sort.Order.desc("age"),Sort.Order.asc("createDate"));

		// ����gender����,���gender�ֶ��ǿյ�,�����ڼ�¼����ǰ��
        Sort genderAes = Sort.by(new Sort.Order(Sort.Direction.ASC,"gender",Sort.NullHandling.NULLS_FIRST));

		// ������
		Sort unsorted = Sort.unsorted();
