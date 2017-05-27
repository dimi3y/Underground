package com.dmitry.bogdanov.underground.service;

import com.dmitry.bogdanov.underground.entity.*;
import com.dmitry.bogdanov.underground.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UndergroundServiceImpl implements UndergroundService {

    private final TicketRepository ticketRepository;
    private final PassageRepository passageRepository;
    private final StationRepository stationRepository;
    private final UndergroundUserRepository undergroundUserRepository;
    private final UserTypeRepository userTypeRepository;
    private final TicketTypeRepository ticketTypeRepository;

    @Autowired
    public UndergroundServiceImpl(TicketRepository ticketRepository, PassageRepository passageRepository, StationRepository stationRepository, UndergroundUserRepository undergroundUserRepository, UserTypeRepository userTypeRepository, TicketTypeRepository ticketTypeRepository) {
        this.ticketRepository = ticketRepository;
        this.passageRepository = passageRepository;
        this.stationRepository = stationRepository;
        this.undergroundUserRepository = undergroundUserRepository;
        this.userTypeRepository = userTypeRepository;
        this.ticketTypeRepository = ticketTypeRepository;
    }

    public String checkUser(UndergroundUser undergroundUser){
        UndergroundUser fuser = undergroundUserRepository.getByLogin(undergroundUser.getUserLogin());

        if(fuser != null){
            if(undergroundUser.getUserPassword().equals(fuser.getUserPassword())){
                return userTypeRepository.getUserTypeNameById(fuser.getUserTypeId());
            } else {
                return "Incorrect password";
            }
        } else {
            return "No such user";
        }
    }

    @Override
    public List<UndergroundUser> getAllUsers() {
        return undergroundUserRepository.findAllUsers();
    }

    @Override
    public List<UserType> getUserTypes() {
        return userTypeRepository.getAllUserTypes();
    }

    @Override
    public List<String>  ticketPopularity(String startDate, String finishDate) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        List<String> result = null;
        Date sDate, fDate;

        try {
            sDate = df.parse(startDate);
            fDate = df.parse(finishDate);
            String[][] list;
//            String[][] types;
//            types =
            if((list = ticketRepository.getTicketPopularity(sDate, fDate)) != null) {
                result = new ArrayList<>(list.length);
                for (String[] aList : list)
                    result.add("\"" + ticketTypeRepository.getTicketTypeById(Long.valueOf(aList[0]))
                            + "\"" + " popularity: " + aList[1]);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
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

    @Override
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

    @Override
    public List<Ticket> activeTickets() {
        return ticketRepository.getAllActive();
    }

    @Override
    public boolean deleteUser(long id) {
        undergroundUserRepository.deleteUsersById(id);
        return undergroundUserRepository.getUserById(id) == null;
    }

    @Override
    public Ticket getTicketInfo(long ticketId){
        return ticketRepository.getTicketById(ticketId);
    }

    @Override
    public List<Passage> getPassagesByTId(long id){
        return passageRepository.getPassagesByTicketId(id);
    }

    @Override
    public UndergroundUser getUser(long id) {
        return undergroundUserRepository.getUserById(id);
    }

    @Override
    public String getTicketType(long ticketTypeId) {
        return ticketTypeRepository.getTicketTypeById(ticketTypeId);
    }

    @Override
    public void updUser(UndergroundUser user) {
        if(user.getUserId() != 0)
            undergroundUserRepository.updateUser(user.getUserId(), user.getUserLogin(), user.getUserPassword(), user.getUserTypeId());
        else
            undergroundUserRepository.save(user);
        undergroundUserRepository.flush();
    }


}
