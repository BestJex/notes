----------------------------
springboot�ĵ�Ԫ����		|
----------------------------
	# ��������
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	
	# ���Դ���
		import io.springboot.jpa.JpaApplication;
		import io.springboot.jpa.dto.UserDTO;
		import io.springboot.jpa.repository.UserRepository;
		import io.springboot.jpa.service.UserService;
		import junit.framework.TestCase;
		import org.junit.Test;
		import org.junit.runner.RunWith;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.boot.test.context.SpringBootTest;
		import org.springframework.test.context.junit4.SpringRunner;



		@RunWith(SpringRunner.class)
		// ����@SpringBootApplication ��
		@SpringBootTest(classes = JpaApplication.class)
		public class JpaTest {

			// ����ʹ��IOC
			@Autowired
			private UserRepository userRepository;

			@Test
			public void test(){
				//TODO ִ�в��Դ���

				// ���Էǿ�
				TestCase.assertNotNull();
				// ����equals
				TestCase.assertEquals();
			}
		}