--------------------------
Ԫģ��
--------------------------
	# ��Ҫ��������ʵ���������

	# �淶Ԫģ���������ȫ���� static �� public ��
	
	# ʵ����
		@Entity
		@Table
		public class Employee{  
			private int id;   
			private String name;
			private int age;
			@OneToMany
			private List<Address> addresses;
		}
	
	# ʵ�����Ԫģ��
		import javax.annotation.Generated;
		import javax.persistence.metamodel.SingularAttribute;
		import javax.persistence.metamodel.ListAttribute;
		import javax.persistence.metamodel.StaticMetamodel;

		@StaticMetamodel(Employee.class)
		public class EmployeeMetamodel {     
			public static volatile SingularAttribute<Employee, Integer> id;   
			public static volatile SingularAttribute<Employee, Integer> age;   
			public static volatile SingularAttribute<Employee, String> name;    
			public static volatile ListAttribute<Employee, Address> addresses;
		}
		
		SingularAttribute
			* ��ͨ������
		CollectionAttribute
		MapAttribute
		SetAttribute
		ListAttribute
			* һ�Զ�/��Զ�����
