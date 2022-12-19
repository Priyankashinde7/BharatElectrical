package com.ps.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.ps.domain.MeterDTO;
import com.ps.entity.MeterBill;
import com.ps.service.ElectricityMeterProcess;
import com.ps.service.ElectricityMeterReadingProcess;

/**
 * Servlet implementation class MeterServlet
 */
public class MeterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doGet method called");
		//get PrintWriter stream object
		PrintWriter pw = res.getWriter();
		//set response Content type
		res.setContentType("text/html");
		//read additional req param value

		String s1Val=req.getParameter("s");
		String name=req.getParameter("name");
		String customerId=req.getParameter("customerid");
		String meterNo=req.getParameter("meterno");
		double meterReading=0.0;
		
		meterReading=Double.parseDouble(req.getParameter("meterreading"));
		
		//hold the data in MeterDTO class
		MeterDTO dt = new MeterDTO();
		dt.setCustName(name);
		dt.setCustomerIdc(customerId);
		dt.setMeterNoc(meterNo);
		dt.setMeterReadingc(meterReading);
		ElectricityMeterProcess  emp= new ElectricityMeterReadingProcess();
		MeterBill mb= emp.meterReading(dt);
		
		pw.println("<h1 style='color:green;text-align:center'><a href='links.html'>Home</a></h1>");
		pw.println("<table border = '1' align ='center'>");
		pw.println("<tr><th>CustomerName</th><th>CustomerId</th><th>MeterNo</th><th>Units</th><th>Amount</th><th>Discount</th><th>DiscountAmount</th></tr>");
		
		pw.println("<tr><td>"+mb.getCustName()+"</td><td>"+mb.getCustomerIdc()+"</td><td>"+mb.getMeterNoc()+"</td><td>"+mb.getMeterReadingc()+"</td><td>"+mb.getAmount()+"</td><td>"+mb.getPercentage()+"</td><td>"+mb.getDiscountAmount()+"</td></tr>");
		pw.println("</table>");
		//close the stream
		pw.close();
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost method called");
		doGet(req, res);
	}

}
