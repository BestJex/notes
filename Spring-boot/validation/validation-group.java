----------------------------------
Group
----------------------------------
	# ����ĸ���
		* ������groups��ʵ��:ͬһ��ģ���ڲ�ͬ�����£�(��̬����)У��ģ���еĲ�ͬ�ֶΡ�
	
	# ���е�У��ע�ⶼ��һ������
		Class<?>[] groups() default { };

		* ����ָ��һ�����߶��Group
	
	# Ĭ�ϵ� Group �ӿ�
		package javax.validation.groups
		public interface Default {
		}
		
		* ����һ����ǽӿڣ�Ĭ�ϵ�����£�У��ע��û������ group ���ԣ���ô��ע������������ default group ��
	
	# �Զ���Group
		* ��㶨����, ����νʵ�ֲ�ʵ�� Group �ӿ�

			����: @Validated(value = Create.class)

			1. Create �̳���Default����ô@Validated(value = Create.class)��У�鷶���Ϊ��Create���͡�Default��
			2. Create û�̳�Default����ô@Validated(value = Create.class)��У�鷶��ֻΪ��Create������@Validated(value = {Create.class, Default.class})��У�鷶���Ϊ��Create���͡�Default����
		

	
	# ������ע���ʱ��ָ��Group
		@NotNull(message = "ID����Ϊ��", groups = { UpdateGroup.class })
		public Integer id;
	
	# У���ʱ��ָ��Group
		validation.validate(user, UpdateGroup.class);