///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package com.stress.controllers;
//
//import com.stress.dao.UserDAO;
//import com.stress.dto.User;
//import com.stress.service.UserDAOImpl;
//import com.stress.utils.VerifyRecaptcha;
//import java.io.IOException;
//import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// *
// * @author KieuMinhHieu
// */
//@WebServlet(name = "UserController", urlPatterns = {"/user"})
//public class UserController extends HttpServlet {
//
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        try {
//            String action = request.getParameter("action");
//            System.out.println("action:" + action);
//            switch (action) {
//                case "viewUser":
//                    viewUser(request, response);
//                    break;
//                case "delete":
//                    deleteUser(request, response);
//                    break;
//            }
//        } catch (Exception e) {
//            log("Error at UserController-doGet: "+e.toString());
//        }
//        
//    }
//
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        try {
//            String action = request.getParameter("action");
//            System.out.println("action:" + action);
//            switch (action) {
//                case "RegisterAccount":
//                    registerUser(request, response);
//                    break;
//                case "update":
//                    updateUser(request, response);
//                    break;
//                case "Login":
//                    loginUser(request, response);
//                    break;
//            }
//        } catch (Exception e) {
//
//        }    
//    }
//
//    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String url="./client/register.jsp";
//        try {
//            String userName=request.getParameter("userName");
//            String birthday=request.getParameter("birthday");
//            String gender=request.getParameter("gender");
//            String email=request.getParameter("email");
//            String address=request.getParameter("address");
//            String phoneNum=request.getParameter("phoneNum");
//            String userID=request.getParameter("userID");
//            String password=request.getParameter("password");
//            String repeatPassword=request.getParameter("repeatPassword");
//            boolean checkValidation=true;
//            if(!password.equals(repeatPassword)){
//                request.setAttribute("ERROR", "Password is not match!");
//                checkValidation=false;
//            }
//            UserDAO dao=new UserDAOImpl();
//            boolean checkDuplicate=dao.checkDuplicateByID(userID,email);
//            boolean check=dao.registerNewUSer(userID, userName, password, email, birthday, address, phoneNum, gender);
//            if(checkValidation==true){
//               if (checkDuplicate == true) {
//                    if (check == true) {
//                    url = "./client/login.jsp";
//                    }
//                }
//           }
//        } catch (Exception e) {
//            log("Error at UserController - Register:"+e.toString());
//        }finally{
//            request.getRequestDispatcher(url).forward(request, response);
//        }
//    }
//
//    private void viewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        String url="./admin/404.jsp";
//        try {
//            UserDAO dao=new UserDAOImpl();
//            List <User> list=dao.getAllUser();
//            if(!list.isEmpty()){
//                request.setAttribute("LIST_USER", list);
//                url="./admin/userTable.jsp";
//            }
//        } catch (Exception e) {
//            log("Error at UserController - ViewUser: "+ e.toString());
//        }finally{
//            request.getRequestDispatcher(url).forward(request, response);
//        }
//    }
//
//    private void updateUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        request.setCharacterEncoding("utf-8");
//        try {
//            String userID=request.getParameter("userID");
//            String userName=request.getParameter("userName");
//            String birthday=request.getParameter("birthday");
//            String gender=request.getParameter("gender");
//            String email=request.getParameter("email");
//            String address=request.getParameter("address");
//            String phoneNum=request.getParameter("phoneNum");
//            String roleID=request.getParameter("roleID");
//            String status=request.getParameter("status");
//            UserDAO dao=new UserDAOImpl();
//            boolean checkUpdate=dao.updateUser(userID, userName,email, birthday, address, phoneNum, gender, roleID, status);
//            if(checkUpdate){
//                viewUser(request, response);
//            }
//        } catch (Exception e) {
//            log("Error at UserController - updateUser: "+ e.toString());
//        }
//        
//    }
//
//    private void deleteUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
//        try {
//            String userID=request.getParameter("userID");
//            UserDAO dao=new UserDAOImpl();
//            boolean check=dao.deleteUser(userID);
//            if(check){
//                viewUser(request, response);
//            }
//        } catch (Exception e) {
//            log("Error at UserController - deleteUser: "+ e.toString());
//        } 
//    }
//
//    private void loginUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
//        String url="./client/login.jsp";
//        try {
//            String userID=request.getParameter("userID");
//            String password=request.getParameter("password");
//            String captcha = request.getParameter("g-recaptcha-response");
//            UserDAO dao=new UserDAOImpl();
//            User loginUser=dao.getUserByIDAndPassword(userID, password);
//            boolean verify = VerifyRecaptcha.verify(captcha);
//            System.out.println(verify);
//            if(loginUser!=null && verify){
//            String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
//            VerifyRecaptcha verifyCaptcha=new VerifyRecaptcha();
//            boolean verify=verifyCaptcha.verifyCaptcha(gRecaptchaResponse);
//            System.out.println("Captcha: "+ verify);
//            if(loginUser!=null && verify==true){
//                HttpSession session =request.getSession();
//                
//                session.setAttribute("LOGIN_USER", loginUser);
//                if(loginUser.getRole().getRoleID().equals("1")){
//                    url="./client/index.jsp";
//                }else if(loginUser.getRole().getRoleID().equals("2")){
//                    url="./admin/index.jsp";
//                }else{
//                    url="./admin/index.jsp";
//                }
//            }
//        } catch (Exception e) {
//            log("Error at UserController - Login: "+e.toString());
//        } finally {
//            request.getRequestDispatcher(url).forward(request, response);
//        }
//        
//        
//    }
//    
//
//    
//}