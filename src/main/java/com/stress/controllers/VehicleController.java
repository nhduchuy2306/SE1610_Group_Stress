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
import java.util.ArrayList;
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
    private Vehicle vehicle = null;

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
                case "vehicleUpdate":
                    showVehicleUpdate(request, response);
                    break;
                default:
                    request.getRequestDispatcher("admin/404.jsp").forward(request, response);
            }
        }
    }

    private void deleteVehicle(HttpServletRequest request, HttpServletResponse response, VehicleDAO vDAO)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String vehicleID = request.getParameter("vehicleID");
        try {
            if (vDAO.deleteVehicle(vehicleID)) {
                request.setAttribute("SUCCESS", "Delete Vehicle " + vehicleID + " Success");
                showAllVehice(request, response, vDAO);
            }
        } catch (Exception e) {
            System.out.println("Error at Delete Vehicle Controller " + e.toString());
        }

    }

    private void showOneVehicle(HttpServletRequest request, HttpServletResponse response, VehicleDAO vDAO, Vehicle v)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = "admin/404.jsp";
        try {
            List<Vehicle> vList = new ArrayList<>();
            List<VehicleType> vType = new VehicleTypeDAOImpl().getAllVehicleType();
            vList.add(v);
            request.setAttribute("VEHICLE_LIST", vList);
            request.setAttribute("VEHICLE_TYPE_LIST", vType);
            url = "/admin/vehicleTable.jsp";
        } catch (Exception e) {
            System.out.println("Error at Show One Vehicle " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
                Vehicle v = new Vehicle(vehicleID, vehicleName, licensePlate, vType, status);
                if (vDAO.updateVehicle(v)) {
                    request.setAttribute("SUCCESS", "Update Vehicle " + v.getVehicleID() + " Successfully");
                    request.setAttribute("ACTION", "UPDATE");
                    vehicle = v;
                    showAllVehice(request, response, vDAO);
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
        String vehicleID = request.getParameter("vehicleID").trim();
        String vehicleName = request.getParameter("vehicleName").trim();
        String licensePlate = request.getParameter("licensePlate").trim();
        int vehicleTypeID = Integer.parseInt(request.getParameter("vehicleTypeID"));
        int status = Integer.parseInt(request.getParameter("status"));
        VehicleDAO vDAO = new VehicleDAOImpl();

        try {
            if (vDAO.duplicateVehicle(vehicleID)) {
                request.setAttribute("ERROR", "Duplicate ID");
                showAllVehice(request, response, vDAO);
            } else if (vehicleID.isEmpty() || vehicleName.isEmpty() || licensePlate.isEmpty()) {
                request.setAttribute("ERROR", "All Fields has to be filled! Try Again!");
                showAllVehice(request, response, vDAO);

            } else {
                VehicleType vType = new VehicleTypeDAOImpl().getVehicleTypeByID(vehicleTypeID);

                if (vType != null) {
                    System.out.println(vType.getVehicleTypeID());

                    Vehicle createItem = new Vehicle(vehicleID, vehicleName, licensePlate, vType, status);

                    if (vDAO.createVehicle(createItem)) {
                        request.setAttribute("SUCCESS", "Create Vehicle " + vehicleID + " Success!");
                        showOneVehicle(request, response, vDAO, createItem);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Eror at Create Vehicle " + e.toString());
        }
    }

    private void showVehicleUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        VehicleDAO vDAO = new VehicleDAOImpl();
        try {
            if (vehicle != null) {
                String status = "";
                if(vehicle.getStatus() == 0) {
                    status = "INACTIVE";
                }else if(vehicle.getStatus() == 1) {
                    status = "ACTIVE";
                }else status = "ONGOING";
                PrintWriter out = response.getWriter();
                out.println(
                        "\n  <td>1</td>\n"
                        + "                                                    <td>" +vehicle.getVehicleID()+"</td>\n"
                        + "                                                    <td>" + vehicle.getVehicleName()+"</td>\n"
                        + "                                                    <td>" + vehicle.getLicensePlate() + "</td>\n"
                        + "                                                    <td>" + vehicle.getVehicleType().getVehicleTypeName() + "</td>\n"
                        + "                                                    <td>\n"
                        + status                                                          
                        + "                                                    </td>\n"
                        + "                                                    <td>\n"
                        + "                                                        <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#modify-${v.vehicleID}\">\n"
                        + "                                                            <i class=\"fa fa-pen\"></i>\n"
                        + "                                                        </button>\n"
                        + "                                                        <div class=\"modal fade\" id=\"modify-${v.vehicleID}\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n"
                        + "                                                            <div class=\"modal-dialog\" role=\"document\">\n"
                        + "                                                                <div class=\"modal-content\">\n"
                        + "                                                                    <div class=\"modal-header\">\n"
                        + "                                                                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Modify Driver ${d.driverName}</h5>\n"
                        + "                                                                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n"
                        + "                                                                            <span aria-hidden=\"true\">&times;</span>\n"
                        + "                                                                        </button>\n"
                        + "                                                                    </div>\n"
                        + "                                                                    <form action=\"VehicleController\">\n"
                        + "                                                                        <div class=\"modal-body\">\n"
                        + "                                                                            <div class=\"modal-body\">\n"
                        + "                                                                                <div class=\"form-group\">\n"
                        + "                                                                                    <label for=\"exampleInputEmail1\">Vehicle ID</label>\n"
                        + "                                                                                    <input type=\"text\" name=\"vehicleID\" class=\"form-control\" value=\""+vehicle.getVehicleID()+"\" id=\"exampleInputEmail1\" readonly placeholder=\"Enter Vehicle ID\">\n"
                        + "                                                                                </div>\n"
                        + "                                                                                <div class=\"form-group\">\n"
                        + "                                                                                    <label for=\"exampleInputEmail1\">Vehicle Name</label>\n"
                        + "                                                                                    <input type=\"text\" name=\"vehicleName\" class=\"form-control\" value=\""+vehicle.getVehicleName()+"\" id=\"exampleInputEmail1\" placeholder=\"Enter Driver Name\">\n"
                        + "                                                                                </div>\n"
                        + "                                                                                <div class=\"form-group\">\n"
                        + "                                                                                    <label for=\"exampleInputEmail1\">LicensePlate</label>\n"
                        + "                                                                                    <input type=\"text\" name=\"licensePlate\" class=\"form-control\" value=\""+vehicle.getLicensePlate()+"\" id=\"exampleInputEmail1\" placeholder=\"Enter DOB\">\n"
                        + "                                                                                </div>\n"
                        + "                                                                                <div class=\"form-group\">\n"
                        + "                                                                                    <label for=\"exampleInputEmail1\">VehicleType</label>\n"
                        + "                                                                                    <select name=\"vehicleTypeID\" class=\"form-control\">\n"
                        + "                                                                                        <c:forEach items=\"${VEHICLE_TYPE_LIST}\" var=\"vT\">\n"
                        + "                                                                                            <option value=\"${vT.vehicleTypeID}\">${vT.vehicleTypeName}</option>\n"
                        + "                                                                                        </c:forEach>\n"
                        + "</select>\n"
                        + "                                                                                </div>\n"
                        + "\n"
                        + "                                                                                <div class=\"form-group\">\n"
                        + "                                                                                    <label for=\"exampleInputEmail1\">Status</label>\n"
                        + "                                                                                    <select name=\"status\" class=\"form-control\">\n"
                        + "                                                                                        <<option value=\"0\"" + (vehicle.getStatus() == 0 ? "selected" : "") + ">INACTIVE</option>\n"
                    + "                                                                                        <option value=\"1\" " + (vehicle.getStatus() == 1 ? "selected" : "") + ">ACTIVE</option>\n"
                    + "                                                                                        <option value=\"2\" " + (vehicle.getStatus() == 2 ? "selected" : "") + ">ONGOING</option>\n"
                        + "                                                                                    </select>\n"
                        + "                                                                                </div>\n"
                        + "                                                                            </div>\n"
                        + "                                                                        </div>\n"
                        + "                                                                        <div class=\"modal-footer\">\n"
                        + "                                                                            <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n"
                        + "                                                                            <button type=\"submit\" name=\"action\" value=\"update\" class=\"btn btn-primary\">Modify</button>\n"
                        + "                                                                        </div>\n"
                        + "                                                                    </form>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                        </div>\n"
                        + "                                                    </td>\n"
                        + "                                                    <td>\n"
                        + "                                                        <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#delete-"+vehicle.getVehicleID()+">\n"
                        + "                                                            <i class=\"fa fa-trash\" aria-hidden=\"true\"></i>\n"
                        + "                                                        </button>\n"
                        + "                                                        <div class=\"modal fade\" id=\"delete-"+vehicle.getVehicleID()+"\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n"
                        + "                                                            <div class=\"modal-dialog\" role=\"document\">\n"
                        + "                                                                <div class=\"modal-content\">\n"
                        + "                                                                    <div class=\"modal-header\">\n"
                        + "                                                                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Delete Vehice "+vehicle.getVehicleName()+"</h5>\n"
                        + "                                                                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n"
                        + "                                                                            <span aria-hidden=\"true\">&times;</span>\n"
                        + "                                                                        </button>\n"
                        + "                                                                    </div>\n"
                        + "                                                                    <form action=\"VehicleController\">\n"
                        + "                                                                        <div class=\"modal-footer\">\n"
                        + "                                                                            <input type=\"hidden\" name=\"vehicleID\" value=\""+vehicle.getVehicleID()+"\">\n"
                        + "                                                                            <button type=\"submit\" name=\"action\" value=\"delete\" class=\"btn btn-primary\">\n"
                        + "                                                                                Delete\n"
                        + "                                                                            </button>\n"
                        + "                                                                            <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n"
                        + "                                                                        </div>\n"
                        + "                                                                    </form>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                        </div>\n"
                        + "                                                    </td>"
                );
            } else {
                throw new Exception("Not have any updated Vehicle");
            }
        } catch (Exception e) {
            System.out.println("Error at show Vehicle Update " + e.toString());
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
