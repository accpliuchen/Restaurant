package com.example.controller;

import com.example.domain.Table;
import com.example.domain.Tutorial;
import com.example.repository.TutorialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@RestController
public class ReservationController {

    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

    private List<Table> tableList = new ArrayList<Table>();

    @Autowired
    private TutorialRepository tutorialRepository;

    public ReservationController(){
        Table table=new Table();
        table.setTableId(1);
        table.setNumbers(2);

        ConcurrentHashMap<String, String> timesLots = new ConcurrentHashMap<>();
        timesLots.put("9:00am","A");
        timesLots.put("9:15am","B");
        timesLots.put("9:30am","");
        timesLots.put("9:45am","");
        timesLots.put("10:00am","");
        timesLots.put("10:15am","");
        timesLots.put("10:30am","");
        timesLots.put("10:45am","");
        timesLots.put("11:00am","");
        timesLots.put("11:15am","");
        timesLots.put("11:30am","");
        timesLots.put("11:45am","");
        timesLots.put("12:00pm","");
        

        table.setTimeslot(timesLots);
        tableList.add(table);

        table.setTableId(2);
        table.setNumbers(2);
        tableList.add(table);

        table.setTableId(3);
        table.setNumbers(4);
        tableList.add(table);

        table.setTableId(4);
        table.setNumbers(6);
        tableList.add(table);
    }

    @RequestMapping(value = "/getAvailableSlots", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<String> getAvailableSlots() {
//        tutorialRepository.save(new Tutorial("aaa", "cccc", false));
        return new ResponseEntity(tableList, HttpStatus.OK);
    }


    @RequestMapping(value = "/getBookedTimeSlots", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<String> getBookedTimeSlots() {
        return new ResponseEntity(tableList, HttpStatus.OK);
    }


    @RequestMapping(value = "/bookRequest", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<String> bookRequest(@RequestParam String userId,@RequestParam int numbers,@RequestParam String slot,@RequestParam int duration) {


        return ResponseEntity.ok("bookRequest Hello World!"+numbers);
    }


//    @RequestMapping(value = "/getAvailableSlots", method = { RequestMethod.GET, RequestMethod.POST })
//    public ResponseEntity<String> getAvailableSlots(@RequestParam("durationInMinutes") int durationInMinutes) {
//        return ResponseEntity.ok("Hello World!");
//    }
}
