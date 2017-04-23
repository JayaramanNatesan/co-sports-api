package com.harman.events.sports.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.harman.events.sports.models.Event;
import com.harman.events.sports.services.EventService;

@Service
public class EventServiceImpl implements EventService {

	public List<Event> getAllEvents() {
		
		List<Event> events = new ArrayList<Event>();
		
		events.add( new Event(1, "Carrom", "Ecospace", Calendar.getInstance().getTime(), 20L, 0L, "Open","Open"));
		
		return null;
	}
}
