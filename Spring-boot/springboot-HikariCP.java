------------------------
HikariCP				|
------------------------
	# һ����Druid��������ӳ�
	# Github
		https://github.com/brettwooldridge/HikariCP
	# SpringBoot2Ĭ��ʹ��(����Ҫ�����starter)
	# Maven����
		<dependency>
			<groupId>com.zaxxer</groupId>
			<artifactId>HikariCP</artifactId>
		</dependency>
	
	# ������

spring:
  # ��������
  datasource:
    type: com.zaxxer.hikari.HikariDataSource
    driverClassName: com.mysql.cj.jdbc.Driver
    jdbc-url: jdbc:mysql://127.0.0.1:3306/mall?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&allowMultiQueries=true
    username: root
    password: root
  
    # ���ӳص���������
    hikari:
	  catalog: 
	  connection-timeout: 
	  validation-timeout: 
	  idle-timeout: 
	  leak-detection-threshold: 
	  max-lifetime: 
	  max-pool-size: 
	  min-idle: 
	  username: 
	  password: 
	  initialization-fail-timeout: 
	  connection-init-sql: 
	  connection-test-query: SELECT 1
	  data-source-class-name: 
	  data-source-jndi-name: 
	  driver-class-name: 
	  jdbc-url: 
	  pool-name: 
	  schema: 
	  transaction-isolation-name: 
	  is-auto-commit: 
	  is-read-only: 
	  is-isolate-internal-queries: 
	  is-register-mbeans: 
	  is-allow-pool-suspension: 
	  data-source: 
	  data-source-properties: 
	  thread-factory: 
  	  scheduled-executor: 
	  metrics-tracker-factory: 
  	  metric-registry: 
	  health-check-registry: 
      health-check-properties: 
	  sealed: 
	
	# ����
		@Bean
		@ConfigurationProperties(prefix = "spring.datasource")
		public DataSource dataSource(){
			HikariDataSource hikariDataSource = new HikariDataSource();
			return hikariDataSource;
		}

------------------------
��������				|
------------------------
@Bean
public DataSource dataSource() {
	HikariConfig config = new HikariConfig();
	config.setJdbcUrl(dataSourceUrl); //����Դ
	config.setUsername(user); //�û���
	config.setPassword(password); //����
	config.addDataSourceProperty("cachePrepStmts", "true"); //�Ƿ��Զ������ã�Ϊtrueʱ����������������Ч
	config.addDataSourceProperty("prepStmtCacheSize", "250"); //���ӳش�СĬ��25���ٷ��Ƽ�250-500
	config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048"); //���������󳤶�Ĭ��256���ٷ��Ƽ�2048
	config.addDataSourceProperty("useServerPrepStmts", "true"); //�°汾MySQL֧�ַ�������׼���������ܹ��õ�������������
	config.addDataSourceProperty("useLocalSessionState", "true");
	config.addDataSourceProperty("useLocalTransactionState", "true");
	config.addDataSourceProperty("rewriteBatchedStatements", "true");
	config.addDataSourceProperty("cacheResultSetMetadata", "true");
	config.addDataSourceProperty("cacheServerConfiguration", "true");
	config.addDataSourceProperty("elideSetAutoCommits", "true");
	config.addDataSourceProperty("maintainTimeStats", "false");

	HikariDataSource ds = new HikariDataSource(config);
	return ds;
}