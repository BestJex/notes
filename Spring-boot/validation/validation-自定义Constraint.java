--------------------------
�Զ���Constraint
--------------------------
	# ���õ�constraint������ʵ��ʹ����˵�Ǹ���������

	# ����һ��constraint��Ҫ�������֣�һ����constraintע�⣬һ����ִ��У���߼�����


	# ʵ�ֽӿ� ConstraintValidator<A extends Annotation, T> �����֤�߼�
		* ���� A ���Լ������У��ע��
		* T ��У��Ŀ�����������
			import javax.validation.ConstraintValidator;
			import javax.validation.ConstraintValidatorContext;
			public class TestConstraintValidator implements ConstraintValidator<TestConstraint, String> {

				@Override
				public boolean isValid(String value, ConstraintValidatorContext context) {
					return "Test".equals(value);
				}
			}

		

	# �Զ���ע��
		* ����������ʱ @Retention(RUNTIME)
		* ��ע���ϱ�ʶ @Constraint ע��, ����ָ�� ConstraintValidator �ӿڵ�ʵ����
			import static java.lang.annotation.ElementType.FIELD;
			import static java.lang.annotation.RetentionPolicy.RUNTIME;
			import java.lang.annotation.Retention;
			import java.lang.annotation.Target;
			import javax.validation.Constraint;
			import javax.validation.Payload;

			@Retention(RUNTIME)
			@Target(FIELD)
			@Constraint(validatedBy = { TestConstraintValidator.class }) // ָ����֤��ʵ����
			public @interface TestConstraint {
				
				// �����쳣ʱ����ʾ��Ϣ
				String message() default "�ֶ�ֵ����Test";

				// group
				Class<?>[] groups() default {};

				// payload
				Class<? extends Payload>[] payload() default {};
			}
		
		* @Constraint ��Ψһ���� validatedBy ��һ������
			Class<? extends ConstraintValidator<?, ?>>[] validatedBy();
		* ������ע����ҪУ�������������, ��ô��ʵ�ֶ�� ConstraintValidator �ӿ�, ����ͨ�� validatedBy ��ʶ


--------------------------
��� Constraint
--------------------------
