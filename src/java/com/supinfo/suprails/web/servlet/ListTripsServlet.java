package com.supinfo.suprails.web.servlet;

import com.supinfo.suprails.entity.TrainStation;
import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.TrainStationService;
import com.supinfo.suprails.service.TripService;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bargenson
 */
@WebServlet(urlPatterns="/trips")
public class ListTripsServlet extends HttpServlet {

    @EJB
    private TripService tripService;
    
    @EJB
    private TrainStationService trainStationService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Trip> trips = tripService.getAllTrips();
        List<TrainStation> trainStations = trainStationService.getAllTrainStations();
        req.setAttribute("trips", trips);
        req.setAttribute("trainStations", trainStations);
        req.getRequestDispatcher("/jsp/listTrips.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TrainStation startStation = trainStationService.findTrainStationById(Long.parseLong(req.getParameter("startStation")));
        TrainStation endStation = trainStationService.findTrainStationById(Long.parseLong(req.getParameter("endStation")));
        BigDecimal highestPrice = BigDecimal.valueOf(Long.parseLong(req.getParameter("price")));
        
        if (startStation instanceof TrainStation && endStation instanceof TrainStation && highestPrice != null) {
            List<Trip> trips = tripService.filterTripsByStartStationAndEndStationEndHighestPric(startStation, endStation, highestPrice);
            req.setAttribute("trips", trips);
            List<TrainStation> trainStations = trainStationService.getAllTrainStations();
            req.setAttribute("trainStations", trainStations);
        }
        req.getRequestDispatcher("/jsp/listTrips.jsp").forward(req, resp);
    }

}
