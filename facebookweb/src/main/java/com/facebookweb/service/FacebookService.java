package com.facebookweb.service;

import java.util.List;

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

	@Override
	public FacebookUser viewProfileService(FacebookUser fb) {
		FacebookDAOInterface fd=new FacebookDAO();
		return fd.viewProfileDAO(fb);
	}

	@Override
	public List<FacebookUser> viewAllProfileService() {
		FacebookDAOInterface fd=new FacebookDAO();
		return fd.viewAllProfileDAO();
	}

	@Override
	public int editProfileService(FacebookUser fb) {
		FacebookDAOInterface fd=new FacebookDAO();
		return fd.editProfileDAO(fb);
	}

	@Override
	public int deleteProfileService(FacebookUser fb) {
		FacebookDAOInterface fd=new FacebookDAO();
		return fd.deleteProfileDAO(fb);
	}

}
