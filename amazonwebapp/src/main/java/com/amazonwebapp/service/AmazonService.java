package com.amazonwebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonwebapp.dao.AmazonDAOInterface;
import com.amazonwebapp.entity.AmazonUser;

@Service
public class AmazonService implements AmazonServiceInterface {

	@Autowired
	private AmazonDAOInterface md;
	
	@Override
	public int createProfile(AmazonUser am) {
		int i=0;
		md.save(am);
		i=1;
		return i;
	}

}
