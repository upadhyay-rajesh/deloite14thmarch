package com.whatsapp.service;

import com.whatsapp.dao.WhatsappDAO;
import com.whatsapp.dao.WhatsappDAOeInterface;
import com.whatsapp.entity.WhatsappUser;

public class WhatsappService implements WhatsappServiceInterface {

	public int createProfileService(WhatsappUser wu) {
		WhatsappDAOeInterface ws=new WhatsappDAO();
		int i=ws.createProfiledao(wu);
		return i;
	}

}
