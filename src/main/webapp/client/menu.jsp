<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <div class="header-top">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-6 col-sm-6 col-6 header-top-left">
                        <ul>
                            <li><a href="#">Visit Us</a></li>
                            <li><a href="#">Buy Tickets</a></li>
                        </ul>
                    </div>
                    <div class="col-lg-6 col-sm-6 col-6 header-top-right">
                        <div class="header-social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container main-menu">
            <div class="row align-items-center justify-content-between d-flex">
                <div id="logo">
                    <a href="${pageContext.request.contextPath}/"><img src="img/logo.png" alt="" title="" /></a>
                </div>
                <nav id="nav-menu-container">
                    <ul class="nav-menu">
                        <li><a href="index.html">Home</a></li>
                        <li><a href="about.html">About</a></li>
                        <li><a href="packages.html">Packages</a></li>
                        <li><a href="hotels.html">Hotels</a></li>
                        <li><a href="contact.html">Contact</a></li>
                        <c:if test="${sessionScope.LOGIN_USER==null}">
                            <li><button type="button" class="login btn btn-primary" data-toggle="modal" data-target="#loginForm">LOGIN</button></li>
                        </c:if>
                        <c:if test="${sessionScope.LOGIN_USER!=null}">
                            <li><a href="${pageContext.request.contextPath}/Logout">Logout</a></li>
                        </c:if>
                        
                    </ul>
                </nav><!-- #nav-menu-container -->
            </div>
        </div>

<style>
    .login{
        background: none;
        border: none;
        font-size: 13px;
        margin-top: -2px;
    }
    .login:focus{
        background: none;
        border: none;
        font-size: 13px;
        margin-top: -2px;
        box-shadow: none;
    }
    .login:hover{
        background: none;
        border: none;
        text-decoration: underline #f8b600;
        color: #b88d1b;
    }
</style>