/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.stress.controllers;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.stress.dao.UserDAO;
import com.stress.dto.Order;
import com.stress.dto.Trip;
import com.stress.dto.User;
import com.stress.service.PayPalService;
import com.stress.service.UserDAOImpl;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Huy
 */
@WebServlet(name = "PayPalResponseController", urlPatterns = {"/PayPalResponse"})
public class PayPalResponse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/client/error.jsp";
        UserDAO userDAO = new UserDAOImpl();
        HttpSession session = request.getSession();
        String paymentId = request.getParameter("paymentId");
        String payerId = request.getParameter("PayerID");
        
        if(paymentId==null && payerId ==null){
            request.setAttribute("MONEY_RECHARGE_FAIL", "RECHARGE MOMNEY VIA PAYPAL FAIL");
            request.getRequestDispatcher("/recharge?action=recharge").forward(request, response);
        }
        else{
            try {
                String money = (String) session.getAttribute("Paypal_recharge");
                User user = (User) session.getAttribute("LOGIN_USER");

                PayPalService paypalService = new PayPalService();
                Payment payment = paypalService.executePayment(paymentId, payerId);
                String state = payment.getState();

                if (state.equals("approved")) {
                    double curMoney = Double.parseDouble(user.getAccountBalance());
                    double moreMoney = Double.parseDouble(money);
                    String total = String.valueOf(curMoney+moreMoney);
                    total = total.substring(0, total.length()-2);

                    user.setAccountBalance(total);


            if (state.equals("approved")) {
                Order order = (Order) session.getAttribute("ORDER");
                if(order!=null){
//                    session.setAttribute("QUANTITY", quantity);
//                    session.setAttribute("PRICE", totalPrice);
//                    session.setAttribute("TAX", price);
//                    session.setAttribute("SEAT_LIST", seatIDs);
//                    session.setAttribute("ORDER", order);
//                    session.setAttribute("TRIP", choosingTrip);
                    
                    

                    url = "./client/order.jsp";
                }
                double curMoney = Double.parseDouble(user.getAccountBalance());
                double moreMoney = Double.parseDouble(money);
                String total = String.valueOf(curMoney+moreMoney);
                total = total.substring(0, total.length()-2);


                }

                request.setAttribute("paypal_success", "RECHARGE MOMNEY VIA PAYPAL SUCCESSFULLY");
                request.getRequestDispatcher(url).forward(request, response);
                

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
