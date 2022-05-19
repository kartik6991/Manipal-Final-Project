package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Cart;
import com.example.demo.entities.Mobile;
import com.example.demo.exception.MobileException;

public interface ICartService {
//	public Cart addMobileItems(List<Mobile> mobiles);

	public String deleteMobileItems(Integer Id) throws MobileException;

	public Cart updateMobileItemquantity(Integer Id);

	public List<Mobile> showAllMobileItems(Integer cartId);

	public Integer placeOrder(Cart cart);
}
