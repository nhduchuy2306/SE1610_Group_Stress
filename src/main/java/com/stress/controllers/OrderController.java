
package com.stress.controllers;

import com.stress.dao.OrderDAO;
import com.stress.dao.TicketDAO;
import com.stress.dto.Order;
import com.stress.dto.Ticket;
import com.stress.dto.User;
import com.stress.service.OrderDAOImpl;
import com.stress.service.TicketDAOImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "OrderController", urlPatterns = {"/order"})
public class OrderController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            switch (action) {
                case "showHistory":
                    showOrderView(request,response);
                    break;
                case "detail":
                    showDetailView(request,response);
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

    private void showOrderView(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        try {
            OrderDAO orderDAO = new OrderDAOImpl();
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("LOGIN_USER");
            if(user!=null){
                List<Order> list = orderDAO.getAllOrderByUserID(user.getUserID());
                if(list!=null){
                    request.setAttribute("ORDER_LIST", list);
                    request.getRequestDispatcher("/client/profile.jsp").forward(request, response);
                }
                else{
                    request.setAttribute("NO_INFORMATION", "NO INFORMATION");
                    request.getRequestDispatcher("/client/profile.jsp").forward(request, response);
                }
            }
            else{
                request.setAttribute("NO_INFORMATION", "NO INFORMATION");
                request.getRequestDispatcher("/client/profile.jsp").forward(request, response);
            }
        } catch (Exception e) {
        }
    }

    private void showDetailView(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException{
        try {
            String orderID = request.getParameter("orderID");
            TicketDAO ticketDAO = new TicketDAOImpl();
            Ticket ticket = ticketDAO.getTicketByOrderID(orderID);
            request.setAttribute("TICKET", ticket);
            request.getRequestDispatcher("/client/order-detail.jsp").forward(request, response);
        } catch (Exception e) {
        } 
    }

}
