package com.journaldev.spring;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

 
import com.journaldev.spring.model.Event;
import com.journaldev.spring.service.EventService;

 
@RestController
@RequestMapping("/events")
public class EventsController {
	
	@Autowired
    private EventService eventService;
	
	 @RequestMapping(method = RequestMethod.GET)
	    public ResponseEntity<List<Event>> getAllEvents() {
	        List<Event> events = eventService.getAllEvents();

	        if (events == null || events.isEmpty()){
	            return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);
	        }

	        return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
	    }
 
    
	   @RequestMapping(value = "{id}", method = RequestMethod.GET)
	    public ResponseEntity<Event> get(@PathVariable("id") int id){
		   Event user = eventService.findById(id);
	        if (user == null){
	            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
	        }

	        return new ResponseEntity<Event>(user, HttpStatus.OK);
	    }
}
