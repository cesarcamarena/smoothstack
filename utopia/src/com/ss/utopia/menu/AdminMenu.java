package com.ss.utopia.menu;

import java.sql.Timestamp;
import java.util.Scanner;

import com.ss.utopia.entity.Flight;

public class AdminMenu {

	public static void menu() {
		System.out.println("1) Add/Update/Delete/Read Flights");
		System.out.println("2) Add/Update/Delete/Read Seats");
		System.out.println("3) Add/Update/Delete/Read Tickets and Passengers");
		System.out.println("4) Add/Update/Delete/Read Airports");
		System.out.println("5) Add/Update/Delete/Read Travelers");
		System.out.println("6) Add/Update/Delete/Read Employees");
		System.out.println("7) Over-ride Trip Cancellation for a ticket");
		System.out.println("8) Exit");
		
		try (Scanner sc = new Scanner(System.in)) {
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1: flightMenu();
					break;
				case 2: seatMenu();
					break;
				case 3: ticketMenu();
					break;
				case 4: airportMenu();
					break;
				case 5: travelerMenu();
					break;
				case 6: employeeMenu();
					break;
				case 7: overrideMenu();
					break;
				case 8: MainMenu.menu();
			}
		}
	}
	
	private static void flightMenu() {
		System.out.println("1) Add Flight");
		System.out.println("2) Update Flight");
		System.out.println("3) Delete Flight");
		System.out.println("4) Read Flights");
		
		Flight f = new Flight();
		
		try (Scanner sc = new Scanner(System.in)){
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					System.out.print("Route ID: ");
					int route_id = sc.nextInt();
					f.setRoute_id(route_id);
					System.out.print("Departure Time: ");
					
					
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
			}
		}
	}
	
	private static void seatMenu() {
		
	}
	
	private static void ticketMenu() {
		
	}
	
	private static void airportMenu() {
		
	}
	
	private static void travelerMenu() {
		
	}
	
	private static void employeeMenu() {
		
	}
	
	private static void overrideMenu() {
		
	}
}
