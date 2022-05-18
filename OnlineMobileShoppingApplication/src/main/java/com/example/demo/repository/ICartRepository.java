package com.example.demo.repository;

public interface ICartRepository {
	public Mobile addMobileItems(List<Mobile> mobiles);
	public Mobile deleteMobileItems(int mobileId) throws MobileNotFoundException;
	public Mobile updateMobileItemquantity(int mobileId);
	public List<Mobile> showAllMobileItems(int cartId);
	public int placeOrder(Cart cart);
}
