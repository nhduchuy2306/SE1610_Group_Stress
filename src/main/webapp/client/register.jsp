<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="img/fav.png">
        <title>SB Admin 2 - Register</title>

        <!-- Custom fonts for this template-->
        <link href="${pageContext.request.contextPath}/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="${pageContext.request.contextPath}/admin/css/sb-admin-2.min.css" rel="stylesheet">
        <style>
        </style>
    </head>

    <body class="bg-gradient-primary">

        <div class="container">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
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

        <!-- Bootstrap core JavaScript-->
        <script src="${pageContext.request.contextPath}/admin/vendor/jquery/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="${pageContext.request.contextPath}/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="${pageContext.request.contextPath}/admin/js/sb-admin-2.min.js"></script>

    </body>

</html>