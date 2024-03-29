package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AddtoCartDTO;
import com.example.demo.entities.Cart;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Mobile;
import com.example.demo.exception.CustomerException;
import com.example.demo.exception.MobileException;
import com.example.demo.repository.ICustomerRepository;
import com.example.demo.repository.IMobileRepository;

@Service
public class CartServiceImpl implements ICartService {
	@Autowired
	private IMobileRepository mobileRepo;
	@Autowired
	private ICustomerRepository customerRepo;

	@Override
	public Cart addMobileToCart(AddtoCartDTO cartDTO) throws CustomerException, MobileException {

		Optional<Customer> customerOpt = this.customerRepo.findById(cartDTO.getCustomerId());
		if (customerOpt.isEmpty())
			throw new CustomerException("Customer ID doesn't exist");
		Customer customer = customerOpt.get();
		Optional<Mobile> mobileOpt = this.mobileRepo.findById(cartDTO.getMobileId());
		if (mobileOpt.isEmpty())
			throw new MobileException("Mobile ID doesn't exist");
		Mobile mob = mobileOpt.get();

		if (customer.getCart() == null) {
			Cart cart = new Cart();
			cart.getMobiles().add(mob);
			customer.setCart(cart);

		} else {
			customer.getCart().getMobiles().add(mob);

		}
		customer = this.customerRepo.save(customer);

		return customer.getCart();
	}

	@Override
	public Cart deleteMobileItemsfromCart(AddtoCartDTO cartDTO) throws CustomerException, MobileException{
		Optional<Customer> customerOpt = this.customerRepo.findById(cartDTO.getCustomerId());
		if (customerOpt.isEmpty())
			throw new CustomerException("Customer ID doesn't exist");
		Customer customer = customerOpt.get();
		Optional<Mobile> mobileOpt = this.mobileRepo.findById(cartDTO.getMobileId());
		if (mobileOpt.isEmpty())
			throw new MobileException("Mobile ID doesn't exist");
		Mobile mob = mobileOpt.get();
		if(customer.getCart().getMobiles().contains(mob))
			customer.getCart().getMobiles().remove(mob);
	    this.customerRepo.save(customer);
		return customer.getCart();
	}
}
