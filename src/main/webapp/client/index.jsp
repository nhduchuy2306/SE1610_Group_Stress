<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/linearicons.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/font-awesome.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/magnific-popup.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/jquery-ui.css">				
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/nice-select.css">							
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/animate.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/owl.carousel.css">				
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/main.css">
        
        
        <link href="${pageContext.request.contextPath}/admin/css/sb-admin-2.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">
        <style>
            datalist {
                position: absolute;
                background-color: white;
                border: 1px solid blue;
                border-radius: 0 0 5px 5px;
                border-top: none;
                font-family: sans-serif;
                width: 350px;
                padding: 5px;
                max-height: 10rem;
                overflow-y: auto
            }
            option {
                background-color: white;
                padding: 4px;
                color: blue;
                margin-bottom: 1px;
                font-size: 18px;
                cursor: pointer;
            }
            .modal-button{
                color: #007bff;
                background: none;
                border: none;
            }
            .modal-button:hover{
                color: #007bff;
                background: none;
                border: none;
            }
            .modal-button:focus{
                color: #007bff;
                background: none;
                border: none;
                box-shadow: none;
            } 
        </style>
    </head>

    <body>
        <header id="header">
            <jsp:include page="menu.jsp"></jsp:include>
        </header>
<!--        Login Form-->
        <div class="modal fade bd-example-modal-lg" id="Login" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="row">
                        <!--<div class="col-lg-6 d-none d-lg-block bg-login-image"></div>-->
                        <img class="col-lg-6 d-none d-lg-block" 
                             src="https://cdn.dribbble.com/users/5980575/screenshots/17141125/car-rental-instagram-social-media-post-banner-template-free-415705_4x.png?compress=1&resize=1000x750&vertical=top" alt="alt"/>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                                </div>
                                <form class="user" action="http://localhost:8080/CarBooking/user" method="post">
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user"
                                               id="exampleInputEmail" aria-describedby="emailHelp"
                                               placeholder="Enter Account..." name="userID">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control form-control-user"
                                               id="exampleInputPassword" placeholder="Password" name="password">
                                    </div>
                                    <div class="form-group">
                                        <div class="custom-control custom-checkbox small">
                                            <input type="checkbox" class="custom-control-input" id="customCheck">
                                            <label class="custom-control-label" for="customCheck">Remember
                                                Me</label>
                                        </div>
                                    </div>
                                    <div class="g-recaptcha" data-sitekey="6LfPMjQiAAAAAALfARSLcVMoKa8KB8kiQM1TLFYI"></div>

                                    <input style="margin-top: 10px" type="submit" class="btn btn-primary btn-user btn-block" name="action" value="Login">
                                    <hr>

                                    <a href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8080/ETrans/login&response_type=code
                                       &client_id=199152751272-83nokhduk5llpkp4vkt55hp9qmci27vc.apps.googleusercontent.com&approval_prompt=force" class="btn btn-google btn-user btn-block">

                                        <i class="fab fa-google fa-fw"></i> Login with Google

                                    </a>
                                    <a href="${pageContext.request.contextPath}/client/index.jsp" class="btn btn-facebook btn-user btn-block">
                                    <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
                                </a>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="${pageContext.request.contextPath}/client/forgot-password.jsp">Forgot Password?</a>
                            </div>
                            <div class="text-center">
                                <button type="button" class="modal-button btn btn-primary" data-toggle="modal" data-target="#Register">Create an Account!</button>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
            </div>
        </div>
<!--        End Login Form-->


        <!--Register Form-->
        
        <div class="modal fade bd-example-modal-lg" id="Register" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="row">
                        <img class="col-lg-5 d-none d-lg-block" 
                             src="https://cdn.dribbble.com/users/5980575/screenshots/17141125/car-rental-instagram-social-media-post-banner-template-free-415705_4x.png?compress=1&resize=1000x750&vertical=top" alt="alt"/>
                        <div class="col-lg-7">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                                </div>
                                <form class="user" action="http://localhost:8080/CarBooking/user" method="post">
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user" id="exampleInputEmail"
                                               placeholder="User Name" name="userName">
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <input type="date" class="form-control form-control-user" id="exampleFirstName"
                                                   placeholder="Birthday" name="birthday" value="">
                                        </div>
                                        <div class="col-sm-6 mb-3 mb-sm-0">
                                            <select class="form-select" style="width: 100%; height:
                                                    100%;border-radius: 40px; padding-left: 10px;border-color: #D1D3E2; color: #CCCCC9"
                                                    name="gender" aria-label="Default select example">
                                                <option selected>Gender</option>
                                                <option value="1">Male</option>
                                                <option value="0">Female</option>
                                            </select>

                                        </div>
                                    </div>                   
                                    <div class="form-group">
                                        <input type="email" class="form-control form-control-user" id="InputEmail"
                                               placeholder="Email Address" name="email">
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user" id="InputAddress"
                                               placeholder="Address" name="address">
                                    </div>
                                    <div class="form-group">
                                        <input type="number" class="form-control form-control-user" id="InputPhoneNum"
                                               placeholder="Phone Number" name="phoneNum">
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user" id="exampleInputEmail"
                                               placeholder="Account" value="" name="userID">
                                    </div>
                                    <p style="color: red; font-size: 20px;"><c:out value="${ERROR}"></c:out></p>
                                        <div class="form-group row">
                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <input type="password" class="form-control form-control-user"
                                                       id="InputPassword" placeholder="Password" name="password">
                                            </div>

                                            <div class="col-sm-6">
                                                <input type="password" class="form-control form-control-user"
                                                       id="RepeatPassword" placeholder="Repeat Password" name="repeatPassword">
                                            </div> 
                                        </div>
                                        <div class="form-group">
                                            <input type="submit" class="form-control form-control-user" id=""
                                                   name="action" value="RegisterAccount" style="background-color: #4e73df; color: white;
                                                   padding:0;height: 6vh">
                                        </div>
                                        <hr>
                                        <a href="index.html" class="btn btn-google btn-user btn-block">
                                            <i class="fab fa-google fa-fw"></i> Login with Google
                                        </a>
                                        <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                            <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
                                        </a>
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="${pageContext.request.contextPath}/client/login.jsp">Already have an account? Login!</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <!--End Register Form-->
        <!-- #header -->
        <!-- start banner Area -->
        <section class="banner-area relative">
            <div class="overlay overlay-bg"></div>
            <div class="container">
                <div class="row fullscreen align-items-center justify-content-between">
                    <div class="col-lg-6 col-md-6 banner-left">
                        <h6 class="text-white">Away from monotonous life</h6>
                        <h1 class="text-white">Magical Travel</h1>
                        <p class="text-white">
                            If you are looking at blank cassettes on the web, you may be very confused at the difference in
                            price. You may see some for as low as $.17 each.
                        </p>
                        <a href="#" class="primary-btn text-uppercase">Get Started</a>
                    </div>
                    <div class="col-lg-5 col-md-6 banner-right">
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item">
                                <h3 class="nav-link bg-white" style="cursor: pointer">Book A Car</h3>
                                <!-- <a class="nav-link active" id="flight-tab" data-toggle="tab" href="#flight" role="tab"
                                        aria-controls="flight" aria-selected="true">Book A Car</a> -->
                            </li>
                        </ul>
                        <div class="tab-content" id="myTabContent"> 
                            <div class="tab-pane fade show active" id="flight" role="tabpanel">
                                <form class="form-wrap">
                                    <input list="froms" class="form-control" placeholder="From" name="from" id="browser">
                                    <datalist id="froms">
                                        <option value="Cambodia">Cambodia</option>
                                        <option value="Hong Kong">Hong Kong</option>
                                        <option value="India">India</option>
                                        <option value="Japan">Japan</option>
                                        <option value="Korea">Korea</option>
                                        <option value="Laos">Laos</option>
                                        <option value="Myanmar">Myanmar</option>
                                        <option value="Singapore">Singapore</option>
                                        <option value="Thailand">Thailand</option>
                                        <option value="Vietnam">Vietnam</option>
                                    </datalist>
                                    <input list="tos" class="form-control" placeholder="To" name="to" id="browser">
                                    <datalist id="tos">
                                        <option value="Cambodia">Cambodia</option>
                                        <option value="Hong Kong">Hong Kong</option>
                                        <option value="India">India</option>
                                        <option value="Japan">Japan</option>
                                        <option value="Korea">Korea</option>
                                        <option value="Laos">Laos</option>
                                        <option value="Myanmar">Myanmar</option>
                                        <option value="Singapore">Singapore</option>
                                        <option value="Thailand">Thailand</option>
                                        <option value="Vietnam">Vietnam</option>
                                    </datalist>
                                    <input type="text" class="form-control date-picker" name="start" placeholder="Start "
                                           onfocus="this.placeholder = ''" onblur="this.placeholder = 'Start'" value="${java.time.LocalDate.now()}">
                                    <input type="text" class="form-control date-picker" name="return" placeholder="Return "
                                           onfocus="this.placeholder = ''" onblur="this.placeholder = 'Return'">
                                    <a href="${pageContext.request.contextPath}/client/route.jsp" class="primary-btn text-uppercase">Search tickets</a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End banner Area -->

        <!-- Start popular-destination Area -->
        <section class="recent-blog-area">
            <div class="container">
                <div class="row d-flex justify-content-center align-items-center">
                    <div class="menu-content pb-60 col-lg-9">
                        <div class="title text-center">
                            <h1 class="mb-10 mt-30">Popular Route</h1>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="active-recent-blog-carusel">
                        <div class="single-recent-blog-post item">
                            <div class="">
                                <div class="overlay overlay-bg"></div>
                                <img class="img-fluid" 
                                     src="https://storage.googleapis.com/vex-config/cms-tool/destination/images/3/img_hero.png" 
                                     alt="">
                            </div>
                            <div class="desc text-center mt-10">
                                <h4>Sài Gòn - Đà Lạt</h4>
                                <a href="#" class="price-btn">150.000đ</a>
                                <del href="#" class="price-btn ml-10">200.000đ</del>
                            </div>
                        </div>
                        <div class="single-recent-blog-post item">
                            <div class="thumb">
                                <div class="overlay overlay-bg"></div>
                                <img class="img-fluid" 
                                     src="https://storage.googleapis.com/vex-config/cms-tool/destination/images/5/img_hero.png?v1" 
                                     alt="">
                            </div>
                            <div class="desc text-center mt-10">
                                <h4>Sài Gòn - Nha Trang</h4>
                                <a href="#" class="price-btn">231.000đ</a>
                                <!-- <del href="#" class="price-btn ml-10">200.000đ</del> -->
                            </div>
                        </div>
                        <div class="single-recent-blog-post item">
                            <div class="thumb">
                                <div class="overlay overlay-bg"></div>
                                <img class="img-fluid" src="https://storage.googleapis.com/vex-config/cms-tool/destination/images/20/img_hero.png?v1" alt="">
                            </div>
                            <div class="desc text-center mt-10">
                                <h4>Sài Gòn - Đà Nẵng</h4>
                                <a href="#" class="price-btn">231.000đ</a>
                                <!-- <del href="#" class="price-btn ml-10">200.000đ</del> -->
                            </div>
                        </div>
                        <div class="single-recent-blog-post item">
                            <div class="thumb">
                                <div class="overlay overlay-bg"></div>
                                <img class="img-fluid" src="https://storage.googleapis.com/vex-config/cms-tool/destination/images/27/img_hero.png" alt="">
                            </div>
                            <div class="desc text-center mt-10">
                                <h4>Nha Trang - Sài Gòn</h4>
                                <a href="#" class="price-btn">240.000đ</a>
                                <!-- <del href="#" class="price-btn ml-10">200.000đ</del> -->
                            </div>
                        </div>
                        <div class="single-recent-blog-post item">
                            <div class="thumb">
                                <div class="overlay overlay-bg"></div>
                                <img class="img-fluid" src="https://storage.googleapis.com/vex-config/cms-tool/destination/images/21/img_hero.png" alt="">
                            </div>
                            <div class="desc text-center mt-10">
                                <h4>Sài Gòn - Vũng Tàu</h4>
                                <a href="#" class="price-btn">150.000đ</a>
                                <!-- <del href="#" class="price-btn ml-10">200.000đ</del> -->
                            </div>
                        </div>
                        <div class="single-recent-blog-post item">
                            <div class="thumb">
                                <div class="overlay overlay-bg"></div>
                                <img class="img-fluid" src="https://storage.googleapis.com/vex-config/cms-tool/destination/images/24/img_hero.png" alt="">
                            </div>
                            <div class="desc text-center mt-10">
                                <h4>Sài Gòn - Buôn Ma Thuột</h4>
                                <a href="#" class="price-btn">270.000đ</a>
                                <del href="#" class="price-btn ml-10">300.000đ</del>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End popular-destination Area -->

        <!-- Start other-issue Area -->
        <section class="other-issue-area">
            <div class="container">
                <div class="row d-flex justify-content-center">
                    <div class="menu-content pb-70 col-lg-9">
                        <div class="title text-center">
                            <h1 class="mb-10">Other issues we can help you with</h1>
                            <p>We all live in an age that belongs to the young at heart. Life that is.</p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="single-other-issue">
                            <div class="thumb">
                                <img class="img-fluid" src="${pageContext.request.contextPath}/client/img/o1.jpg" alt="">
                            </div>
                            <a href="#">
                                <h4>Rent a Car</h4>
                            </a>
                            <p>
                                The preservation of human life is the ultimate value, a pillar of ethics and the foundation.
                            </p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="single-other-issue">
                            <div class="thumb">
                                <img class="img-fluid" src="img/o2.jpg" alt="">
                            </div>
                            <a href="#">
                                <h4>Cruise Booking</h4>
                            </a>
                            <p>
                                I was always somebody who felt quite sorry for myself, what I had not got compared.
                            </p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="single-other-issue">
                            <div class="thumb">
                                <img class="img-fluid" src="img/o3.jpg" alt="">
                            </div>
                            <a href="#">
                                <h4>To Do List</h4>
                            </a>
                            <p>
                                The following article covers a topic that has recently moved to center stage–at least it
                                seems.
                            </p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="single-other-issue">
                            <div class="thumb">
                                <img class="img-fluid" src="img/o4.jpg" alt="">
                            </div>
                            <a href="#">
                                <h4>Food Features</h4>
                            </a>
                            <p>
                                There are many kinds of narratives and organizing principles. Science is driven by evidence.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End other-issue Area -->

        <!-- Start Platform and connect -->
        <section class="other-issue-area">
            <div class="container">
                <div class="row d-flex justify-content-center">
                    <div class="menu-content pb-70 col-lg-9">
                        <div class="title text-center">
                            <h1 class="mb-10">Platform and networks</h1>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="single-other-issue d-flex flex-col justify-content-centerc align-items-center">
                            <div class="mr-20">
                                <i style="font-size:60px; color: blue;" class="fa fa-bus" aria-hidden="true"></i>
                            </div>
                            <div class="p-100" href="#">
                                <h4>2000+ nhà xe chất lượng cao</h4>
                                <p>5000+ tuyến đường trên toàn quốc, chủ động và đa dạng lựa chọn.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="single-other-issue d-flex flex-col justify-content-centerc align-items-center">
                            <div class="mr-20">
                                <i style="font-size:60px; color: yellow;" class="fa fa-ticket" aria-hidden="true"></i>
                            </div>
                            <div class="p-100" href="#">
                                <h4>Đặt vé dễ dàng</h4>
                                <p>Đặt vé chỉ với 60s. Chọn xe yêu thích cực nhanh và thuận tiện.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="single-other-issue d-flex flex-col justify-content-centerc align-items-center">
                            <div class="mr-20">
                                <i style="font-size:60px; color: green;" class="fa fa-check-circle-o" aria-hidden="true"></i>
                            </div>
                            <div class="p-100" href="#">
                                <h4>2000+ nhà xe chất lượng cao</h4>
                                <p>5000+ tuyến đường trên toàn quốc, chủ động và đa dạng lựa chọn.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="single-other-issue d-flex flex-col justify-content-centerc align-items-center">
                            <div class="mr-20">
                                <i style="font-size:60px; color: red;" class="fa fa-tags" aria-hidden="true"></i>
                            </div>
                            <div class="p-100" href="#">
                                <h4>2000+ nhà xe chất lượng cao</h4>
                                <p>5000+ tuyến đường trên toàn quốc, chủ động và đa dạng lựa chọn.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Platform and connect -->

        <!-- Start Gas station -->
        <section class="other-issue-area">
            <div class="container">
                <div class="row d-flex justify-content-center">
                    <div class="menu-content pb-70 col-lg-9">
                        <div class="title text-center">
                            <h1 class="mb-10">Gas Station</h1>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="single-other-issue">
                            <div class="thumb">
                                <img class="img-fluid" src="https://storage.googleapis.com/fe-production/images/bx-mien-dong.jpg" alt="">
                            </div>
                            <a href="#">
                                <h4 class="text-center">Bến Xe Miền Đông</h4>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="single-other-issue">
                            <div class="thumb">
                                <img class="img-fluid" src="https://storage.googleapis.com/fe-production/images/bx-nuoc-ngam.jpg" alt="">
                            </div>
                            <a href="#">
                                <h4 class="text-center">Bến Xe Miền Tây</h4>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="single-other-issue">
                            <div class="thumb">
                                <img class="img-fluid" src="https://storage.googleapis.com/fe-production/images/bx-gia-lam.jpg" alt="">
                            </div>
                            <a href="#">
                                <h4 class="text-center">Bến Xe An Sương</h4>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="single-other-issue">
                            <div class="thumb">
                                <img class="img-fluid" src="https://storage.googleapis.com/fe-production/images/bx-my-dinh.jpg" alt="">
                            </div>
                            <a href="#">
                                <h4 class="text-center">Bến Xe Gia Lâm</h4>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Gas station -->

        <!-- start footer Area -->
        <footer class="footer-area">
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
    </body>

</html>
</html>
