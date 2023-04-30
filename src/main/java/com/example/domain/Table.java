package com.example.domain;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Table implements Serializable {

	@Expose (serialize = true, deserialize = false)
	private int numbers;

	@Expose (serialize = true, deserialize = false)
	private int tableId;

	@Expose (serialize = true, deserialize = false)
	private String[] timeslots=new String[]{"9:00am","9:15am","9:30am","9:45am","10:00am","10:15am","10:30am","10:45am","11:00am","11:15am","11:30am","11:45am","12:00pm"};


	private boolean booked;

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

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}

	public  List<Table> init(){
		List<Table> tableList = new ArrayList<Table>();

		Table table_one=new Table();
		table_one.setTableId(1);
		table_one.setBooked(false);
		table_one.setNumbers(2);
		tableList.add(table_one);
		
		Table table_two=new Table();
		table_two.setTableId(2);
		table_one.setBooked(false);
		table_two.setNumbers(2);
		tableList.add(table_two);


		Table table_three=new Table();
		table_three.setTableId(3);
		table_three.setNumbers(4);
		table_one.setBooked(false);
		tableList.add(table_three);


		Table table_four=new Table();
		table_four.setTableId(4);
		table_four.setNumbers(6);
		table_one.setBooked(false);
		tableList.add(table_four);

		return tableList;

	}
//	public static void main(String args[]) {
//
//		
//	}

	/**
	 * *
	 * @param tableList
	 * @return
	 */
	public static List getBookedTimeSlots(List<Table> tableList){

		if(!tableList.isEmpty()) {
			for (int i = 0; i < tableList.size(); i++) {
				Table table_value = tableList.get(i);
				String[] timeslots = table_value.getTimeslots();
				for (int j = 0; j <= timeslots.length - 1; j++) {
					if (timeslots[j].split(":").length < 3) {
						timeslots[j] = timeslots[j].substring(0);

					} else {
						timeslots[j] = "";
					}
					timeslots = Arrays.stream(timeslots)
							.filter(s -> s != null && s.length() > 0)
							.toArray(String[]::new);

					table_value.setTimeslots(timeslots);
				}
			}
		}

		return tableList;
	}

	/**
	 **
	 * @param tableList
	 * @param table
	 * @return
	 */
	public static  boolean checkAvailableTable(List<Table> tableList,Table table){

		if(!tableList.isEmpty()) {
			for (int i = 0; i < tableList.size(); i++) {
				Table table_value = tableList.get(i);
				if (table_value.numbers >= table.getNumbers()) {
					return true;
				}
			}
		}
		return false;
	}


	/**
	 * *
	 * @param tableList
	 * @param slot
	 * @param times
	 * @param userId
	 * @param table
	 * @return
	 */
	public static boolean setAvailableTable(List<Table> tableList,String slot,int times,String userId,Table table){

		if(!tableList.isEmpty()) {
			for (int i = 0; i < tableList.size(); i++) {
				boolean flag = false;
				Table table_value = tableList.get(i);
				if (table_value.isBooked() != true) {
					if (table.getNumbers() <= table_value.numbers) {
						String[] timeslots = table_value.getTimeslots();
						for (int j = 0; j <= timeslots.length - 1; j++) {
							if (timeslots[j].equals(slot)) {
								table_value.setBooked(true);
								timeslots[j] += ":" + userId;
								flag = true;
								times--;
							} else if (flag && times != 0) {
								timeslots[j] += ":" + userId;
								times--;
								if (times == 0) flag = false;
							}
						}
						break;
					}
				}
			}
			return true;
		}else{
			return false;
		}
	}
}
