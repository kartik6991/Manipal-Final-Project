package com.example.demo.repository;

public interface IMobileRepository {

	public Mobile addMobile(Mobile mobile);
	public Mobile updateMedicine(Mobile mobile) throws MobileNotFoundException;
	public Mobile deleteMedicine(int id) throws MobileNotFoundException;
	public List<Mobile> showAllMobile();
	public Mobile showMobileById(int mobileId);
}
