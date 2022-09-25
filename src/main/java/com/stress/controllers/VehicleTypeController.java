/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.stress.controllers;

import com.stress.dao.VehicleTypeDAO;
import com.stress.dto.VehicleType;
import com.stress.service.VehicleTypeDAOImpl;
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
@WebServlet(name = "VehicleTypeController", urlPatterns = {"/VehicleTypeController"})
public class VehicleTypeController extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VehicleTypeController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VehicleTypeController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
         VehicleTypeDAO vDao = new VehicleTypeDAOImpl();
         String action = request.getParameter("action");
         switch (action) {
            case "show":
                
                break;
            case "create":
                break;
            case "update":
                break;
            case "delete":
                break;
            default:
                throw new AssertionError();
        }
    }
    private void showAllVehicleType(HttpServletRequest request, HttpServletResponse response, VehicleTypeDAO vDAO) 
            throws ServletException, IOException {
        try {
        List<VehicleType> vehicleTypeList = vDAO.getAllVehicleType();
        if(!vehicleTypeList.isEmpty()) {
            request.setAttribute("VEHICLE_TYPE_LIST", vehicleTypeList);
        }
        }catch(Exception e) {
            System.out.println("Error at ShowAllVehicleType " + e.toString());
        }
        request.getRequestDispatcher("/admin/vehicleTypeTable.jsp").forward(request, response);
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
        processRequest(request, response);
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
