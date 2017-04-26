package com.harman.events.sports.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harman.events.exceptions.ResourceNotFoundException;
import com.harman.events.exceptions.ResourcePreConditionFailed;
import com.harman.events.exceptions.ValidationFailed;
import com.harman.events.sports.models.Event;
import com.harman.events.sports.services.EventService;

@RestController
@RequestMapping("/events")
public class EventsRestfulService {

	@Autowired
	EventService eventService;
	
	@RequestMapping(method = RequestMethod.GET)
    public Collection<Event> getAllEvents() {
		
        return eventService.getAllEvents();
    }
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
    public Event getEvent(@PathVariable("id") int id) {
		
        Event event = eventService.fetchEvent( id);

        if (event == null) {
            throw new ResourceNotFoundException( String.format( "event (id=%d) does not exist.", id));
        }
        
        return event;
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public Event createEvent(@RequestBody Event event) {
		
		// This is just an example, the same can be wrapped in an advice and made generic
		try {
			
			return eventService.addEvent(event);

		} catch( ValidationFailed ex) {
			
			throw new ResourcePreConditionFailed( ex.getMessage());
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/{id}")
    public Event updateEvent(@PathVariable("id") int id, @RequestBody Event event) {
		
        return eventService.updateEvent( id, event);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
    public Event deleteEvent(@PathVariable("id") int id, @RequestBody Event event) {
		
        return eventService.deleteEvent( id, event);
	}
}
