/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.stress.controllers;

import com.stress.dao.VehicleDAO;
import com.stress.dto.Vehicle;
import com.stress.dto.VehicleType;
import com.stress.service.VehicleDAOImpl;
import com.stress.service.VehicleTypeDAOImpl;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
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
 * @author MinhQuang
 */
@WebServlet(name = "VehicleController", urlPatterns = {"/admin/VehicleController"})
public class VehicleController extends HttpServlet {

    private static final String ERROR = "error.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        VehicleDAO vDAO = new VehicleDAOImpl();
        if (action != null) {
            switch (action) {
                case "show":
                    showAllVehice(request, response, vDAO);
                    break;
                case "update":
                    updateVehicle(request, response, vDAO);
                    break;
                case "delete":
                    deleteVehicle(request, response, vDAO);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
      private void deleteVehicle(HttpServletRequest request, HttpServletResponse response, VehicleDAO vDAO)
            throws ServletException, IOException {
           response.setContentType("text/html;charset=UTF-8");
       
        String vehicleID = request.getParameter("vehicleID");
          try {
              if(vDAO.deleteVehicle(vehicleID))
                  showAllVehice(request, response, vDAO);
          } catch (Exception e) {
              System.out.println("Error at Delete Vehicle Controller " + e.toString());
          }
        
      }
    private void updateVehicle(HttpServletRequest request, HttpServletResponse response, VehicleDAO vDAO)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
       
        String vehicleID = request.getParameter("vehicleID");
        String vehicleName = request.getParameter("vehicleName");
        String licensePlate = request.getParameter("licensePlate");
        int vehicleTypeID = Integer.parseInt(request.getParameter("vehicleTypeID"));
        int status = Integer.parseInt(request.getParameter("status"));
        try {
            VehicleType vType = new VehicleTypeDAOImpl().getVehicleTypeByID(vehicleTypeID);
            if (vType != null) {
              
                if (vDAO.updateVehicle(new Vehicle(vehicleID, vehicleName, licensePlate, vType, status))) {
                    showAllVehice(request,response, vDAO);
                }
            }
        } catch (Exception e) {
            System.out.println("Eror at Update Vehicle " + e.toString());
        }

    }

    private void showAllVehice(HttpServletRequest request, HttpServletResponse response, VehicleDAO vDAO)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = ERROR;
        try {
            List<Vehicle> vList = vDAO.getAllVehicle();
            List<VehicleType> vType = new VehicleTypeDAOImpl().getAllVehicleType();
            if (!vList.isEmpty() && !vType.isEmpty()) {
                request.setAttribute("VEHICLE_LIST", vList);
                request.setAttribute("VEHICLE_TYPE_LIST", vType);
                url = "/admin/vehicleTable.jsp";
            } else {
                request.setAttribute("ERROR", "Nothing to Shown");
            }
        } catch (Exception e) {
            System.out.println("Error at Show All Vehicle " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String vehicleID = request.getParameter("vehicleID");
        String vehicleName = request.getParameter("vehicleName");
        String licensePlate = request.getParameter("licensePlate");
        int vehicleTypeID = Integer.parseInt(request.getParameter("vehicleTypeID"));
        int status = Integer.parseInt(request.getParameter("status"));
        
        try {
            VehicleType vType = new VehicleTypeDAOImpl().getVehicleTypeByID(vehicleTypeID);
           
            if (vType != null) {
                System.out.println(vType.getVehicleTypeID());
                VehicleDAO vDAO = new VehicleDAOImpl();
                Vehicle createItem = new Vehicle(vehicleID, vehicleName, licensePlate, vType, status);
                System.out.println(createItem);
                if (vDAO.createVehicle(createItem)) {
                    System.out.println("Create Success");
                    showAllVehice(request, response, vDAO);
                }
            }
        } catch (Exception e) {
            System.out.println("Eror at Create Vehicle " + e.toString());
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
