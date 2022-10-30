/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.stress.controllers;

import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;
import com.stress.service.PayPalService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Huy
 */
@WebServlet(name = "PayPalResponseController", urlPatterns = {"/PayPalResponse"})
public class PayPalResponse extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paymentId = request.getParameter("paymentId");
        String payerId = request.getParameter("PayerID");
         
        try {
            PayPalService paypalService = new PayPalService();
            Payment payment = paypalService.executePayment(paymentId, payerId);
             
//            PayerInfo payerInfo = paypalService.getPaymentDetails(paymentId).getPayer().getPayerInfo();
//            Transaction transaction = payment.getTransactions().get(0);
//            ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();     

            request.getRequestDispatcher("/recharge?action=recharge").forward(request, response);
             
        } catch (PayPalRESTException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            request.getRequestDispatcher("/client/error.jsp").forward(request, response);
        }    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
