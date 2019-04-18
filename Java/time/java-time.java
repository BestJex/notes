------------------------
java.time				|
------------------------
	# �µ�����API
	# ���ṹ
		java.time
			|-LocalDate				//��������
			|-LocalTime				//����ʱ��
			|-LocalDateTime			//��������ʱ��
			|-Instant				//ʱ���
			|-DayOfWeek
		java.time.chrono
		java.time.format
			|-DateTimeFormatter
			|-DateTimeFormatterBuilder
			|-DecimalStyle
		java.time.temporal
		java.time.zone
		

------------------------
java.time demos			|
------------------------

# ��ȡָ�����ڵ����/СLocalDateTime
	LocalDateTime dateTimeMin = LocalDateTime.of(LocalDate.now(),LocalTime.MIN);
	LocalDateTime dateTimeMax = LocalDateTime.of(LocalDate.now(),LocalTime.MAX);


# ʹ������ȥ�޸�ָ��������
	LocalDate.now().with(DayOfWeek.MONDAY)
	LocalDate.now().with(DayOfWeek.SUNDAY)




