
package com.stress.controllers;

import com.stress.dao.CityDAO;
import com.stress.dao.RouteDAO;
import com.stress.dao.TripDAO;
import com.stress.dto.Route;
import com.stress.dto.Trip;
import com.stress.service.CityDAOImpl;
import com.stress.service.RouteDAOImpl;
import com.stress.service.TripDAOImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Huy
 */
@WebServlet(name = "BookingController", urlPatterns = {"/book"})
public class BookingController extends HttpServlet {
    
    private TripDAO tripDAO = new TripDAOImpl();
    private RouteDAO routeDAO = new RouteDAOImpl();
    private CityDAO cityDAO = new CityDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            switch (action) {
                case "showTrip":
                    showTrip(request,response);
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private void showTrip(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        try {
            String routeName = request.getParameter("routeName");
            String startDay = request.getParameter("start");              
//            List<Trip> listTrip = tripDAO.getAllTripByStartEndLocationAndStartDay(from, to, startDay);
            List<Trip> listTrip = null;
            request.setAttribute("LIST_ALL_TRIP_BY_LOCATION", listTrip); 
            request.getRequestDispatcher("./client/route.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


}
