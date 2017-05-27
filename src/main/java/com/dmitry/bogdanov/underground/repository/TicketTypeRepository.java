package com.dmitry.bogdanov.underground.repository;

import com.dmitry.bogdanov.underground.entity.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketTypeRepository extends JpaRepository<TicketType, Long> {

    @Query("SELECT t.ticketTypeName FROM TicketType t WHERE t.ticketTypeId = ?1")
    String getTicketTypeById(long ticketTypeId);
}
