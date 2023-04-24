package com.example.domain;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.io.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Table implements Serializable {
	private int tableId;
	private int numbers;

	private ConcurrentHashMap timeslot;

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

	public ConcurrentHashMap getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(ConcurrentHashMap timeslot) {
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


		Date date = DateUtil.date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");// 设置日期格式
		Date now = new Date();
		String today = sdf1.format(now);
		String startTime = "9:30am";
		String endTime = "1:30am";
		String beginDate = today + " " + startTime;
		String endDate = today + " " + endTime;
		String strDateFormat = "dd-MM-yyyy hh:mmaa";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date1 = new SimpleDateFormat(strDateFormat, Locale.ENGLISH).parse(beginDate);
			Date date2 = new SimpleDateFormat(strDateFormat, Locale.ENGLISH).parse(endDate);
			long between = DateUtil.between(date1, date2, DateUnit.HOUR);
			System.out.println(between + "");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("===");

	}
}
