-----------------------------
���ּ���					 |
-----------------------------
	List<T> findAll();
	List<T> findAll(Sort sort);

	List<T> findAllById(Iterable<ID> ids);
	T getOne(ID id);
	@Override
	<S extends T> List<S> findAll(Example<S> example);
	@Override
	<S extends T> List<S> findAll(Example<S> example, Sort sort);


	Iterable<T> findAll(Sort sort);
	Page<T> findAll(Pageable pageable);

	Optional<T> findById(ID id);
	boolean existsById(ID id);
	Iterable<T> findAll();
	Iterable<T> findAllById(Iterable<ID> ids);
	long count();


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
-----------------------------
��ҳ						 |
-----------------------------
	# ���(�ӿ�)
		Pageable
			|-PageRequest
		Page
	
	# PageRequest�ľ�̬����������ʵ��
		PageRequest of(int page, int size) 
		PageRequest of(int page, int size, Sort sort)
		PageRequest of(int page, int size, Direction direction, String... properties)
	
	# demo
		// ����һ����ҳ,������
		PageRequest.of(1,10);

		// ����һ����ҳ,����name��������
        PageRequest.of(1,10,Sort.by(Sort.Order.asc("name")));

		// ����һ����ҳ,����name,age,gender��������
        PageRequest.of(1,10, Sort.Direction.ASC,"name","age","gender");
	
	# ��ҳ��� Page(�ӿ�)
		int getNumber();
		int getNumberOfElements();
		int getSize();			 // ÿҳ��ʾ�ļ�¼��
		int getTotalPages();	 // ��ҳ��
		long getTotalElements(); // �ܼ�¼��
		<U> Page<U> map(Function<? super T, ? extends U> converter);	// ����ת���ӿ�
		List<T> getContent();	// ��ȡ������
		boolean hasContent();	// �Ƿ�������
		Sort getSort();			// ��ȡ�������
		boolean isFirst();		// �Ƿ��ǵ�һ��
		boolean isLast();		// �Ƿ������һ��
		boolean hasNext();		// �Ƿ�����һ��
		boolean hasPrevious();	// �Ƿ�����һ��
		
		* json�ṹ
			{
				"content": [],					//��ҳ������
				"pageable": {
					"sort": {
						"sorted": true,
						"unsorted": false,
						"empty": false
					},
					"offset": 10,
					"pageSize": 10,
					"pageNumber": 1,
					"paged": true,
					"unpaged": false
				},
				"totalPages": 1,
				"totalElements": 6,
				"last": true,
				"number": 1,
				"size": 10,
				"sort": {
					"sorted": true,
					"unsorted": false,
					"empty": false
				},
				"numberOfElements": 0,
				"first": false,
				"empty": true
			}

-----------------------------
����						 |
-----------------------------
	# �ӿ�
		Example
		ExampleMatcher

	# ��̬����
		<T> Example<T> of(T probe)
		<T> Example<T> of(T probe, ExampleMatcher matcher) 
	
