package com.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Trainees {
	
	TrainerInterface tt;
		
	//adapter
	public void setTt(TrainerInterface tt) {
		this.tt = tt;
	}

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
