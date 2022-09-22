/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.stress.controllers;

import com.stress.dao.UserDAO;
import com.stress.dto.GooglePojo;
import com.stress.service.UserDAOImpl;
import com.stress.utils.GoogleUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.stress.dto.User;

/**
 *
 * @author Huy, Quangtm
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginGoogleController extends HttpServlet {

    
    private static final String ERROR = "login.jsp";
    private static final String REGISTER = "register.jsp";
    private static final String USER_ROLE = "1";
    private static final String ADMIN_ROLE = "2"; 
    private static final String ADMIN = "admin/index.jsp";
    private static final String USER = "index.jsp";
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String url = ERROR;
        try {
            String code = request.getParameter("code");
            if (code != null && !code.isEmpty()) {
                String accessToken = GoogleUtils.getToken(code);
                GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);

                // This is a reCaptcha check box using when check login
                // Login With Google, not using Recaptcha
                //String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
                //boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
                if (googlePojo != null) {
                    UserDAO userDao = new UserDAOImpl();
                    User loginUser = userDao.getUserByEmail(googlePojo.getEmail());
                    if (loginUser != null) {
                        session.setAttribute("LOGIN_USER", loginUser);
                        if(loginUser.getRoleID().trim().equals(ADMIN_ROLE)) {
                            System.out.println("Welcome Admin");
                            url = ADMIN;
                        }
                        if(loginUser.getRoleID().trim().equals(USER_ROLE)) url = USER;
                        
                       
                    } else {
                        session.setAttribute("LOGIN_USER", loginUser);
                        url = REGISTER;
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("Error at Login Google Controller " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
