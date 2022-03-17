package com.facebookweb.dao;

import java.util.List;

import com.facebookweb.entity.FacebookUser;

public interface FacebookDAOInterface {

	int createProfileDAO(FacebookUser fb);

	boolean loginDAO(FacebookUser fb);

	FacebookUser viewProfileDAO(FacebookUser fb);

	List<FacebookUser> viewAllProfileDAO();

	int editProfileDAO(FacebookUser fb);

	int deleteProfileDAO(FacebookUser fb);

}
