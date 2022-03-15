package com.instagram.controller;

import java.util.List;
import java.util.Scanner;

import com.instagram.entity.InstagramUser;
import com.instagram.service.InstagramService;
import com.instagram.service.InstagramServiceInterface;

public class InstagramController implements InstagramControllerInterface {

	public void createProfileController() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name");
		String name=sc.next();
		
		System.out.println("enter password");
		String password=sc.next();
		
		System.out.println("enter email");
		String email=sc.next();
		
		System.out.println("enter address");
		String address=sc.next();
		
		InstagramUser iu=new InstagramUser();
		iu.setName(name);
		iu.setPassword(password);
		iu.setEmail(email);
		iu.setAddress(address);
		
		InstagramServiceInterface is=new InstagramService();
		int i=is.createProfileService(iu);
		
		if(i>0) {
			System.out.println("profile created");
		}
		else {
			System.out.println("could not create profile");
		}

	}

	public void vieweProfileController() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email to view profile");
		String email=sc.next();
		
		InstagramUser iu=new InstagramUser();
		iu.setEmail(email);
		
		InstagramServiceInterface is=new InstagramService();
		InstagramUser w=is.viewProfileService(iu);
		
		if(w!=null) {
			System.out.println("Name is "+w.getName());
			System.out.println("Password is "+w.getPassword());
			System.out.println("Email is "+w.getEmail());
			System.out.println("Address is "+w.getAddress());
		}
	}

	public void vieweAllProfileController() {
		InstagramServiceInterface is=new InstagramService();
		List<InstagramUser> ll=is.viewAllProfileService();
		
		for(InstagramUser iu:ll) {
			System.out.println("**********************");
			System.out.println("Name is "+iu.getName());
			System.out.println("Password is "+iu.getPassword());
			System.out.println("Email is "+iu.getEmail());
			System.out.println("Address is "+iu.getAddress());
		}
		
		
		
	}

}











