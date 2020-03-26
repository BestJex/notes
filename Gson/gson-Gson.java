---------------------
Gson
---------------------
	# ���캯��
		public Gson() 
	
	# ʵ������
		Excluder excluder()
		FieldNamingStrategy fieldNamingStrategy()

		<T> T fromJson(JsonElement json, Class<T> classOfT)
		<T> T fromJson(JsonElement json, Type typeOfT)
		<T> T fromJson(JsonReader reader, Type typeOfT)
		<T> T fromJson(Reader json, Class<T> classOfT)
		<T> T fromJson(Reader json, Type typeOfT)
		<T> T fromJson(String json, Class<T> classOfT)
		<T> T fromJson(String json, Type typeOfT)

		<T> TypeAdapter<T> getAdapter(TypeToken<T> type)
		<T> TypeAdapter<T> getAdapter(Class<T> type)
		<T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory skipPast, TypeToken<T> type)
		boolean htmlSafe()
		GsonBuilder newBuilder()
		JsonReader newJsonReader(Reader reader)
		JsonWriter newJsonWriter(Writer writer)
		boolean serializeNulls()

		String toJson(JsonElement jsonElement)
		void toJson(JsonElement jsonElement, JsonWriter writer)
		void toJson(JsonElement jsonElement, Appendable writer)
		String toJson(Object src)
		void toJson(Object src, Appendable writer)
		String toJson(Object src, Type typeOfSrc)
		void toJson(Object src, Type typeOfSrc, JsonWriter writer)
		void toJson(Object src, Type typeOfSrc, Appendable writer)

		JsonElement toJsonTree(Object src)
		JsonElement toJsonTree(Object src, Type typeOfSrc)
			* ��ָ���Ķ���, ת��ΪjsonElement

		String toString()

---------------------
GsonBuilder
---------------------
	# Gson�Ĺ���Builder
	# ���캯��
		GsonBuilder()
	
	# ʵ������
		addDeserializationExclusionStrategy(ExclusionStrategy strategy)
		addSerializationExclusionStrategy(ExclusionStrategy strategy)
			* �������л�/�����л�ʱ�ֶ��ų��Ĳ���
			* �����л�/�����л�ʱ��Ҫĳ�ֶ�, Ҳ���Կ��Բ���@Expore����
			* ���󷽷�
				 boolean shouldSkipField(FieldAttributes f);
				 boolean shouldSkipClass(Class<?> clazz);
			
		GsonBuilder disableHtmlEscaping()
			* ��ֹhtml����
			* Ĭ�ϻ��html���б���

		disableInnerClassSerialization()
			* ���л�ʱ, �ų��ڲ���

		enableComplexMapKeySerialization()
		excludeFieldsWithModifiers(int... modifiers)
			* Ĭ�����л���ʱ��, �������:transient, static �ֶ�
			* ����Ҫ�������ֶ�, ͨ�� Modifier ����

		excludeFieldsWithoutExposeAnnotation()
			* ���û�б�ʶ @Expose(serialize = true, deserialize = true) , �򲻻���з����л������л�

		generateNonExecutableJson()
		registerTypeAdapter(Type type, Object typeAdapter)
			* Ϊָ��������, �������л�/�����л�����
			* typeAdapter��Ҫ ʵ�� JsonSerializer �� JsonDeserializer �ӿ�
				JsonSerializer
					public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context);
				JsonDeserializer
					public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)

		registerTypeAdapterFactory(TypeAdapterFactory factory)
		registerTypeHierarchyAdapter(Class<?> baseType, Object typeAdapter)
		serializeNulls()
			* ���л� null �ֶ�
			* Ĭ�ϲ������л� null �ֶ�

		serializeSpecialFloatingPointValues()
			
		setDateFormat(int style)
		setDateFormat(int dateStyle, int timeStyle)
		setDateFormat(String pattern)
			* �������ڵĸ�ʽ��

		setExclusionStrategies(ExclusionStrategy... strategies)
		setFieldNamingPolicy(FieldNamingPolicy namingConvention)
			* �����ֶ����ƵĲ���, ö��
				FieldNamingPolicy
					IDENTITY						�ֶ�������ɶ, ����ɶ
					UPPER_CAMEL_CASE				����ĸ��д
					UPPER_CAMEL_CASE_WITH_SPACES	����ĸ��д ���ո�ָ�
					LOWER_CASE_WITH_UNDERSCORES		������ĸСд �»��߷ָ�
					LOWER_CASE_WITH_DASHES			������ĸСд �л��߷ָ�
					LOWER_CASE_WITH_DOTS			�����ַ�Сд ��ָ�

		setFieldNamingStrategy(FieldNamingStrategy fieldNamingStrategy)
			* ����Gson�ֶν�������, �����ֶ� -> json�ֶ�����
			* FieldNamingStrategy �� �ӿ�, Ψһ���󷽷�
				String translateName(Field f);

		setLenient()
		setLongSerializationPolicy(LongSerializationPolicy serializationPolicy)
		setPrettyPrinting()
			* ���л���, ��ʽ��json�ַ���

		setVersion(double ignoreVersionsAfter)
			* ���ð汾��,
			* �ڶ���,�����ֶ��ϱ�ʶ�İ汾�� @Since(value), ֻ��С�ڵ������ֵ�ĲŻᱻ���л�

		create()


---------------------
JsonElement
---------------------
	# ������
	# ʵ������
		JsonElement deepCopy();
		boolean isJsonArray()
		boolean isJsonObject()
		boolean isJsonPrimitive()
		boolean isJsonNull()
		JsonObject getAsJsonObject()
		JsonArray getAsJsonArray()
		JsonPrimitive getAsJsonPrimitive()
		JsonNull getAsJsonNull()
		boolean getAsBoolean()
		Number getAsNumber()
		String getAsString()
		double getAsDouble()
		float getAsFloat()
		long getAsLong()
		int getAsInt()
		byte getAsByte()
		BigDecimal getAsBigDecimal()
		BigInteger getAsBigInteger()
		short getAsShort()
		String toString()
	
	# ʵ����
		JsonArray
		JsonNull
		JsonObject
		JsonPrimitive
		