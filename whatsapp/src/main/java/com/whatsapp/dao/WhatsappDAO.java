package com.whatsapp.dao;

import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.whatsapp.entity.WhatsappUser;

public class WhatsappDAO implements WhatsappDAOeInterface {

	public int createProfiledao(WhatsappUser wu) {
		int i=0;
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		EntityTransaction et=s.getTransaction();
		et.begin();
			s.save(wu);
			et.commit();
			i=1;
		return i;
	}

}
