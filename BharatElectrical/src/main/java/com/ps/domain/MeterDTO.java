package com.ps.domain;

public class MeterDTO {
	private String nameOfCust,customerIdc, meterNoc;
	private double meterReadingc;
	
	public void setCustName(String name){
		this.nameOfCust= name;
	}
	public String getCustName() {
		return nameOfCust;
	}
	
	public void setCustomerIdc(String customerId) {
		this.customerIdc = customerId;
	}
	public String getCustomerIdc() {
		return customerIdc;
	}
	
	public void setMeterNoc(String meterNo) {
		this.meterNoc= meterNo;
	}
	public String getMeterNoc() {
		return meterNoc;
	}
	
	public void setMeterReadingc(double meterReading) {
		
		this.meterReadingc = meterReading;
	}
	public double getMeterReadingc() {
		return meterReadingc;
	}
}
