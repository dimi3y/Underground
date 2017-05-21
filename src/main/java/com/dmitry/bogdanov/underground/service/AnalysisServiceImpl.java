package com.dmitry.bogdanov.underground.service;

import com.dmitry.bogdanov.underground.entity.Station;
import com.dmitry.bogdanov.underground.entity.Ticket;
import com.dmitry.bogdanov.underground.repository.PassageRepository;
import com.dmitry.bogdanov.underground.repository.StationRepository;
import com.dmitry.bogdanov.underground.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AnalysisServiceImpl implements AnalysisService{

    private final TicketRepository ticketRepository;

    private final PassageRepository passageRepository;

    private final StationRepository stationRepository;

    @Autowired
    public AnalysisServiceImpl(TicketRepository ticketRepository, PassageRepository passageRepository, StationRepository stationRepository) {
        this.ticketRepository = ticketRepository;
        this.passageRepository = passageRepository;
        this.stationRepository = stationRepository;
    }

    public List<String>  ticketPopularity(String startDate, String finishDate) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        List<String> result = null;
        Date sDate, fDate;

        try {
            sDate = df.parse(startDate);
            fDate = df.parse(finishDate);
            String[][] list;
            if((list = ticketRepository.getTicketPopularity(sDate, fDate)) != null) {
                result = new ArrayList<String>();
                for (String[] aList : list)
                    result.add(aList[0] + " popularity: " + aList[1]);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<String> stationPopularity(String startDate, String finishDate) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        List<String> result = null;
        Date sDate, fDate;

        try {
            sDate = df.parse(startDate);
            fDate = df.parse(finishDate);
            List<Station> stations;

            if((stations = stationRepository.getAll()) != null) {
                result = new ArrayList<String>();
                Long popularity;
                for (Station aStation : stations) {
                    popularity = passageRepository.getStationPopularity(aStation.getStationId(), sDate, fDate);
                    if (popularity != null) {
                        result.add(aStation.getStationName() + " popularity: " + popularity);
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<String> loadAnalysis(String date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        List<String> result = null;

        try {
            String stime, ftime;
            Long load;
            result = new ArrayList<String>();
            for(int i = 0; i < 24; i++){
                stime = (i < 10 ? "0" + i : i) + ":00:00.000";
                ftime = (i+1 < 10 ? "0" + (i+1) : (i+1)) + ":00:00.000";
                load = passageRepository.getLoadInTime(df.parse(date + " " + stime), df.parse(date + " " + ftime));
                result.add(stime + "-" + ftime + " load: " + load);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<Ticket> activeTickets() {
        return ticketRepository.getAllActive();
    }
}
