package com.facebookweb.service;

import com.facebookweb.dao.FacebookDAO;
import com.facebookweb.dao.FacebookDAOInterface;
import com.facebookweb.entity.FacebookUser;

public class FacebookService implements FacebookServiceInterface {

	@Override
	public int createProfileService(FacebookUser fb) {
		FacebookDAOInterface fd=new FacebookDAO();
		return fd.createProfileDAO(fb);
	}

	@Override
	public boolean checkLoginService(FacebookUser fb) {
		FacebookDAOInterface fd=new FacebookDAO();
		return fd.loginDAO(fb);
	}

}
