---------------------
��������
---------------------
	@IdClass
		Class value();
		
		* ��ʶ��ʵ������. ָ��id�������ⲿ�������������(����������)
		* ��Ϊ�������������Ҫ�м�������
			1. ����ʵ�� Serializable
			2. ������ public �޲ι�����
			3. ���븲д hashCode equals ����(EntityMangerͨ��find����������Entityʱ,�Ǹ���equals�ķ���ֵ���жϵ�)
		
		// ʹ���û� user_id �� title ��Ϊ��������
		public class UserBlogKey implements Serializable {
			private Integer userId; 
			private String title;	
			// ���Թ��췽����getter/setter/equals/hashCode
		}

		@Entity
		@Table(name = "user_blog")
		@IdClass(value = UserBlogKey.class) // ָ������������
		public class UserBlog {
			// ָ���������������е��ֶ�����
			@Id
			@Column(name = "user_id", nullable = false)
			private Integer userId;
			// ָ���������������е��ֶ�����
			@Id
			@Column(name = "title", nullable = false)
			private String title;
			
			// �������ֶ�
			@Column(name = "name")
			private String name;  

			// ����getter/setter
		}

		CREATE TABLE `user_blog` (
		  `title` varchar(255) NOT NULL,
		  `user_id` int(11) NOT NULL,
		  `id` int(11) NOT NULL,
		  `name` varchar(255) DEFAULT NULL,
		  PRIMARY KEY (`title`,`user_id`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
		
		interface UserBlogRepository extends JpaRepository<UserBlog, UserBlogKey>