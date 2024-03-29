package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Mobile;
import com.example.demo.exception.MobileException;

public interface IMobileService {
	Mobile addMobile(Mobile mobile) throws MobileException;

	Mobile updateMobile(Mobile mobile) throws MobileException;

	String deleteMobile(String id) throws MobileException;

	List<Mobile> showAllMobile();

	Mobile showMobileById(String mobileId) throws MobileException;
}
