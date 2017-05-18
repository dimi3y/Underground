package com.dmitry.bogdanov.underground.repository;

import com.dmitry.bogdanov.underground.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {
}
