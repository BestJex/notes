------------------------
Querydsl				|
------------------------
	# ����
		http://www.querydsl.com/

	
	# ���� & �������
		<!-- https://mvnrepository.com/artifact/com.querydsl/querydsl-jpa -->
		<dependency>
			<groupId>com.querydsl</groupId>
			<artifactId>querydsl-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>com.querydsl</groupId>
			<artifactId>querydsl-apt</artifactId>
			<scope>provided</scope>
		</dependency>


		<build>
			<plugins>
				<plugin>
					<groupId>com.mysema.maven</groupId>
					<artifactId>apt-maven-plugin</artifactId>
					<version>1.1.3</version>
					<executions>
						<execution>
							<goals>
								<goal>process</goal>
							</goals>
							<configuration>
								<outputDirectory>target/generated-sources/java</outputDirectory>
								<processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
							</configuration>
						</execution>
					</executions>
				</plugin>
			</plugins>
		</build>
		
		* ��Ҫ����������jpa
	
	# ���� JPAQueryFactory
		import javax.persistence.EntityManager;

		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.context.annotation.Bean;
		import org.springframework.context.annotation.Configuration;

		import com.querydsl.jpa.impl.JPAQueryFactory;

		@Configuration
		public class JPAQueryFactoryConfiguration {

			@Bean
			public JPAQueryFactory jPAQueryFactory (@Autowired EntityManager entityManager) {
				return new JPAQueryFactory(entityManager);
			}
		}
	
	# Repository ʵ�ֽӿ�: QuerydslPredicateExecutor
		* ͨ���ýӿ�, �� Repository ��չqueryDsl�ļ���api
	
	# ����Ҫ JPAQueryFactory �ĵط�, ע��
		@Autowired
		JPAQueryFactory jPAQueryFactory
	
