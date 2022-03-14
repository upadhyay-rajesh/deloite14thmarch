package com.facebook;

import java.util.Scanner;

public class FacebookView {

	public static void main(String[] args) {
		
		String ss="y";
		
		while(ss.equals("y")) {
		
		System.out.println("********************MAIN MENU****************");
		System.out.println("press 1 to create profile");
		System.out.println("press 2 to view profile");
		System.out.println("press 3 to delete profile");
		System.out.println("press 4 to search profile");
		System.out.println("press 5 to view all profile");
		System.out.println("press 6 to edit profile");

		Scanner sc = new Scanner(System.in);
		System.out.println("enter your choice");
		int ch = sc.nextInt();

		switch (ch) {
		case 1:
			System.out.println("profile created");
			break;
		case 2:
			System.out.println("profile viewed");
			break;
		case 3:
			System.out.println("profile deleted");
			break;
		case 4:
			System.out.println("profile searched");
			break;
		case 5:
			System.out.println("all profile viewed");
			break;
		case 6:
			System.out.println("profile edited");
			break;
		default:
			System.out.println("wrong choice");

		}
		System.out.println("do you want to continue press y/n");
		ss=sc.next();
		}

	}

}
