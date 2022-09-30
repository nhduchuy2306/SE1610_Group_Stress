package com.stress.controllers;

import com.stress.dao.LocationDAO;
import com.stress.dao.RouteDAO;
import com.stress.dto.Location;
import com.stress.dto.Route;
import com.stress.service.LocationDAOImpl;
import com.stress.service.RouteDAOImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RouteController", urlPatterns = {"/route"})
public class RouteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            System.out.println("action:" + action);
            switch (action) {
                case "viewRoute":
                    viewRoute(request, response);
                    break;
                case "addRoute":
                    addRoute(request, response);
                    break;
                case "updateRoute":
                    updateRoute(request, response);
                    break;
                case "deleteRoute":
                    deleteRoute(request, response);
                    break;
            }
        } catch (Exception e) {

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            System.out.println("action:" + action);
            switch (action) {
                case "viewRoute":
                    viewRoute(request, response);
                    break;
                case "addRoute":
                    addRoute(request, response);
                    break;
                case "updateRoute":
                    updateRoute(request, response);
                    break;
                case "deleteRoute":
                    deleteRoute(request, response);
                    break;
            }
        } catch (Exception e) {

        }
    }

    private void viewRoute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "./admin/404.jsp";
        try {
            RouteDAO dao = new RouteDAOImpl();
            List<Route> list = dao.getAllRoute();
            if (!list.isEmpty()) {
                request.setAttribute("LIST_ROUTE", list);
                url = "./admin/routeTable.jsp";
            }
        } catch (Exception e) {
            log("Error at RouteController - viewRoute: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    private void addRoute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String tmpRouteID = request.getParameter("RouteID");
            String routeName = request.getParameter("RouteName");
            String startLocID = request.getParameter("StartLocation");
            String endLocID = request.getParameter("EndLocation");
            String description = request.getParameter("description");
            String tmpStatus = request.getParameter("Status");
            //==================Conversion process======================//
            int routeID = Integer.parseInt(tmpRouteID);
            int sLID = Integer.parseInt(startLocID);
            int eLID = Integer.parseInt(endLocID);
            LocationDAO LDAO = new LocationDAOImpl();
            Location startLocation = LDAO.getLocationById(sLID);
            Location endLocation = LDAO.getLocationById(eLID);
            boolean Status = Boolean.parseBoolean(tmpStatus);
            //===========================================================//
            RouteDAO RDAO = new RouteDAOImpl();
            boolean checkDuplicate = RDAO.checkDuplicateByID(routeID);
            boolean check = RDAO.addRoute(new Route(routeID, routeName, startLocation, endLocation, description, Status));
            if (checkDuplicate == false) {
                if (check == true) {
                    viewRoute(request, response);
                }
            }
        } catch (Exception e) {
            log("Error at RouteController - addRoute:" + e.toString());
        }
    }
    private void updateRoute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
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
            RouteDAO dao=new RouteDAOImpl();
            boolean checkUpdate=dao.updateRoute(RouteID,RouteName,StartLocation,EndLocation,Description,Status);
            if(checkUpdate){
                viewRoute(request, response);
            }
        } catch (Exception e) {
            log("Error at RouteController - updateRoute: "+ e.toString());
        }
    }
    private void deleteRoute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            String RouteID=request.getParameter("RouteID");
            RouteDAO dao=new RouteDAOImpl();
            boolean check=dao.deleteRoute(RouteID);
            if(check){
                viewRoute(request, response);
            }
        } catch (Exception e) {
            log("Error at RouteController - deleteRoute: "+ e.toString());
        } 
    }
}
