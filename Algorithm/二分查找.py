# collection ����Ϊ�����������������,�����ڷ��ظ���
def indexedBinarySearch(collection, value):
    low = 0
    high = len(collection) - 1
    while(low <= high):
        mid = (low + high) // 2
        item = collection[mid]
        if item > value:
            high = mid - 1
        elif item < value:
            low = mid + 1
        else:
            return mid
    return -(low + 1)



# ��ȡ��λ�����±�,��� start �� end ����Ļ�,  ��ĳЩ�����п��ܻᵼ�����, ��Ҫ��һ�ּ��㷽ʽ
	mid = low + (high - low) // 2
	

# ���֧���޷���λ������Ļ�, ����
	 mid = (low + high) >>> 1;