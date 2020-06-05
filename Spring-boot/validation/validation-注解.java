--------------------
ע��
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
	# ͨ�õ�����
		String message() default "{javax.validation.constraints....message}";
			* ����У��ʧ�ܵ�ʱ����ʾ��Ϣ

		Class<?>[] groups() default { };
			* ָ��Group

		Class<? extends Payload>[] payload() default { };
			* ��ȡ��Ϣ��
	
	@AssertTrue
	@AssertFalse
		* ����Ϊnull,�����Ϊnull�Ļ�����Ϊ true/false

	@DecimalMax
	@DecimalMin
		* ���ܳ������, ��Сֵ
		* ��������: BigDecimal, BigInteger, CharSequence, byte, short, int, long

		String value();
			* ����ֵ
		boolean inclusive() default true;
			* �Ƿ����ָ����ֵ
	
	@Max
	@Min
		* ��󲻵�С�ڴ���Сֵ
		* ��������: BigDecimal, BigInteger, byte, short, int, long

		long value();
			* ָ��ֵ

	@Digits
		* ���ñ���������������������λ����С����λ��������ָ����Χ��

		int integer();
			* �������

		int fraction();
			* ���С��λ
	@Email
		* �������ʼ�

		String regexp() default ".*";
			* Ĭ�ϵ��ʼ���֤���ʽ
		Pattern.Flag[] flags() default { };
			* ָ�������ѡ��

	@Future
	@Past
	@FutureOrPresent
	@PastOrPresent
		* ���ڱ����ڵ�ǰ���ڵ� ����/��ȥ/δ����������/��ȥ��������
		* ֧�ּ�������java������������صĶ���
	
	@Negative
	@NegativeOrZero
	@Positive
	@PositiveOrZero
		* ���ݱ�����: ����/������0/����/������0
		* ֧����������: BigDecimal, BigInteger, byte, short, int, long, float
	
	

	@NotNull
		* ����Ϊnull

	@Null
		* ����Ϊnull

	@Pattern
		* ��������ָ����������ʽ

		String regexp();
			* ָ������
		Flag[] flags() default { };
			* ָ�����ʽ��flag

	@Size
		* ���ϡ����顢map�ȵ�size()ֵ������ָ����Χ��

		int min() default 0;
			* ��С����
		int max() default Integer.MAX_VALUE;
			* ��󳤶�

	@NotBlank
		* �ַ�������Ϊnull,�ַ���trin()��Ҳ���ܵ���""

	@NotEmpty
		* ����Ϊnull�����ϡ����顢map��size()����Ϊ0���ַ���trin()����Ե��� ""


