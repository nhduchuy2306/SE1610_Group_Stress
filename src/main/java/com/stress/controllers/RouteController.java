package com.stress.controllers;

import com.stress.dao.LocationDAO;
import com.stress.dao.RouteDAO;
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
                case "showDelete":
                    showDeleteHistory(request, response);
                    break;

            }
        } catch (Exception e) {
            System.out.println("Error at Do Get " + e.toString());
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
                case "recover":
                    recoverRoute(request, response);
                    break;
            }
        } catch (Exception e) {

        }
    }
    private void recoverRoute(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String url = "/admin/404.jsp";
        try {
            String routeID = request.getParameter("routeID");
            RouteDAO routeDAO = new RouteDAOImpl();
            if(routeDAO.recoverRoute(routeID)) {
                request.setAttribute("SUCCESS", "Recover Route " + routeID + " Success!");
                Route recoverItem = routeDAO.getRouteByID(Integer.parseInt(routeID));
                
                request.setAttribute("ROUTE_ID", recoverItem.getRouteName());
                viewRoute(request, response);
            }
        } catch (Exception e) {
            System.out.println("Error at Recover Route Controller " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
    private void showDeleteHistory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String url = "/admin/404.jsp";
        try {
            RouteDAO routeDAO = new RouteDAOImpl();
            List<Route> list = routeDAO.getDeleteHistory();
            System.out.println(list.size());
            request.setAttribute("DELETE_LIST", list);
            request.getRequestDispatcher("/admin/routeTable.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Error at Show Delete Route History " + e.toString());
        }
    }

    private void viewRoute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String url = "./404.jsp";
        try {
            RouteDAO dao = new RouteDAOImpl();
            List<Route> list = dao.getAllRoute();
            List<Location> allLocation = new LocationDAOImpl().getAllLocation();
            List<City> cityList = new CityDAOImpl().getAllCity();

            List<Vehicle> activeVehicle = new VehicleDAOImpl().getAllActiveVehicle();
            List<Driver> activeDriver = new DriverDAOImpl().getDriverWithLicense(); 
            request.setAttribute("ROUTE_LIST", list);
            request.setAttribute("CITY_LIST", cityList);
            request.setAttribute("LIST_ACTIVE_VEHICLE", activeVehicle);
            request.setAttribute("LIST_ACTIVE_DRIVER", activeDriver);
            request.setAttribute("LOCATION_LIST", allLocation);
            url = "./routeTable.jsp";

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


            String startLocID = request.getParameter("startLocation");
            String endLocID = request.getParameter("endLocation");
            String description = request.getParameter("description");

            //==================Conversion process======================//

            int sLID = Integer.parseInt(startLocID);
            int eLID = Integer.parseInt(endLocID);
            LocationDAO LDAO = new LocationDAOImpl();
            Location startLocation = LDAO.getLocationById(sLID);
            Location endLocation = LDAO.getLocationById(eLID);

            String routeName = startLocation.getLocationName() + "_" + endLocation.getLocationName();

            //===========================================================//
            RouteDAO RDAO = new RouteDAOImpl();
            Route createItem = new Route(0, routeName, startLocation, endLocation, description, true);
            if (RDAO.checkDuplicate(createItem)) {
                request.setAttribute("ERROR", "The Start and End Location has exist! Try Again!");
                viewRoute(request, response);
            } else if (createItem.getStartLocation().getLocationID() == createItem.getEndLocation().getLocationID()) {
                request.setAttribute("ERROR", "Start and End Location is the Same! Can't Create");
                viewRoute(request, response);
            } else {
                int routeID = RDAO.addRoute(createItem);
                createItem.setRouteID(routeID);

                if (routeID > 0) {
                    request.setAttribute("ROUTE_ID", createItem.getRouteName());
                    request.setAttribute("SUCCESS", "Create " + createItem.getRouteName() + " Success");
                    viewRoute(request, response);
                }
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
            String RouteName = StartLocation.getLocationName() + "_" + EndLocation.getLocationName();
            boolean Status = Boolean.parseBoolean(tmpStatus);
            //===========================================================//
            RouteDAO dao = new RouteDAOImpl();
            boolean checkUpdate = dao.updateRoute(RouteID, RouteName, StartLocation, EndLocation, Description, Status);
            if (checkUpdate) {
                request.setAttribute("ROUTE_ID", RouteName);
                viewRoute(request, response);
            }
        } catch (Exception e) {
            log("Error at RouteController - updateRoute: " + e.toString());
        }
    }

    private void deleteRoute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String RouteID = request.getParameter("routeID");
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
