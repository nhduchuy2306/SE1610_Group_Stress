
package com.stress.controllers;

import com.stress.dao.DriverDAO;
import com.stress.dto.Driver;
import com.stress.service.DriverDAOImpl;
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
@WebServlet(name = "DriverController", urlPatterns = {"/admin/driver"})
public class DriverController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action.equals("")){
            
        }
        else if(action.equals("show")){
            showDriverTable(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void showDriverTable(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            DriverDAO dao = new DriverDAOImpl();
            List<Driver> list = dao.getAllDriver();
            request.setAttribute("LIST_ALL_DRIVER", list);
            request.getRequestDispatcher("/admin/driverTable.jsp").forward(request, response);   
        } catch (Exception e) {
        }
    }
}
