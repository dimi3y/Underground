package com.dmitry.bogdanov.underground.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "passage")
public class Passage {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "PASSAGE_ID", unique = true, nullable = false)
    private long passageId;

    @Column(name = "STATION_ID", nullable = false)
    private long stationId;

//    @ManyToOne(targetEntity = Ticket.class, fetch = FetchType.EAGER)
//    @JoinColumn(name = "TICKET_ID", nullable = false)
    @Column(name = "TICKET_ID", nullable = false)
    private long ticketId;

    @Column(name = "PASSAGE_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date passageDate;

    public Passage() {
    }

    public Passage(long stationId, long ticketId, Date passageDate) {
        this.stationId = stationId;
        this.ticketId = ticketId;
        this.passageDate = passageDate;
    }

    public long getPassageId() {
        return passageId;
    }

    public void setPassageId(long passageId) {
        passageId = passageId;
    }

    public long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
        this.stationId = stationId;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public Date getPassageDate() {
        return passageDate;
    }

    public void setPassageDate(Date passageDate) {
        this.passageDate = passageDate;
    }
}
