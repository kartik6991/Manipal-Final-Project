package com.example.demo.service;

public interface IOrderService {
	public Order addOrder(Order order);
	public Order updateOrder(Order order) throws OrderNotFoundException;
	public Order cancelOrder(int id) throws OrderNotFoundException;
	public List<Order> showAllMobiles(int id);
	public double calculateTotalCost(List<Mobile> list);
}