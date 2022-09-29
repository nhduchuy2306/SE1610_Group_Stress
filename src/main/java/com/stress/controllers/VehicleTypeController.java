
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


@WebServlet(name = "VehicleTypeController", urlPatterns = {"/admin/VehicleTypeController"})
public class VehicleTypeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         request.setCharacterEncoding("utf-8");
         VehicleTypeDAO vDao = new VehicleTypeDAOImpl();
         String action = request.getParameter("action");
         if(action != null) {
         switch (action) {
            case "show":
                showAllVehicleType(request, response, vDao);
                break;
            case "update":
                updateVehicleType(request, response, vDao);
                break;
            case "delete":
                deleteVehicleType(request, response, vDao);
                break;
            default:
                throw new AssertionError();
        }
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
    private void deleteVehicleType(HttpServletRequest request, HttpServletResponse response, VehicleTypeDAO vDAO) 
             throws ServletException, IOException {
        String vehicleTypeID = request.getParameter("vehicleTypeID");
        try {
            if(vDAO.deleteVehicleType(vehicleTypeID)) 
                showAllVehicleType(request, response, vDAO);
        } catch (Exception e) {
            System.out.println("Error at Delete VehicleType " + e.toString());
        }
    }
    
     private void updateVehicleType(HttpServletRequest request, HttpServletResponse response, VehicleTypeDAO vDAO) 
             throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8");
         int vehicleTypeID = Integer.parseInt(request.getParameter("vehicleTypeID"));
         String vehicleTypeName = request.getParameter("vehicleTypeName");
         int totalSeat = Integer.parseInt(request.getParameter("totalSeat"));
         VehicleType updateVehicleTypeItem = new VehicleType(vehicleTypeID, vehicleTypeName, totalSeat);
         try {
             if(vDAO.updateVehicleType(updateVehicleTypeItem)) 
                 showAllVehicleType(request, response, vDAO);
         } catch (Exception e) {
             System.out.println("Error at Update Vehicle Type " + e.toString());
         } 
         
     }
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        
        String vehicleName = request.getParameter("vehicleTypeName").trim();
        int totalSeat = Integer.parseInt(request.getParameter("totalSeat").trim());
        VehicleType newVehicleType = new VehicleType(0, vehicleName, totalSeat);
        VehicleTypeDAO vtDao = new VehicleTypeDAOImpl();
        try {
            if(vtDao.createVehicleType(newVehicleType)) 
            showAllVehicleType(request, response, vtDao);
                 
        } catch (Exception e) {
            System.out.println("Error at Create Vehicle Type " + e.toString());
        }
        
            
        
    }
   
}
