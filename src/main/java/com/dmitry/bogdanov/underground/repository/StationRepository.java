package com.dmitry.bogdanov.underground.repository;

import com.dmitry.bogdanov.underground.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StationRepository extends JpaRepository<Station, Long> {

    @Query("SELECT s FROM Station s")
    List<Station> getAll();
}
