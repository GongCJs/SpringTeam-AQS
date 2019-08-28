package team.spring.aqs;

import org.apache.tomcat.util.descriptor.web.InjectionTarget;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import team.spring.aqs.entity.AqsUser;
import team.spring.aqs.service.UserService;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	@Autowired
	UserService userService;

	@Test
	public void contextLoads() {
		AqsUser user = new AqsUser();
		user.setUserAccount("root");
		user.setUserNickname("root");
		user.setUserPassword("root");
		user.setUserCreateTime(new Date());
		userService.saveUser(user);
	}
}
