package com.cg.customer.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.customer.entities.Customer;
import com.cg.customer.service.ICustomerService;
import com.cg.customer.service.CustomerServiceImpl;

@Component
public class ProjectUi {
	@Autowired
	private ICustomerService service ;

	public void runUi() {
		Customer customer = add("Prakhar");
		long id1 = customer.getId();
		Customer customer2 = add("Gupta");
		long id2 = customer2.getId();
		Customer customer3 = add("Tohka");
		long id3 = customer3.getId();
		customer2=updateName(id2, "Tenka");
		
	}

	public Customer add(String name) {
		Customer customer = new Customer(name);
		customer = service.register(customer);
		System.out.println("Customer added with details, id=" + customer.getId() + " name=" + customer.getName());
		return customer;
	}
	public Customer updateName(long id,String name) {
		Customer customer = service.updateName(id,name);
		System.out.println("Customer details updated, id=" + customer.getId() + " name=" + customer.getName());
		return customer;
	}
	}
