
# 쳲���������,�ӵ�3�ʼ,ÿһ�����ǰ����֮��
# 1,1,2,3,5,8,13,21,34,55.....
# ����ʹ�õݹ�

def fib(num):
	# �����ǰ2��
    if num <= 2:
        return 1
    else:
        return fib(num - 2) + fib(num - 1)


for i in range(1,11):
    print(fib(i),end=',')

