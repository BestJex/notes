
# �����ļ��ο�
	https://github.com/docker/docker.github.io/blob/master/compose/compose-file/index.md


# ����

version: "[�汾��]"
service:
  [Ӧ������]:
    image:
    build: [ָ��DockerfileĿ¼,���¹���һ������]
	ports:
	  - "[�������˿�]:[�����˿�]"
    volumes:
	  - [������Ŀ¼]:[����Ŀ¼]
    networks:
	  - [����]
	deploy:
	# ����ѡ��
	  replicas: [��Ⱥ����]
	  update_config:
	    parallelism: 2
		delay: 10s
		restart_policy:
		# ��������
		  condition: on-failure
		  # ��������,ö��ֵ