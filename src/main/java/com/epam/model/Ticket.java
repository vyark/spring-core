package com.epam.model;

import lombok.Data;

/**
 * Created by maksym_govorischev.
 */
@Data
public class Ticket {
    public enum Category {STANDARD, PREMIUM, BAR}

    private long id;
    private long eventId;
    private long userId;
    private Category category;
    private int place;
}
