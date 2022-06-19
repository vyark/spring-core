package com.epam.service;

import com.epam.dao.EventDao;
import com.epam.model.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EventService {

    @Autowired
    private EventDao eventDao;

    public Event getEventById(long eventId) {
        return eventDao.get(eventId);
    }

    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        int skipCount = (pageNum - 1) * pageSize;

        return eventDao.values().stream()
                        .filter(event -> event.getTitle().equals(title))
                        .skip(skipCount)
                        .limit(pageSize)
                        .collect(Collectors.toList());
    }

    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        int skipCount = (pageNum - 1) * pageSize;

        return eventDao.values().stream()
                        .filter(event -> event.getDate().equals(day))
                        .skip(skipCount)
                        .limit(pageSize)
                        .collect(Collectors.toList());
    }

    public Event createEvent(Event event) {
        return eventDao.put(event.getId(), event);
    }

    public Event updateEvent(Event event) {
        return eventDao.replace(event.getId(), event);
    }

    public boolean deleteEvent(long eventId) {
        return eventDao.remove(eventId);
    }
}
