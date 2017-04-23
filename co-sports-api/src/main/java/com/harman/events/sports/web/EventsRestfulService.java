package com.harman.events.sports.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harman.events.sports.models.Event;
import com.harman.events.sports.services.EventService;

@RestController
@RequestMapping("/events")
public class EventsRestfulService {

	@Autowired
	EventService eventService;
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();

        if (events == null || events.isEmpty()){
            return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
    }
}
