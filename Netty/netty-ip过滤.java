--------------------------------
ip����							|
--------------------------------
	# ���
		IpFilterRuleType
			* ���صĽ��ö��

		IpFilterRule
			*��������
			|-IpSubnetFilterRule

		AbstractRemoteAddressFilter
			* ��ͬ��������
			|-UniqueIpFilter
			|-RuleBasedIpFilter

	# AbstractRemoteAddressFilter
		* ������,�ṩ��һ�����󷽷�,���ڹ���ip
			boolean accept(ChannelHandlerContext ctx, T remoteAddress) throws Exception;
		
		* ���ip���ں�����,��ᴥ���쳣
			 throw new IllegalStateException("cannot determine to accept or reject a channel: " + ctx.channel());

		* �ṩ�ɸ�д���¼�����
			void channelAccepted(ChannelHandlerContext ctx, T remoteAddress);
				* ipͨ������

			ChannelFuture channelRejected(ChannelHandlerContext ctx, T remoteAddress);
				* ip���ش���(����������ʵ��Ҫ���ͻ�����Ӧ������)
				* �������Ӧ�κ�����,���� null

	# IpFilterRule
		* ip���������,��һ���ӿ�,ʵ����:IpSubnetFilterRule
			IpSubnetFilterRule(String ipAddress, int cidrPrefix, IpFilterRuleType ruleType)
			IpSubnetFilterRule(InetAddress ipAddress, int cidrPrefix, IpFilterRuleType ruleType)


--------------------------------
UniqueIpFilter					|
--------------------------------
	# Ψһip���ӵĹ�����
	# һ��ipֻ�ܱ���һ������

--------------------------------
RuleBasedIpFilter				|
--------------------------------
	# ���ݹ���������ip
		RuleBasedIpFilter(IpFilterRule... rules)


