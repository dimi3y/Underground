package com.dmitry.bogdanov.underground.repository;

import com.dmitry.bogdanov.underground.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {

    @Query("SELECT ut.userTypeName FROM UserType ut WHERE ut.userTypeId = ?1")
    String getUserTypeNameById(long id);

    @Query("SELECT ut FROM UserType ut" )
    List<UserType> getAllUserTypes();
}
