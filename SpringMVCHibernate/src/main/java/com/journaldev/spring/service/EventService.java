package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Event;

public interface EventService {
	
	List<Event> getAllEvents();
	Event findById(int id);

}
