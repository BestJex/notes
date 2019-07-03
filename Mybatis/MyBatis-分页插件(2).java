-----------------------
MyBatis-��ҳ���		|
-----------------------
	# maven
		<dependency>
			<groupId>com.github.pagehelper</groupId>
			<artifactId>pagehelper</artifactId>
		</dependency>

-------------------------
MyBatis-PageRowBounds��ҳ|
-------------------------
	# mybatis����
		<plugin interceptor="com.github.pagehelper.PageInterceptor">
			<!-- ���� -->
			<property name="helperDialect" value="mysql"/>
			<!-- RowBounds�����offset������Ϊ��ҳ��page���� -->
			<property name="offsetAsPageNum" value="true"/>
			<!-- ��ҳ������������ֹ��Ϊҳ��ͷβ������������ռ�¼ -->
			<property name="reasonable" value="true"/>
			<!-- �� pageSize(limit) = 0 ����ҳ�룬ֱ�Ӽ��������еļ�¼ -->
			<property name="pageSizeZero" value="true"/>
			<!-- RowBounds ��Ϊ��ҳ����ʱ��Ҫ���ܼ�¼�� -->
			<property name="rowBoundsWithCount" value="true"/>
		</plugin>
	
	# ����

		// SQL�������˶���
		UserEntity userEntity = new UserEntity();
		
		// ҳ���ÿҳ��ʾ����
		PageRowBounds pageRowBounds = new PageRowBounds(2, 1);

		// �Ƿ�Ҫ�����ܼ�¼��
		pageRowBounds.setCount(true);
		
		List<UserEntity> users = this.userMapper.pageTest(userEntity ,pageRowBounds);
		
	
		* pageRowBounds ������
			{
				"count":true,			// �Ƿ�����ܼ�¼����
				"limit":1,				// ÿҳ��ʾ����
				"offset":2,				// ��ǰҳ��
				"total":3				// �ܼ�¼����
			}
				
			