package com.harman.events.sports.services;

import java.util.Collection;

import com.harman.events.sports.models.Event;

public interface EventService {

	public Event addEvent (Event event);
	public Event fetchEvent (int eventId);
	public Event updateEvent (int eventId, Event event);
	public Event deleteEvent (int eventId, Event event);
	
	public Collection<Event> getAllEvents();	
}
