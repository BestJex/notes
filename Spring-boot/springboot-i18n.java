---------------------
i18n ���ʻ�			 |
---------------------
	# ���
		LocaleResolver
			AbstractLocaleResolver
				AbstractLocaleContextResolver
					FixedLocaleResolver
					SessionLocaleResolver
			LocaleContextResolver
				AbstractLocaleContextResolver
					FixedLocaleResolver(�̶���)
					SessionLocaleResolver(����session)
				CookieLocaleResolver(����cookie)
			AcceptHeaderLocaleResolver(����Header)


			LocaleChangeInterceptor(���ʻ���������)


---------------------
CookieLocaleResolver |
---------------------
	
---------------------
LocaleContextHolder	 |
---------------------
	# ��ǰ���Ի��������� ThreadLocal
	# �ṩ��һЩ��̬����
		Locale getLocale()
			* ��ȡ��ǰ������ Locale ����
		
	