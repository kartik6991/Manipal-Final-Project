package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Address;
import com.example.demo.exception.AddressException;

public interface IAddressService {
	public Address addAddress(Address address) throws AddressException;

	public Address updateAddress(Address address) throws AddressException;

	public String deleteAddress(String id) throws AddressException;

	public List<Address> showAllAddresses();

	public Address showAddressById(String id) throws AddressException;
}
