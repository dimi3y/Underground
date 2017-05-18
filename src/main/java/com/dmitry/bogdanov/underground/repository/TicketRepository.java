package com.dmitry.bogdanov.underground.repository;

import com.dmitry.bogdanov.underground.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
