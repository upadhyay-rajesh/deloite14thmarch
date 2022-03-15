package com.instagram.view;

import java.util.Scanner;

import com.instagram.controller.InstagramController;
import com.instagram.controller.InstagramControllerInterface;

public class InstagramView {

	public static void main(String[] args) {
		String ss="y";
		
		while(ss.equals("y")) {
		System.out.println("*******************MAIN MENU**********");
		System.out.println("press 1 to create profile");
		System.out.println("press 2 to view profile");
		System.out.println("press 3 to view all profile");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter choice");
		int ch=sc.nextInt();
		
		InstagramControllerInterface ic=new InstagramController();
		
		switch(ch) {
		case 1: ic.createProfileController();
			break;
		case 2: ic.vieweProfileController();
		break;
		case 3: ic.vieweAllProfileController();
		break;
			default:System.out.println("wrong choice");
		}
		System.out.println("continue press y/n");
		ss=sc.next();
		}
		
		

	}

}
