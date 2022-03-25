package com.whatsappboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whatsappboot.dao.WhatsappDAOInterface;
import com.whatsappboot.entity.WhatsappUser;

@Service
@Transactional
public class WhatsappService implements WhatsappServiceInterface{
	
	@Autowired
	private WhatsappDAOInterface wd;

	@Override
	public int createProfileService(WhatsappUser wu) {
		int i=0;
		wd.save(wu);
		i=1;
		return i;
	}

	@Override
	public List<WhatsappUser> viewAllProfileService() {
		// TODO Auto-generated method stub
		return wd.findAll();
	}

	@Override
	public WhatsappUser viewProfileService(WhatsappUser w) {
		// TODO Auto-generated method stub
		 Optional<WhatsappUser> ww=wd.findById(w.getEmail());
		return ww.get();
	}

	@Override
	public String editProfileService(WhatsappUser ww) {
		// TODO Auto-generated method stub
		String s="profile not edited";
		wd.saveAndFlush(ww);
		s="profile edited";
		return s;
	}

	@Override
	public String deleteProfileService(WhatsappUser w) {
		String s="profile not deleted";
		wd.deleteById(w.getEmail());
		s="profile deleted";
		return s;
	}

}
