# ϣ������
	* ���ǲ������򾭹��Ľ���һ�����°汾, Ҳ����: ��С��������
	* ����˼��: 
		1. �Ѽ�¼�����±��һ����������
			gap = length / 2
		2. ��ÿһ��ʹ��ֱ�Ӳ��������㷨����
		3. �����������𽥼���, ÿ������Ĺؼ���Խ��Խ��
			gap = gap / 2
		4. ����������1��ʱ��, �����ļ�ǡ�ñ��ֳ�1��, �㷨��ֹ
			if gap = 1 : break
	

# ����ʵ��
def shellSort(arr):
    gab = len(arr) // 2

    while gab > 0:
        for i in range(gab, len(arr)):
            x = i - gab
            while x >= 0:
                if arr[x] > arr[x + gab]:
                    temp = arr[x]
                    arr[x] = arr[x + gab]
                    arr[x + gab] = temp
                x -= gab

        gab = gab // 2


arr = [5, 4, 7, 1, 8, 2, 9, 3, 6, 0]


shellSort(arr)

print(arr)


