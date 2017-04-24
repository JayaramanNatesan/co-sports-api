package com.journaldev.spring.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.journaldev.spring.model.Event;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Transactional
public class EventServiceTest {
	
	@Autowired	
	private EventService eventService;
	

	@Test
	public void testGetAllEvents() {
		List<Event> events = eventService.getAllEvents();
		//fail("Not yet implemented");
		//success("");
		assertEquals(events.size(), 11);
	}

}
