----------------------
CrudRepository		  |
----------------------

public interface CrudRepository<T, ID> extends Repository<T, ID> {
	// ����ʵ��
	<S extends T> S save(S entity);
	// ��������
	<S extends T> Iterable<S> saveAll(Iterable<S> entities);
	/**
		* ��������id���д������
	**/

	// ����id����
	Optional<T> findById(ID id);

	// ����id�ж��Ƿ����
	boolean existsById(ID id);

	// ��������
	Iterable<T> findAll();
	// ���ݶ��id����
	Iterable<T> findAllById(Iterable<ID> ids);

	// �ܼ�¼����
	long count();


	// ����id ɾ��
	void deleteById(ID id);
	// ɾ��ָ����ʵ��(�����idɾ��)
	void delete(T entity);
	// ɾ������(�����idɾ��)
	void deleteAll(Iterable<? extends T> entities);
	/***
		* ִ��ɾ����ʱ��,���ȸ���ID������¼
		* �����¼������(���ִ�е���:deleteById,���׳��쳣 EmptyResultDataAccessException ),�Ȳ���,��ɾ��
		* �����¼�Ѿ�����,ֱ��ɾ��
	***/



	// ��ձ�
	void deleteAll();
}
----------------------
JpaRepository		  |
----------------------
	public interface JpaRepository<T, ID> extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T> {

		List<T> findAll();

		List<T> findAll(Sort sort);

		List<T> findAllById(Iterable<ID> ids);

		Iterable<T> findAll(Sort sort);

		Page<T> findAll(Pageable pageable);


		<S extends T> List<S> saveAll(Iterable<S> entities);

		void flush();

		<S extends T> S saveAndFlush(S entity);

		void deleteInBatch(Iterable<T> entities);

		void deleteAllInBatch();

		T getOne(ID id);

		@Override
		<S extends T> List<S> findAll(Example<S> example);
		@Override
		<S extends T> List<S> findAll(Example<S> example, Sort sort);

		<S extends T> Optional<S> findOne(Example<S> example);
		<S extends T> Page<S> findAll(Example<S> example, Pageable pageable);
		<S extends T> long count(Example<S> example);
		<S extends T> boolean exists(Example<S> example);
	}
