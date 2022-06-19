package com.epam.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by maksym_govorischev.
 */
@Data
public class Event {
    private long id;
    private String title;
    private Date date;
}
