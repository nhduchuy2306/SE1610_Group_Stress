package com.stress.controllers;

import com.stress.dao.DriverDAO;
import com.stress.dto.Driver;
import com.stress.service.DriverDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
@WebServlet(name = "DriverController", urlPatterns = {"/driver"})
public class DriverController extends HttpServlet {

    private Driver driver = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");

        switch (action) {
            case "add":
                addNewDriver(request, response);
                break;
            case "delete":
                deleteDriver(request, response);
                break;
            case "update":
                updateDriver(request, response);
                break;
            case "show":
                showDriverTable(request, response);
                break;
            case "driverUpdate":
                showDriverUpdate(request, response);
                break;
            case "search":
                searchDriver(request, response);
                break;
            case "isContain":
                showDriverID(request, response);
                break;
            default:
//                showErrorPage(request, response);
                break;
        }
    }

    private void showDriverTable(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            DriverDAO dao = new DriverDAOImpl();
            List<Driver> list = dao.getAllDriver();
            if (list != null) {
                request.setAttribute("LIST_ALL_DRIVER", list);
                request.getRequestDispatcher("/admin/driverTable.jsp").forward(request, response);
            } else {
                showErrorPage(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addNewDriver(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            String driverID = request.getParameter("driverID").trim();
            String driverName = request.getParameter("driverName").trim();
            String dob = request.getParameter("DOB").trim();
            String sex = request.getParameter("sex").trim();
            String driverPic = request.getParameter("driverPic").trim();
            String phoneNumber = request.getParameter("phoneNumber").trim();
            String status = request.getParameter("status").trim();

            DriverDAO dao = new DriverDAOImpl();
            Driver driverTmp = dao.getDriverByID(driverID);

            if (driverTmp != null) {
                request.setAttribute("ERROR", "DUPLICATE DRIVER ID");
                request.getRequestDispatcher("/driver?action=show").forward(request, response);
            } else {
                driver = new Driver(driverID, driverName, Date.valueOf(dob), Boolean.parseBoolean(sex),
                        driverPic, phoneNumber, Integer.parseInt(status));

                boolean check = dao.addNewDriver(driver);
                if (check) {
                    request.setAttribute("SUCCESS", "ADD DRIVER SUCCESSFULLY");
                    request.setAttribute("ADD", "SUCCESS");
                    request.getRequestDispatcher("/driver?action=show").forward(request, response);
                } else {
                    request.setAttribute("ERROR", "CAN NOT ADD DRIVER");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteDriver(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            String driverID = request.getParameter("driverID").trim();
            DriverDAO dao = new DriverDAOImpl();
            boolean check = dao.deleteDriver(driverID);
            if (check) {
                request.setAttribute("SUCCESS", "DELETE DRIVER SUCCESSFULLY");
                request.getRequestDispatcher("/driver?action=show").forward(request, response);
            } else {
                request.setAttribute("ERROR", "CAN NOT DELETE DRIVER");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateDriver(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            String driverID = request.getParameter("driverID").trim();
            String driverName = request.getParameter("driverName").trim();
            String dob = request.getParameter("DOB").trim();
            String sex = request.getParameter("sex").trim();
            String driverPic = request.getParameter("driverPic").trim();
            String phoneNumber = request.getParameter("phoneNumber").trim();
            String status = request.getParameter("status").trim();

            driver = new Driver(driverID, driverName, Date.valueOf(dob), Boolean.parseBoolean(sex),
                    driverPic, phoneNumber, Integer.parseInt(status));

            DriverDAO dao = new DriverDAOImpl();
            boolean check = dao.updateDriver(driver);

            if (check) {
                request.setAttribute("SUCCESS", "UPDATE DRIVER SUCCESSFULLY");
                request.setAttribute("UPDATE", "SUCEESS");
                request.getRequestDispatcher("/driver?action=show").forward(request, response);
            } else {
                request.setAttribute("ERROR", "CAN NOT UPDATE DRIVER");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showErrorPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/client/error.jsp").forward(request, response);
    }

    private void showDriverUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            DriverDAO dao = new DriverDAOImpl();
            if(driver==null){
                driver = new Driver("D001", "Nguyễn Hoàng Đức Huy", Date.valueOf("2002-06-23"), 
                        true, "", "09812345678", 1);
            }
            driver = dao.getDriverByID(driver.getDriverID());
            System.out.println(driver);
            String Driverstatus = "";
            if (driver.getStatus() == 0) {
                Driverstatus = "INACTIVE";
            }
            if (driver.getStatus() == 1) {
                Driverstatus = "ACTIVE";
            }
            if (driver.getStatus() == 2) {
                Driverstatus = "ONGOING";
            }

            PrintWriter out = response.getWriter();

            out.println("<tr>\n"
                    + "                                                    <td>1</td>\n"
                    + "                                                    <td>" + driver.getDriverID() + "</td>\n"
                    + "                                                    <td>" + driver.getDriverName() + "</td>\n"
                    + "                                                    <td>" + driver.getDOB() + "</td>\n"
                    + "                                                    <td>" + (driver.isSex() == true ? "MALE" : "FEMALE") + "</td>\n"
                    + "                                                    <td><<img src=\"" + driver.getDriverPicture() + "\" alt=\"alt\"/></td>\n"
                    + "                                                    <td>" + driver.getPhoneNumber() + "</td>\n"
                    + "                                                    <td>" + Driverstatus + "</td>\n"
                    + "                                                    <td>\n"
                    + "                                                        <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#modify-" + driver.getDriverID().trim() + "\">\n"
                    + "                                                            <i class=\"fa fa-pen\"></i>\n"
                    + "                                                        </button>\n"
                    + "                                                        <div class=\"modal fade\" id=\"modify-" + driver.getDriverID().trim() + "\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n"
                    + "                                                            <div class=\"modal-dialog\" role=\"document\">\n"
                    + "                                                                <div class=\"modal-content\">\n"
                    + "                                                                    <div class=\"modal-header\">\n"
                    + "                                                                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Modify Driver " + driver.getDriverName().trim() + "</h5>\n"
                    + "                                                                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n"
                    + "                                                                            <span aria-hidden=\"true\">&times;</span>\n"
                    + "                                                                        </button>\n"
                    + "                                                                    </div>\n"
                    + "                                                                    <form action=\"driver\">\n"
                    + "                                                                        <div class=\"modal-body\">\n"
                    + "                                                                            <div class=\"modal-body\">\n"
                    + "                                                                                <div class=\"form-group\">\n"
                    + "                                                                                    <label for=\"exampleInputEmail1\">Driver ID</label>\n"
                    + "                                                                                    <input type=\"text\" name=\"driverID\" class=\"form-control\" value=\"" + driver.getDriverID().trim() + "\" id=\"exampleInputEmail1\" readonly placeholder=\"Enter Driver ID\">\n"
                    + "                                                                                </div>\n"
                    + "                                                                                <div class=\"form-group\">\n"
                    + "                                                                                    <label for=\"exampleInputEmail1\">Driver Name</label>\n"
                    + "                                                                                    <input type=\"text\" name=\"driverName\" class=\"form-control\" value=\"" + driver.getDriverName().trim() + "\" id=\"exampleInputEmail1\" placeholder=\"Enter Driver Name\">\n"
                    + "                                                                                </div>\n"
                    + "                                                                                <div class=\"form-group\">\n"
                    + "                                                                                    <label for=\"exampleInputEmail1\">DOB</label>\n"
                    + "                                                                                    <input type=\"date\" name=\"DOB\" class=\"form-control\" value=\"" + driver.getDOB() + "\" id=\"exampleInputEmail1\" placeholder=\"Enter DOB\">\n"
                    + "                                                                                </div>\n"
                    + "                                                                                <div class=\"form-group\">\n"
                    + "                                                                                    <label for=\"exampleInputEmail1\">Gender</label>\n"
                    + "                                                                                    <select name=\"sex\" class=\"form-control\">\n"
                    + "                                                                                        <option value=\"true\"" + (driver.isSex() == true ? "selected" : "") + ">MALE</option>\n"
                    + "                                                                                        <option value=\"false\" " + (driver.isSex() == false ? "selected" : "") + ">FEMALE</option>\n"
                    + "                                                                                    </select>\n"
                    + "                                                                                </div>\n"
                    + "                                                                                <div class=\"form-group\">\n"
                    + "                                                                                    <label for=\"exampleInputEmail1\">Driver Picture</label>\n"
                    + "                                                                                    <input type=\"text\" name=\"driverPic\" class=\"form-control\" value=\"" + driver.getDriverPicture() + "\" id=\"exampleInputEmail1\" placeholder=\"Enter Driver Picture\">\n"
                    + "                                                                                </div>\n"
                    + "                                                                                <div class=\"form-group\">\n"
                    + "                                                                                    <label for=\"exampleInputEmail1\">Phone Number</label>\n"
                    + "                                                                                    <input type=\"text\" name=\"phoneNumber\" class=\"form-control\" value=\"" + driver.getPhoneNumber() + "\" id=\"exampleInputEmail1\" placeholder=\"Enter Phone Number\">\n"
                    + "                                                                                </div>\n"
                    + "                                                                                <div class=\"form-group\">\n"
                    + "                                                                                    <label for=\"exampleInputEmail1\">Status</label>\n"
                    + "                                                                                    <select name=\"status\" class=\"form-control\">\n"
                    + "                                                                                        <option value=\"0\"" + (driver.getStatus() == 0 ? "selected" : "") + ">INACTIVE</option>\n"
                    + "                                                                                        <option value=\"1\" " + (driver.getStatus() == 1 ? "selected" : "") + ">ACTIVE</option>\n"
                    + "                                                                                        <option value=\"2\" " + (driver.getStatus() == 2 ? "selected" : "") + ">ONGOING</option>\n"
                    + "                                                                                    </select>\n"
                    + "                                                                                </div>\n"
                    + "                                                                            </div>\n"
                    + "                                                                        </div>\n"
                    + "                                                                        <div class=\"modal-footer\">\n"
                    + "                                                                            <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n"
                    + "                                                                            <button type=\"submit\" name=\"action\" value=\"update\" class=\"update-button btn btn-primary\">Save</button>\n"
                    + "                                                                        </div>\n"
                    + "                                                                    </form>\n"
                    + "                                                                </div>\n"
                    + "                                                            </div>\n"
                    + "                                                        </div>\n"
                    + "                                                    </td>\n"
                    + "                                                    <td>\n"
                    + "                                                        <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#delete-" + driver.getDriverID() + "\">\n"
                    + "                                                            <i class=\"fa fa-trash\" aria-hidden=\"true\"></i>\n"
                    + "                                                        </button>\n"
                    + "                                                        <div class=\"modal fade\" id=\"delete-" + driver.getDriverID().trim() + "\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n"
                    + "                                                            <div class=\"modal-dialog\" role=\"document\">\n"
                    + "                                                                <div class=\"modal-content\">\n"
                    + "                                                                    <div class=\"modal-header\">\n"
                    + "                                                                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Delete Driver " + driver.getDriverName() + "</h5>\n"
                    + "                                                                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n"
                    + "                                                                            <span aria-hidden=\"true\">&times;</span>\n"
                    + "                                                                        </button>\n"
                    + "                                                                    </div>\n"
                    + "                                                                    <form action=\"driver\">\n"
                    + "                                                                        <div class=\"modal-footer\">\n"
                    + "                                                                            <input type=\"hidden\" name=\"driverID\" value=\"" + driver.getDriverID() + "\">\n"
                    + "                                                                            <button type=\"submit\" name=\"action\" value=\"delete\" class=\"btn btn-primary\">\n"
                    + "                                                                                Delete\n"
                    + "                                                                            </button>\n"
                    + "                                                                            <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n"
                    + "                                                                        </div>\n"
                    + "                                                                    </form>\n"
                    + "                                                                </div>\n"
                    + "                                                            </div>\n"
                    + "                                                        </div>\n"
                    + "                                                    </td>\n"
                    + "                                                </tr>");
        } catch (Exception e) {
        }
    }
    
    private void showDriverID(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            String driverId = request.getParameter("driverId");
            DriverDAO dao = new DriverDAOImpl();
            driver = dao.getDriverByID(driverId);
            PrintWriter out = response.getWriter();
            out.println(driver);
            out.close();
        } catch (Exception e) {
        }
    }

    private void searchDriver(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            String txt = request.getParameter("txt");
            DriverDAO dao = new DriverDAOImpl();
            List<Driver> list = dao.getDriverByName(txt);
            PrintWriter out = response.getWriter();
            for (int i = 1; i <= list.size();i++) {
                Driver d = list.get(i);
                String Driverstatus = "";
                if (d.getStatus() == 0) {
                    Driverstatus = "INACTIVE";
                }
                if (d.getStatus() == 1) {
                    Driverstatus = "ACTIVE";
                }
                if (d.getStatus() == 2) {
                    Driverstatus = "ONGOING";
                }
                out.println("<tr>\n"
                    + "                                                    <td>"+i+"</td>\n"
                    + "                                                    <td>" + d.getDriverID() + "</td>\n"
                    + "                                                    <td>" + d.getDriverName() + "</td>\n"
                    + "                                                    <td>" + d.getDOB() + "</td>\n"
                    + "                                                    <td>" + (d.isSex() == true ? "MALE" : "FEMALE") + "</td>\n"
                    + "                                                    <td><<img src=\"" + d.getDriverPicture() + "\" alt=\"alt\"/></td>\n"
                    + "                                                    <td>" + d.getPhoneNumber() + "</td>\n"
                    + "                                                    <td>" + Driverstatus + "</td>\n"
                    + "                                                    <td>\n"
                    + "                                                        <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#modify-" + d.getDriverID().trim() + "\">\n"
                    + "                                                            <i class=\"fa fa-pen\"></i>\n"
                    + "                                                        </button>\n"
                    + "                                                        <div class=\"modal fade\" id=\"modify-" + d.getDriverID().trim() + "\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n"
                    + "                                                            <div class=\"modal-dialog\" role=\"document\">\n"
                    + "                                                                <div class=\"modal-content\">\n"
                    + "                                                                    <div class=\"modal-header\">\n"
                    + "                                                                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Modify Driver " + driver.getDriverName().trim() + "</h5>\n"
                    + "                                                                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n"
                    + "                                                                            <span aria-hidden=\"true\">&times;</span>\n"
                    + "                                                                        </button>\n"
                    + "                                                                    </div>\n"
                    + "                                                                    <form action=\"driver\">\n"
                    + "                                                                        <div class=\"modal-body\">\n"
                    + "                                                                            <div class=\"modal-body\">\n"
                    + "                                                                                <div class=\"form-group\">\n"
                    + "                                                                                    <label for=\"exampleInputEmail1\">Driver ID</label>\n"
                    + "                                                                                    <input type=\"text\" name=\"driverID\" class=\"form-control\" value=\"" + d.getDriverID().trim() + "\" id=\"exampleInputEmail1\" readonly placeholder=\"Enter Driver ID\">\n"
                    + "                                                                                </div>\n"
                    + "                                                                                <div class=\"form-group\">\n"
                    + "                                                                                    <label for=\"exampleInputEmail1\">Driver Name</label>\n"
                    + "                                                                                    <input type=\"text\" name=\"driverName\" class=\"form-control\" value=\"" + d.getDriverName().trim() + "\" id=\"exampleInputEmail1\" placeholder=\"Enter Driver Name\">\n"
                    + "                                                                                </div>\n"
                    + "                                                                                <div class=\"form-group\">\n"
                    + "                                                                                    <label for=\"exampleInputEmail1\">DOB</label>\n"
                    + "                                                                                    <input type=\"date\" name=\"DOB\" class=\"form-control\" value=\"" + d.getDOB() + "\" id=\"exampleInputEmail1\" placeholder=\"Enter DOB\">\n"
                    + "                                                                                </div>\n"
                    + "                                                                                <div class=\"form-group\">\n"
                    + "                                                                                    <label for=\"exampleInputEmail1\">Gender</label>\n"
                    + "                                                                                    <select name=\"sex\" class=\"form-control\">\n"
                    + "                                                                                        <option value=\"true\"" + (d.isSex() == true ? "selected" : "") + ">MALE</option>\n"
                    + "                                                                                        <option value=\"false\" " + (d.isSex() == false ? "selected" : "") + ">FEMALE</option>\n"
                    + "                                                                                    </select>\n"
                    + "                                                                                </div>\n"
                    + "                                                                                <div class=\"form-group\">\n"
                    + "                                                                                    <label for=\"exampleInputEmail1\">Driver Picture</label>\n"
                    + "                                                                                    <input type=\"text\" name=\"driverPic\" class=\"form-control\" value=\"" + d.getDriverPicture() + "\" id=\"exampleInputEmail1\" placeholder=\"Enter Driver Picture\">\n"
                    + "                                                                                </div>\n"
                    + "                                                                                <div class=\"form-group\">\n"
                    + "                                                                                    <label for=\"exampleInputEmail1\">Phone Number</label>\n"
                    + "                                                                                    <input type=\"text\" name=\"phoneNumber\" class=\"form-control\" value=\"" + d.getPhoneNumber() + "\" id=\"exampleInputEmail1\" placeholder=\"Enter Phone Number\">\n"
                    + "                                                                                </div>\n"
                    + "                                                                                <div class=\"form-group\">\n"
                    + "                                                                                    <label for=\"exampleInputEmail1\">Status</label>\n"
                    + "                                                                                    <select name=\"status\" class=\"form-control\">\n"
                    + "                                                                                        <option value=\"0\"" + (d.getStatus() == 0 ? "selected" : "") + ">INACTIVE</option>\n"
                    + "                                                                                        <option value=\"1\" " + (d.getStatus() == 1 ? "selected" : "") + ">ACTIVE</option>\n"
                    + "                                                                                        <option value=\"2\" " + (d.getStatus() == 2 ? "selected" : "") + ">ONGOING</option>\n"
                    + "                                                                                    </select>\n"
                    + "                                                                                </div>\n"
                    + "                                                                            </div>\n"
                    + "                                                                        </div>\n"
                    + "                                                                        <div class=\"modal-footer\">\n"
                    + "                                                                            <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n"
                    + "                                                                            <button type=\"submit\" name=\"action\" value=\"update\" class=\"update-button btn btn-primary\">Save</button>\n"
                    + "                                                                        </div>\n"
                    + "                                                                    </form>\n"
                    + "                                                                </div>\n"
                    + "                                                            </div>\n"
                    + "                                                        </div>\n"
                    + "                                                    </td>\n"
                    + "                                                    <td>\n"
                    + "                                                        <button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#delete-" + d.getDriverID() + "\">\n"
                    + "                                                            <i class=\"fa fa-trash\" aria-hidden=\"true\"></i>\n"
                    + "                                                        </button>\n"
                    + "                                                        <div class=\"modal fade\" id=\"delete-" + d.getDriverID().trim() + "\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n"
                    + "                                                            <div class=\"modal-dialog\" role=\"document\">\n"
                    + "                                                                <div class=\"modal-content\">\n"
                    + "                                                                    <div class=\"modal-header\">\n"
                    + "                                                                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Delete Driver " + d.getDriverName() + "</h5>\n"
                    + "                                                                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n"
                    + "                                                                            <span aria-hidden=\"true\">&times;</span>\n"
                    + "                                                                        </button>\n"
                    + "                                                                    </div>\n"
                    + "                                                                    <form action=\"driver\">\n"
                    + "                                                                        <div class=\"modal-footer\">\n"
                    + "                                                                            <input type=\"hidden\" name=\"driverID\" value=\"" + d.getDriverID() + "\">\n"
                    + "                                                                            <button type=\"submit\" name=\"action\" value=\"delete\" class=\"btn btn-primary\">\n"
                    + "                                                                                Delete\n"
                    + "                                                                            </button>\n"
                    + "                                                                            <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n"
                    + "                                                                        </div>\n"
                    + "                                                                    </form>\n"
                    + "                                                                </div>\n"
                    + "                                                            </div>\n"
                    + "                                                        </div>\n"
                    + "                                                    </td>\n"
                    + "                                                </tr>");
            }
        } catch (Exception e) {
        }
    }
}
