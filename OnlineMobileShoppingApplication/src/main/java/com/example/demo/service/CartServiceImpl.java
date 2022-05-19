package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cart;
import com.example.demo.entities.Mobile;
import com.example.demo.exception.MobileException;
import com.example.demo.repository.ICartRepository;

@Service
public class CartServiceImpl implements ICartService {
	@Autowired
	private ICartRepository cartRepo;

//	@Override
//	public Cart addMobileItems(List<Mobile> mobiles) {
//		return this.cartRepo.saveAll(mobiles);
//	}

	@Override
	public String deleteMobileItems(Integer id) throws MobileException {
		this.cartRepo.deleteById(id);
		return "Deleted mobile items in the cart";
	}

	@Override
	public Cart updateMobileItemquantity(Integer id) {
		Optional<Cart> updatingCart = this.cartRepo.findById(id);
		Cart cart = updatingCart.get();
		return this.cartRepo.save(cart);
	}

	@Override
	public List<Mobile> showAllMobileItems(Integer cartId) {
		Optional<Cart> cartOptional = this.cartRepo.findById(cartId);

		Cart cart = cartOptional.get();
		return cart.getMobile();
	}

	@Override
	public Integer placeOrder(Cart cart) {
		return cart.getQuantity();
	}
}
