package com.example.controller;

import com.example.domain.Table;
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
import java.util.stream.Collectors;

@RestController
public class ReservationController {

    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

    private List<Table> tableList = new ArrayList<Table>();

    public ReservationController(){
        Table table=new Table();
        table.setTableId(1);
        table.setNumbers(2);
        tableList.add(table);
    }

    @RequestMapping(value = "/getAvailableSlots", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<String> getAvailableSlots() {
        return new ResponseEntity(tableList, HttpStatus.OK);
    }


    @RequestMapping(value = "/getBookedTimeSlots", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<String> getBookedTimeSlots() {
        return ResponseEntity.ok("Hello World!");
    }


    @RequestMapping(value = "/bookRequest", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<String> bookRequest() {
        return ResponseEntity.ok("Hello World!");
    }


//    @RequestMapping(value = "/getAvailableSlots", method = { RequestMethod.GET, RequestMethod.POST })
//    public ResponseEntity<String> getAvailableSlots(@RequestParam("durationInMinutes") int durationInMinutes) {
//        return ResponseEntity.ok("Hello World!");
//    }
}
