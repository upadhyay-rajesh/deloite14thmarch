package com.whatsappboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.whatsappboot.entity.WhatsappUser;
import com.whatsappboot.service.WhatsappServiceInterface;
//@Controller   //in case of B2C
@RestController   //in case of B2B
public class WhatsappController {
	
	
	
	@Autowired
	private WhatsappServiceInterface ws;
	
	@GetMapping("allProfile")
	public List<WhatsappUser> all(){
		return ws.viewAllProfileService();
	}
	
	
	@GetMapping("viewProfile/{id}")
	public WhatsappUser view(@PathVariable("id") String ss){
		WhatsappUser w=new WhatsappUser();
		w.setEmail(ss);
		return ws.viewProfileService(w);
	}
	
	@PostMapping("createProfile")
	public String registerUser(@RequestBody WhatsappUser wu) {
		int i=ws.createProfileService(wu);
		if(i>0) {
			return "Profile created";
		}
		else {
			return "could not create profile";
		}
	}
	
	@PutMapping("editProfile/{id}")
	public String edit(@PathVariable("id") String ss,@RequestBody WhatsappUser ww){
		
		
		ww.setEmail(ss);
		return ws.editProfileService(ww);
	}
	
	@DeleteMapping("deleteProfile/{id}")
	public String delete(@PathVariable("id") String ss){
		WhatsappUser w=new WhatsappUser();
		w.setEmail(ss);
		return ws.deleteProfileService(w);
	}
}









