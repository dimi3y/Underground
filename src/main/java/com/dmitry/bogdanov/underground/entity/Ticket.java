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

    @Column(name = "PASSAGES_COUNT", nullable = false)
    private long passageCount;

    @Column(name = "ACTIVATION_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date activationDate;

    @Column(name = "TICKET_TYPE_ID", nullable = false)
    private long ticketTypeId;

    @Column(name = "IS_ACTIVE", nullable = false)
    private boolean isActive;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketId", targetEntity = Passage.class, fetch = FetchType.EAGER)
//    private Set<Passage> passages = new LinkedHashSet<Passage>();

    public Ticket() {
    }

    public Ticket(int passageCount, Date activationDate){
        this.passageCount = passageCount;
        this.activationDate = activationDate;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
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

    public long getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(long ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
