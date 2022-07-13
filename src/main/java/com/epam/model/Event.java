package com.epam.model;

import com.epam.mapper.DateAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * Created by maksym_govorischev.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"title", "date"})
public class Event {
    @XmlAttribute(name="id")
    private long id;
    private String title;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date date;

    public Event(long eventId) {
        this.id=eventId;
    }
}
