
# ��ص�������
	JpaProperties (spring.jpa)
	SpringDataWebProperties (spring.data.web)
	HibernateProperties	(spring.jpa.hibernate)

# SpringData��JPA���������
spring.data.jpa.repositories.bootstrap-mode=default
	* ö��
		DEFAULT(Ĭ��)
		DEFERRED
		LAZY
spring.data.jpa.repositories.enabled=true
	

# JPA������
spring.jpa.database=
spring.jpa.database-platform=
spring.jpa.generate-ddl=false
spring.jpa.open-in-view=false
spring.jpa.show-sql=false
spring.jpa.properties.*
spring.jpa.mapping-resources=

spring.jpa.hibernate.ddl-auto=
	* ö��
		create				���ܱ��Ƿ����, ÿ�������������½���(�ᵼ�����ݶ�ʧ)
		create-drop			������ʱ�򴴽���, �����˳�(SessionFactory�ر�)��ʱ��ɾ����
		none				�������κβ���
		update				������ݱ������򴴽�, ��ʵ������޸ĺ�,�´����������޸ı�ṹ(����ɾ���Ѿ����ڵ�����)
		validate			������ʱ����֤���ݱ�Ľṹ, 

spring.jpa.hibernate.naming.implicit-strategy=
spring.jpa.hibernate.naming.physical-strategy=
spring.jpa.hibernate.use-new-id-generator-mappings=

