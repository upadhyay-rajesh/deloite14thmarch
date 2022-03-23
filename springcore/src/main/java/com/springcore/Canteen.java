package com.springcore;

import org.springframework.stereotype.Component;

@Component
public class Canteen implements CanteenInterface{

	public void prepareFood() {
		// TODO Auto-generated method stub
		System.out.println("food is ready");
	}

}
