-------------------
HttpServletMapping |
-------------------
	# �����ȡ
		HttpServletMapping httpServletMapping = request.getHttpServletMapping();
	# �ӿڷ���
		public String getMatchValue();

		public String getPattern();
		
		public String getServletName();

		public MappingMatch getMappingMatch();
	
	# MappingMatch ö��
		CONTEXT_ROOT
		DEFAULT
		EXACT
		EXTENSION
		PATH