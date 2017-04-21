package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Event;

public interface EventDAO {
	
	List<Event> getAllEvents();
	Event findById(int id);

}
