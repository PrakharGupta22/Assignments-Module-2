package com.cg.customerjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.customerjpa.dao.ICustomerDao;
import com.cg.customerjpa.entities.Customer;
import com.cg.customerjpa.util.ValidationUtil;

@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService {
 
    @Autowired
    private ICustomerDao dao;


    @Override
    public Customer register(Customer customer) {
        ValidationUtil.checkArgumentNotNull(customer);
        ValidationUtil.checkName(customer.getName());
        customer = dao.add(customer);
        return customer;
    }


	@Override
	public Customer updateName(long id, String name) {
		ValidationUtil.checkName(name);
		Customer customer=dao.findById(id);
		customer.setName(name);
		customer=dao.update(customer);
        return customer;
	}



}

