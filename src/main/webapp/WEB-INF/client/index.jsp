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
        <link rel="stylesheet" href="<s:url value='/css/linearicons.css'/>">
        <link rel="stylesheet" href="<s:url value='/css/font-awesome.min.css'/>">
        <link rel="stylesheet" href="<s:url value='/css/bootstrap.css'/>">
        <link rel="stylesheet" href="<s:url value='/css/magnific-popup.css'/>">
        <link rel="stylesheet" href="<s:url value='/css/jquery-ui.css'/>">
        <link rel="stylesheet" href="<s:url value='/css/nice-select.css'/>">
        <link rel="stylesheet" href="<s:url value='/css/animate.min.css'/>">
        <link rel="stylesheet" href="<s:url value='/css/owl.carousel.css'/>">
        <link rel="stylesheet" href="<s:url value='/css/main.css'/>">
    </head>

    <body>
        <header id="header">
            <jsp:include page="menu.jsp"></jsp:include>
        </header><!-- #header -->
            <c:out value="${pageContext.request.contextPath}"></c:out>
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
                                    <fieldset name="from">
                                        <select class="form-control" required name='from' onchange=''>
                                            <option value="">From</option>
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
                                        </select>
                                    </fieldset>
                                    <fieldset name="to">
                                        <select class="form-control" required name='to' onchange=''>
                                            <option value="">To</option>
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
                                        </select>
                                    </fieldset>
                                    <input type="text" class="form-control date-picker" name="start" placeholder="Start "
                                           onfocus="this.placeholder = ''" onblur="this.placeholder = 'Start'">
                                    <input type="text" class="form-control date-picker" name="return" placeholder="Return "
                                           onfocus="this.placeholder = ''" onblur="this.placeholder = 'Return'">
                                    <a href="route.jsp" class="primary-btn text-uppercase">Search tickets</a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End banner Area -->

        <!-- Start popular-destination Area -->
        <section class="recent-blog-area section-gap">
            <div class="container">
                <div class="row d-flex justify-content-center">
                    <div class="menu-content pb-60 col-lg-9">
                        <div class="title text-center">
                            <h1 class="mb-10">Popular Route</h1>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="active-recent-blog-carusel">
                        <div class="single-recent-blog-post item">
                            <div class="">
                                <div class="overlay overlay-bg"></div>
                                <img class="img-fluid" src="https://storage.googleapis.com/vex-config/cms-tool/destination/images/3/img_hero.png" alt="">
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
                                <img class="img-fluid" src="https://storage.googleapis.com/vex-config/cms-tool/destination/images/5/img_hero.png?v1" alt="">
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
        <section class="other-issue-area section-gap">
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
                                <img class="img-fluid" src="img/o1.jpg" alt="">
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
        <section class="other-issue-area section-gap">
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
        <section class="other-issue-area section-gap">
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

        <script src="./src/main/webapp/WEB-INF/client/js/vendor/jquery-2.2.4.min.js"></script>
        <script src="./src/main/webapp/WEB-INF/client/js/popper.min.js"></script>
        <script src="./src/main/webapp/WEB-INF/client/js/vendor/bootstrap.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
        <script src="./src/main/webapp/WEB-INF/client/js/jquery-ui.js"></script>
        <script src="./src/main/webapp/WEB-INF/client/js/easing.min.js"></script>
        <script src="./src/main/webapp/WEB-INF/client/js/hoverIntent.js"></script>
        <script src="./src/main/webapp/WEB-INF/client/js/superfish.min.js"></script>
        <script src="./src/main/webapp/WEB-INF/client/js/jquery.ajaxchimp.min.js"></script>
        <script src="./src/main/webapp/WEB-INF/client/js/jquery.magnific-popup.min.js"></script>
        <script src="./src/main/webapp/WEB-INF/client/js/jquery.nice-select.min.js"></script>
        <script src="./src/main/webapp/WEB-INF/client/js/owl.carousel.min.js"></script>
        <script src="./src/main/webapp/WEB-INF/client/js/mail-script.js"></script>
        <script src="./src/main/webapp/WEB-INF/client/js/main.js"></script>
    </body>
    
</html>
