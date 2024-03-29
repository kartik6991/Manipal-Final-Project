package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Address;
import com.example.demo.exception.AddressException;
import com.example.demo.service.IAddressService;

@CrossOrigin(value="http://localhost:3000/")
@RestController
@RequestMapping("api")
public class AddressController {
	@Autowired
	private IAddressService addressService;
	
	@GetMapping("addresses")
	public List<Address> getAllAddresses(){
		return this.addressService.showAllAddresses();
	}
	
	@PostMapping("addAddress")
	public Address createAddress(@RequestBody Address address) throws AddressException {
		return this.addressService.addAddress(address);
	}
	
	@DeleteMapping("cancelAddress/{id}")
	public String cancelAddressById(@PathVariable("id") String id) throws AddressException {
		return this.addressService.deleteAddress(id);
	}
	
	@PutMapping("updateAddress")
	public Address updateAddress(@RequestBody Address address) throws AddressException {
		return this.addressService.updateAddress(address);
	}
	
	@GetMapping("address/{id}")
	public Address showAddressById(@PathVariable("id") String id)throws AddressException {
		return this.addressService.showAddressById(id);
	}
	
}
