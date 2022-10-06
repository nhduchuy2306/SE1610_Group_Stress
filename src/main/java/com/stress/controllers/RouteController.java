package com.stress.controllers;

import com.stress.dao.DriverDAO;
import com.stress.dao.LocationDAO;
import com.stress.dao.RouteDAO;
import com.stress.dao.VehicleDAO;
import com.stress.dto.City;
import com.stress.dto.Driver;
import com.stress.dto.Location;
import com.stress.dto.Route;
import com.stress.dto.Vehicle;
import com.stress.service.CityDAOImpl;
import com.stress.service.DriverDAOImpl;
import com.stress.service.LocationDAOImpl;
import com.stress.service.RouteDAOImpl;
import com.stress.service.VehicleDAOImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RouteController", urlPatterns = {"/admin/route"})
public class RouteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            String action = request.getParameter("action");
            System.out.println("action:" + action);
            switch (action) {
                case "show":
                    viewRoute(request, response);
                    break;

            }
        } catch (Exception e) {

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            String action = request.getParameter("action");
            System.out.println("action:" + action);
            switch (action) {

                case "create":
                    addRoute(request, response);
                    break;
                case "update":
                    updateRoute(request, response);
                    break;
                case "delete":
                    deleteRoute(request, response);
                    break;
            }
        } catch (Exception e) {

        }
    }

    private void viewRoute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String url = "./admin/404.jsp";
        try {
            RouteDAO dao = new RouteDAOImpl();
            List<Route> list = dao.getAllRoute();
            List<Location> allLocation = new LocationDAOImpl().getAllLocation();
            List<City> cityList = new CityDAOImpl().getAllCity();
            if (!list.isEmpty()) {
                List<Vehicle> activeVehicle = new VehicleDAOImpl().getAllActiveVehicle();
                List<Driver> activeDriver = new DriverDAOImpl().getDriverWithLicense();
                request.setAttribute("ROUTE_LIST", list);
                request.setAttribute("CITY_LIST", cityList);
                request.setAttribute("LIST_ACTIVE_VEHICLE", activeVehicle);
                request.setAttribute("LIST_ACTIVE_DRIVER", activeDriver);
                request.setAttribute("LOCATION_LIST", allLocation);
                url = "./routeTable.jsp";
            }
        } catch (Exception e) {
            log("Error at RouteController - viewRoute: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    private void addRoute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {

            String routeName = request.getParameter("routeName");
            String startLocID = request.getParameter("startLocation");
            String endLocID = request.getParameter("endLocation");
            String description = request.getParameter("description");
            String tmpStatus = request.getParameter("status");
            //==================Conversion process======================//

            int sLID = Integer.parseInt(startLocID);
            int eLID = Integer.parseInt(endLocID);
            LocationDAO LDAO = new LocationDAOImpl();
            Location startLocation = LDAO.getLocationById(sLID);
            Location endLocation = LDAO.getLocationById(eLID);

            //===========================================================//
            RouteDAO RDAO = new RouteDAOImpl();
            Route createItem = new Route(0, routeName, startLocation, endLocation, description, true);
            int routeID = RDAO.addRoute(createItem);
            createItem.setRouteID(routeID);

            if (routeID > 0) {
                request.setAttribute("ROUTE_ID", routeID);
                request.setAttribute("SUCCESS", "Create Success");
                viewRoute(request, response);
            }

        } catch (Exception e) {
            log("Error at RouteController - addRoute:" + e.toString());
        }
    }

    private void updateRoute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            String tmpRouteID = request.getParameter("RouteID");
            String RouteName = request.getParameter("RouteName");
            String startLocID = request.getParameter("StartLocation");
            String endLocID = request.getParameter("EndLocation");
            String Description = request.getParameter("Description");
            String tmpStatus = request.getParameter("Status");
            //==================Conversion process======================//
            int RouteID = Integer.parseInt(tmpRouteID);
            int sLID = Integer.parseInt(startLocID);
            int eLID = Integer.parseInt(endLocID);
            LocationDAO LDAO = new LocationDAOImpl();
            Location StartLocation = LDAO.getLocationById(sLID);
            Location EndLocation = LDAO.getLocationById(eLID);
            boolean Status = Boolean.parseBoolean(tmpStatus);
            //===========================================================//
            RouteDAO dao = new RouteDAOImpl();
            boolean checkUpdate = dao.updateRoute(RouteID, RouteName, StartLocation, EndLocation, Description, Status);
            if (checkUpdate) {
                request.setAttribute("ROUTE_ID", RouteID);
                viewRoute(request, response);
            }
        } catch (Exception e) {
            log("Error at RouteController - updateRoute: " + e.toString());
        }
    }

    private void deleteRoute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String RouteID = request.getParameter("RouteID");
            RouteDAO dao = new RouteDAOImpl();
            boolean check = dao.deleteRoute(RouteID);
            if (check) {
                viewRoute(request, response);
            }
        } catch (Exception e) {
            log("Error at RouteController - deleteRoute: " + e.toString());
        }
    }
}
