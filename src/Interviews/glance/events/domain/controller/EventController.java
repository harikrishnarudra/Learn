package Interviews.glance.events.domain.controller;

import com.sun.jdi.request.EventRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public class EventController {

    @PostMapping
    public ResponseEntity handleCreate(EventRequest request){
        return ResponseEntity.ok().build();
    }
}
