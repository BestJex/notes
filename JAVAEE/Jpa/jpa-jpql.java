-------------------------
jpql
-------------------------
	# JPQL
		* ֧��ʹ�� AS �ؼ��������
		* ��֧��ʹ��;����, ��֧��ʹ��``
	
	# JPQL����ռλ
		* ʹ��λ��ռλ
			1? 2? 3? 
		
		* ʹ�ñ���ռλ
			:name, :age

	# ����
		FROM io.app.domain.User 
			* ����дSELECT, ֱ�� FROM ����
			* �������EntityManager����, �����ü�д, ������ȫ��
	
	# ģ����ѯ
		FROM io.app.domain.User  WHERE name LIKE ?1
			* ռλ����, ��Ҫ�Լ���� % ����
	
	# ����
		FROM User ORDER BY name DESC, id ASC
	
	
	# ͳ��
		SELECT COUNT(1) FROM User
	
	# ����
		UPDATE User SET name = ?1 WHERE id = ?2

	# ɾ��
		DELETE User WHERE id = ?1
	

	

	
