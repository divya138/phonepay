package com.hcl.phonepaytransaction.dto;

public class TransferDto {
	
	private long fromMobileNumber;
	private long toMobileNumber;
	private double ammount;
	public long getFromMobileNumber() {
		return fromMobileNumber;
	}
	public void setFromMobileNumber(long fromMobileNumber) {
		this.fromMobileNumber = fromMobileNumber;
	}
	public long getToMobileNumber() {
		return toMobileNumber;
	}
	public void setToMobileNumber(long toMobileNumber) {
		this.toMobileNumber = toMobileNumber;
	}
	public double getAmmount() {
		return ammount;
	}
	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}
	

}
