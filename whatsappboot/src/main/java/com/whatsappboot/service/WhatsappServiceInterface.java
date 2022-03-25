package com.whatsappboot.service;

import java.util.List;

import com.whatsappboot.entity.WhatsappUser;

public interface WhatsappServiceInterface {

	int createProfileService(WhatsappUser wu);

	List<WhatsappUser> viewAllProfileService();

	WhatsappUser viewProfileService(WhatsappUser w);

	String editProfileService(WhatsappUser ww);

	String deleteProfileService(WhatsappUser w);

}
