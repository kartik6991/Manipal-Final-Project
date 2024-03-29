package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.OrderDTO;
import com.example.demo.entities.AddToOrder;
import com.example.demo.entities.Customer;
import com.example.demo.entities.CustomerIdDTO;
import com.example.demo.entities.Order;
import com.example.demo.exception.CustomerException;
import com.example.demo.exception.OrderException;
import com.example.demo.repository.ICustomerRepository;
import com.example.demo.repository.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private IOrderRepository orderRepo;
	@Autowired
	private ICustomerRepository customerRepo;
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
	public String cancelOrder(String id) throws OrderException {
		this.orderRepo.deleteById(id);
		return "Order is cancelled";
	}

	@Override
	public List<Order> showAllOrders() {
		return orderRepo.findAll();
	}
	@Override
	public Order showOrderById(String id) throws OrderException {
		Optional<Order> orderOptional = this.orderRepo.findById(id);
		if (orderOptional.isEmpty())
			throw new OrderException("Order Id doesn't exist");
		return orderOptional.get();
	}
	@Override
	public Double totalCost(AddToOrder add) throws CustomerException, OrderException {
		Optional<Customer>customerOpt=this.customerRepo.findById(add.getCustomerId());
		if(customerOpt.isEmpty())
			throw new CustomerException("Customer Id doesn't exist");
		Customer customer=customerOpt.get();
		Optional<Order>orderOpt=this.orderRepo.findById(add.getOrderId());
		if(orderOpt.isEmpty())
			throw new OrderException("Order Id doesn't exist");
		Order order=orderOpt.get();
		Double sum=0.0;
		for(int i=0;i<customer.getCart().getMobiles().size();i++)
			sum=sum+customer.getCart().getMobiles().get(i).getMobileCost()*(customer.getCart().getMobiles().get(i).getQuantity());
		order.setTotalCost(sum);
		this.orderRepo.save(order);
		if(customer.getOrders().contains(order))
			throw new OrderException("Order already added");
		else
			customer.getOrders().add(order);
		this.customerRepo.save(customer);
		return order.getTotalCost();
	}
	
	@Override
	public Order addOrderToCustomer(OrderDTO addorderDTO)throws OrderException, CustomerException{
		Optional<Order>orderOpt=this.orderRepo.findById(addorderDTO.getOrderId());
		if (orderOpt.isEmpty())
			throw new OrderException("Order Id doesn't exist");
		Order order=orderOpt.get();
		Optional<Customer>customerOpt=this.customerRepo.findById(addorderDTO.getCustomerId());
		if (customerOpt.isEmpty())
			throw new CustomerException("Customer Id doesn't exist");
		Customer customer=customerOpt.get();
		if(customer.getOrders().contains(order))
			throw new OrderException("Order Id already added");
		else
			customer.getOrders().add(order);
		this.customerRepo.save(customer);
		return order;
	}
	
	@Override
	public Integer quantity(CustomerIdDTO add) throws CustomerException{
		Optional<Customer>customerOpt=this.customerRepo.findById(add.getCustId());
		if(customerOpt.isEmpty())
			throw new CustomerException("Customer Id doesn't exist");
		Customer customer=customerOpt.get();
		Integer count=0;
		for(int i=0;i<customer.getCart().getMobiles().size();i++)
			count=count+customer.getCart().getMobiles().get(i).getQuantity();
		return count;
	}
}
