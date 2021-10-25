package com.ss.utopia.menu;

import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		System.out.println("Welcome to the Utopia Airlines Management System. Which category of a user are you?");
		System.out.println("1) Employee/Agent");
		System.out.println("2) Administrator");
		System.out.println("3) Traveler");
		System.out.println("4) Quit");
		
		try(Scanner sc = new Scanner(System.in)){
			int choice = sc.nextInt();
			
			if (choice < 1 || choice > 4) {
				System.out.println("Not valid. Try again");
			}
			
			switch (choice) {
				case 1:
					break;
					
				case 2: AdminMenu.menu();
					break;
				
				case 3:
					break;
					
				case 4: return;
			}
		}
		
		
		
	}

}
