package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.OrderDTO;
import com.example.demo.entities.AddToOrder;
import com.example.demo.entities.CustomerIdDTO;
import com.example.demo.entities.Order;
import com.example.demo.exception.CustomerException;
import com.example.demo.exception.OrderException;

public interface IOrderService {
	public Order addOrder(Order order) throws OrderException;

	public Order updateOrder(Order order) throws OrderException;

	public String cancelOrder(String id) throws OrderException;

	public List<Order> showAllOrders();

	public Order showOrderById(String id) throws OrderException;

	Integer quantity(CustomerIdDTO add) throws CustomerException;

	Double totalCost(AddToOrder add) throws CustomerException, OrderException;

	Order addOrderToCustomer(OrderDTO addorderDTO) throws OrderException, CustomerException;
}
