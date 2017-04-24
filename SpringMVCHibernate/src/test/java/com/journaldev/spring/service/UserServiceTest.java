package com.journaldev.spring.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.journaldev.spring.model.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Transactional
public class UserServiceTest {
	
	@Autowired	
	private UserService userService;

	/*@Test
	public void testListUsers() {
		fail("Not yet implemented");
	}
*/
	@Test
	public void testListUsersByEventId() {
		List<User> users = userService.listUsersByEventId(5);
		//fail("Not yet implemented");
		//success("");
		assertEquals(users.size(), 3);
	}

}
