-------------------------
image					 |
-------------------------
	# ��ѯ����
		docker search [name]
			name
				* ��ѯָ���ľ���
		����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
		NAME                                   DESCRIPTION                                     STARS               OFFICIAL            AUTOMATED
		mysql                                  MySQL is a widely used, open-source relation��   7649                [OK]                [ok]
		����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
		NAME ����
		DESCRIPTION ����
		STARS ��������(�ܵ���ӭ�ĳ̶�)
		OFFICIAL �Ƿ��ǹٷ�������
		AUTOMATED �Ƿ�DockerHub�Զ�������


	# �鿴���صľ���(�г�����)
		docker images [name]
			name
				* �����г����صľ���
			
		--------------------------------------------------------------------------------------
		REPOSITORY            TAG                 IMAGE ID            CREATED             SIZE
		hello-world           latest              fce289e99eb9        6 days ago          1.84kB
		nginx                 latest              7042885a156a        9 days ago          109MB
		--------------------------------------------------------------------------------------
	
	# ������ȡ
		docker pull [name]:[tag]
			name
				* ��������
			tag
				* ��ǩ(�汾��)
			-a
				* ����ָ�����������tag(�汾)������
	
	# ɾ������
		docker rmi [name]
			* ����ֻ��ɾ�� last �汾
			* Ҳ���԰�name����ָ����image id
			* ɾ�����еľ���
				docker rmi `docker images -q`

	
	# ��������
		docker save [name]:[tag] > /[path].image
		
	# ���뾵��
		docker load < /[path].image
	
	