--------------------
JPA��ע��			|
--------------------
	@EnableJpaRepositories
	@EntityScan
	@NoRepositoryBean
		* ��ʶ�� Repository ��,��ʾ�ýӿڲ���һ��Repository
		* ����Ҫ���ɶ�̬�������

--------------------
Entityע��			|
--------------------
	@Entity
	@Table
	@Column
	@Id
	@GeneratedValue
		* ��ʶID�ֶ�,����ָ�������ɲ���
		* strategy ,ָ�����ɲ���
			GenerationType.TABLE		ʹ��һ���ض������ݿ��������������� 
			GenerationType.SEQUENCE		���ݵײ����ݿ����������������,���������ݿ�֧������
			GenerationType.IDENTITY		���������ݿ��Զ�����(��Ҫ���Զ������ͣ�)
			GenerationType.AUTO			�����ɳ������