package com.facebookweb.service;

import java.util.List;

import com.facebookweb.entity.FacebookUser;

public interface FacebookServiceInterface {

	int createProfileService(FacebookUser fb);

	boolean checkLoginService(FacebookUser fb);

	FacebookUser viewProfileService(FacebookUser fb);

	List<FacebookUser> viewAllProfileService();

	int editProfileService(FacebookUser fb);

	int deleteProfileService(FacebookUser fb);

}
