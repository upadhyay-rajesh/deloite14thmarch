package com.facebook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.facebook.entity.FacebookUser;

public class FacebookDAO {

	public int createProfileDAO(FacebookUser fb) {
		int i=0;
		
		try {
			//step 1 load driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//step 2 create connection with database
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rajesh");
			
			//step 3 create query
			PreparedStatement ps=con.prepareStatement("insert into deloitfacebook values(?,?,?,?)");
			ps.setString(1, fb.getName());
			ps.setString(2, fb.getPassword());
			ps.setString(3, fb.getEmail());
			ps.setString(4, fb.getAddress());
			
			//execute query
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return i;
	}

}
