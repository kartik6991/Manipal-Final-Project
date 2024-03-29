package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Address;
import com.example.demo.exception.AddressException;
import com.example.demo.repository.IAddressRepository;

@Service
public class AddressServiceImpl implements IAddressService {
	@Autowired 
	private IAddressRepository addressRepo;
	@Override
	public Address addAddress(Address address) throws AddressException {
		Optional<Address> newAddress = this.addressRepo.findById(address.getAdd_Id());
		if (newAddress.isPresent())
			throw new AddressException("Already address added");
		return this.addressRepo.save(address);
	}

	@Override
	public Address updateAddress(Address address) throws AddressException {
		return this.addressRepo.save(address);
	}

	@Override
	public String deleteAddress(String id) throws AddressException {
		this.addressRepo.deleteById(id);
		return "Address deleted successfully";
	}

	@Override
	public List<Address> showAllAddresses() {
		return addressRepo.findAll();
	}

	@Override
	public Address showAddressById(String id) throws AddressException {
		Optional<Address> addressOptional = this.addressRepo.findById(id);
		if (addressOptional.isEmpty())
			throw new AddressException("Address doesn't exist");
		return addressOptional.get();
	}
	
}
