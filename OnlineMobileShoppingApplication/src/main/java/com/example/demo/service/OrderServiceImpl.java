package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Mobile;
import com.example.demo.entities.Order;
import com.example.demo.exception.OrderException;
import com.example.demo.repository.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private IOrderRepository orderRepo;

	@Override
	public Order addOrder(Order order) throws OrderException {
		Optional<Order> newOrder = this.orderRepo.findById(order.getOrderId());
		if (newOrder.isPresent())
			throw new OrderException("Already ordered");
		return this.orderRepo.save(order);
	}

	@Override
	public Order updateOrder(Order order) throws OrderException {
		return this.orderRepo.save(order);
	}

	@Override
	public String cancelOrder(Integer id) throws OrderException {
		this.orderRepo.deleteById(id);
		return "Order is cancelled";
	}

	@Override
	public List<Order> showAllMobiles(Integer id) {
		return orderRepo.findAll();
	}

	@Override
	public Double calculateTotalCost(List<Mobile> list) {
		Double sum = 0.0;
		for (int i = 0; i < list.size(); i++) {
			sum = sum + list.get(i).getMobileCost();
		}
		return sum;
	}
}
