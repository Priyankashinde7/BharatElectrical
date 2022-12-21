package com.ps.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.ps.domain.registerDTO;
import com.ps.repository.AuthenticationRepo;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doGet method called");
		//get PrintWriter stream object
		PrintWriter pw = res.getWriter();
		//set response Content type
		res.setContentType("text/html");
		
		//read additional req param value
		
		String s1Val=req.getParameter("submit");
		String firstName=req.getParameter("firstname");
		String middleName=req.getParameter("middlename");
		String lastName=req.getParameter("lastname");
		String type=req.getParameter("type");
	
		long phone=0;
		String countryCode=req.getParameter("country code");
		phone=Long.parseLong(req.getParameter("phone"));
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String password=req.getParameter("pass");
		String retypePassword=req.getParameter("repass");
		
		//hold the data into the registerDTO
		registerDTO rd = new registerDTO();
		rd.setFname(firstName);
		rd.setMname(middleName);
		rd.setLname(lastName);
		rd.setType(type);
		rd.setAddr(address);
		rd.setEmail(email);
		rd.setPass(password);
		rd.setRepass(retypePassword);
		rd.setCountryCode(countryCode);
		rd.setPhoneNo(phone);
		AuthenticationRepo ap= new AuthenticationRepo();
		ap.SendValuesToDb(rd);
		pw.println("<h1 style='color:green;text-align:center'><a href='index.html'>Home</a></h1>");
		//close the stream
		pw.close();
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
