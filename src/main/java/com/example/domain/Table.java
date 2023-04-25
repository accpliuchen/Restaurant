package com.example.domain;

import java.io.*;

import java.text.ParseException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Table implements Serializable {

	private int tableId;
	private int numbers;

	private Map timeslot;

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

	public Map getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(Map timeslot) {
		this.timeslot = timeslot;
	}

	public static void main(String args[]) throws ParseException {
//		String startTime="9:30";
//		String endTime="10:30pm";
//
////		String beginTime = "2018-07-28 14:42:32";
////
////		String endTime = "2018-07-29 12:26:32";
//
////		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//
//		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
//
////		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
////		Date startDate=sdf.parse(sdformat.format(new Date())+" " +startTime);
////		Date endDate=sdf.parse(sdformat.format(new Date())+" "+ endTime);
//
//
//		//System.out.println(DateUtil.between(startDate,endDate, DateUnit.HOUR));
//
//		Date now = new Date();
//
//		Date afterDate = new Date(now.getTime() + 300000);
//		System.out.println(sdf.format(afterDate ));
//
////	    if(startDate.before(endDate) && endDate.after(startDate)){
////	    	System.out.println("Over");
////	    }


//		Date date = DateUtil.date();
//		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");// 设置日期格式
//		Date now = new Date();
//		String today = sdf1.format(now);
//		String startTime = "9:30am";
//		String endTime = "1:30am";
//		String beginDate = today + " " + startTime;
//		String endDate = today + " " + endTime;
//		String strDateFormat = "dd-MM-yyyy hh:mmaa";
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		try {
//			Date date1 = new SimpleDateFormat(strDateFormat, Locale.ENGLISH).parse(beginDate);
//			Date date2 = new SimpleDateFormat(strDateFormat, Locale.ENGLISH).parse(endDate);
//			long between = DateUtil.between(date1, date2, DateUnit.HOUR);
//			System.out.println(between + "");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		System.out.println("===");

		List<Table> tableList = new ArrayList<Table>();

		Map<String, Integer> timeslots;

		Table table=new Table();
		table.setTableId(1);
		table.setNumbers(2);

		Map<String, String> timesLots = new ConcurrentHashMap<String,String>();
		timesLots.put("9:00am","");
		timesLots.put("9:15am","");
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

		table=new Table();

		table.setTableId(2);
		table.setNumbers(2);

		timesLots = new ConcurrentHashMap<String,String>();
		timesLots.put("9:00am","");
		timesLots.put("9:15am","");
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

		table=new Table();
		table.setTableId(3);
		table.setNumbers(4);

		timeslots = new ConcurrentHashMap<String,Integer>();
		timeslots.put("9:00am",0);
		timeslots.put("9:15am",1);
		timeslots.put("9:30am",2);
		timeslots.put("9:45am",3);
		timeslots.put("10:00am",4);
		timeslots.put("10:15am",5);
		timeslots.put("10:30am",6);
		timeslots.put("10:45am",7);
		timeslots.put("11:00am",8);
		timeslots.put("11:15am",9);
		timeslots.put("11:30am",10);
		timeslots.put("11:45am",11);
		timeslots.put("12:00pm",12);


//		List<String> values = new ArrayList<>(timeslots.keySet());
//		Collections.sort(values, new Comparator<String>() {
//			public int compare(String a, String b) {
//				// no need to worry about nulls as we know a and b are both in pl
//				return timeslots.get(a) - timeslots.get(b);
//			}
//		});
//
//		for(String val : values) {
//			System.out.println(val + "," + timeslots.get(val));
//		}

		table.setTimeslot(timeslots);
		tableList.add(table);

		table=new Table();
		table.setTableId(4);
		table.setNumbers(6);

		timesLots = new ConcurrentHashMap<String,String>();
		timesLots.put("9:00am","");
		timesLots.put("9:15am","");
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

//		for (int i = 0; i < tableList.size(); i++) {
//			for (Object key : tableList.get(3).getTimeslot().keySet()) {
//				if(timesLots.get(key).equals(""))
//					System.out.println(key + " : " + timesLots.get(key));
//			}
//
//			System.out.println("===");
//		}
		Table tables=new Table();
		tables.setNumbers(3);
		String slot="9:30am";
		int duration=60;



		//System.out.println(checkAvailableTable(tableList,tables,slot,duration,"A"));

		System.out.println(setAvailableTable(timeslots,slot,duration,"A"));
	}


//	public static  boolean checkAvailableTable(List<Table> tableList,Table table,String slot,int duration,String userId){
//		for (int i = tableList.size()-1; i >=0 ; i--) {
//			Table tEntitty=tableList.get(2);
//			for (Object key : tableList.get(i).getTimeslot().keySet()) {
//				//
//				if (!tableList.get(i).getTimeslot().get(key).equals("")  || Math.abs(table.getNumbers()-tEntitty.getNumbers())<=1) {
//					return false;
//				}else if (key.equals(slot)){
//					while(duration>=0){
//						System.out.println("key "+ key+" value "+tableList.get(i).getTimeslot().get(key));
//						tableList.get(i).getTimeslot().put(key,userId);
//						duration=duration-15;
//					}
//				}
//
//			}
//		}
//		return true;
//	}

	public static  boolean checkAvailableTable(List<Table> tableList,Table table,String slot,int duration,String userId){
		int pivot=duration/15;

		for (int i = 0; i <tableList.size(); i++) {

			Table tEntitty=tableList.get(i);

			if(tEntitty.numbers>table.getNumbers()){
				//System.out.println(tEntitty.numbers);
				for (Object key : tableList.get(i).getTimeslot().keySet()){
					if(pivot!=0){
//						if (key.equals(slot)){
//							pivot=duration/15;
//						}


						pivot--;

					}
				}

			}

		}
		return false;
	}


	public static boolean setAvailableTable(Map<String, Integer> timeslots,String slot,int duration,String userId){

		List<String> values = new ArrayList<>(timeslots.keySet());
		Collections.sort(values, new Comparator<String>() {
			public int compare(String a, String b) {
				// no need to worry about nulls as we know a and b are both in pl
				return timeslots.get(a) - timeslots.get(b);
			}
		});


//		for(String val : values) {
//			if(val.equals(slot)) {
//				//while(duration>=0) {
//					System.out.println(val + "," + val+userId);
//					timeslots.put(val,timeslots.get(val)+userId);
//					duration=duration-15;
//				//}
//			}
//		}

		return true;
	}
}
