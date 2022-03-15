package com.instagram.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.instagram.entity.InstagramUser;

public class InstagramDAO implements InstagramDAOInterface {

	public int createProfileDAO(InstagramUser iu) {
		int i=0;
		/*try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rajesh");
			PreparedStatement ps=con.prepareStatement("insert into deloiteinstagram values(?,?,?,?)");
			ps.setString(1,iu.getName());
			ps.setString(2,iu.getPassword());
			ps.setString(3,iu.getEmail());
			ps.setString(4,iu.getAddress());
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		EntityTransaction et=s.getTransaction();
		et.begin();
			s.save(iu);
		et.commit();
		i=1;
		return i;
	}

	public InstagramUser viewProfileDAO(InstagramUser iu) {
		InstagramUser ss=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rajesh");
			PreparedStatement ps=con.prepareStatement("select * from deloiteinstagram where email=?");
			
			ps.setString(1,iu.getEmail());
		
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				
				ss=new InstagramUser();
				ss.setName(n);
				ss.setPassword(p);
				ss.setEmail(e);
				ss.setAddress(a);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ss;
	}

}
