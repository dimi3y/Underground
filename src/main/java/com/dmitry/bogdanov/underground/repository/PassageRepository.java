package com.dmitry.bogdanov.underground.repository;

import com.dmitry.bogdanov.underground.entity.Passage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface PassageRepository extends JpaRepository<Passage, Long> {

    @Query("SELECT COUNT(p) FROM Passage p WHERE p.stationId = ?1 AND p.passageDate > ?2 " +
            "AND p.passageDate < ?3")
    Long getStationPopularity(long id, Date start, Date end);
    @Query("SELECT COUNT(p) FROM Passage p WHERE p.passageDate >= ?1 " +
            "AND p.passageDate < ?2")
    Long getLoadInTime(Date start, Date end);

    @Query("SELECT p FROM Passage p WHERE p.ticketId = ?1")
    List<Passage> getPassagesByTicketId(long ticketId);
}
