package com.epam.service;

import com.epam.model.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class EventServiceTest {
    @Autowired
    private EventService service;

    @Test
    public void testShouldGetEventById() {
        Event result = service.getEventById(1);

        assertEquals(1, result.getId());
    }

//    @Test
//    public void shouldGetEventsByTitle() {
//        List<Event> result = service.getEventsByTitle("Rock Concert", 5, 1);
//
//        assertEquals(1, result.size());
//    }
//
//    @Test
//    public void shouldGetEventsForDay() {
//        List<Event> result = service.getEventsForDay(Date.from(Instant.parse("2022-12-04T20:00" +
//                ":00Z")), 5, 1);
//
//        assertEquals(1, result.size());
//    }
//
//    @Test
//    public void shouldCreateEvent() {
//        Event event = new Event();
//        event.setId(3);
//        event.setTitle("Pop Music");
//        event.setDate(Date.from(Instant.parse("2023-01-10T20:00:00Z")));
//
//        Event result = service.createEvent(event);
//
//        assertEquals(3, result.getId());
//    }
//
//    @Test
//    public void shouldUpdateEvent() {
//        Event event = new Event();
//        event.setId(1);
//        event.setTitle("Pop Music");
//        event.setDate(Date.from(Instant.parse("2023-01-10T20:00:00Z")));
//
//        Event result = service.updateEvent(event);
//
//        assertEquals("Pop Music", result.getTitle());
//    }
//
//    @Test
//    public void shouldDeleteEvent_success() {
//        boolean result = service.deleteEvent(2);
//
//        assertEquals(true, result);
//    }
//
//    @Test
//    public void shouldDeleteEvent_throwException() {
//        IllegalStateException thrown = assertThrows(IllegalStateException.class, () ->
//                service.deleteEvent(3));
//
//        assertEquals("Event doesn't exist with id: 3", thrown.getMessage());
//    }
}
