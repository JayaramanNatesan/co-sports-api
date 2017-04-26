package com.harman.events.sports.services.impl;

import java.util.Calendar;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Service;

import com.harman.events.exceptions.ValidationFailed;
import com.harman.events.sports.models.Event;
import com.harman.events.sports.services.EventService;

@Service
public class EventServiceImpl implements EventService {

	private static final ConcurrentMap<Integer, Event> __sampleEvents = new ConcurrentHashMap<Integer, Event>();
	
	{
		__sampleEvents.put(1, new Event(1, "Carrom", "Ecospace", Calendar.getInstance().getTime(), 20L, 0L, "Open","Open"));
		__sampleEvents.put(2, new Event(2, "Cricket", "Campus", Calendar.getInstance().getTime(), 20L, 0L, "Closed","Closed"));
	}
	
	public Collection<Event> getAllEvents() {
		
		return __sampleEvents.values();
	}

	public Event fetchEvent(int eventId) {
		
		return __sampleEvents.get( eventId);
	}

	public Event addEvent(Event event) {
		
		return __sampleEvents.put( event.getEventId(), event);
	}

	public Event updateEvent(int eventId, Event event) {
		
		if ( eventId != event.getEventId() ) {
			throw new ValidationFailed( String.format( "Event id cannot be updated."));
		}
		
		return __sampleEvents.put( eventId, event);
	}

	public Event deleteEvent(int eventId, Event event) {
		
		Event eventInStore = __sampleEvents.get( eventId);
		
		if ( eventInStore == null ) {
			
			throw new ValidationFailed( String.format( "Event (%d) does not exist.", eventId));
		}
		
		if ( compareEvents( event, eventInStore) != 0 ) {
			
			throw new ValidationFailed( String.format( "Event id and content do not match"));
		}
		
		if ( !__sampleEvents.remove( eventId, eventInStore) ) {
			
			throw new ValidationFailed( String.format( "Error in removing Event (%d).", eventId));
		}
		
		return eventInStore;
	}
	
	private int compareEvents (Event event1, Event event2) {
		
		return event1.getEventId() - event2.getEventId();
	}
}
