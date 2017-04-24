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

	@Transactional
	public List<Event> getAllEvents() {
		return eventDAO.getAllEvents();
	}
	@Transactional
	public Event findById(int id) {
		return eventDAO.findById(id);
	}

}
