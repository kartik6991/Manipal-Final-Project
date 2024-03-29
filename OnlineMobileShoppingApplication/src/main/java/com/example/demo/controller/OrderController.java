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

import com.example.demo.entities.OrderDTO;
import com.example.demo.entities.AddToOrder;
import com.example.demo.entities.CustomerIdDTO;
import com.example.demo.entities.Mobile;
import com.example.demo.entities.Order;
import com.example.demo.exception.CustomerException;
import com.example.demo.exception.OrderException;
import com.example.demo.service.IOrderService;

@CrossOrigin(value="http://localhost:3000/")
@RestController
@RequestMapping("api")
public class OrderController {
	@Autowired
	private IOrderService orderService;

	@GetMapping("orders")
	public List<Order> getAllOrders() {
		return this.orderService.showAllOrders();
	}

	@PostMapping("addorder")
	public Order createOrder(@RequestBody Order order) throws OrderException {
		return this.orderService.addOrder(order);
	}

	@DeleteMapping("cancelorder/{id}")
	public String cancelOrder(@PathVariable("id") String id) throws OrderException {
		return this.orderService.cancelOrder(id);
	}

	@PutMapping("updateorder")
	public Order updateOrder(@RequestBody Order order) throws OrderException {
		return this.orderService.updateOrder(order);
	}

	@GetMapping("order/{id}")
	public Order showOrderById(@PathVariable("id") String id) throws OrderException {
		return this.orderService.showOrderById(id);
	}

	@PostMapping("totalCost")
	public Double totalCost(@RequestBody AddToOrder add) throws CustomerException,OrderException {
		return this.orderService.totalCost(add);
	}

	@PostMapping("totalQuantity")
	public Integer quantity(@RequestBody CustomerIdDTO customer) throws CustomerException {
		return this.orderService.quantity(customer);
	}
	
	@PostMapping("addOrderToCustomer")
	public Order addOrdertoCustomer(@RequestBody OrderDTO addDTO) throws OrderException,CustomerException{
		return this.addOrdertoCustomer(addDTO);
	}
}
