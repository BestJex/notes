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
		* һ��ָ����һ�����߶��Group����ôֻ����ִ�� validate ����ָ��ָ���� Group �Ż�ִ��У�飬���̳�û��ϵ
	
	# �Զ���Group
		* ��㶨����, ����νʵ�ֲ�ʵ�� Group �ӿ�

	# ������ע���ʱ��ָ��Group
		@NotNull(message = "ID����Ϊ��", groups = { UpdateGroup.class })
		public Integer id;
	
	# У���ʱ��ָ��Group
		validation.validate(user, UpdateGroup.class);