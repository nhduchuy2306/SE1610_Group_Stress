/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.stress.controllers;

import com.paypal.base.rest.PayPalRESTException;
import com.stress.dto.User;
import com.stress.service.PayPalService;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "PayPalRequestController", urlPatterns = {"/PayPalRequest"})
public class PayPalRequestController extends HttpServlet {

    public static final String PAYPAL_SUCCESS = "recharge?action=recharge";
    public static final String PAYPAL_CANCEL = "recharge?action=recharge";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "sendPayPal":
                    pay(request, response);
                    break;
                case "cancel":
                    results(request, response);
                    break;
                case "success":
                    results(request, response);
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
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "sendPayPal":
                    pay(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void pay(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("LOGIN_USER");
            String price = request.getParameter("amount");
            
            PayPalService paypalService = new PayPalService();
            String approvalLink = paypalService.authorizePayment(price, user);
            response.sendRedirect(approvalLink);
            
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            request.getRequestDispatcher("/client/error.jsp").forward(request, response);
        }
    }
    
    public void results(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try {
            String action = request.getParameter("action");
            PrintWriter out = response.getWriter();
            
            if(action.equals("success")){
                out.println("Thanh toan thanh cong");
            }
            else{
                out.println("Thanh toan that bai");
            }
        } catch (Exception e) {
        }
    }
}
