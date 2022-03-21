package com.facebookweb.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.facebookweb.entity.FacebookUser;

public class FacebookDAO implements FacebookDAOInterface {

	@Override
	public int createProfileDAO(FacebookUser fb) {
		int i=0;
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		EntityTransaction et=s.getTransaction();
		et.begin();
			s.save(fb);
		et.commit();
		i=1;
		return i;
	}

	@Override
	public boolean loginDAO(FacebookUser fb) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from com.facebookweb.entity.FacebookUser f where email=:em and password=:pw");
		q.setParameter("em", fb.getEmail());
		q.setParameter("pw", fb.getPassword());
		
		List<FacebookUser> ll=q.getResultList();
		if(ll.size()>0) {
			return true;
		}
		return false;
	}

	@Override
	public FacebookUser viewProfileDAO(FacebookUser fb) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from com.facebookweb.entity.FacebookUser f where email=:em");
		q.setParameter("em", fb.getEmail());
		
		FacebookUser f1=null;
		List<FacebookUser> ll=q.getResultList();
		if(ll.size()>0) {
			for(FacebookUser s1:ll) {
				f1=s1;
			}
		}
		return f1;
	}

	@Override
	public List<FacebookUser> viewAllProfileDAO() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from com.facebookweb.entity.FacebookUser f");
		
		List<FacebookUser> ll=q.getResultList();
		return ll;
	}

	@Override
	public int editProfileDAO(FacebookUser fb) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("update com.facebookweb.entity.FacebookUser f set f.name=:nm, f.password=:pw, f.address=:ad where f.email=:em");
		q.setParameter("nm", fb.getName());
		q.setParameter("pw", fb.getPassword());
		q.setParameter("ad", fb.getAddress());
		q.setParameter("em", fb.getEmail());
		EntityTransaction et=s.getTransaction();
		et.begin();
		int i=q.executeUpdate();
		et.commit();
		
		return i;
	}

	@Override
	public int deleteProfileDAO(FacebookUser fb) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("delete from com.facebookweb.entity.FacebookUser f where f.email=:em");
		q.setParameter("em", fb.getEmail());
		EntityTransaction et=s.getTransaction();
		et.begin();
		int i=q.executeUpdate();
		et.commit();
		return i;
	}

}















