package rik.yl.core.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rik.yl.core.model.Event;
import rik.yl.core.repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    //get all
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    //add event
    public Event saveEvent(Event event) {
        eventRepository.save(event);
        return event;
    }

    //gets one
    public Event getEventById(Long id) {
        //check if exists to avoid double connection
        Optional<Event> result = eventRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }

    //delete event
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

}
