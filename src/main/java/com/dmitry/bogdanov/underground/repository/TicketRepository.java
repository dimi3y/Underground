package com.dmitry.bogdanov.underground.repository;

import com.dmitry.bogdanov.underground.entity.Ticket;
import com.dmitry.bogdanov.underground.entity.Passage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t WHERE t.ticketId = ?1")
    Ticket getTicketById(long ticketId);

    @Query("SELECT t FROM Ticket t WHERE t.passageCount > 0")
    List<Ticket> getAllActive();

    @Query("SELECT t.ticketTypeId, COUNT(t) FROM Ticket t WHERE t.activationDate > ?1 " +
            "AND t.activationDate < ?2 GROUP BY t.ticketTypeId")
    String[][] getTicketPopularity(Date start, Date end);

}
