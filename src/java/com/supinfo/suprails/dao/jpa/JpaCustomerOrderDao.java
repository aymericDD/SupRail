/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.dao.jpa;

import com.supinfo.suprails.dao.CustomerOrderDao;
import com.supinfo.suprails.entity.Customer;
import com.supinfo.suprails.entity.CustomerOrder;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rico
 */
@Stateless
public class JpaCustomerOrderDao implements CustomerOrderDao{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
        if (customerOrder != null) {
            em.persist(customerOrder.getCustomer());
            em.persist(customerOrder);
            return customerOrder;
        }
        return null;
    }   
    
}
