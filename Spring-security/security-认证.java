------------------
��֤			  |
------------------
	# �������
		UsernamePasswordAuthenticationFilter


		UsernamePasswordAuthenticationToken

		AuthenticationManager

		AuthenticationProvider

		GrantedAuthority
			* ��ʾ��ɫ��Ϣ�ӿ�
			* ʵ��
				JaasGrantedAuthority
				SimpleGrantedAuthority
				SwitchUserGrantedAuthority

		UserDetailsService
			* �����û���, �����û��Ľӿ�
			* ֻ��һ������
				UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
				
				* �÷���ֻҪ����null, �ͱ�ʾ��֤ʧ��
			
			
		UserDetails
			* ��ʾ�û�������ӿ�
			* ���󷽷�
				Collection<? extends GrantedAuthority> getAuthorities();
				String getPassword();
				String getUsername();
				boolean isAccountNonExpired();
				boolean isAccountNonLocked();
				boolean isCredentialsNonExpired();
				boolean isEnabled();
			
			* ��ʵ����
				User
		
		PasswordEncoder
			* ����ı���ӿ�
			* ʵ����
				BCryptPasswordEncoder
				DelegatingPasswordEncoder