------------------------
�ֿ�					|
------------------------
	# Docker �ֿ��ַ & �ṹ
		https://hub.docker.com/
			|-repoisoty1
				|-image1 tag1
				|-image1 tag2
				|-image2
			|-repoisoty2
	


------------------------
���ֲֿ�				|
------------------------
	https://hub.docker.com/

------------------------
�޸�Ϊ���ڵĲֿ�		|
------------------------
	# �༭�ļ�
		vim /etc/docker/deamon.json
		*  ������,ֱ����Ӹ��ļ�
	
	# ����
		{
			"registry-mirrors":["https://docker.mirrors.ustc.edu.cn"]
		}
	
	# ��������
		systemctl restart docker