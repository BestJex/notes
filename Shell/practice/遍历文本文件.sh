#!/bin/bash
# ============================================= 2019��1��22�� 13:56:43
IFS_OLD=$IFS

IFS=$'\n'	# ���зָ�

for entry in `cat /etc/passwd`; do
	echo "values in :${entry}"
	IFS=:	# ð��ָ�
	for value in $entry ; do
		echo "${value}	"
	done
done

# ��ԭԭʼ�ķָ��
IFS=$IFS_OLD