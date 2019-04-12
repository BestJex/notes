---------------------
jpa					 |
---------------------
	# �ο�
		https://ityouknow.gitbooks.io/spring-data-jpa-reference-documentation/content/
		https://docs.spring.io/spring-data/jpa/docs/current-SNAPSHOT/reference/html/#reference
	
	# Maven
		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
	
	# ʹ��
		1,�Զ���ӿڼ̳�:Repository
			public interface UserRepository extends JpaRepository<UserDTO,Integer> {}

		2,����ɨ��Repository��Entity
			@EnableJpaRepositories(basePackages = {"io.springboot.jpa.repository"})
			@EntityScan(basePackages = {"io.springboot.jpa.dto"})

		4,Entit���ע��
			@Entity
			@Table(name = "user")
			@Id
			@Column

		5,����Ҫ�ĵط�ע��
			@Autowired
			private UserRepository userRepository;
			
		
	# ���ĵ� Repository
		Repository
			|-CrudRepository
				|PagingAndSortingRepository
			|-QueryByExampleExecutor
					|-JpaRepository

