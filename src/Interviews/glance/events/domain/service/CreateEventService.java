package Interviews.glance.events.domain.service;

import Interviews.glance.events.events.Event;

public interface CreateEventService {

    public void handleCreate(Event event);
}
