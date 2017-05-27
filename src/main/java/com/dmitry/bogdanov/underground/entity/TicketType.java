package com.dmitry.bogdanov.underground.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ticket_type")
public class TicketType {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "TICKET_TYPE_ID", unique = true, nullable = false)
    private long ticketTypeId;

    @Column(name = "TICKET_TYPE_NAME", nullable = false, length = 60)
    private String ticketTypeName;

    public TicketType() {
    }

    public long getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(long ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public String getTicketTypeName() {
        return ticketTypeName;
    }

    public void setTicketTypeName(String ticketTypeName) {
        this.ticketTypeName = ticketTypeName;
    }
}
