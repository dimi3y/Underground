package com.dmitry.bogdanov.underground.service;

import com.dmitry.bogdanov.underground.entity.Passage;
import com.dmitry.bogdanov.underground.entity.Ticket;
import com.dmitry.bogdanov.underground.entity.UndergroundUser;
import com.dmitry.bogdanov.underground.entity.UserType;

import java.util.List;

public interface UndergroundService {


    List<String> ticketPopularity(String startDate, String finishDate);
    List<String> stationPopularity(String startDate, String finishDate);
    List<String> loadAnalysis(String date);
    List<Ticket> activeTickets();

    String checkUser(UndergroundUser undergroundUser);
    List<UndergroundUser> getAllUsers();
    List<UserType> getUserTypes();
    boolean deleteUser(long id);
    Ticket getTicketInfo(long id);
    List<Passage> getPassagesByTId(long id);
    UndergroundUser getUser(long id);
    String getTicketType(long id);
    void updUser(UndergroundUser user);
}
