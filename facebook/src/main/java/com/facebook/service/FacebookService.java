package com.facebook.service;

import com.facebook.dao.FacebookDAO;
import com.facebook.entity.FacebookUser;

public class FacebookService {
	public int createProfileService(FacebookUser fb) {
		
		FacebookDAO fd=new FacebookDAO();
		int i=fd.createProfileDAO(fb);
		return i;
	}
}
