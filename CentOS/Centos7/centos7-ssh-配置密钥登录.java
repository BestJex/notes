
# �ڿͻ���������Կ��
	* ʹ��ssh��������
		ssh-keygen -t rsa
	
	* ʹ��Git�ͻ�������
		ssh-keygen -t rsa -C "747692844@qq.com"

# �޸������ļ�
	vim /etc/ssh/sshd_config

	PubkeyAuthentication yes					# ���û����ܳ׵İ�ȫ��֤
	PasswordAuthentication yes					# ���û��ڿ���İ�ȫ��֤
	StrictModes no								# �ر�ssh�ڽ��յ�¼����֮ǰ�ȼ���û���Ŀ¼��rhosts�ļ���Ȩ�޺�����Ȩ
	AuthorizedKeysFile .ssh/authorized_keys		# ָ����Կ�ļ�

# ��homeĿ¼����ļ�
	.ssh/authorized_keys

	* ���ļ�, һ������һ���ͻ��˹�Կ


# ���� ssh ����
	systemctl restart sshd.service

	* ǧ��ǵ�Ҫ�Ȱѹ�Կ��ӵ��˷�����, ������