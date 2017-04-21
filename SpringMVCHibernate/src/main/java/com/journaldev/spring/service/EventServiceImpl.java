package com.journaldev.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.EventDAO;
import com.journaldev.spring.model.Event;
@Service
public class EventServiceImpl implements EventService{
	@Autowired
	private EventDAO eventDAO;
	 //private static final AtomicLong counter = new AtomicLong();
	  
	   /* static List<Event> events = new ArrayList<Event>(
	            Arrays.asList(
	            		new Event(counter.incrementAndGet(), "Carom Tournament", "Campus", new java.sql.Date(new Date(0).getTime()), 50L, 30L, "OPEN", "OPEN"),
	            		new Event(counter.incrementAndGet(), "Antakshari", "Campus", new java.sql.Date(new Date(0).getTime()), 50L, 50L, "CLOSED", "OPEN"),
	            		new Event(counter.incrementAndGet(), "All Hand Meet", "SEZ", new java.sql.Date(new Date(0).getTime()), 500L, 300L, "OPEN", "OPEN")
	                    ));*/

	@Transactional
	public List<Event> getAllEvents() {
		return eventDAO.getAllEvents();
	}
	@Transactional
	public Event findById(int id) {
		return eventDAO.findById(id);
	}

}
