--------------------
Լ��ע��
--------------------
	@Constraint
		Class<? extends ConstraintValidator<?, ?>>[] validatedBy();
	
	@Valid
	@ReportAsSingleViolation
	@OverridesAttribute
		Class<? extends Annotation> constraint();
		String name() default "";
		int constraintIndex() default -1;

--------------------
Լ��ע��
--------------------
	@AssertFalse
		* ����Ϊnull,�����Ϊnull�Ļ�����Ϊfalse
			String message() default "{javax.validation.constraints.AssertFalse.message}";
			Class<?>[] groups() default { };
			Class<? extends Payload>[] payload() default { };

			@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
			@Retention(RUNTIME)
			@Documented
			@interface List {

				AssertFalse[] value();
			}

	@AssertTrue
		* ����Ϊnull,�����Ϊnull�Ļ�����Ϊtrue

	@DecimalMax
		* ���ò��ܳ������ֵ

	@DecimalMin
		* ���ò��ܳ�����Сֵ

	@Digits
		* ���ñ���������������������λ����С����λ��������ָ����Χ��

	@Future
		* ���ڱ����ڵ�ǰ���ڵ�δ��

	@Past
		* ���ڱ����ڵ�ǰ���ڵĹ�ȥ

	@Max
		* ��󲻵ó��������ֵ

	@Min
		* ��󲻵�С�ڴ���Сֵ

	@NotNull
		* ����Ϊnull�������ǿ�

	@Null
		* ����Ϊnull

	@Pattern
		* ��������ָ����������ʽ

	@Size
		* ���ϡ����顢map�ȵ�size()ֵ������ָ����Χ��

	@Email
		* ������email��ʽ

	@Length
		* ���ȱ�����ָ����Χ��

	@NotBlank
		* �ַ�������Ϊnull,�ַ���trin()��Ҳ���ܵ��ڡ���

	@NotEmpty
		* ����Ϊnull�����ϡ����顢map��size()����Ϊ0���ַ���trin()����Ե��� ""

	@Range
		* ֵ������ָ����Χ��

	@URL
		* ������һ��URL
