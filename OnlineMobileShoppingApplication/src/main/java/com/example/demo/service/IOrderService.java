package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Mobile;
import com.example.demo.entities.Order;
import com.example.demo.exception.OrderException;

public interface IOrderService {
	public Order addOrder(Order order) throws OrderException;

	public Order updateOrder(Order order) throws OrderException;

	public String cancelOrder(Integer id) throws OrderException;

	public List<Order> showAllMobiles(Integer id);

	public Double calculateTotalCost(List<Mobile> list);
}
