package com.dmitry.bogdanov.underground.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "u_tickets")
public class Ticket {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "ticket_type", nullable = false, length = 30)
    private String ticket_type;

    @Column(name = "passages_count", nullable = false, length = 30)
    private int passages_count;

    @Column(name = "activation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date activation_date;

    public Ticket() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTicket_type() {
        return ticket_type;
    }

    public void setTicket_type(String ticket_type) {
        this.ticket_type = ticket_type;
    }

    public int getPassages_count() {
        return passages_count;
    }

    public void setPassages_count(int passages_count) {
        this.passages_count = passages_count;
    }

    public Date getActivation_date() {
        return activation_date;
    }

    public void setActivation_date(Date activation_date) {
        this.activation_date = activation_date;
    }
}
