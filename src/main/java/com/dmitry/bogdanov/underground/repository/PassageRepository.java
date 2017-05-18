package com.dmitry.bogdanov.underground.repository;

import com.dmitry.bogdanov.underground.entity.Passage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassageRepository extends JpaRepository<Passage, Long> {
}
