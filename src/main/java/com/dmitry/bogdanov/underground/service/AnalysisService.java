package com.dmitry.bogdanov.underground.service;

import com.dmitry.bogdanov.underground.entity.Ticket;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AnalysisService {
    List<String> ticketPopularity(String startDate, String finishDate);
    List<String> stationPopularity(String startDate, String finishDate);
    List<String> loadAnalysis(String date);
    List<Ticket> activeTickets();
}
