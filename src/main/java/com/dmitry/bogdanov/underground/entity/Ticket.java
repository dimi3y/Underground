package com.dmitry.bogdanov.underground.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "TICKET_ID", unique = true, nullable = false)
    private long ticketId;

    @Column(name = "TICKET_TYPE", nullable = false, length = 30)
    private String ticketType;

    @Column(name = "PASSAGES_COUNT", nullable = false)
    private long passageCount;

    @Column(name = "ACTIVATION_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date activationDate;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketId", targetEntity = Passage.class, fetch = FetchType.EAGER)
//    private Set<Passage> passages = new LinkedHashSet<Passage>();

    public Ticket() {
    }

    public Ticket(String ticketType, int passageCount, Date activationDate){
        this.ticketType = ticketType;
        this.passageCount = passageCount;
        this.activationDate = activationDate;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public long getPassageCount() {
        return passageCount;
    }

    public void setPassageCount(long passageCount) {
        this.passageCount = passageCount;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

//    public Set<Passage> getPassages() {
//        return passages;
//    }
//
//    public void setPassages(Set<Passage> passages) {
//        this.passages = passages;
//    }
}
