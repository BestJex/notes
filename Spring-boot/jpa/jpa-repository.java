----------------------
Repository			  |
----------------------
	# ���ĵ� Repository
		Repository		// ��ʶ�ӿڣ�spring�����
			|-CrudRepository // ������CRUD
				|PagingAndSortingRepository // ����ͷ�ҳ��ѯ
			|-QueryByExampleExecutor // ���Ը���Example������ѯ
					|-JpaRepository  // �̳з�ҳ,����,crud�Ľӿ�
		JpaSpecificationExecutor
	
----------------------
CrudRepository		  |
----------------------

public interface CrudRepository<T, ID> extends Repository<T, ID> {
	<S extends T> S save(S entity);
		* ������޸�, ����ʹ�� sava ����
		* ������ǿ�ʵ��entity�Ƿ�������, �����Ǹ���, �����Ǵ���

	<S extends T> Iterable<S> saveAll(Iterable<S> entities);
		* �־û�, ���������id, id��ֵ���д��������

	Optional<T> findById(ID id);
		* ����ID����

	boolean existsById(ID id);
		* ����ID�ж��Ƿ����

	Iterable<T> findAll();
	Iterable<T> findAllById(Iterable<ID> ids);
		* �������л��߸���ID����һ����¼

	long count();
		* ��ȡ��¼��������


	void deleteById(ID id);
	void delete(T entity);
	void deleteAll(Iterable<? extends T> entities);
	
		* ִ��ɾ����ʱ��,���ȸ���ID������¼
		* �����¼������(���ִ�е���:deleteById,���׳��쳣 EmptyResultDataAccessException ),�Ȳ���,��ɾ��
		* �����¼�Ѿ�����,ֱ��ɾ��, ɾ���������Ǹ���ID��ɾ��


	void deleteAll();
		* ֱ��ɾ����
	
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
