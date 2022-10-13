
package com.stress.controllers;

import com.stress.dao.CityDAO;
import com.stress.dao.RouteDAO;
import com.stress.dao.TripDAO;
import com.stress.dto.Trip;
import com.stress.service.CityDAOImpl;
import com.stress.service.RouteDAOImpl;
import com.stress.service.TripDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
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
                case "createTrip":
                    createTrip(request,response);
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
            int routeID =Integer.parseInt( request.getParameter("routeID"));
            System.out.println("RouteID"+ routeID);
            String startDay = request.getParameter("start");
            System.out.println("startDate"+ startDay);
//            List<Trip> listTrip = tripDAO.getAllTripByStartEndLocationAndStartDay(from, to, startDay);

            List<Trip> listTrip = tripDAO.getAllTripByRouteAndStartDay(routeID, startDay);
            System.out.println("List: "+listTrip);
            request.setAttribute("LIST_ALL_TRIP_BY_LOCATION", listTrip); 
            request.getRequestDispatcher("./client/route.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Error at BookingController - showTrip" +e.toString());
        }
    }

    private void createTrip(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException{
        
        PrintWriter p = response.getWriter();
        p.print("<h1>Send request for choosing seat successfully</h1>");
        
        String seatID = request.getParameter("seatID");
        String[] s = seatID.split(",");
        for (String item : s) {
            System.out.println(item);
        }
        
    }


}
