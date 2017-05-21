package com.dmitry.bogdanov.underground.controller;

import com.dmitry.bogdanov.underground.entity.Station;
import com.dmitry.bogdanov.underground.entity.Ticket;
import com.dmitry.bogdanov.underground.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("station", new Station());
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @RequestMapping(value = "/tpop", method = RequestMethod.GET)
    public ModelAndView ticketPopularityController(@ModelAttribute("station") Station station) {
        List<String> lists = service.ticketPopularity("2016-05-19 14:49:40.724000",
                "2017-02-19 14:49:40.724000");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("lists", lists);
        modelAndView.setViewName("ticketpop");

        return modelAndView;
    }

    @RequestMapping(value = "/tact", method = RequestMethod.GET)
    public ModelAndView activeTicketsController(@ModelAttribute("station") Station station) {
        List<Ticket> tickets = service.activeTickets();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tickets", tickets);
        modelAndView.setViewName("active_tickets");

        return modelAndView;
    }

    @RequestMapping(value = "/upop", method = RequestMethod.GET)
    public ModelAndView undergroundLoadController() {
        service.loadAnalysis();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("lists", null);
        modelAndView.setViewName("ug_load");

        return modelAndView;
    }

    @RequestMapping(value = "/spop", method = RequestMethod.GET)
    public ModelAndView stationPopularityController(@ModelAttribute("station") Station station) {
        List<String> list = service.stationPopularity("2016-05-19 14:49:40.724000","2017-06-19 14:49:40.724000");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("lists", list);
        modelAndView.setViewName("stations_popularity");

        return modelAndView;
    }
}
