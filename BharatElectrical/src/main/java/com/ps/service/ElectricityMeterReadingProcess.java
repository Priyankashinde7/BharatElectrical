package com.ps.service;

import com.ps.domain.MeterDTO;
import com.ps.entity.MeterBill;
import com.ps.repository.ElectricityMeterRepository;

public class ElectricityMeterReadingProcess implements ElectricityMeterProcess{

	@Override
	public MeterBill meterReading(MeterDTO dt) {
		//dt.setCustName("test");
		String name=dt.getCustName();
		String customerId=dt.getCustomerIdc();
		String meterNo=dt.getMeterNoc();
		double meterReading=dt.getMeterReadingc();
		double unit = dt.getMeterReadingc();
		double amount = unit * 5;
		double discAmount = 0;
		String s ="";
		
		System.out.println("Your name :"+dt.getCustName());
		System.out.println("Your Customer Id is :"+dt.getCustomerIdc());
		System.out.println("your Meter no is :"+dt.getMeterNoc());
		System.out.println("Before discount your amount per unit is: "+amount);
		
		if(unit<=100) {
			System.out.println("you will get 5% discount");
			s="5%";
			double discValue= amount * 0.05;
			discAmount = amount - discValue;
			System.out.println("After discount your amount is:"+discAmount);
		}
		
		if(unit >= 100 && unit <= 200) {
			System.out.println("you will get 10% discount");
			s="10%";
			double discValue= amount * 0.1;
			discAmount = amount - discValue;
			System.out.println("After discount your amount is:"+discAmount);
		}
		if(unit >= 200 && unit <=500) {
			System.out.println("you will get 20% discount");
			s="20%";
			double discValue= amount * 0.2;
			discAmount = amount - discValue;
			System.out.println("After discount your amount is:"+discAmount);
		}
		if(unit > 500) {
			System.out.println("you will not get any discount");
			s="No Discount";
			System.out.println("Your amount is:"+amount);
		}
		//hold the data in MeterBill class
		MeterBill mb = new MeterBill();
		mb.setCustName(name);
		mb.setCustomerIdc(customerId);
		mb.setMeterNoc(meterNo);
		mb.setMeterReadingc(meterReading);
		mb.setAmount(amount);
		mb.setDiscountAmount(discAmount);
		mb.setPercentage(s);
		ElectricityMeterRepository emp1 =new ElectricityMeterRepository();
		emp1.SendValuesToDb(mb);
		return mb;
	}
}
