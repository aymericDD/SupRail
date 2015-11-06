/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.service;

import com.supinfo.suprails.dao.CustomerOrderDao;
import com.supinfo.suprails.entity.CustomerOrder;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rico
 */
@Stateless
public class CustomerOrderService {
    
    @EJB
    private CustomerOrderDao customerOrderDao;
    
    @EJB
    private PrinterService printerService;
    
    @Asynchronous
    public void processCustomerOrder(CustomerOrder customerOrder) {
        if (customerOrder != null) {
            customerOrderDao.addCustomerOrder(customerOrder);
            System.out.println("Send mail");
            printerService.print(customerOrder);
        }
    }
    
}
