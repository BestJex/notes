---------------------
discourse			 |
---------------------
	# github
		https://github.com/discourse/discourse

	# ��װ
		https://github.com/discourse/discourse_docker
		https://github.com/discourse/discourse/blob/master/docs/INSTALL-cloud.md
	

	# Docker��װ
		* �Ƴ��ɰ汾
yum remove docker \
docker-client \
docker-client-latest \
docker-common \
docker-latest \
docker-latest-logrotate \
docker-logrotate \
docker-selinux \
docker-engine-selinux \
docker-engine
		* ��װϵͳ����Ҫ�Ĺ���
			yum install -y yum-utils device-mapper-persistent-data lvm2
		
		* ������Դ��Ϣ
			yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
		
		* ���� yum ����
			yum makecache fast
		
		* ��װ Docker-ce
			yum -y install docker-ce
		
		* ���� Docker ��̨����
			systemctl start docker
		
		* �������� hello-world
			docker run hello-world
		 
		* ɾ��docket ce
			yum remove docker-ce
			rm -rf /var/lib/docker
	
	# 

---------------------
launcher ά��		 |
---------------------
	�﷨: launcher COMMAND CONFIG [--skip-prereqs] [--docker-args STRING]
	COMMAND:
		start:      Start/initialize a container
			* ��ʼ��һ��container
		stop:       Stop a running container
			* ֹͣһ��container
		restart:    Restart a container
			* ����һ��container
		destroy:    Stop and remove a container
		enter:      Use nsenter to get a shell into a container
		logs:       View the Docker logs for a container
		bootstrap:  Bootstrap a container for the config based on a template
		rebuild:    Rebuild a container (destroy old, bootstrap, start new)
			* ���¹���
		cleanup:    Remove all containers that have stopped for > 24 hours

	Options:
		--skip-prereqs             Don't check launcher prerequisites
		--docker-args              Extra arguments to pass when running docker