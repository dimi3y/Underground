package com.dmitry.bogdanov.underground.controller;

import com.dmitry.bogdanov.underground.entity.Station;
import com.dmitry.bogdanov.underground.entity.Ticket;
import com.dmitry.bogdanov.underground.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class AnalysisController {

    @Autowired
    private AnalysisService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
//        ModelAndView modelAndView = new ModelAndView();
//        List<String> list = new ArrayList<String>();
//        list.add("start date");
//        list.add("finish date");
//        modelAndView.addObject("dates", list);
//        modelAndView.setViewName("index");

        return null;
    }

    @RequestMapping(value = "/tpop", method = RequestMethod.GET)
    public ModelAndView ticketPopularityController(@RequestParam(name = "sdate", required = true) String sDate,
                                                   @RequestParam(value = "fdate", required = true) String fDate) {

        List<String> lists = service.ticketPopularity(sDate, fDate);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sdate", sDate);
        modelAndView.addObject("fdate", fDate);
        modelAndView.addObject("lists", lists);
        modelAndView.setViewName("ticketpop");

        return modelAndView;
    }

    @RequestMapping(value = "/tact", method = RequestMethod.GET)
    public ModelAndView activeTicketsController() {
        List<Ticket> tickets = service.activeTickets();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tickets", tickets);
        modelAndView.setViewName("active_tickets");

        return modelAndView;
    }

    @RequestMapping(value = "/upop", method = RequestMethod.GET)
    public ModelAndView undergroundLoadController(@RequestParam(name = "date", required = true) String date) {
        List<String> load = service.loadAnalysis(date);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("date", date);
        modelAndView.addObject("lists", load);
        modelAndView.setViewName("ug_load");

        return modelAndView;
    }

    @RequestMapping(value = "/spop", method = RequestMethod.GET)
    public ModelAndView stationPopularityController(@RequestParam(name = "sdate", required = true) String sDate,
                                                    @RequestParam(value = "fdate", required = true) String fDate) {
        List<String> list = service.stationPopularity(sDate,fDate);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sdate", sDate);
        modelAndView.addObject("fdate", fDate);
        modelAndView.addObject("lists", list);
        modelAndView.setViewName("stations_popularity");

        return modelAndView;
    }
}
