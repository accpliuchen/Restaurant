package com.example.domain;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Table implements Serializable {

    @Expose(serialize = true, deserialize = false)
    private int tableId;

    @Expose(serialize = true, deserialize = false)
    private int numbers;

    @Expose(serialize = true, deserialize = false)
    private String[] timeslots = new String[]{"9:00am", "9:15am", "9:30am", "9:45am", "10:00am", "10:15am", "10:30am", "10:45am", "11:00am", "11:15am", "11:30am", "11:45am", "12:00pm"};


    public String[] getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(String[] timeslots) {
        this.timeslots = timeslots;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }


    public List<Table> init() {
        List<Table> tableList = new ArrayList<Table>();

        Table table_one = new Table();
        table_one.setTableId(1);
        table_one.setNumbers(2);
        tableList.add(table_one);

        Table table_two = new Table();
        table_two.setTableId(2);
        table_two.setNumbers(2);
        tableList.add(table_two);


        Table table_three = new Table();
        table_three.setTableId(3);
        table_three.setNumbers(4);
        tableList.add(table_three);


        Table table_four = new Table();
        table_four.setTableId(4);
        table_four.setNumbers(6);
        tableList.add(table_four);

        return tableList;

    }

    public static void main(String args[]) {
        
    }


    /**
     * *
     *
     * @param tableList
     * @return
     */
    public static synchronized List getBookedTimeSlots(List<Table> tableList) {

        List<Table> clonedList = new ArrayList<Table>();

        if (!tableList.isEmpty()) {
            for (int i = 0; i < tableList.size(); i++) {
                Table table_value = tableList.get(i);

                Table newTable_Value = new Table();

                newTable_Value.setTableId(table_value.getTableId());
                newTable_Value.setNumbers(table_value.getNumbers());

                String[] timeslotsArray = new String[table_value.getTimeslots().length];
                for (int j = 0; j <= table_value.getTimeslots().length - 1; j++) {
                    timeslotsArray[j] = table_value.getTimeslots()[j];
                }
                newTable_Value.setTimeslots(timeslotsArray);

                String[] timeslots = newTable_Value.getTimeslots();

                for (int j = 0; j <= timeslots.length - 1; j++) {

                    if (timeslots[j].split(":").length == 3) {
                        timeslots[j] = timeslots[j].substring(0);

                    } else {
                        timeslots[j] = "";
                    }

                }

                timeslots = Arrays.stream(timeslots)
                        .filter(s -> s != null && s.length() > 0)
                        .toArray(String[]::new);

                newTable_Value.setTimeslots(timeslots);

                clonedList.add(newTable_Value);
            }
        }

        return clonedList;
    }

    /**
     * *
     *
     * @param tableList
     * @return
     */

    public static synchronized List getAvailableTimeSlots(List<Table> tableList) {
        List<Table> clonedList = new ArrayList<Table>();

        if (!tableList.isEmpty()) {
            for (int i = 0; i < tableList.size(); i++) {
                Table table_value = tableList.get(i);
                Table newTable_Value = new Table();

                newTable_Value.setTableId(table_value.getTableId());
                newTable_Value.setNumbers(table_value.getNumbers());

                String[] timeslotsArray = new String[table_value.getTimeslots().length];
                for (int j = 0; j <= table_value.getTimeslots().length - 1; j++) {
                    timeslotsArray[j] = table_value.getTimeslots()[j];
                }
                newTable_Value.setTimeslots(timeslotsArray);

                String[] timeslots = newTable_Value.getTimeslots();
                for (int j = 0; j <= timeslots.length - 1; j++) {
                    if (timeslots[j].split(":").length < 3) {
                        timeslots[j] = timeslots[j].substring(0);

                    } else {
                        timeslots[j] = "";
                    }

                }

                timeslots = Arrays.stream(timeslots)
                        .filter(s -> s != null && s.length() > 0)
                        .toArray(String[]::new);

                newTable_Value.setTimeslots(timeslots);

                clonedList.add(newTable_Value);
            }
        }

        return clonedList;
    }

    public static synchronized boolean checkTime(String slot) {
         int time=Integer.parseInt(slot.split(":")[0]);
         if(time<9 || time>12){
             return false;
         }
         return true;
    }

    /**
     * *
     *
     * @param tableList
     * @param table
     * @return
     */
    public static synchronized boolean checkAvailableTable(List<Table> tableList, Table table) {

        if (!tableList.isEmpty()) {
            for (int i = 0; i < tableList.size(); i++) {
                Table table_value = tableList.get(i);
                if (table_value.numbers >= table.getNumbers() && table.getTableId()==table_value.getTableId()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * *
     *
     * @param table
     * @param slot
     * @param times
     * @return
     */
    public static synchronized boolean checkAvailableTableTimes(Table table, String slot, int times) {
        String[] timeslots = table.getTimeslots();
        boolean flag = false;
        for (int j = 0; j <= timeslots.length - 1; j++) {

            if (timeslots[j].equals(slot) || (timeslots[j].split(":")[0] + ":" + timeslots[j].split(":")[1]).equals(slot)) {
                flag = true;
            }
            if (flag) {
                if (timeslots[j].split(":").length == 3 && times != 0) {
                    return false;
                }

                times--;
            }
            if (times == 0) return true;

        }

        return true;

    }

    /**
     * * 
     * @param tableList
     * @param table
     * @return
     */
    public static synchronized boolean checkDuplicateTables(List<Table> tableList, Table table){

        for (Table tables : tableList) 
        {
           if(tables.getTableId()==table.getTableId()){
            return false;
           }
        }

        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public static synchronized boolean addTables(List<Table> tableList, Table table){
        return tableList.add(table);
    }

    /**
     * *
     *
     * @param tableList
     * @param slot
     * @param times
     * @param userId
     * @param table
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public static synchronized boolean setAvailableTable(List<Table> tableList, String slot, int times, String userId, Table table) {

        if (!tableList.isEmpty()) {
            for (int i = 0; i < tableList.size(); i++) {
                boolean flag = false;
                Table table_value = tableList.get(i);
                if (table.getNumbers() <= table_value.numbers && table.getTableId()==table_value.getTableId()) {
                    //checked existed booked
                    if (checkAvailableTableTimes(table_value, slot, times)) {
                        String[] timeslots = table_value.getTimeslots();
                        for (int j = 0; j <= timeslots.length - 1; j++) {
                            if (timeslots[j].equals(slot) && timeslots[j].split(":").length == 2) {

                                timeslots[j] += ":" + userId;
                                flag = true;
                                times--;
                            } else if (flag && times != 0) {
                                timeslots[j] += ":" + userId;
                                times--;
                                if (times == 0) flag = false;
                            }
                        }

                    } else {
                        return false;
                    }
                    break;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
