# ע�����ڰ�: javax.persistence

@Entity
	* ��ʶ��ǰ����һ����DB�����ʵ����

@Table
	String name() default "";
		* ���ݱ������

	String catalog() default "";

	String schema() default "";

	UniqueConstraint[] uniqueConstraints() default {};

	Index[] indexes() default {};
		* ������������
		* Index ע�������
			String name				��������
			String columnList		��������
			boolean unique			�Ƿ�ΨһԼ��

@Column
	String name() default "";
		* �ֶε�����, �������������һ��, ����ʡ��

	boolean unique() default false;

	boolean nullable() default true;
		* �Ƿ����Ϊnull

	boolean insertable() default true;

	boolean updatable() default true;

	String columnDefinition() default "";
		* �����������Լ�Լ���Լ�ע��, ����: 
			columnDefinition = "int(20) unsigned COMMENT 'id'"
			columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��'"

	String table() default "";

	int length() default 255;

	int precision() default 0;

	int scale() default 0;

@Id
@GeneratedValue
	* ��ʶID�ֶ�,����ָ�������ɲ���
	* strategy ,ָ�����ɲ���
		GenerationType.TABLE		ʹ��һ���ض������ݿ��������������� 
		GenerationType.SEQUENCE		���ݵײ����ݿ����������������,���������ݿ�֧������
		GenerationType.IDENTITY		���������ݿ��Զ�����(��Ҫ���Զ������ͣ�)
		GenerationType.AUTO			�����ɳ������

@MappedSuperclass
	* ��ʶ��ʵ����ĸ���, ����JPAע��ļ̳С�

@Transient
	* ��ʾ���ֶβ������ݱ��ӳ���ֶ�
