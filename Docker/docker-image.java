-------------------------
image					 |
-------------------------
	# �鿴���صľ���(�г�����)
		docker images
		--------------------------------------------------------------------------------------
		REPOSITORY            TAG                 IMAGE ID            CREATED             SIZE
		hello-world           latest              fce289e99eb9        6 days ago          1.84kB
		nginx                 latest              7042885a156a        9 days ago          109MB
		--------------------------------------------------------------------------------------

	# ������ȡ
		docker pull [name]:[tag]
	
	# ɾ������
		docker rmi [name]
			* ����ֻ��ɾ�� last �汾
			* Ҳ���԰�name����ָ����image id

	
	# ��������
		docker save [name]:[tag] > /[path].image
		
	# ���뾵��
		docker load < /[path].image
	
	