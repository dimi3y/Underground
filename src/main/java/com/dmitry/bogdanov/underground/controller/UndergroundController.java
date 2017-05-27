package com.dmitry.bogdanov.underground.controller;

import com.dmitry.bogdanov.underground.entity.Passage;
import com.dmitry.bogdanov.underground.entity.Ticket;
import com.dmitry.bogdanov.underground.entity.UndergroundUser;
import com.dmitry.bogdanov.underground.service.UndergroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.*;
import java.util.List;

@RestController
public class UndergroundController {

    @Autowired
    private UndergroundService service;

    //@RequestMapping(value = )

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView loginPage(@ModelAttribute("message") String message) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new UndergroundUser("login", "password"));
        modelAndView.addObject("message", message.equals("") ?
                "Enter your login and password to sign in" : message);
        modelAndView.setViewName("login");

        return modelAndView;
    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public ModelAndView mainPage(@ModelAttribute("user") UndergroundUser user) {
        String roleOrError = service.checkUser(user);
        ModelAndView modelAndView = new ModelAndView();

        switch (roleOrError) {
            case "ADMIN":
                modelAndView.addObject("message", "Welcome, " + user.getUserLogin());
                modelAndView.addObject("users", service.getAllUsers());
                modelAndView.addObject("user", user);
                modelAndView.addObject("types", service.getUserTypes());
                modelAndView.setViewName("admin_index");
                break;
            case "OPERATOR":
                modelAndView.addObject("message", "Welcome, " + user.getUserLogin());
                modelAndView.setViewName("operator_index");
                break;
            case "USER":
                modelAndView.addObject("message", "Welcome, " + user.getUserLogin());
                modelAndView.setViewName("user_index");
                break;
            default:
                modelAndView.addObject("user", user);
                modelAndView.addObject("message", roleOrError + ", please try again");
                modelAndView.setViewName("login");
                break;
        }


        return modelAndView;
    }

    @RequestMapping(value = "/usrview", method = RequestMethod.GET)
    public ModelAndView userView(@RequestParam(name = "edit_id", required = true) long id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cuser", id != 0 ? service.getUser(id) : new UndergroundUser("login", "password", 0));
//        modelAndView.addObject("user", user);
        modelAndView.setViewName("user_view");
//        modelAndView.addObject("ms", message.equals("") ?
//                "Enter your login and password to sign in" : message);
//        modelAndView.setViewName("edit_user");

        return modelAndView;
    }

    @RequestMapping(value = "/usredit", method = RequestMethod.POST)
    public ModelAndView userEdit(@ModelAttribute("cuser") UndergroundUser cuser) {

        service.updUser(cuser);
        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("user", user);
//        modelAndView.addObject("cuser", cuser);
        modelAndView.setViewName("admin_index");
//        modelAndView.addObject("ms", message.equals("") ?
//                "Enter your login and password to sign in" : message);
//        modelAndView.setViewName("edit_user");
        return modelAndView;
    }

//    @RequestMapping(value = "/usr", method = RequestMethod.POST)
//    public ModelAndView addUser(@ModelAttribute("user") UndergroundUser user) {
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("user", user);
//        modelAndView.setViewName("edit_user");
////        modelAndView.addObject("ms", message.equals("") ?
////                "Enter your login and password to sign in" : message);
////        modelAndView.setViewName("edit_user");
//
//        return modelAndView;
//    }

    @RequestMapping(value = "/usr", method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam(name = "delete_id", required = true) long id) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", (service.deleteUser(id) ? "Deleted user with id = " :
                "Error deleting user with id = ") + id);
        modelAndView.addObject("users", service.getAllUsers());
        modelAndView.setViewName("admin_index");

        return modelAndView;
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

    @RequestMapping(value = "/upsg", method = RequestMethod.GET)
    public ModelAndView userTicketInformation(@RequestParam(name = "id", required = true) long id) {

        Ticket ticket = service.getTicketInfo(id);
        List<Passage> passages = service.getPassagesByTId(id);
        String t_type = service.getTicketType(ticket.getTicketTypeId());


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("passages", passages);
        modelAndView.addObject("ticket", ticket);
        modelAndView.setViewName("ticket_info");

        return modelAndView;
    }
}
