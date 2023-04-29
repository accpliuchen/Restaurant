package com.example.controller;

import com.example.domain.Table;
import com.example.repository.TutorialRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.ArrayList;

@RestController
public class ReservationController {

    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

    private List<Table> tableList = new ArrayList<Table>();

    @Autowired
    private TutorialRepository tutorialRepository;

    public ReservationController(){
        Table table=new Table();
        tableList=table.init();
    }

    @RequestMapping(value = "/getAvailableSlots", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<String> getAvailableSlots() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(tableList);
        return new ResponseEntity(json, HttpStatus.OK);
    }


    @RequestMapping(value = "/getBookedTimeSlots", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<String> getBookedTimeSlots() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(tableList);
        return new ResponseEntity(json, HttpStatus.OK);
    }


    @RequestMapping(value = "/bookRequest", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<String> bookRequest(@RequestParam String userId,@RequestParam int numbers,@RequestParam String slot,@RequestParam int duration) {
        Table table=new Table();
        table.setNumbers(numbers);
        boolean result=table.checkAvailableTable(tableList,table);

        if(result){
            int dur=60/15;
            boolean isAvailable=table.setAvailableTable(tableList,slot,dur ,userId,table);
            return new ResponseEntity(isAvailable, HttpStatus.OK);
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

}