----------------------------
集合						|
----------------------------
	# 元素不能重复
	# 接口方法
		add();
		remove();
		contains();
		size();
		isEmpty();
	
	# 底层可以是二分搜索树或者链表实现
		* 二分搜索树作为底层实现太简单了,几乎API都不用咋修改,这里不写

	# 链表的实现,其实就是在add方法添加判断是否已经存在的逻辑
		@Override
		public boolean add(E e) {
			if(this.contains(e)) {
				//如果已经包含,则不添加
				return false;
			}
			return this.add(e);
		}