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
        <link rel="stylesheet" href="css/linearicons.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" href="css/nice-select.css">
        <link rel="stylesheet" href="css/animate.min.css">
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="css/main.css">
        <link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="css/jquery.seat-charts.css">
        <link rel="stylesheet" href="css/stylechoosecar.css">
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
                    <div class="row px-xl-5">
                        <!-- Shop Sidebar Start -->
                        <div class="col-lg-3 col-md-12">
                            <!-- Price Start -->
                            <div class="border-bottom mb-4 pb-4">
                                <h5 class="font-weight-semi-bold mb-4">Filter by price</h5>
                                <form>
                                    <div
                                        class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                        <input type="checkbox" class="custom-control-input" checked id="price-all">
                                        <label class="custom-control-label" for="price-all">All Price</label>
                                        <span class="badge border font-weight-normal">1000</span>
                                    </div>
                                    <div
                                        class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                        <input type="checkbox" class="custom-control-input" id="price-1">
                                        <label class="custom-control-label" for="price-1">$0 - $100</label>
                                        <span class="badge border font-weight-normal">150</span>
                                    </div>
                                    <div
                                        class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                        <input type="checkbox" class="custom-control-input" id="price-2">
                                        <label class="custom-control-label" for="price-2">$100 - $200</label>
                                        <span class="badge border font-weight-normal">295</span>
                                    </div>
                                    <div
                                        class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                        <input type="checkbox" class="custom-control-input" id="price-3">
                                        <label class="custom-control-label" for="price-3">$200 - $300</label>
                                        <span class="badge border font-weight-normal">246</span>
                                    </div>
                                    <div
                                        class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                        <input type="checkbox" class="custom-control-input" id="price-4">
                                        <label class="custom-control-label" for="price-4">$300 - $400</label>
                                        <span class="badge border font-weight-normal">145</span>
                                    </div>
                                    <div
                                        class="custom-control custom-checkbox d-flex align-items-center justify-content-between">
                                        <input type="checkbox" class="custom-control-input" id="price-5">
                                        <label class="custom-control-label" for="price-5">$400 - $500</label>
                                        <span class="badge border font-weight-normal">168</span>
                                    </div>
                                </form>
                            </div>
                            <!-- Price End -->

                            <!-- Color Start -->
                            <div class="border-bottom mb-4 pb-4">
                                <h5 class="font-weight-semi-bold mb-4">Filter by color</h5>
                                <form>
                                    <div
                                        class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                        <input type="checkbox" class="custom-control-input" checked id="color-all">
                                        <label class="custom-control-label" for="price-all">All Color</label>
                                        <span class="badge border font-weight-normal">1000</span>
                                    </div>
                                    <div
                                        class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                        <input type="checkbox" class="custom-control-input" id="color-1">
                                        <label class="custom-control-label" for="color-1">Black</label>
                                        <span class="badge border font-weight-normal">150</span>
                                    </div>
                                    <div
                                        class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                        <input type="checkbox" class="custom-control-input" id="color-2">
                                        <label class="custom-control-label" for="color-2">White</label>
                                        <span class="badge border font-weight-normal">295</span>
                                    </div>
                                    <div
                                        class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                        <input type="checkbox" class="custom-control-input" id="color-3">
                                        <label class="custom-control-label" for="color-3">Red</label>
                                        <span class="badge border font-weight-normal">246</span>
                                    </div>
                                    <div
                                        class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                        <input type="checkbox" class="custom-control-input" id="color-4">
                                        <label class="custom-control-label" for="color-4">Blue</label>
                                        <span class="badge border font-weight-normal">145</span>
                                    </div>
                                    <div
                                        class="custom-control custom-checkbox d-flex align-items-center justify-content-between">
                                        <input type="checkbox" class="custom-control-input" id="color-5">
                                        <label class="custom-control-label" for="color-5">Green</label>
                                        <span class="badge border font-weight-normal">168</span>
                                    </div>
                                </form>
                            </div>
                            <!-- Color End -->

                            <!-- Size Start -->
                            <div class="mb-5">
                                <h5 class="font-weight-semi-bold mb-4">Filter by size</h5>
                                <form>
                                    <div
                                        class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                        <input type="checkbox" class="custom-control-input" checked id="size-all">
                                        <label class="custom-control-label" for="size-all">All Size</label>
                                        <span class="badge border font-weight-normal">1000</span>
                                    </div>
                                    <div
                                        class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                        <input type="checkbox" class="custom-control-input" id="size-1">
                                        <label class="custom-control-label" for="size-1">XS</label>
                                        <span class="badge border font-weight-normal">150</span>
                                    </div>
                                    <div
                                        class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                        <input type="checkbox" class="custom-control-input" id="size-2">
                                        <label class="custom-control-label" for="size-2">S</label>
                                        <span class="badge border font-weight-normal">295</span>
                                    </div>
                                    <div
                                        class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                        <input type="checkbox" class="custom-control-input" id="size-3">
                                        <label class="custom-control-label" for="size-3">M</label>
                                        <span class="badge border font-weight-normal">246</span>
                                    </div>
                                    <div
                                        class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                        <input type="checkbox" class="custom-control-input" id="size-4">
                                        <label class="custom-control-label" for="size-4">L</label>
                                        <span class="badge border font-weight-normal">145</span>
                                    </div>
                                    <div
                                        class="custom-control custom-checkbox d-flex align-items-center justify-content-between">
                                        <input type="checkbox" class="custom-control-input" id="size-5">
                                        <label class="custom-control-label" for="size-5">XL</label>
                                        <span class="badge border font-weight-normal">168</span>
                                    </div>
                                </form>
                            </div>
                            <!-- Size End -->
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
                                                <a class="dropdown-item" href="#">Latest</a>
                                                <a class="dropdown-item" href="#">Popularity</a>
                                                <a class="dropdown-item" href="#">Best Rating</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-6 col-sm-12">
                                    <div class="card product-item border-0 mb-4">
                                        <div
                                            class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                                            <img class="img-fluid w-100" src="img/product-1.jpg" alt="">
                                        </div>
                                        <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                                            <h6 class="text-truncate mb-3">Colorful Stylish Shirt</h6>
                                            <div class="d-flex justify-content-center">
                                                <h6>$123.00</h6>
                                                <h6 class="text-muted ml-2"><del>$123.00</del></h6>
                                            </div>
                                        </div>
                                        <div class="card-footer bg-light border">
                                            <p>
                                                <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                                                    Button with data-target
                                                </button>
                                            </p>

                                            <button type="button" class="btn btn-primary" data-toggle="modal"
                                                    data-target="#exampleModal" onclick="AlwaysFlightClick()">
                                                Launch demo modal
                                            </button>
                                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <form action="/send" method="get">
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
                                                                           data-toggle="tab" href="#car" role="tab"
                                                                           aria-controls="flight"
                                                                           aria-selected="true">Cars</a>
                                                                    </li>
                                                                    <li class="nav-item">
                                                                        <a class="nav-link" id="hotel-tab" data-toggle="tab"
                                                                           href="#hotel" role="tab" aria-controls="hotel"
                                                                           aria-selected="false">Time</a>
                                                                    </li>
                                                                </ul>
                                                                <div class="tab-content" id="myTabContent">
                                                                    <div class="tab-pane fade show active" id="car"
                                                                         role="tabpanel" aria-labelledby="flight-tab">
                                                                        <div class="wrapper-seat">
                                                                            <div class="container-seat">
                                                                                <h1 class="text-center">Chosing seats</h1>
                                                                                <div id="seat-map-seat">
                                                                                    <div
                                                                                        class="text-center front-indicator-seat">
                                                                                        Chosing</div>
                                                                                </div>
                                                                                <div class="booking-details-seat">
                                                                                    <h2>Booking Details</h2>
                                                                                    <h3> Selected Seats (<span
                                                                                            id="counter-seat">0</span>):
                                                                                    </h3>
                                                                                    <ul id="selected-seats"></ul>
                                                                                    Total: <b>$<span
                                                                                            id="total-seat">0</span></b>
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
                                                                    <div class="tab-pane fade" id="hotel" role="tabpanel"
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
                                                                        <button style="position:absolute; bottom:10px; right:20px;" type="button" class="btn btn-secondary"
                                                                                onclick=""> Next</button>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-secondary"
                                                                        data-dismiss="modal">Close</button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="collapse container mb-10" id="collapseExample">
                                    <div class="card card-body">
                                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 pb-1">
                                    <div class="card product-item border-0 mb-4">
                                        <div
                                            class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                                            <img class="img-fluid w-100" src="img/product-2.jpg" alt="">
                                        </div>
                                        <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                                            <h6 class="text-truncate mb-3">Colorful Stylish Shirt</h6>
                                            <div class="d-flex justify-content-center">
                                                <h6>$123.00</h6>
                                                <h6 class="text-muted ml-2"><del>$123.00</del></h6>
                                            </div>
                                        </div>
                                        <div class="card-footer d-flex justify-content-between bg-light border">
                                            <a href="" class="btn btn-sm text-dark p-0"><i
                                                    class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                                            <a href="" class="btn btn-sm text-dark p-0"><i
                                                    class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 pb-1">
                                    <div class="card product-item border-0 mb-4">
                                        <div
                                            class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                                            <img class="img-fluid w-100" src="img/product-3.jpg" alt="">
                                        </div>
                                        <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                                            <h6 class="text-truncate mb-3">Colorful Stylish Shirt</h6>
                                            <div class="d-flex justify-content-center">
                                                <h6>$123.00</h6>
                                                <h6 class="text-muted ml-2"><del>$123.00</del></h6>
                                            </div>
                                        </div>
                                        <div class="card-footer d-flex justify-content-between bg-light border">
                                            <a href="" class="btn btn-sm text-dark p-0"><i
                                                    class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                                            <a href="" class="btn btn-sm text-dark p-0"><i
                                                    class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 pb-1">
                                    <div class="card product-item border-0 mb-4">
                                        <div
                                            class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                                            <img class="img-fluid w-100" src="img/product-4.jpg" alt="">
                                        </div>
                                        <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                                            <h6 class="text-truncate mb-3">Colorful Stylish Shirt</h6>
                                            <div class="d-flex justify-content-center">
                                                <h6>$123.00</h6>
                                                <h6 class="text-muted ml-2"><del>$123.00</del></h6>
                                            </div>
                                        </div>
                                        <div class="card-footer d-flex justify-content-between bg-light border">
                                            <a href="" class="btn btn-sm text-dark p-0"><i
                                                    class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                                            <a href="" class="btn btn-sm text-dark p-0"><i
                                                    class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 pb-1">
                                    <div class="card product-item border-0 mb-4">
                                        <div
                                            class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                                            <img class="img-fluid w-100" src="img/product-5.jpg" alt="">
                                        </div>
                                        <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                                            <h6 class="text-truncate mb-3">Colorful Stylish Shirt</h6>
                                            <div class="d-flex justify-content-center">
                                                <h6>$123.00</h6>
                                                <h6 class="text-muted ml-2"><del>$123.00</del></h6>
                                            </div>
                                        </div>
                                        <div class="card-footer d-flex justify-content-between bg-light border">
                                            <a href="" class="btn btn-sm text-dark p-0"><i
                                                    class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                                            <a href="" class="btn btn-sm text-dark p-0"><i
                                                    class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 pb-1">
                                    <div class="card product-item border-0 mb-4">
                                        <div
                                            class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                                            <img class="img-fluid w-100" src="img/product-6.jpg" alt="">
                                        </div>
                                        <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                                            <h6 class="text-truncate mb-3">Colorful Stylish Shirt</h6>
                                            <div class="d-flex justify-content-center">
                                                <h6>$123.00</h6>
                                                <h6 class="text-muted ml-2"><del>$123.00</del></h6>
                                            </div>
                                        </div>
                                        <div class="card-footer d-flex justify-content-between bg-light border">
                                            <a href="" class="btn btn-sm text-dark p-0"><i
                                                    class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                                            <a href="" class="btn btn-sm text-dark p-0"><i
                                                    class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 pb-1">
                                    <div class="card product-item border-0 mb-4">
                                        <div
                                            class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                                            <img class="img-fluid w-100" src="img/product-7.jpg" alt="">
                                        </div>
                                        <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                                            <h6 class="text-truncate mb-3">Colorful Stylish Shirt</h6>
                                            <div class="d-flex justify-content-center">
                                                <h6>$123.00</h6>
                                                <h6 class="text-muted ml-2"><del>$123.00</del></h6>
                                            </div>
                                        </div>
                                        <div class="card-footer d-flex justify-content-between bg-light border">
                                            <a href="" class="btn btn-sm text-dark p-0"><i
                                                    class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                                            <a href="" class="btn btn-sm text-dark p-0"><i
                                                    class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 pb-1">
                                    <div class="card product-item border-0 mb-4">
                                        <div
                                            class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                                            <img class="img-fluid w-100" src="img/product-8.jpg" alt="">
                                        </div>
                                        <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                                            <h6 class="text-truncate mb-3">Colorful Stylish Shirt</h6>
                                            <div class="d-flex justify-content-center">
                                                <h6>$123.00</h6>
                                                <h6 class="text-muted ml-2"><del>$123.00</del></h6>
                                            </div>
                                        </div>
                                        <div class="card-footer d-flex justify-content-between bg-light border">
                                            <a href="" class="btn btn-sm text-dark p-0"><i
                                                    class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                                            <a href="" class="btn btn-sm text-dark p-0"><i
                                                    class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 pb-1">
                                    <div class="card product-item border-0 mb-4">
                                        <div
                                            class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                                            <img class="img-fluid w-100" src="img/product-1.jpg" alt="">
                                        </div>
                                        <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                                            <h6 class="text-truncate mb-3">Colorful Stylish Shirt</h6>
                                            <div class="d-flex justify-content-center">
                                                <h6>$123.00</h6>
                                                <h6 class="text-muted ml-2"><del>$123.00</del></h6>
                                            </div>
                                        </div>
                                        <div class="card-footer d-flex justify-content-between bg-light border">
                                            <a href="" class="btn btn-sm text-dark p-0">
                                                <i class="fas fa-eye text-primary mr-1"></i>
                                                View Detail
                                            </a>
                                            <a href="" class="btn btn-sm text-dark p-0">
                                                <i class="fas fa-shopping-cart text-primary mr-1"></i>
                                                Add To Cart
                                            </a>
                                        </div>
                                    </div>
                                </div>
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
                                <li><img src="img/i1.jpg" alt=""></li>
                                <li><img src="img/i2.jpg" alt=""></li>
                                <li><img src="img/i3.jpg" alt=""></li>
                                <li><img src="img/i4.jpg" alt=""></li>
                                <li><img src="img/i5.jpg" alt=""></li>
                                <li><img src="img/i6.jpg" alt=""></li>
                                <li><img src="img/i7.jpg" alt=""></li>
                                <li><img src="img/i8.jpg" alt=""></li>
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

        <script src="js/vendor/jquery-2.2.4.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/vendor/bootstrap.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="js/easing.min.js"></script>
        <script src="js/hoverIntent.js"></script>
        <script src="js/superfish.min.js"></script>
        <script src="js/jquery.ajaxchimp.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/mail-script.js"></script>
        <script src="js/main.js"></script>
        <script src="js/jquery.seat-charts.js"></script>
        <script src="js/chosing-seat.js"></script>
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
    </body>

</html>
