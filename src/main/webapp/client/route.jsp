<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Mobile Specific Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Favicon-->
        <link rel="shortcut icon" href="img/fav.png">
        <!-- Author Meta -->
        <meta name="author" content="colorlib">
        <!-- Meta Description -->
        <meta name="description" content="">
        <!-- Meta Keyword -->
        <meta name="keywords" content="">
        <!-- meta character set -->
        <meta charset="UTF-8">
        <!-- Site Title -->
        <title>Car Booking</title>

        <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/linearicons.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/font-awesome.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/magnific-popup.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/jquery-ui.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/nice-select.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/animate.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/owl.carousel.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/main.css">
        <link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/client/css/jquery.seat-charts.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/stylechoosecar.css">
    </head>

    <body>
        <header id="header">
            <jsp:include page="menu.jsp"></jsp:include>
            </header><!-- #header -->

            <!-- start banner Area -->
            <section class="about-banner relative">
                <div class="overlay overlay-bg"></div>
                <div class="container">
                    <div class="row d-flex align-items-center justify-content-center">
                        <div class="about-content col-lg-12">
                            <h1 class="text-white">
                                Tickets
                            </h1>
                            <p class="text-white link-nav"><a href="index.html">Home </a> <span
                                    class="lnr lnr-arrow-right"></span> <a href="hotels.html"> Hotels</a></p>
                        </div>
                    </div>
                </div>
            </section>
            <!-- End banner Area -->

            <!-- Start destinations Area -->
            <section class="destinations-area section-gap">
                <div class="container">
                    <div class="row d-flex justify-content-center">
                        <div class="menu-content pb-60 col-lg-9">
                            <div class="title text-center">
                                <h1 class="mb-10">Tickets</h1>
                            </div>
                        </div>
                    </div>
                    <div class="container-fluid pt-5">
                        <div class="row px-xl-5 justify-content-between">
                            <!-- Shop Sidebar Start -->
                            <div class="col-lg-3 col-md-12" id="">
                                <!-- Price Start -->
                                <div class="mb-4 pb-4">
                                    <h5 class="font-weight-semi-bold mb-4">Filter by price</h5>
                                    <form action="" c>
                                        <div class="d-flex align-items-center justify-content-between mb-3">
                                            <input type="text" name="lowPrice" style="width: 90px" placeholder="Low Price">
                                            <span class="mr-10 ml-10"> - </span>
                                            <input type="text" name="highPrice" style="width: 90px" placeholder="High Price">
                                        </div>
                                        <button type="submit" class="btn btn-primary float-right">Go</button>
                                    </form>
                                </div>
                                <!-- Price End -->

                                <!-- Time Start -->
                                <div class="mb-4 pb-4">
                                    <h5 class="font-weight-semi-bold mb-4">Filter by time</h5>
                                    <form action="">
                                        <div class="d-flex align-items-center justify-content-between">
                                            <div>
                                                <button style="width: 100px;" class="btn btn-primary mb-3" type="button">Sáng sớm<br>(0h-6h)</button>
                                                <button style="width: 100px;" class="btn btn-primary" type="button">Buổi sáng<br>(6h-12h)</button>
                                            </div>
                                            <div class="ml-3">
                                                <button style="width: 100px;" class="btn btn-primary mb-3" type="button">Buổi chiều<br>(12h-18h)</button>
                                                <button style="width: 100px;" class="btn btn-primary" type="button">Buổi tối<br>(18h-24h)</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <!-- Time end -->

                            </div>
                            <!-- Shop Sidebar End -->
                            <!-- Shop Product Start -->
                            <div class="col-lg-9 col-md-12">
                                <div class="row pb-3">
                                    <div class="col-12 pb-1">
                                        <div class="d-flex align-items-center justify-content-between mb-4">
                                            <form action="">
                                                <div class="input-group">
                                                    <input type="text" class="form-control" placeholder="Search by name">
                                                    <div class="input-group-append">
                                                        <span class="input-group-text bg-transparent text-primary">
                                                            <i class="fa fa-search"></i>
                                                        </span>
                                                    </div>
                                                </div>
                                            </form>
                                            <div class="dropdown ml-4">
                                                <button class="btn border dropdown-toggle" type="button" id="triggerId"
                                                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    Sort by
                                                </button>
                                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="triggerId">
                                                    <a class="dropdown-item" href="#">Low to High</a>
                                                    <a class="dropdown-item" href="#">Time</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                <c:forEach items="${LIST_ALL_TRIP_BY_LOCATION}" var="trip">
                                    <input type="hidden" name="tripID" value="${trip.tripID}">
                                    <div class="col-lg-12 col-md-6 col-sm-12">
                                        <div class="card product-item border-0 mb-4">
                                            <div
                                                class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                                                <img class="img-fluid w-100" src="img/product-1.jpg" alt="">
                                            </div>
                                            <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                                                <div class="row">
                                                    <div class="ticket-car-name col-md-4">
                                                        <div class="bus-icon">
                                                            <i class="fa fa-bus" style="font-size: 40px; color: #007bff;" aria-hidden="true"></i>
                                                            <h4 class="mt-10">${trip.tripName}</h4>
                                                        </div>
                                                    </div>
                                                    <div class="ticket-row-name col-md-4 ">
                                                        <div class="ticket-from-to text-center">
                                                            <div class="ticket-from d-flex justify-content-center align-items-center">
                                                                <div class="mr-15">
                                                                    <i class="fa fa-circle" style="font-size: 25px; color:greenyellow;" aria-hidden="true"></i>
                                                                </div>
                                                                <div>
                                                                    <h6 class="text-center">23:15</h6>
                                                                    <span class="text-center">${trip.route.startLocation.locationName}</span>
                                                                </div>
                                                            </div>
                                                            <div class="ticket-from mt-10 d-flex justify-content-center align-items-center">
                                                                <div class="mr-15">
                                                                    <i class="fa fa-map-marker" style="font-size: 25px; color: red;" aria-hidden="true"></i>
                                                                </div>
                                                                <div>
                                                                    <h6></h6>
                                                                    <span>${trip.route.endLocation.locationName}</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="ticket-car-description col-md-4">
                                                        <p class="font-weight-bold" style="color:black;">${trip.vehicle.vehicleName}</p>
                                                        <p class="seat-remain font-weight-bold" style="color:black;">${trip.seatRemain} seat remain</p>
                                                    </div>
                                                </div>
                                                <div class="price float-sm-right">
                                                    <h3 class="mr-30" style="color: #007bff;">
                                                        <c:if test="${trip.vehicle.vehicleType.totalSeat==16}">
                                                            ${trip.vehicle.vehicleType.PRICE_16} đ
                                                        </c:if>
                                                        <c:if test="${trip.vehicle.vehicleType.totalSeat==29}">
                                                            ${trip.vehicle.vehicleType.PRICE_29} đ
                                                        </c:if>
                                                        <c:if test="${trip.vehicle.vehicleType.totalSeat==45}">
                                                            ${trip.vehicle.vehicleType.PRICE_45} đ
                                                        </c:if>
                                                    </h3>
                                                </div>
                                            </div>
                                            <div class="card-footer bg-light border d-flex justify-content-between align-items-center">
                                                <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapse-${trip.tripID.trim()}" aria-expanded="false" aria-controls="collapseExample">
                                                    View more detail
                                                </button>
                                                <button type="button" class="btn-choose-seat btn btn-primary" data-toggle="modal"
                                                        data-target="#choose-${trip.tripID.trim()}" onclick="AlwaysFlightClick()">
                                                    Choose ticket
                                                </button>
                                                <div class="modal fade" id="choose-${trip.tripID.trim()}" tabindex="-1" role="dialog"
                                                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog" role="document">
                                                        <div class="modal-content">
                                                            <form action="" method="get">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title" id="exampleModalLabel">Book car
                                                                    </h5>
                                                                    <button type="button" class="close" data-dismiss="modal"
                                                                            aria-label="Close">
                                                                        <span aria-hidden="true">&times;</span>
                                                                    </button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    <ul class="modal-title nav nav-tabs" id="myTab"
                                                                        role="tablist">
                                                                        <li class="nav-item">
                                                                            <a class="nav-link active" id="flight-tab"
                                                                               data-toggle="tab" href="#car-${trip.tripID.trim()}" role="tab"
                                                                               aria-controls="flight"
                                                                               aria-selected="true">Cars</a>
                                                                        </li>
                                                                        <li class="nav-item">
                                                                            <a class="nav-link" id="hotel-tab" data-toggle="tab"
                                                                               href="#hotel-${trip.tripID.trim()}" role="tab" aria-controls="hotel"
                                                                               aria-selected="false">Time</a>
                                                                        </li>
                                                                    </ul>
                                                                    <div class="tab-content" id="myTabContent">
                                                                        <div class="tab-pane fade show active" id="car-${trip.tripID.trim()}"
                                                                             role="tabpanel" aria-labelledby="flight-tab">
                                                                            <div class="wrapper-seat">
                                                                                <div class="container-seat">
                                                                                    <input type="text" style="visibility: hidden; opacity: 0" name="tripID" value="${trip.tripID.trim()}">
                                                                                    <input type="text" style="visibility: hidden; opacity: 0" name="price" value="
                                                                                           <c:if test="${trip.vehicle.vehicleType.totalSeat==16}">
                                                                                               ${trip.vehicle.vehicleType.PRICE_16}
                                                                                           </c:if>
                                                                                           <c:if test="${trip.vehicle.vehicleType.totalSeat==29}">
                                                                                               ${trip.vehicle.vehicleType.PRICE_29}
                                                                                           </c:if>
                                                                                           <c:if test="${trip.vehicle.vehicleType.totalSeat==45}">
                                                                                               ${trip.vehicle.vehicleType.PRICE_45}
                                                                                           </c:if>
                                                                                        ">
                                                                                    <input type="text" style="visibility: hidden; opacity: 0" name="totalSeat" value="${trip.vehicle.vehicleType.totalSeat}">
                                                                                    <h1 class="text-center">Chosing seats</h1>
                                                                                    <div class="seat-map-seat">
                                                                                        <div class="text-center front-indicator-seat">
                                                                                            Chosing</div>
                                                                                    </div>
                                                                                    <div class="booking-details-seat">
                                                                                        <h2>Booking Details</h2>
                                                                                        <h3> Selected Seats (<span
                                                                                                class="counter-seat">0</span>):
                                                                                        </h3>
                                                                                        <ul class="selected-seats"></ul>
                                                                                        Total: <b><span
                                                                                                class="total-seat">0</span> vnđ</b>
                                                                                        <button
                                                                                            class="btn btn-secondary checkout-button-seat"
                                                                                            type="button"
                                                                                            onclick="nextInFlights()">Next
                                                                                            &raquo;</button>
                                                                                        <div id="legend-seat"></div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="tab-pane fade" id="hotel-${trip.tripID.trim()}" role="tabpanel"
                                                                             aria-labelledby="hotel-tab">
                                                                            <div style="height:300px; width: 100%"
                                                                                 class="container">
                                                                                <div class="row pt-70">
                                                                                    <div class="col-lg-6 col-md-6 text-center">
                                                                                        <h3>Start Time:</h3>
                                                                                        <h5>13-Sep-22</h5>
                                                                                    </div>
                                                                                    <div class="col-lg-6 col-md-6 text-center">
                                                                                        <h3>End Time:</h3>
                                                                                        <h5>16-Sep-22</h5>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <button style="position:absolute; bottom:10px; right:20px;" type="button" class="choose-seat btn btn-secondary"
                                                                                    > Confirm</button>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="collapse" id="collapse-${trip.tripID.trim()}">
                                                <div class="card card-body">
                                                    <ul class="nav nav-tabs" role="tablist">
                                                        <li class="nav-item">
                                                            <a class="nav-link active" id="picture"
                                                               data-toggle="tab" href="#1-${trip.tripID.trim()}" role="tab"
                                                               aria-controls="picture"
                                                               aria-selected="true">Picture</a>
                                                        </li>
                                                        <li class="nav-item">
                                                            <a class="nav-link" id="utilies"
                                                               data-toggle="tab" href="#2-${trip.tripID.trim()}" role="tab"
                                                               aria-controls="utilies"
                                                               aria-selected="true">Utilities</a>
                                                        </li>
                                                        <li class="nav-item">
                                                            <a class="nav-link" id="policy"
                                                               data-toggle="tab" href="#3-${trip.tripID.trim()}" role="tab"
                                                               aria-controls="policy"
                                                               aria-selected="true">Policy</a>
                                                        </li>
                                                    </ul>
                                                    <div class="tab-content ">
                                                        <div class="tab-pane active" id="1-${trip.tripID.trim()}"
                                                             role="tabpanel" aria-labelledby="picture">
                                                            <div id="carousel-${trip.tripID.trim()}" class="carousel slide" data-ride="carousel">
                                                                <div class="carousel-inner">
                                                                    <div class="carousel-item active">
                                                                        <img style="width: 100px; height: 350px;" class="d-block w-100" src="https://i.ytimg.com/vi/dip_8dmrcaU/maxresdefault.jpg" alt="First slide">
                                                                    </div>
                                                                    <div class="carousel-item">
                                                                        <img style="width: 100px; height: 350px;" class="d-block w-100" src="https://maserati.scene7.com/is/image/maserati/maserati/regional/us/models/my22/levante/22_LV_Trofeo_PS_T1_HomePage_1920x1080.jpg?$1920x2000$&fit=constrain" alt="Second slide">
                                                                    </div>
                                                                    <div class="carousel-item">
                                                                        <img style="width: 100px; height: 350px;" class="d-block w-100" src="https://www.notebookcheck.net/fileadmin/Notebooks/News/_nc3/apple_car_concept_199.jpeg" alt="Third slide">
                                                                    </div>
                                                                </div>
                                                                <a class="carousel-control-prev" href="#carousel-${trip.tripID.trim()}" role="button" data-slide="prev">
                                                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                                                    <span class="sr-only">Previous</span>
                                                                </a>
                                                                <a class="carousel-control-next" href="#carousel-${trip.tripID.trim()}" role="button" data-slide="next">
                                                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                                                    <span class="sr-only">Next</span>
                                                                </a>
                                                            </div>
                                                        </div>
                                                        <div class="tab-pane" id="2-${trip.tripID.trim()}" role="tabpanel"
                                                             aria-labelledby="utilities">
                                                            Utility
                                                        </div>
                                                        <div class="tab-pane" id="3-${trip.tripID.trim()}" role="tabpanel"
                                                             aria-labelledby="policy">
                                                            Policy
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>


                                <!--Phân trang-->
                                <div class="col-12 pb-1">
                                    <nav aria-label="Page navigation">
                                        <ul class="pagination justify-content-center mb-3">
                                            <li class="page-item disabled">
                                                <a class="page-link" href="#" aria-label="Previous">
                                                    <span aria-hidden="true">&laquo;</span>
                                                    <span class="sr-only">Previous</span>
                                                </a>
                                            </li>
                                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                                            <li class="page-item">
                                                <a class="page-link" href="#" aria-label="Next">
                                                    <span aria-hidden="true">&raquo;</span>
                                                    <span class="sr-only">Next</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </nav>
                                </div>

                            </div>
                        </div>
                        <!-- Shop Product End -->
                    </div>
                </div>
            </div>
        </section>
        <!-- End destinations Area -->

        <!-- start footer Area -->
        <footer class="footer-area section-gap">
            <div class="container">

                <div class="row">
                    <div class="col-lg-3  col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6>About Agency</h6>
                            <p>
                                The world has become so fast paced that people don’t want to stand by reading a page of
                                information, they would much rather look at a presentation and understand the message. It
                                has come to a point
                            </p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6>Navigation Links</h6>
                            <div class="row">
                                <div class="col">
                                    <ul>
                                        <li><a href="#">Home</a></li>
                                        <li><a href="#">Feature</a></li>
                                        <li><a href="#">Services</a></li>
                                        <li><a href="#">Portfolio</a></li>
                                    </ul>
                                </div>
                                <div class="col">
                                    <ul>
                                        <li><a href="#">Team</a></li>
                                        <li><a href="#">Pricing</a></li>
                                        <li><a href="#">Blog</a></li>
                                        <li><a href="#">Contact</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3  col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6>Newsletter</h6>
                            <p>
                                For business professionals caught between high OEM price and mediocre print and graphic
                                output.
                            </p>
                            <div id="mc_embed_signup">
                                <form target="_blank"
                                      action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
                                      method="get" class="subscription relative">
                                    <div class="input-group d-flex flex-row">
                                        <input name="EMAIL" placeholder="Email Address" onfocus="this.placeholder = ''"
                                               onblur="this.placeholder = 'Email Address '" required="" type="email">
                                        <button class="btn bb-btn"><span class="lnr lnr-location"></span></button>
                                    </div>
                                    <div class="mt-10 info"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3  col-md-6 col-sm-6">
                        <div class="single-footer-widget mail-chimp">
                            <h6 class="mb-20">InstaFeed</h6>
                            <ul class="instafeed d-flex flex-wrap">
                                <li><img src="${pageContext.request.contextPath}/client/img/i1.jpg" alt=""></li>
                                <li><img src="${pageContext.request.contextPath}/client/img/i2.jpg" alt=""></li>
                                <li><img src="${pageContext.request.contextPath}/client/img/i3.jpg" alt=""></li>
                                <li><img src="${pageContext.request.contextPath}/client/img/i4.jpg" alt=""></li>
                                <li><img src="${pageContext.request.contextPath}/client/img/i5.jpg" alt=""></li>
                                <li><img src="${pageContext.request.contextPath}/client/img/i6.jpg" alt=""></li>
                                <li><img src="${pageContext.request.contextPath}/client/img/i7.jpg" alt=""></li>
                                <li><img src="${pageContext.request.contextPath}/client/img/i8.jpg" alt=""></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="row footer-bottom d-flex justify-content-between align-items-center">
                    <p class="col-lg-8 col-sm-12 footer-text m-0">
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;
                        <script>document.write(new Date().getFullYear());</script> All rights reserved | This template is
                        made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com"
                                                                                         target="_blank">Colorlib</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </p>
                    <div class="col-lg-4 col-sm-12 footer-social">
                        <a href="#"><i class="fa fa-facebook"></i></a>
                        <a href="#"><i class="fa fa-twitter"></i></a>
                        <a href="#"><i class="fa fa-dribbble"></i></a>
                        <a href="#"><i class="fa fa-behance"></i></a>
                    </div>
                </div>
            </div>
        </footer>
        <!-- End footer Area -->

        <script src="${pageContext.request.contextPath}/client/js/vendor/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/client/js/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/client/js/vendor/bootstrap.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
        <script src="${pageContext.request.contextPath}/client/js/jquery-ui.js"></script>
        <script src="${pageContext.request.contextPath}/client/js/easing.min.js"></script>
        <script src="${pageContext.request.contextPath}/client/js/hoverIntent.js"></script>
        <script src="${pageContext.request.contextPath}/client/js/superfish.min.js"></script>
        <script src="${pageContext.request.contextPath}/client/js/jquery.ajaxchimp.min.js"></script>
        <script src="${pageContext.request.contextPath}/client/js/jquery.magnific-popup.min.js"></script>
        <script src="${pageContext.request.contextPath}/client/js/jquery.nice-select.min.js"></script>
        <script src="${pageContext.request.contextPath}/client/js/owl.carousel.min.js"></script>
        <script src="${pageContext.request.contextPath}/client/js/mail-script.js"></script>
        <script src="${pageContext.request.contextPath}/client/js/main.js"></script>
        <script src="${pageContext.request.contextPath}/client/js/jquery.seat-charts.js"></script>
        <!--<script src="js/chosing-seat.js"></script>-->

        <script>
                            var flight_tab = document.querySelector("#flight-tab");
                            var hotel_tab = document.querySelector("#hotel-tab");
                            var holiday_tab = document.querySelector("#holiday-tab");

                            function AlwaysFlightClick() {
                                flight_tab.click();
                            }

                            function nextInFlights() {
                                hotel_tab.click();
                            }

                            function nextInHotels() {
                                holiday_tab.click();
                            }
        </script>
        <jsp:include page="/client/seat-script.jsp"></jsp:include>
    </body>

</html>
