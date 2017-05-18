package com.dmitry.bogdanov.underground.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "u_passages")
public class Passage {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "station_id", nullable = false)
    private long station_id;

    @Column(name = "ticket_id", nullable = false)
    private long ticket_id;

    @Column(name = "passage_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date passage_date;

    public Passage() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStation_id() {
        return station_id;
    }

    public void setStation_id(long station_id) {
        this.station_id = station_id;
    }

    public long getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Date getPassage_date() {
        return passage_date;
    }

    public void setPassage_date(Date passage_date) {
        this.passage_date = passage_date;
    }
}
