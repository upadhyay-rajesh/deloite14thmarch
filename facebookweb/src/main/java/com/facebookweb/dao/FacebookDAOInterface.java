package com.facebookweb.dao;

import com.facebookweb.entity.FacebookUser;

public interface FacebookDAOInterface {

	int createProfileDAO(FacebookUser fb);

	boolean loginDAO(FacebookUser fb);

	FacebookUser viewProfileDAO(FacebookUser fb);

}
