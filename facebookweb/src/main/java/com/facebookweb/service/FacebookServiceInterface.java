package com.facebookweb.service;

import com.facebookweb.entity.FacebookUser;

public interface FacebookServiceInterface {

	int createProfileService(FacebookUser fb);

	boolean checkLoginService(FacebookUser fb);

	FacebookUser viewProfileService(FacebookUser fb);

}
