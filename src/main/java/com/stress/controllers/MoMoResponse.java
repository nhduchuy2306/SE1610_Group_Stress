/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.stress.controllers;

import com.stress.dao.UserDAO;
import com.stress.dto.User;
import com.stress.service.UserDAOImpl;
import static com.stress.utils.Constants.ACCESS_KEY;
import static com.stress.utils.Constants.SECRET_KEY;
import static com.stress.utils.DigitalSignature.signHmacSHA256;
import java.io.IOException;
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
@WebServlet(name = "MoMoResponse", urlPatterns = {"/MoMoResponse"})
public class MoMoResponse extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String partnerCode = request.getParameter("partnerCode");
            String orderId = request.getParameter("orderId");
            String requestId = request.getParameter("requestId");
            String amount = request.getParameter("amount");
            String orderInfo = request.getParameter("orderInfo");
            String extraData = request.getParameter("extraData");
            String signature = request.getParameter("signature");
            String resultCode = request.getParameter("resultCode");
            String message = request.getParameter("message");
            String orderType = request.getParameter("orderType");
            String payType = request.getParameter("payType");
            String responseTime = request.getParameter("responseTime");
            String transId = request.getParameter("transId");

            String requestRawData = new StringBuilder()
                    .append("accessKey").append("=").append(ACCESS_KEY).append("&")
                    .append("amount").append("=").append(amount).append("&")
                    .append("extraData").append("=").append(extraData).append("&")
                    .append("message").append("=").append(message).append("&")
                    .append("orderId").append("=").append(orderId).append("&")
                    .append("orderInfo").append("=").append(orderInfo).append("&")
                    .append("orderType").append("=").append(orderType).append("&")
                    .append("partnerCode").append("=").append(partnerCode).append("&")
                    .append("payType").append("=").append(payType).append("&")
                    .append("requestId").append("=").append(requestId).append("&")
                    .append("responseTime").append("=").append(responseTime).append("&")
                    .append("resultCode").append("=").append(resultCode).append("&")
                    .append("transId").append("=").append(transId)
                    .toString();

            String signRequest = signHmacSHA256(requestRawData, SECRET_KEY);

            
            if (!signRequest.equals(signature)) {
                request.setAttribute("WRONG", "Thông tin không hợp lệ");
                request.getRequestDispatcher("success.jsp").forward(request, response);
            }
            if (!resultCode.equals("0")) {
                request.setAttribute("FAIL", "Thanh toán thất bại");
                request.getRequestDispatcher("success.jsp").forward(request, response);
            } else {
                request.setAttribute("SUCCESS", "Thanh toán thành công");
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("LOGIN_USER");
                UserDAO userDAO = new UserDAOImpl();
                boolean check = userDAO.updateUser(user.getUserID(), amount);
                if(check)
                    request.getRequestDispatcher("/client/recharge.jsp").forward(request, response);
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
