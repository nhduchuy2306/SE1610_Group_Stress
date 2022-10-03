
package com.stress.controllers;

import com.stress.dao.TripDAO;
import com.stress.dto.Trip;
import com.stress.service.TripDAOImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TripController", urlPatterns = {"/trip"})
public class TripController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            switch (action) {
                case "show":
                    showTripTable(request,response);
                    break;
                case "showTrip":
                    showTripView(request,response);
                    break;
            }
        } catch (Exception e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    private void showTripTable(HttpServletRequest request, HttpServletResponse response) {
        try {
            TripDAO tripDAO = new TripDAOImpl();
            List<Trip> list = tripDAO.getAllTrip();
            request.setAttribute("LIST_ALL_TRIP", list);
            request.getRequestDispatcher("/admin/tripTable.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }

    private void showTripView(HttpServletRequest request, HttpServletResponse response) {
        try {
            
        } catch (Exception e) {
        }
    }


}
