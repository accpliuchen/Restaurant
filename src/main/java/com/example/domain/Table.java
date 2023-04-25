package com.example.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

class Entry{
	private String key;
	private String value;


	public Entry(String key,String value){
		this.key=key;
		this.value=value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

public class Table implements Serializable {

	private int numbers;

	private Map timeslot;

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public Map getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(Map timeslot) {
		this.timeslot = timeslot;
	}

	public  List<Table> init(){
		List<Table> tableList = new ArrayList<Table>();

		Map<Entry, Integer> timeslots;

		Table table_one=new Table();
		table_one.setNumbers(2);

		timeslots = new ConcurrentHashMap<Entry,Integer>();
		timeslots.put(new Entry("9:00am",""),0);
		timeslots.put(new Entry("9:15am",""),1);
		timeslots.put(new Entry("9:30am",""),2);
		timeslots.put(new Entry("9:45am",""),3);
		timeslots.put(new Entry("10:00am",""),4);
		timeslots.put(new Entry("10:15am",""),5);
		timeslots.put(new Entry("10:30am",""),6);
		timeslots.put(new Entry("10:45am",""),7);
		timeslots.put(new Entry("11:00am",""),8);
		timeslots.put(new Entry("11:15am",""),9);
		timeslots.put(new Entry("11:30am",""),10);
		timeslots.put(new Entry("11:45am",""),11);
		timeslots.put(new Entry("12:00pm",""),12);

		table_one.setTimeslot(timeslots);
		tableList.add(table_one);



		System.out.println("===========================");

		Table table_two=new Table();
		table_two.setNumbers(2);

		timeslots = new ConcurrentHashMap<Entry,Integer>();
		timeslots.put(new Entry("9:00am",""),0);
		timeslots.put(new Entry("9:15am",""),1);
		timeslots.put(new Entry("9:30am",""),2);
		timeslots.put(new Entry("9:45am",""),3);
		timeslots.put(new Entry("10:00am",""),4);
		timeslots.put(new Entry("10:15am",""),5);
		timeslots.put(new Entry("10:30am",""),6);
		timeslots.put(new Entry("10:45am",""),7);
		timeslots.put(new Entry("11:00am",""),8);
		timeslots.put(new Entry("11:15am",""),9);
		timeslots.put(new Entry("11:30am",""),10);
		timeslots.put(new Entry("11:45am",""),11);
		timeslots.put(new Entry("12:00pm",""),12);

		table_two.setTimeslot(timeslots);
		tableList.add(table_two);

		System.out.println("===========================");


		Table table_three=new Table();
		table_three.setNumbers(4);

		timeslots = new ConcurrentHashMap<Entry,Integer>();
		timeslots.put(new Entry("9:00am",""),0);
		timeslots.put(new Entry("9:15am",""),1);
		timeslots.put(new Entry("9:30am",""),2);
		timeslots.put(new Entry("9:45am",""),3);
		timeslots.put(new Entry("10:00am",""),4);
		timeslots.put(new Entry("10:15am",""),5);
		timeslots.put(new Entry("10:30am",""),6);
		timeslots.put(new Entry("10:45am",""),7);
		timeslots.put(new Entry("11:00am",""),8);
		timeslots.put(new Entry("11:15am",""),9);
		timeslots.put(new Entry("11:30am",""),10);
		timeslots.put(new Entry("11:45am",""),11);
		timeslots.put(new Entry("12:00pm",""),12);
		table_three.setTimeslot(timeslots);
		tableList.add(table_three);

		System.out.println("===========================");


		Table table_four=new Table();
		table_four.setNumbers(6);

		timeslots = new ConcurrentHashMap<Entry,Integer>();
		timeslots.put(new Entry("9:00am",""),0);
		timeslots.put(new Entry("9:15am",""),1);
		timeslots.put(new Entry("9:30am",""),2);
		timeslots.put(new Entry("9:45am",""),3);
		timeslots.put(new Entry("10:00am",""),4);
		timeslots.put(new Entry("10:15am",""),5);
		timeslots.put(new Entry("10:30am",""),6);
		timeslots.put(new Entry("10:45am",""),7);
		timeslots.put(new Entry("11:00am",""),8);
		timeslots.put(new Entry("11:15am",""),9);
		timeslots.put(new Entry("11:30am",""),10);
		timeslots.put(new Entry("11:45am",""),11);
		timeslots.put(new Entry("12:00pm",""),12);
		table_four.setTimeslot(timeslots);
		tableList.add(table_four);

		return tableList;

	}
	public static void main(String args[]) {

		List<Table> tableList = new ArrayList<Table>();

		Map<String, String> timeslots;

		Table table_one=new Table();
		table_one.setNumbers(2);

		timeslots = new ConcurrentHashMap<String, String>();
//		timeslots.put(new Entry("9:00am",""),0);
//		timeslots.put(new Entry("9:15am",""),1);
//		timeslots.put(new Entry("9:30am",""),2);
//		timeslots.put(new Entry("9:45am",""),3);
//		timeslots.put(new Entry("10:00am",""),4);
//		timeslots.put(new Entry("10:15am",""),5);
//		timeslots.put(new Entry("10:30am",""),6);
//		timeslots.put(new Entry("10:45am",""),7);
//		timeslots.put(new Entry("11:00am",""),8);
//		timeslots.put(new Entry("11:15am",""),9);
//		timeslots.put(new Entry("11:30am",""),10);
//		timeslots.put(new Entry("11:45am",""),11);
//		timeslots.put(new Entry("12:00pm",""),12);


		timeslots.put("9:00","");
		timeslots.put("9:15","");
		timeslots.put("9:30","");
		timeslots.put("9:45","");
		timeslots.put("10:00","");
		timeslots.put("10:15","");
		timeslots.put("10:30","");
		timeslots.put("10:45","");
		timeslots.put("11:00","");
		timeslots.put("11:15","");
		timeslots.put("11:30","");
		timeslots.put("11:45","");
		timeslots.put("12:00","");

		table_one.setTimeslot(timeslots);
		tableList.add(table_one);



//		System.out.println("===========================");
//
//		Table table_two=new Table();
//		table_two.setNumbers(2);
//
//		timeslots = new ConcurrentHashMap<Entry,Integer>();
//		timeslots.put(new Entry("9:00am",""),0);
//		timeslots.put(new Entry("9:15am",""),1);
//		timeslots.put(new Entry("9:30am",""),2);
//		timeslots.put(new Entry("9:45am",""),3);
//		timeslots.put(new Entry("10:00am",""),4);
//		timeslots.put(new Entry("10:15am",""),5);
//		timeslots.put(new Entry("10:30am",""),6);
//		timeslots.put(new Entry("10:45am",""),7);
//		timeslots.put(new Entry("11:00am",""),8);
//		timeslots.put(new Entry("11:15am",""),9);
//		timeslots.put(new Entry("11:30am",""),10);
//		timeslots.put(new Entry("11:45am",""),11);
//		timeslots.put(new Entry("12:00pm",""),12);
//
//		table_two.setTimeslot(timeslots);
//		tableList.add(table_two);
//
//		System.out.println("===========================");
//
//
//		Table table_three=new Table();
//		table_three.setNumbers(4);
//
//		timeslots = new ConcurrentHashMap<Entry,Integer>();
//		timeslots.put(new Entry("9:00am",""),0);
//		timeslots.put(new Entry("9:15am",""),1);
//		timeslots.put(new Entry("9:30am",""),2);
//		timeslots.put(new Entry("9:45am",""),3);
//		timeslots.put(new Entry("10:00am",""),4);
//		timeslots.put(new Entry("10:15am",""),5);
//		timeslots.put(new Entry("10:30am",""),6);
//		timeslots.put(new Entry("10:45am",""),7);
//		timeslots.put(new Entry("11:00am",""),8);
//		timeslots.put(new Entry("11:15am",""),9);
//		timeslots.put(new Entry("11:30am",""),10);
//		timeslots.put(new Entry("11:45am",""),11);
//		timeslots.put(new Entry("12:00pm",""),12);
//		table_three.setTimeslot(timeslots);
//		tableList.add(table_three);
//
//		System.out.println("===========================");
//
//
//		Table table_four=new Table();
//		table_four.setNumbers(6);
//
//		timeslots = new ConcurrentHashMap<Entry,Integer>();
//		timeslots.put(new Entry("9:00am",""),0);
//		timeslots.put(new Entry("9:15am",""),1);
//		timeslots.put(new Entry("9:30am",""),2);
//		timeslots.put(new Entry("9:45am",""),3);
//		timeslots.put(new Entry("10:00am",""),4);
//		timeslots.put(new Entry("10:15am",""),5);
//		timeslots.put(new Entry("10:30am",""),6);
//		timeslots.put(new Entry("10:45am",""),7);
//		timeslots.put(new Entry("11:00am",""),8);
//		timeslots.put(new Entry("11:15am",""),9);
//		timeslots.put(new Entry("11:30am",""),10);
//		timeslots.put(new Entry("11:45am",""),11);
//		timeslots.put(new Entry("12:00pm",""),12);
//		table_four.setTimeslot(timeslots);
//		tableList.add(table_four);


		ObjectMapper objectMapper = new ObjectMapper();

		try {
//			String json = objectMapper.writeValueAsString(tableList);
//			System.out.println(json);


			Gson gson = new Gson();
			String json = gson.toJson(tableList);
			System.out.println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}


		System.out.println("===========&&&&&&================");

		Table table_demo;
		table_demo=new Table();
		table_demo.setNumbers(3);
		System.out.println("==============1============"+checkAvailableTable(tableList,table_demo));
		System.out.println("==============one============"+setAvailableTable(tableList,"9:30am", 60/15,"A"));

		table_demo.setNumbers(2);
		System.out.println("==============2============"+checkAvailableTable(tableList,table_demo));

		table_demo.setNumbers(7);
		System.out.println("==============3============"+checkAvailableTable(tableList,table_demo));


		table_demo.setNumbers(2);
		System.out.println("==============4============"+checkAvailableTable(tableList,table_demo));

		System.out.println("===========================");
	}

	public static  boolean checkAvailableTable(List<Table> tableList,Table table){

		for (int i = 0; i <tableList.size(); i++) {
			Table tEntitty=tableList.get(i);

			if(tEntitty.numbers>table.getNumbers()) {
			    return true;
			}
		}
		return false;
	}


	public static boolean setAvailableTable(List<Table> tableList,String slot,int times,String userId){

		for (int i = 0; i <tableList.size(); i++) {

			List<Map.Entry<String, String>> list =
					new LinkedList<Map.Entry<String, String>>(tableList.get(i).getTimeslot().entrySet());
			boolean flag = false;

			// Sort the list
			Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
				public int compare(Map.Entry<String, String> o1,
								   Map.Entry<String, String> o2) {
					return (o1.getKey()).compareTo(o2.getKey());
				}
			});

			// put data from sorted list to hashmap
			HashMap<String, String> temp = new LinkedHashMap<String, String>();
			for (Map.Entry<String, String> entry : list) {

				//System.out.println(aa.getKey().getKey());
				if (entry.getKey().equals(slot)) {
					//System.out.println("find =="+entry.getKey().getKey()+"=="+ entry.getKey().getKey().equals(slot));
					entry.setValue(userId);
					flag = true;
					times--;
				} else if (flag && times != 0) {
					//System.out.println("duration==="+entry.getKey().getKey());
					entry.setValue(userId);
					times--;
					if (times == 0) flag = false;
				}

				temp.put(entry.getKey(), entry.getValue());
			}

		}
		return true;
	}
}
