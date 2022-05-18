package com.example.demo.service;

public interface IMobileService {
	public Mobile addMobile(Mobile mobile);
	public Mobile updateMedicine(Mobile mobile) throws MobileNotFoundException;
	public Mobile deleteMedicine(int id) throws MobileNotFoundException;
	public List<Mobile> showAllMobile(int id);
	public Mobile showMobileById(int mobileId);
}
