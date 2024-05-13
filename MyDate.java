package com.atguigu.myapi;

import java.util.Date;

public class MyDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println(date);
		Date date2 = new Date(1000L);
		System.out.println(date2);
		Date date3 = new Date();
		date3.setTime(1000L);
		System.out.println(date3.getTime());
	}

}
