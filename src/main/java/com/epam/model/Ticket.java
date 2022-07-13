package com.epam.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@XmlRootElement
@XmlType(propOrder = {"user", "event", "category", "place"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Ticket {
    public enum Category {STANDARD, PREMIUM, BAR}
    @XmlAttribute(name="id")
    private long id;
    private Event event;
    private User user;
    private Category category;
    private int place;
}
