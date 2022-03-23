package com.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("a2")
public class Trainees {
	
	@Autowired
	TrainerInterface tt;
	
	/*
	 * @Autowired will do following 3 task automatically
	 * 1. will create setter method
	 * 2. from abc.xml <property> tag not required
	 * 3. we have to enable annotation in abc.xml file as <ctx:annotation-config />
	 */
		
	//adapter
/*	public void setTt(TrainerInterface tt) {
		this.tt = tt;
	}
*/
	public void display() {
		tt.teach();
	}

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("abc.xml");
		
		Trainees t=(Trainees)ctx.getBean("a2");
		
		//TrainerInterface t1=new  Trainer();
		//t.setTt(t1); //dependency injenction
		
		t.display();

	}

}
