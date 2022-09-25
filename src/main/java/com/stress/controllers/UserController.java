/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.stress.controllers;

import com.stress.dao.IUser;
import com.stress.service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KieuMinhHieu
 */
@WebServlet(name = "UserController", urlPatterns = {"/user"})
public class UserController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        switch (action) {
            case "update":
                updateUser(request,response);
                break;
            case "RegisterAccount":
                registerUser(request,response);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String name=request.getParameter("action");
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url="./client/register.jsp";
        try {
            String userName=request.getParameter("userName");
            String birthday=request.getParameter("birthday");
            String gender=request.getParameter("gender");
            String email=request.getParameter("email");
            String address=request.getParameter("address");
            String phoneNum=request.getParameter("phoneNum");
            String userID=request.getParameter("userID");
            String password=request.getParameter("password");
            String repeatPassword=request.getParameter("repeatPassword");
            boolean checkValidation=true;
            if(!password.equals(repeatPassword)){
                request.setAttribute("ERROR", "Password is not match!");
                checkValidation=false;
            }
            IUser dao=new UserService();
            boolean checkDuplicate=dao.checkDuplicateByID(userID);
            boolean check=dao.registerNewUSer(userID, userName, password, email, birthday, address, phoneNum, gender);
            if(checkValidation==true){
               if (checkDuplicate == true) {
                    if (check == true) {
                    url = "./client/login.jsp";
                    }
                }
           }
        } catch (Exception e) {
            log("Error at UserController - Register:"+e.toString());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
    

    
}
