
# KMP�㷨�ĺ���,��һ������Ϊ����ƥ���PMT(Partial Match Table)������

# ����ǰ׺�ͺ�׺(�ַ������������Լ���ǰ/��׺)
    Harry Potter
		Harry ǰ׺����	{"H", "Ha", "Har", "Harr"}
		Potter ��׺����	{"otter", "tter", "ter", "er", "r"}

# PMT�е�ֵ���ַ�����ǰ׺�������׺���ϵĽ������Ԫ�صĳ���
	"aba" 
		ǰ׺ {"a", "ab"}		ǰ׺����
		��׺ {"ba" ,"a"}		��׺����
		PMT =  {"a"} = 1		ǰ��׺���ϵĽ�����,���Ԫ�س�����1
	

	"ababa"
		ǰ׺ {"a", "ab", "aba", "abab"}
		��׺ {"baba", "aba" ,"ba" ,"a"}
		PMT = {"a", "aba"} = 3

# ababababca ��PMT
	char	'a' 'b' 'a' 'b' 'a' 'b' 'c' 'a'
	index	 0	 1	 2	 3	 4	 5   6	 7
	value	 0   0   1   2	 3   4   0   1


# ��TMɶ���⣿