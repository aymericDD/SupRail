/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.webservice;

import com.supinfo.suprails.entity.CustomerOrder;
import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.CustomerOrderService;
import com.supinfo.suprails.service.TripService;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;

/**
 *
 * @author Rico
 */
@WebService(serviceName = "tripService")
public class TripWebservice {
    
    @EJB
    private TripService tripService;
    
    @EJB
    private CustomerOrderService customerOrderService;
    
    public List<Trip> getTrips() {
        return tripService.getAllTrips();
    }
    
    public void processCustomerOrder(CustomerOrder customerOrder) {
        customerOrderService.processCustomerOrder(customerOrder);
    }
    
}
