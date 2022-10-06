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
        
<!--        test-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/datalist.css">
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
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
        
        <div class="modal fade col-lg-12" id="loginForm" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title caps"><strong>Welcome Back!</strong></h4>
                    </div>
                    <div class="modal-body col-lg-12">
                        <div class="row">

                            <div class="col-lg-12">
                                <div class="p-2">
                                    <form class="registration user" id="registration" action="${pageContext.request.contextPath}/user" method="post">
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user"
                                               id="userID" aria-describedby="emailHelp"
                                               placeholder="Enter Account..." name="userID" oninput="checkUserID()"value="${requestScope.USERID}">
                                        <p style="color: red;margin: 10px 0 0 20px;" id="error">${requestScope.ERROR_LOGIN1}</p>
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control form-control-user"
                                               id="password" placeholder="Password" name="password" oninput="checkPassword()" >
                                        <p style="color: red;margin: 10px 0 0 20px;" id="errorPassword">${requestScope.ERROR_LOGIN2}</p>
                                    </div>
                                    <div class="form-group">
                                        <div class="custom-control custom-checkbox small">
                                            <input type="checkbox" class="custom-control-input" id="customCheck" value="lsRememberMe">
                                            <label class="custom-control-label" for="customCheck">Remember
                                                Me</label>
                                        </div>
                                    </div>
                                    <div class="g-recaptcha" data-sitekey="6LcFThUiAAAAAEZk9isOhp_hFXnYQpQPjQtRdU17"></div>
                                    <p style="color: red;margin: 10px 0 0 20px;" id="errorPassword">${requestScope.ERROR_RECAPTCHA}</p>
                                    
                                    <input style="margin-top: 10px" onclick="lsRememberMe()" type="submit" class="btn btn-primary btn-user btn-block" name="action" value="Login">
                                    <hr>
                                    <a href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8080/ETrans/login&response_type=code
                                       &client_id=199152751272-83nokhduk5llpkp4vkt55hp9qmci27vc.apps.googleusercontent.com&approval_prompt=force" class="btn btn-google btn-user btn-block">
                                        <i class="fab fa-google fa-fw"></i> Login with Google
                                    </a>
    
                                </form>
                            </div>
                        </div>
                    </div>
                    </div>
                    <div class="modal-footer text-center">
                        <div class="col-lg-12" style="margin-top: -10px;">
                            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#demo-2" data-dismiss="modal">Forgot Password?</button>
                        </div>
                        <div class="col-lg-12" style="margin-top: -10px;">
                           <button type="button" class="btn btn-default" data-toggle="modal" data-target="#registerForm" data-dismiss="modal">Create an Account!</button>
                        </div>
                       
                    </div>
                </div>
            </div>
        </div>
<!--        End Login Form-->


        <!--Register Form-->
        
        <div class="modal fade" id="registerForm" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title caps"><strong>Create an Account!</strong></h4>
                    </div>
                    <div class="modal-body col-lg-12">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="p-15">
                                    <form class="user" action="${pageContext.request.contextPath}/user" method="post" id="FromRegistration">
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user" id="nameInput"
                                                   placeholder="User Name" name="userName" required="" value="${requestScope.USER_TMP.username}">
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <input type="date" class="form-control form-control-user" id="exampleFirstName"
                                                       placeholder="Birthday" name="birthday" value="${requestScope.USER_TMP.dob}" required="">
                                            </div>
                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <select class="form-select" style="width: 100%; height:
                                                        100%;border-radius: 40px; padding-left: 10px;border-color: #D1D3E2; color: #CCCCC9"
                                                        name="gender" aria-label="Default select example" required="">
                                                    <option value="1" ${requestScope.USER_TMP.sex eq true?"selected":""}>Male</option>
                                                    <option value="0" ${requestScope.USER_TMP.sex eq false?"selected":""}>Female</option>
                                                </select>

                                            </div>
                                        </div>                   
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user" id="InputEmail"
                                                   placeholder="Email Address" name="email" required="" value="${requestScope.USER_TMP.email}">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user" id="InputAddress"
                                                   placeholder="Address" name="address" required="" value="${requestScope.USER_TMP.address}">
                                        </div>
                                        <div class="form-group">
                                            <input type="number" class="form-control form-control-user" id="InputPhoneNum"
                                                   placeholder="Phone Number" name="phoneNum" required="" value="${requestScope.USER_TMP.phoneNumber}">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user" id="userIDRegister"
                                                   placeholder="Account" value="${requestScope.USER_TMP.userID}" name="userID" required="">
                                            <p style="color: red;margin: 10px 0 0 20px;" id="errorPassword">${requestScope.ERROR_USERID}</p>
                                        </div>
                                        <p style="color: red; font-size: 20px;"><c:out value="${ERROR}"></c:out></p>
                                            <div class="form-group row">
                                                <div class="col-sm-6 mb-3 mb-sm-0">
                                                    <input type="password" class="form-control form-control-user"
                                                           id="passwordRegister" placeholder="Password" name="password" required="" value="${requestScope.USER_TMP.password}">
                                                </div>

                                                <div class="col-sm-6">
                                                    <input type="password" class="form-control form-control-user"
                                                           id="password_repeat" placeholder="Repeat Password" name="repeatPassword" required=""value="${requestScope.USER_TMP.password}">
                                                </div> 
                                            </div>
                                            <div class="form-group">
                                                <input type="submit" class="form-control form-control-user" id=""
                                                       name="action" value="RegisterAccount" style="background-color: #4e73df; color: white;
                                                       padding:0;height: 6vh">
                                            </div>
                                            <hr>
                                            <a href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8080/ETrans/login&response_type=code
                                               &client_id=199152751272-83nokhduk5llpkp4vkt55hp9qmci27vc.apps.googleusercontent.com&approval_prompt=force" class="btn btn-google btn-user btn-block">
                                                <i class="fab fa-google fa-fw"></i> Login with Google
                                            </a>
                                        </form>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="col-lg-12"></div>
                        <button type="button"  style="margin-left: auto;margin-right: auto; background:none; color: gray; border: none; margin-top: -10px;" 
                                class="btn btn-primary" data-toggle="modal" data-target="#loginForm" data-dismiss="modal">Already have an account? Login!</button>
                    </div>
                </div>
            </div>
        </div>
        
        <!--End Register Form-->
        
        <!--Forgot form-->
        
        <div class="modal fade" id="demo-2" tabindex="-1" style="">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title caps"><strong>Forgot Your Password?</strong></h4>
                        </div>
                        <div class="modal-body col-lg-12">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="p-5">
                                        <div class="text-center" style="margin-top: -10px;">
<!--                                            <h1 class="h4 text-gray-900 mb-2">Forgot Your Password?</h1>-->
                                                <p class="mb-4">We get it, stuff happens. Just enter your account address below
                                                and we'll send your new password to email!</p>
                                        </div>
                                        <form class="user" action="${pageContext.request.contextPath}/user">
                                            <div class="form-group">
                                                <input type="text" class="form-control form-control-user"
                                                       id="exampleInputEmail" aria-describedby="emailHelp"
                                                       placeholder="Enter Your Account ..." name="userID" required="">
                                            </div>
                                            <p style="color: #28fe09; font-size: 20px;">${requestScope.SUCCESS}</p>
                                            <p style="color: red; font-size: 20px;">${requestScope.ERROR_FORGOT}</p>
                                            <input type="submit" name="action" value="Get Password by Email" class="btn btn-primary btn-user btn-block">
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer" style="margin-top: -40px;">
                            <button style="margin-left: auto;margin-right: auto;"
                                    type="button" class="modal-button btn btn-info" data-toggle="modal" data-target="#loginForm" data-dismiss="modal">Try to login again!</button>
                        </div>
                    </div>
                </div>
            </div>
        
        <!--End Forgot form-->
        
        <!-- #header -->
        <!-- start banner Area -->
        <section class="banner-area relative">
            <div class="overlay overlay-bg"></div>
            <div class="container">
                <div class="row fullscreen align-items-center justify-content-between">
                    <div class="col-lg-12 col-md-12 mt-60 pt-60">
<!--                        <h6 class="text-white">Away from monotonous life</h6>-->
                        <h1 class="text-white" style="font-size: 500%">Magical Travel</h1>
                        <p class="text-white" style="font-size: 120%">
                            If you are looking at blank cassettes on the web, you may be very confused at the difference in
                            price. You may see some for as low as $.17 each.
                        </p>
<!--                        <a href="#" class="primary-btn text-uppercase">Get Started</a>-->
                    </div>
                    <div class="col-lg-12 col-md-12 banner-right" style="margin-top: -40px; height: 300px;">
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item">
                                <h3 class="nav-link bg-white" style="cursor: pointer; color: #00b3ee">
                                    <i class="fa fa-bus" aria-hidden="true" style="padding-right: 10px">    Booking</i></h3>
                                <!-- <a class="nav-link active" id="flight-tab" data-toggle="tab" href="#flight" role="tab"
                                        aria-controls="flight" aria-selected="true">Book A Car</a> -->
                            </li>
                        </ul>

                        <div class="tab-content" id="myTabContent" style="height: 10vh"> 
                            <div class="tab-pane fade show active row" id="flight" role="tabpanel">
                                <form class="form-wrap col-md-12" style="display: inline-flex" action="trip">
                                    <div id="universe" class="col-md-3 d-flex" style="margin:-35px 0 0 -20px;">
                                        <i class="fa-sharp fa-solid fa-location-dot" style="font-size: 50px;margin-top: 12px;color: #36b9cc"></i>
                                        <ul class="select-list-group" id="listone">
                                            <li>
                                                <div class="col-md-12">
                                                    <div>
                                                        <input type="text" class="select-list-group__search" placeholder="From" id="data1"
                                                               style="font-size: 25px" name="from"/>
                                                    </div>
                                                    <ul class="select-list-group__list" data-toggle="false" style="margin-left: 0px">
                                                        <c:forEach var="city" items="${requestScope.LIST_CITY}">
                                                            <li class="select-list-group__list-item" data-display="true" data-highlight="false">${city.cityName}</li>
                                                        </c:forEach>
                                                    </ul>
                                                </div>
                                                
                                            </li>
                                        </ul>
                                        
                                    </div>
                                    <div class="col-md-1" style="margin:-12px 0 30px 0;padding: 5px 0 0 0; cursor:pointer;" >
                                        <i class="fa-solid fa-arrow-right-arrow-left" style="font-size: 30px; color: #00b3ee"  onclick="changeData()"></i>
                                    </div>
                                    
                                    <div id="universe" class="col-md-3" style="margin:-35px 40px 0 -20px;height: 9vh;  padding:0 0 0 3vw;">
                                        <ul class="select-list-group2 d-flex" id="listtwo">
                                            <i class="fa-sharp fa-solid fa-location-dot" style="font-size: 50px;margin-top: 12px;color: #36b9cc"></i>
                                            <li>
                                                <div style="" class="col-md-12">
                                                    <div style="display: block;padding-right: 80px;">
                                                        <input type="text" class="select-list-group__search2 col-md-12" placeholder="To" id="data2"
                                                               style="font-size: 25px;border-right: 1px solid #D1D3E2;width: 12vw" name="to"/>
                                                    </div>
                                                    
                                                
                                                    <ul class="select-list-group__list2" data-toggle="false" style="margin-left: 0px">
                                                        <c:forEach var="city" items="${requestScope.LIST_CITY}">
                                                            <li class="select-list-group__list-item2" data-display="true" data-highlight="false">${city.cityName}</li>
                                                        </c:forEach>
                                                    </ul>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                    
                                    <div class="col-md-3 d-flex" style=" margin-left: 50px">
                                        <i  class="fa-solid fa-calendar-days" style="font-size: 50px; margin: -20px 0 0 0px;padding-left: 0px;color: #36b9cc"></i>
                                        <input type="text" class="form-control date-picker "  name="start" placeholder="Start "
                                           onfocus="this.placeholder = ''" onblur="this.placeholder = 'Start'"value="${java.time.LocalDate.now()}"
                                           style="margin: -35px 0 0 0; height: 9vh;font-size: 25px; border: none">
                                    </div>
                                    
                                    <button type="submit" class="primary-btn text-uppercase col-md-2 float-right"
                                            style="height: 10vh; margin: -40px 0 0 0px; font-size: 20px" name="action" value="showTrip">Search</button>
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
                                <img class="img-fluid" src="${pageContext.request.contextPath}/client/img/o2.jpg" alt="">
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
                                <img class="img-fluid" src="${pageContext.request.contextPath}/client/img/o3.jpg" alt="">
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
                                <img class="img-fluid" src="${pageContext.request.contextPath}/client/img/o4.jpg" alt="">
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
        <script src="${pageContext.request.contextPath}/client/js/validation.js"></script>
        <script src="${pageContext.request.contextPath}/client/js/validationSignUp.js"></script>
        <script src="https://www.google.com/recaptcha/api.js"></script>
        
<!--        test-->
        <script src="${pageContext.request.contextPath}/client/js/datalist.js"></script>
        <script src="${pageContext.request.contextPath}/client/js/datalist2.js"></script>
    </body>
        <c:if test="${requestScope.ACTIVE_LOGINFORM!=null}">
            <script>
            $(window).load(function () {
                $('#loginForm').modal('show');
            });
            </script>
        </c:if>
        <c:if test="${requestScope.ERROR_USERID!=null}">
            <script>
            $(window).load(function () {
                $('#registerForm').modal('show');
            });
            </script>
        </c:if>
        <c:if test="${requestScope.RESET_PASSWORD!=null}">
            <script>
            $(window).load(function () {
                $('#demo-2').modal('show');
            });
            </script>
        </c:if>
            
        <script>
            function changeData(){
                var tmp=document.getElementById("data1").value;
                document.getElementById("data1").value=document.getElementById("data2").value;
                document.getElementById("data2").value=tmp;
            }
        </script>
</html>

