package com.facebook.dao;

import com.facebook.entity.FacebookUser;

public class FacebookDAO {

	public int createProfileDAO(FacebookUser fb) {
		int i=0;
		if(fb.getName().equals("Rajesh")) {
			return i;
		}
		else {
			i=1;
			return i;
		}
		
	}

}
