/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.web.servlet;

import com.supinfo.suprails.dao.CustomerOrderDao;
import com.supinfo.suprails.entity.Customer;
import com.supinfo.suprails.entity.CustomerOrder;
import com.supinfo.suprails.service.TripService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.classfilewriter.annotations.IntAnnotationValue;

/**
 *
 * @author Rico
 */
@WebServlet(urlPatterns = {"/admin/customer-order/add"})
public class AddCustomerOrderServlet extends HttpServlet {

    @EJB
    private CustomerOrderDao customerOrderDao;
    
    @EJB 
    private TripService tripService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/addCustomerOrder.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Init Customer
        Customer customer = new Customer();
        customer.setEmail(request.getParameter("email"));
        customer.setFirstName(request.getParameter("firstName"));
        customer.setLastName(request.getParameter("lastName"));
        
        // Init CusomerOrder
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomer(customer);
        customerOrder.setTrip(tripService.findTripById(Long.parseLong(request.getParameter("id"))));
        
        // Save customerOrderin bdd
        customerOrderDao.addCustomerOrder(customerOrder);
        
        response.sendRedirect(request.getContextPath() + "/trips");
    }

}
