# ��ŵ��
	* ˼·: �����ж��ٸ���, ����������




# ����ʵ��
def hanoitower(number, a, b, c):
    if number == 1:
        print('��[%d]���̴� [%s] -> [%s]' % (number, a, c))
    else:
        hanoitower(number - 1, a, c, b)
        print('��[%d]���̴� [%s] -> [%s]' % (number, a, c))
        hanoitower(number - 1, b, a, c)


hanoitower(5, 'a', 'b', 'c')