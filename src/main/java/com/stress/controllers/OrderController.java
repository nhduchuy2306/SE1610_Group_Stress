package com.stress.controllers;

import com.stress.dao.OrderDAO;
import com.stress.dao.SeatDAO;
import com.stress.dao.TicketDAO;
import com.stress.dao.UserDAO;
import com.stress.dto.Order;
import com.stress.dto.Seat;
import com.stress.dto.Ticket;
import com.stress.dto.User;
import com.stress.service.OrderDAOImpl;
import com.stress.service.SeatDAOImpl;
import com.stress.service.TicketDAOImpl;
import com.stress.service.UserDAOImpl;
import com.stress.utils.Email;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
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
                    showOrderView(request, response);
                    break;
                case "detail":
                    showDetailView(request, response);
                    break;
                case "Return":
                    showReturnTicket(request, response);
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

        try {
            String action = request.getParameter("action");
            switch (action) {
                case "showHistory":
                    showOrderView(request, response);
                    break;
                case "detail":
                    showDetailView(request, response);
                    break;
                case "return":
                    returnTicket(request, response);
                    break;
                case "Return":
                    showReturnTicket(request, response);
                    break;
                case "Approve":
                    approveReturnTicket(request, response);
                    break;
                case "Reject":
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
            System.out.println("Error at Post " + e.toString());
        }
    }

    private void approveReturnTicket(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "./client/404.jsp";
        try {
            String orderID = request.getParameter("orderID");
            OrderDAO orderDAO = new OrderDAOImpl();
            // should set status for order to INT
            Order od = orderDAO.getOderByID(orderID);
            if (od != null) {
                SeatDAO sDAO = new SeatDAOImpl();
                TicketDAO tDAO = new TicketDAOImpl();
                List<Ticket> ticketList = tDAO.getTicketByOrderID(orderID);
                // Get Total Money to return for User
                double returnMoney = 0;
                if(ticketList.size() > 0) {
                    for (Ticket ticket : ticketList) {
                        returnMoney += ticket.getSeat().getPrice();
                        sDAO.updateSeat(ticket.getTrip().getTripID(), ticket.getSeat().getSeatID());
                    }
                }
                
                double accountBalance = Double.parseDouble(od.getUser().getAccountBalance());
                accountBalance += returnMoney;
                
                
                new UserDAOImpl().updateUser(od.getUser().getUserID(), String.valueOf(accountBalance));
                
                Email.sendEmail(od.getUser().getEmail(), "", "The Return Ticket Request Has been Approved!\nPlease Check Again Information:\nOrder: "
                        + od.getOrderID() + "\n" + "Create Date: " + od.getCreateDate() + "\n\tWe have recover money into Your AccountBalance! For further information"
                                + ", Please Contact: 079_809_1101\n\t\t\tGROUP STRESS" , "Return Ticket Successfully");
                request.setAttribute("ORDER", od);
                request.setAttribute("RETURN_SUCCESS", "Approve Return Success!");
                url = "./admin/orderTable.jsp";
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Error at Approve Return Ticket Controller " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    private void showReturnTicket(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "./client/404.jsp";
        try {
            String orderID = request.getParameter("orderID");
            OrderDAO orderDAO = new OrderDAOImpl();
            Order od = orderDAO.getOderByID(orderID);
            if (od != null) {
                request.setAttribute("ORDER", od);
                HttpSession session = request.getSession();
                session.setAttribute("LOGIN_USER", new UserDAOImpl().getUserByEmail("quangtmse161987@fpt.edu.vn"));
                url = "./admin/orderTable.jsp";
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Error at Return Ticket Controller " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    private void returnTicket(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "./client/404.jsp";
        try {

            String orderID = request.getParameter("orderID");
            OrderDAO oDAO = new OrderDAOImpl();
            Order od = oDAO.getOderByID(orderID);
            List<Ticket> ticketList = new TicketDAOImpl().getTicketByOrderID(orderID);
            Date goingDate = ticketList.get(0).getSeat().getTrip().getStartDateTime();
            if(Date.valueOf(LocalDate.now()).after(goingDate)) {
                request.setAttribute("ERROR", "Cant not Return this Order! This Trip is already Going");
                showDetailView(request, response);
            } else {
            Email.sendEmail("quangtmse161987@fpt.edu.vn", "", "A customer want to Return an Order\n" + "Please "
                    + "click at the link below\n"
                    + "http://localhost:8080/ETrans/order?action=Return&orderID=" + orderID, "Return Order Request");
            request.setAttribute("RETURN_ORDER_SUCCESS", "An Email has send to Staff. You Request will be processed in a shortest Time");
            showDetailView(request, response);
            }

        } catch (Exception e) {
            System.out.println("Error at Return Ticket Controller " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

    private void showOrderView(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            OrderDAO orderDAO = new OrderDAOImpl();
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("LOGIN_USER");
            if (user != null) {
                List<Order> list = orderDAO.getAllOrderByUserID(user.getUserID());
                if (list != null) {
                    request.setAttribute("ORDER_LIST", list);
                    request.getRequestDispatcher("./client/profile.jsp").forward(request, response);
                } else {
                    request.setAttribute("NO_INFORMATION", "NO INFORMATION");
                    request.getRequestDispatcher("./client/profile.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("NO_INFORMATION", "NO INFORMATION");
                request.getRequestDispatcher("./client/profile.jsp").forward(request, response);
            }
        } catch (Exception e) {
        }
    }

    private void showDetailView(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String orderID = request.getParameter("orderID");
            TicketDAO ticketDAO = new TicketDAOImpl();
            List<Ticket> ticket = ticketDAO.getTicketByOrderID(orderID);
            request.setAttribute("ORDER_ID", orderID);
            request.setAttribute("TICKET", ticket);
            request.getRequestDispatcher("/client/order-detail.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }

}
