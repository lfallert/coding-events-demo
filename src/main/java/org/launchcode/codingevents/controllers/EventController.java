package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

    private static List<Event> events = new ArrayList<>();

//    @GetMapping
//    public String displayAllEvents(Model model) {
//        model.addAttribute("title", "All Events");
//        model.addAttribute("events", events);
//        return "events/index";
//    }

    @GetMapping
    public String displayAllEvents(Model model) {
        Map<String, String> eventsMap = new HashMap<>();
        eventsMap.put("Strange Loop", "Cool STL Tech conference");
        eventsMap.put("Code with Pride", "LC event for the LGBTQ+ community");
        eventsMap.put("CoderGirl", "Cool thing where Mike plays weird music");
        model.addAttribute("events", eventsMap);
        return "events/index";

    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName, @RequestParam String eventDescription) {
        events.add(new Event(eventName, eventDescription));
        return "redirect:";
    }

}
