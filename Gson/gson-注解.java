-------------------
Annotation
-------------------
	@Expose
		boolean serialize() default true;
		boolean deserialize() default true;
		
	* ��ʶ�ڶ����ֶ���
	* �Ƿ����л�, �����л����ֶ�
	* new Gson()��ʽ����Gson�� @Expose ��û���κ�Ч��,
	* ֻ�в���GsonBuilder����Gson���ҵ�����excludeFieldsWithoutExposeAnnotation
	* ��@Expose����Ӱ��toJson��fromGson���л��ͷ����л�����



	@SerializedName
		String value();
			* ���л������л�ʱ�ֶε�����

		String[] alternate() default {};
			* �����л�ʱ�ֶεı�������

	* �������ֶν���������,
	
	@Since
		double value();

	* �汾��ע��, ��ʶ����, �ֶ���
