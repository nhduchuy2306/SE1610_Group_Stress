package com.stress.controllers;

import com.stress.dao.CityDAO;
import com.stress.dao.OrderDAO;
import com.stress.dao.RouteDAO;
import com.stress.dao.SeatDAO;
import com.stress.dao.TicketDAO;
import com.stress.dao.TripDAO;
import com.stress.dao.UserDAO;
import com.stress.dto.Order;
import com.stress.dto.Seat;
import com.stress.dto.Ticket;
import com.stress.dto.Trip;
import com.stress.dto.User;
import com.stress.service.CityDAOImpl;
import com.stress.service.OrderDAOImpl;
import com.stress.service.RouteDAOImpl;
import com.stress.service.SeatDAOImpl;
import com.stress.service.TicketDAOImpl;
import com.stress.service.TripDAOImpl;
import com.stress.service.UserDAOImpl;
import com.stress.utils.CommonFunction;
import com.stress.utils.Email;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "BookingController", urlPatterns = {"/book"})
public class BookingController extends HttpServlet {

    private final TripDAO tripDAO = new TripDAOImpl();
    private final RouteDAO routeDAO = new RouteDAOImpl();
    private final CityDAO cityDAO = new CityDAOImpl();
    private final SeatDAO seatDAO = new SeatDAOImpl();
    private final UserDAO userDAO = new UserDAOImpl();
    private final TicketDAO ticketDAO = new TicketDAOImpl();
    private final OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            switch (action) {
                case "Search":
                    showTrip(request, response);
                    break;
                case "createTrip":
                    createTicket(request, response);
                    break;

                case "choose-ticket":
                    choosingTicket(request, response);
                    break; 
                case "Sort":
                    sortTrip(request, response);
                    break;
                case "chooseCar":
                    chooseCar(request, response);
                    break;
                case "SortByTime":
                    sortByTime(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.toString());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            switch (action) {
                case "Search":
                    showTrip(request, response);
                    break;
                case "createTrip":
                    createTicket(request, response);
                    break;
                case "payingAccount":
                    bookingTicketAccountBalance(request, response);
                    break;

                case "choose-ticket":
                    choosingTicket(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.toString());
        }

    }

    private void showTrip(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        try {
            int routeID = Integer.parseInt(request.getParameter("routeID"));
            String startDay = request.getParameter("start");
            String []a=startDay.split("/");
            String checkStartDate=a[2]+"-"+a[1]+"-"+a[0];
            SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
            Date dateInput=formater.parse(checkStartDate);
            String test= java.time.LocalDate.now().toString();
            Date currentDate=formater.parse(test);
            
            List<Trip> listTrip=null;
            
            if (dateInput.compareTo(currentDate)==0) {
                listTrip=tripDAO.getAllTripByRouteAndSameStartDay(routeID, startDay);
            }else{
                listTrip = tripDAO.getAllTripByRouteAndStartDay(routeID, startDay);
            }
            request.setAttribute("LIST_ALL_TRIP_BY_LOCATION", listTrip);
            request.setAttribute("ROUTEID", routeID);
            request.setAttribute("STARTDAY",startDay );
        } catch (Exception e) {
            System.out.println("Error at BookingController - showTrip" + e.toString());
        } finally {
            request.getRequestDispatcher("./client/route.jsp").forward(request, response);
        }
    }

    private void bookingTicketAccountBalance(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "404.jsp";
//        }
        try {
            HttpSession session = request.getSession();
            String orderID = request.getParameter("orderID");
            String seatIDs = request.getParameter("seatID");
            String[] seatID = seatIDs.split(",");
            String tripID = request.getParameter("tripID");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            double price = Double.parseDouble(request.getParameter("totalPrice")); // totalPrice
            double accountBalance = 0; // Account balance of Active Customer
            
            User loginUser = (User) session.getAttribute("LOGIN_USER");

            // Starting checkout
            Order order = orderDAO.getOderByID(orderID); // getOrderByID

            accountBalance = Double.parseDouble(loginUser.getAccountBalance());
            if (accountBalance >= price) {
                Trip choosingTrip = tripDAO.getTripByID(tripID);
                for (int i = 0; i < quantity; i++) {
                        Seat seat = seatDAO.getSeatByID(seatID[i], tripID);
                        

                        if (seatDAO.lockSeat(seat.getSeatID(), tripID)) {
                            Ticket ticket = new Ticket(0, seat, choosingTrip, order);
                            ticketDAO.addNewTicket(ticket);
                            
                        }

                    }
                //accountBalance -= price;
                // update Account Balance again
                accountBalance -= price;
                loginUser.setAccountBalance(String.valueOf(accountBalance));
                userDAO.updateUser(loginUser.getUserID(),
                        loginUser.getAccountBalance());
                session.setAttribute("LOGIN_USER", loginUser);
                request.setAttribute("SUCCESS", "Check Out Success!");
                order.setStatus(true);
                request.setAttribute("PRICE", price);
                request.setAttribute("ORDER", order);
                if(Email.sendEmail(loginUser.getEmail(), "" ,"Dear " + loginUser.getUsername() + "\n" + 
                        "You have Boook Ticket successfully\n" + "Total Price: " + price * 0.1, "Booked Ticket Successfully")) {
                orderDAO.updateOrder(order);
                url = "./client/index.jsp";
                }
                
            } else {
                request.setAttribute("ERROR", "Account Balance is not Enough!");
            }

        } catch (Exception e) {
            System.out.println("Error at CheckOut Controller" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

    private void createTicket(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "./client/404.jsp";
//        }
        try {
            HttpSession session = request.getSession();
            String tripID = request.getParameter("tripID");
            String seatIDs = request.getParameter("seatID");
            String[] seatID = seatIDs.split(",");
            int quantity = seatID.length; // quantity of Seat that Customer choose 
            double price = 0; // totalPrice

            User loginUser = (User) session.getAttribute("LOGIN_USER");
            if (loginUser != null) {
                // Starting checkout
                if (quantity > 0) {

                    Trip choosingTrip = tripDAO.getTripByID(tripID);
                    String orderID = CommonFunction.generateID("tblOrders", "Order");
                    Order order = new Order(orderID, null, "", loginUser, false);
                    order = orderDAO.createOrder(order);
                    
                    for (int i = 0; i < quantity; i++) {
                        Seat seat = seatDAO.getSeatByID(seatID[i], tripID);
                            price += seat.getPrice();

                    }
                    request.setAttribute("QUANTITY", quantity);
                    request.setAttribute("PRICE", price);
                    request.setAttribute("SEAT_LIST", seatIDs);
                    request.setAttribute("ORDER", order);
                    request.setAttribute("TRIP", choosingTrip);
                    
                    url = "./client/order.jsp";
                } else {
                    request.setAttribute("ERROR", "You not Book any Seat!");

                }
            } else {
                request.setAttribute("ERROR_FOR_LOGIN", "You have to login First");
                url = "./client/index.jsp";
            }
        } catch (Exception e) {
            System.out.println("Error at Show Ticket Detail Controller" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

    private void choosingTicket(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String tripID = request.getParameter("tripID");
            String totalSeat = request.getParameter("totalSeat");
            List<Seat> list = seatDAO.getAllUnAvailbeSeatByTripID(tripID);
            Trip trip = tripDAO.getTripByID(tripID);
            List<String> unavailableSeat = new ArrayList<>();
           
            for (Seat s : list) {
                unavailableSeat.add(s.getSeatID().trim());
            }
            String seat = "";
            for (String s : unavailableSeat) {
                seat += s + ",";
            }
            System.out.println(seat);
            request.setAttribute("totalSeat", totalSeat);
            request.setAttribute("unavailabelSeat", seat);
            request.setAttribute("tripID", tripID);
            request.setAttribute("trip", trip);
            request.getRequestDispatcher("/client/ticket-detail.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }

    private void sortTrip(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            int routeID = Integer.parseInt(request.getParameter("routeID"));
            String startDay = request.getParameter("start");
            String []a=startDay.split("/");
            String checkStartDate=a[2]+"-"+a[1]+"-"+a[0];
            SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
            Date dateInput=formater.parse(checkStartDate);
            String test= java.time.LocalDate.now().toString();
            Date currentDate=formater.parse(test);  
            List<Trip> listTrip=null;
            
            if (dateInput.compareTo(currentDate)==0) {
                listTrip=tripDAO.getAllTripByRouteAndSameStartDay(routeID, startDay);
            }else{
                listTrip = tripDAO.getAllTripByRouteAndStartDay(routeID, startDay);
            }
            String sort=request.getParameter("sort");
            switch (sort) {
                case "ascendingbyDate":
                    Collections.sort(listTrip);
                    request.setAttribute("LIST_ALL_TRIP_BY_LOCATION", listTrip);
                    break;
                case "descendingbyDate":
                    Collections.sort(listTrip,Collections.reverseOrder());
                    request.setAttribute("LIST_ALL_TRIP_BY_LOCATION", listTrip);
                    break;
                case "ascendingbyPrice":
                    Collections.sort(listTrip,new Trip().reversed());
                    request.setAttribute("LIST_ALL_TRIP_BY_LOCATION", listTrip);
                    break;
                case "descendingbyPrice":
                    Collections.sort(listTrip,new Trip());
                    request.setAttribute("LIST_ALL_TRIP_BY_LOCATION", listTrip);
                    break;
                default:
                    throw new AssertionError();
            } 
            request.setAttribute("ROUTEID", routeID);
            request.setAttribute("STARTDAY",startDay );
        } catch (Exception e) {
            System.out.println("Error at BookingController - sortTrip" + e.toString());
        } finally {
            request.getRequestDispatcher("./client/route.jsp").forward(request, response);
        }
        
    }

    private void chooseCar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        try {
            int routeID = Integer.parseInt(request.getParameter("routeID"));
            String startDay = request.getParameter("start");
            String []a=startDay.split("/");
            String checkStartDate=a[2]+"-"+a[1]+"-"+a[0];
            SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
            Date dateInput=formater.parse(checkStartDate);
            String test= java.time.LocalDate.now().toString();
            Date currentDate=formater.parse(test);  
            List<Trip> listTrip=null;
            
            if (dateInput.compareTo(currentDate)==0) {
                listTrip=tripDAO.getAllTripByRouteAndSameStartDay(routeID, startDay);
            }else{
                listTrip = tripDAO.getAllTripByRouteAndStartDay(routeID, startDay);
            }
            System.out.println(listTrip);
            String carName=request.getParameter("carName");
            int seat=Integer.parseInt(request.getParameter("seat"));
            List<Trip> listTripCar=getTripByVehicleTypes(listTrip, carName, seat);
            request.setAttribute("LIST_ALL_TRIP_BY_LOCATION", listTripCar);
            request.setAttribute("ROUTEID", routeID);
            request.setAttribute("STARTDAY",startDay );
        } catch (Exception e) {
            System.out.println("Error at BookingController - chooseCar" + e.toString());
        } finally {
            request.getRequestDispatcher("./client/route.jsp").forward(request, response);
        }  
    }
    
    private List<Trip> getTripByVehicleTypes(List<Trip> list,String carName,int seat){
        List<Trip> listTrip=new ArrayList<>();
        for (Trip trip : list) {
            if(trip.getVehicle().getVehicleName().equalsIgnoreCase(carName)&&trip.getVehicle().getVehicleType().getTotalSeat()==seat){
                listTrip.add(trip);
            }
        }
        return listTrip;
    }

    private void sortByTime(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            int routeID = Integer.parseInt(request.getParameter("routeID"));
            String startDay = request.getParameter("start");
            String []a=startDay.split("/");
            String checkStartDate=a[2]+"-"+a[1]+"-"+a[0];
            SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
            Date dateInput=formater.parse(checkStartDate);
            String test= java.time.LocalDate.now().toString();
            Date currentDate=formater.parse(test);  
            List<Trip> listTrip=null;
            
            if (dateInput.compareTo(currentDate)==0) {
                listTrip=tripDAO.getAllTripByRouteAndSameStartDay(routeID, startDay);
            }else{
                listTrip = tripDAO.getAllTripByRouteAndStartDay(routeID, startDay);
            }
            int from=Integer.parseInt(request.getParameter("from"));
            int to=Integer.parseInt(request.getParameter("to"));
            List<Trip> listTripCar=getTripByTime(listTrip, from, to);
            System.out.println("From:"+from+"-To:"+to);
            System.out.println(listTripCar);
            request.setAttribute("LIST_ALL_TRIP_BY_LOCATION", listTripCar);
            request.setAttribute("ROUTEID", routeID);
            request.setAttribute("STARTDAY",startDay );
        } catch (Exception e) {
            System.out.println("Error at BookingController - sortByTime" + e.toString());
        } finally {
            request.getRequestDispatcher("./client/route.jsp").forward(request, response);
        }
    }
    private List<Trip> getTripByTime(List<Trip> list,int from,int to){
        List<Trip> listTrip=new ArrayList<>();
        for (Trip trip : list) {
            if(trip.getStartTime().getHours()>=from &&trip.getStartTime().getHours()<=to){
                listTrip.add(trip);
            }
        }
        return listTrip;
    }
}
