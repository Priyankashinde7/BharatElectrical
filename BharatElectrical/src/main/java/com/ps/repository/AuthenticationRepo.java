package com.ps.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ps.domain.registerDTO;



public class AuthenticationRepo {
	private static final String INSERT_USER_DATA= "INSERT INTO USER_DATA VALUES(?,?,?,?,?,?,?,?,?,?)";
	
	public registerDTO SendValuesToDb(registerDTO rd) {
		//load the jdbc driver class
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","priyajayrang7");
				PreparedStatement ps = con.prepareStatement(INSERT_USER_DATA);
						){
			System.out.println("db enter");
			String fname=rd.getFname();
			String mname=rd.getMname();
			String lname=rd.getLname();
			String type = rd.getType();
			String addr= rd.getAddr();
			String email= rd.getEmail();
			String pass= rd.getPass();
			String repass= rd.getRepass();
			String code= rd.getCountryCode();
			long phone= rd.getPhoneNo();
			
			//set the above inputs to the pre-compiled SQL Query Params
			ps.setString(1, fname);
			ps.setString(2, mname);
			ps.setString(3, lname);
			ps.setString(4, type);
			ps.setString(5, addr);
		    ps.setString(6, email);
		    ps.setString(7, pass);
		    ps.setString(8, repass);
		    ps.setString(9,code);
		    ps.setLong(10, phone);
		    
			//execute the pre-compiled Query
			int result = ps.executeUpdate();
			
			//process the results
			if(result==0)
				System.out.println("your details are wrong");
			else
				System.out.println("Your details are stored");
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rd;
	}

}
