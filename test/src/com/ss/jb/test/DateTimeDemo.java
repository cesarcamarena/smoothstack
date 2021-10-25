package com.ss.jb.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

public class DateTimeDemo {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		
		LocalDate indiaDate = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		System.out.println(indiaDate);
		LocalTime indiaTime = LocalTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println(indiaTime);
		//mm-dd-yyyy/dd-mm-yyyy
	}

}
