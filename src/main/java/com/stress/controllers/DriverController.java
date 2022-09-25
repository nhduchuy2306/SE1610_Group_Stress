package com.stress.controllers;

import com.stress.dao.DriverDAO;
import com.stress.dto.Driver;
import com.stress.service.DriverDAOImpl;
import java.io.IOException;
import java.sql.Date;
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
@WebServlet(name = "DriverController", urlPatterns = {"/driver"})
public class DriverController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "add":
                addNewDriver(request, response);
                break;
            case "delete":
                deleteDriver(request, response);
                break;
            case "update":
                updateDriver(request, response);
                break;
            case "show":
                showDriverTable(request, response);
                break;
        }
    }

    private void showDriverTable(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            DriverDAO dao = new DriverDAOImpl();
            List<Driver> list = dao.getAllDriver();
            if (list != null) {
                request.setAttribute("LIST_ALL_DRIVER", list);
                request.getRequestDispatcher("/admin/driverTable.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addNewDriver(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String driverID = request.getParameter("driverID").trim();
            String driverName = request.getParameter("driverName").trim();
            String dob = request.getParameter("DOB").trim();
            String sex = request.getParameter("sex").trim();
            String driverPic = request.getParameter("driverPic").trim();
            String phoneNumber = request.getParameter("phoneNumber").trim();
            String status = request.getParameter("status").trim();

            DriverDAO dao = new DriverDAOImpl();
            Driver driverTmp = dao.getDriverByID(driverID);

            if (driverTmp != null) {
                request.setAttribute("ERROR", "DUPLICATE DRIVER ID");
                request.getRequestDispatcher("/driver?action=show").forward(request, response);
            } else {
                Driver driver = new Driver(driverID, driverName, Date.valueOf(dob), Boolean.parseBoolean(sex),
                        driverPic, phoneNumber, Integer.parseInt(status));

                boolean check = dao.addNewDriver(driver);
                if (check) {
                    request.setAttribute("SUCCESS", "ADD DRIVER SUCCESSFULLY");
                    request.getRequestDispatcher("/driver?action=show").forward(request, response);
                } else {
                    request.setAttribute("ERROR", "CAN NOT ADD DRIVER");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteDriver(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String driverID = request.getParameter("driverID").trim();
            DriverDAO dao = new DriverDAOImpl();
            boolean check = dao.deleteDriver(driverID);
            if (check) {
                request.setAttribute("SUCCESS", "DELETE DRIVER SUCCESSFULLY");
                request.getRequestDispatcher("/driver?action=show").forward(request, response);
            } else {
                request.setAttribute("ERROR", "CAN NOT DELETE DRIVER");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateDriver(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String driverID = request.getParameter("driverID").trim();
            String driverName = request.getParameter("driverName").trim();
            String dob = request.getParameter("DOB").trim();
            String sex = request.getParameter("sex").trim();
            String driverPic = request.getParameter("driverPic").trim();
            String phoneNumber = request.getParameter("phoneNumber").trim();
            String status = request.getParameter("status").trim();
            
            Driver driver = new Driver(driverID, driverName, Date.valueOf(dob), Boolean.parseBoolean(sex), 
                    driverPic, phoneNumber, Integer.parseInt(status));
            
            DriverDAO dao = new DriverDAOImpl();
            boolean check = dao.updateDriver(driver);
            
            if (check) {
                request.setAttribute("SUCCESS", "UPDATE DRIVER SUCCESSFULLY");
                request.getRequestDispatcher("/driver?action=show").forward(request, response);
            } else {
                request.setAttribute("ERROR", "CAN NOT UPDATE DRIVER");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
