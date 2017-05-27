package com.dmitry.bogdanov.underground.repository;


import com.dmitry.bogdanov.underground.entity.UndergroundUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface UndergroundUserRepository extends JpaRepository<UndergroundUser, Long> {

    @Query("SELECT u FROM UndergroundUser u WHERE u.userLogin LIKE ?1")
    UndergroundUser getByLogin(String login);

    @Query("SELECT u FROM UndergroundUser u")
    List<UndergroundUser> findAllUsers();

    @Query("SELECT u FROM UndergroundUser u WHERE u.userId = ?1")
    UndergroundUser getUserById(long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM UndergroundUser u WHERE u.userId = ?1")
    void deleteUsersById(long id);


    @Modifying
    @Transactional
    @Query("UPDATE UndergroundUser u SET u.userTypeId = ?4, " +
            "u.userLogin = ?2, u.userPassword = ?3 WHERE u.userId = ?1")
    void updateUser(long id, String login, String password, long tid);
}
