package com.ps.repository;

import com.ps.entity.MeterBill;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ElectricityMeterRepository {
	private static final String INSERT_UNIT_READING = "INSERT INTO UNIT_READING VALUES(?,?,?,?,?,?,?)";
	
	public void SendValuesToDb(MeterBill mb) {
		//load the jdbc driver class
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","priyajayrang7");
				PreparedStatement ps = con.prepareStatement(INSERT_UNIT_READING);
						){
			String name=mb.getCustName();
			String customerId=mb.getCustomerIdc();
			String meterNo=mb.getMeterNoc();
			double meterReading=mb.getMeterReadingc();
			double amount = mb.getAmount();
			String s =mb.getPercentage();
			double discAmount = mb.getDiscountAmount();
			
			//set the above inputs to the pre-compiled SQL Query Params
			ps.setString(1, name);
			ps.setString(2, customerId);
			ps.setString(3, meterNo);
			ps.setDouble(4, meterReading);
			ps.setDouble(5, amount);
			ps.setString(6,s);
			ps.setDouble(7, discAmount);
			
			
			//execute the pre-compiled Query
			int result = ps.executeUpdate();
			
			//process the results
			if(result==0)
				System.out.println("your details are wrong");
			else
				System.out.println("Your have to pay: "+discAmount);
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
