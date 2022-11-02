package rik.yl.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rik.yl.core.model.Event;
import rik.yl.core.repository.EventRepository;
import rik.yl.core.services.EventService;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;


import java.util.*;

//Controller
@RestController
@RequestMapping("api/event")
public class EventController {

    //Connect services
    @Autowired
    private EventService eventService;
    @Autowired
    private EventRepository eventRepository;

    //fetch all events to view on homepage
    @GetMapping("events")
    public List<Event> GetEvents() { return eventService.getEvents(); }


    @PostMapping
    //public ResponseEntity<Event> SaveEvent(@PathVariable){}
    public ResponseEntity<Event> AddEvent(@RequestBody Event event){
        Event success = eventService.saveEvent(event);
        if (success != null){
            return ResponseEntity.status(HttpStatus.OK).body(event);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    //get one event
    @GetMapping("/{id}")
    public ResponseEntity<Event> GetEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        if (event != null){
            return ResponseEntity.status(HttpStatus.OK).body(event);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    //delete event
    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Boolean>> DeleteEvent(@PathVariable Long id){
        eventService.deleteEvent(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
