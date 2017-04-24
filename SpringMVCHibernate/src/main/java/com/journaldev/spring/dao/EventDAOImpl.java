package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Event;

@Repository
public class EventDAOImpl implements EventDAO {
	private static final Logger logger = LoggerFactory.getLogger(EventDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public List<Event> getAllEvents() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Event> eventList = session.createQuery("from Event order by eventName").list();
		for(Event event : eventList){
			logger.info("Person List::"+event);
		}
		return eventList;
	}

	@Override
	public Event findById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Event event = (Event) session.load(Event.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+event);
		return event;
	}

}
