package com.facebook.controller;

import java.util.Scanner;

import com.facebook.entity.FacebookUser;
import com.facebook.service.FacebookService;

//why controller , to take input(request) from user and to give output(response) to user
public class FacebookController {
	public void createProfile() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your name");
		String name=sc.next();
		
		System.out.println("enter your password");
		String password=sc.next();
		
		System.out.println("enter your email");
		String email=sc.next();
		
		System.out.println("enter your address");
		String address=sc.next();
		
		//controller want to pass data to service so how it should pass
		//via DTO(data transfer object) design pattern
		//if it will pass data in form of object then object of which class?
		//entity class
		
		FacebookUser fb=new FacebookUser();
		fb.setName(name);
		fb.setPassword(password);
		fb.setEmail(email);
		fb.setAddress(address);
		
		FacebookService fs=new FacebookService();
		int i=fs.createProfileService(fb);
		
		if(i>0) {
		
		System.out.println("profile created");
		}
		else {
			System.out.println("could not create profile");
		}
	}
	
	public void viewProfile() {
		System.out.println("profile viewed");
	}
	public void editProfile() {
		System.out.println("profile edited");
	}
	public void deleteProfile() {
		System.out.println("profile deleted");
	}
	public void searchProfile() {
		System.out.println("profile searched");
	}
	public void viewAllProfile() {
		System.out.println("all profile viewed");
	}
}
