package com.springcore;

import org.springframework.stereotype.Component;

@Component
public class Trainer implements TrainerInterface{

	public void teach() {
		System.out.println("Trainer is teaching");
		
	}

}
