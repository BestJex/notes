-------------------
HttpServletMapping |
-------------------
	# ��̬�Ļ�ȡ·��
		* ͨ����⣬����Ϊ�˻�ȡͨ���ӳ���URI
		* restFull

	# �����ȡ
		HttpServletMapping httpServletMapping = request.getHttpServletMapping();

	# �ӿڷ���
		// ����ƥ�䵽��value��Ҳ����URI��ӳ��ֵ
		public String getMatchValue();
		
		// ���ش��������Servlet��pattern
		public String getPattern();
		
		// ����Servlet������
		public String getServletName();

		// ����ƥ��ģʽ
		public MappingMatch getMappingMatch();
	
	# MappingMatch ö��
		CONTEXT_ROOT
		DEFAULT

		EXACT
			* ��׼ƥ��

		EXTENSION
			* ��չ��ƥ��
				xx.do
		PATH
			* ·��ƥ��
				/*
