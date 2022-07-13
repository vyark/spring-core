package com.epam.model;

import com.epam.model.Ticket;
import com.epam.model.User;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="tickets")
public class TicketListContainer {
    private List<Ticket> ticketList;

    @XmlElement(name = "ticket")
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}