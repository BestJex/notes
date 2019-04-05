management:
  endpoints:
    web:
      # ���ʶ˵��base uri
      base-path: /actuator
      # ����ָ���˵��ӳ�� uri
      path-mapping:
        health:  health
      # �����֧��(CorsEndpointProperties)
      cors:
        allow-credentials: true
        allowed-methods: *
        max-age: 1800s
      # �Ⱪ¶�Ķ˵�
      exposure:
        exclude:
        include:
          - '*'
    jmx:
      exposure:
        exclude:
        include:

    # �Ƿ�����Ĭ�ϵĶ˵�(Ĭ�� true),���õĶ˵㽫��Ӧ�ó�������������ȫɾ��
    enabled-by-default: true

  # ÿ���˵������
  endpoint:
    shutdown:
      enabled: true
    
    beans:
      enabled: true
      cache:
        time-to-live: 10s