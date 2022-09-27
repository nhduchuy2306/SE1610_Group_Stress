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
        <title>User Tables</title>
        <!-- Custom fonts for this template -->
        <link href="${pageContext.request.contextPath}/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/admin/css/sb-admin-2.min.css" rel="stylesheet">
        <!-- Custom styles for this page -->
        <link href="${pageContext.request.contextPath}/admin/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    </head>
    <body id="page-top">
        <!-- Page Wrapper -->
        <div id="wrapper">
            <!-- Sidebar -->
            <jsp:include page="sidebar.jsp"></jsp:include>
                <!-- End of Sidebar -->

                <!-- Content Wrapper -->
                <div id="content-wrapper" class="d-flex flex-column">

                    <!-- Main Content -->
                    <div id="content">
                        <!-- Topbar -->
                    <jsp:include page="topbar.jsp"></jsp:include>
                        <!-- End of Topbar -->
                        <!-- Begin Page Content -->
                        <div class="container-fluid">

                            <!-- Page Heading -->
                            <h1 class="h3 mb-2 text-gray-800 text-center font-weight-bold">User Table</h1>

                            <!-- DataTales Example -->
                            <div class="card shadow mb-4">
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                            <thead>
                                                <tr>
                                                    <th>No</th>
                                                    <th>UserID</th>
                                                    <th>Name</th>
                                                    <th>Gender</th>
                                                    <th>Birthday</th>
                                                    <th>Email</th>
                                                    <th>Phone Number</th>
                                                    <th>Address</th>
                                                    <th>Password</th>
                                                    <th>Role</th>
                                                    <th>Status</th>
                                                    <th>EDIT</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="user" varStatus="counter" items="${requestScope.LIST_USER}">
<!--                                                <form action="MainController">-->
                                                    <tr>
                                                        <td>${counter.count}</td>
                                                        <td>${user.userID}</td>
                                                        <td>${user.username}</td>
                                                        <c:if test="${user.sex==true}">
                                                            <td>Male</td>
                                                        </c:if>
                                                        <c:if test="${user.sex==false}">
                                                            <td>Female</td>
                                                        </c:if>
                                                        <td>${user.dob}</td>
                                                        <td>${user.email}</td>
                                                        <td>${user.phoneNumber}</td>
                                                        <td>${user.address}</td>
                                                        <td>${user.password}</td>
                                                        <td>${user.role.roleName}</td>
                                                        <td><c:choose>
                                                            <c:when test="${user.status eq 0}">
                                                                INACTIVE
                                                            </c:when>
                                                            <c:when test="${user.status eq 1}">
                                                                ACTIVE NORMAL
                                                            </c:when>
                                                            
                                                        </c:choose>
                                                        </td>

                                                        <td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#Edit-${user.userID.trim()}">
                                                                EDIT
                                                            </button>
                                                        </td> 
                                                    </tr>
<!--                                                </form>-->
                                            <!--Start-Modal-->

                                                        <div class="modal fade" id="Edit-${user.userID.trim()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                            <div class="modal-dialog" role="document">
                                                                <div class="modal-content">
                                                                    <div class="modal-header">
                                                                        <h5 class="modal-title" id="exampleModalLabel">USER</h5>
                                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                            <span aria-hidden="true">&times;</span>
                                                                        </button>
                                                                    </div>
                                                                    <div class="modal-body">
                                                                       <form action="http://localhost:8080/CarBooking/user" method="POST">
                                                                            <div class="form-group">
                                                                                <label for="recipient-name" class="col-form-label">UserID</label>
                                                                                <input type="text" class="form-control" name="userID" readonly=""  value="${user.userID}">
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label for="recipient-name" class="col-form-label">Name</label>
                                                                                <input type="text" class="form-control" name="userName"  value="${user.username}">
                                                                            </div>
                                                                            
                                                                            <div class="row" style="display: inline-flex">
                                                                                <div class="col-sm-6 mb-3 mb-sm-0">
                                                                                    <label for="recipient-name" class="col-form-label">Gender</label>
                                                                                    <select class="form-select" style="width: 100%;height: 38px;border-radius: 5px; padding-left: 10px;border-color: #D1D3E2; color: #CCCCC9"
                                                                                            name="gender" aria-label="Default select example">
                                                                                        <option value="1"${user.sex eq true?"selected":""}>Male</option>
                                                                                        <option value="0"${user.sex eq false?"selected":""}>Female</option>
                                                                                    </select>
                                                                                </div>
                                                                                <div class="form-group col-sm-6 mb-3 mb-sm-0">
                                                                                    <label for="recipient-name" class="col-form-label">Birthday</label>
                                                                                    <input type="date" class="form-control" name="birthday"  value="${user.dob}">
                                                                                </div>
                                                                            </div>
                                                                            
                                                                            <div class="form-group">
                                                                                <label for="recipient-name" class="col-form-label">Email</label>
                                                                                <input type="email" class="form-control" name="email"  value="${user.userID}">
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label for="recipient-name" class="col-form-label">Phone Number</label> <br/>
                                                                                <input type="text" class="form-control" name="phoneNum"  value="${user.phoneNumber}">
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label for="recipient-name" class="col-form-label">Address</label>
                                                                                <input type="text" class="form-control" name="address"  value="${user.address}">
                                                                            </div>
                                                                            <div class="form-group row" style="display: inline-flex">
                                                                                <div class="col-sm-6 mb-3 mb-sm-0">
                                                                                    <label for="recipient-name" class="col-form-label">Role</label><br/> 
                                                                                   
                                                                                    <select class="form-select" style="width: 100%;height: 38px;border-radius: 5px; padding-left: 10px;border-color: #D1D3E2; color: #CCCCC9"
                                                                                            name="roleID">
                                                                                        <option  value="1" ${user.role.roleID eq "1"?"selected":""}>USER</option>
                                                                                        <option  value="2" ${user.role.roleID eq "2"?"selected":""}>STAFF</option>
                                                                                        <option  value="3" ${user.role.roleID eq "3"?"selected":""} >ADMIN</option>
                                                                                    </select>
                                                                                </div>
                                                                                    
                                                                                <div class="col-sm-6 mb-3 mb-sm-0">
                                                                                    <label for="recipient-name" class="col-form-label">Status</label>      
                                                                                    <select class="form-select" style="width: 100%;height: 38px;border-radius: 5px; padding-left: 10px;border-color: #D1D3E2; color: #CCCCC9"
                                                                                            name="status" aria-label="Default select example">
                                                                                        <option value="1" ${user.status eq 2?"selected":""}>ACTIVE GOOGLE</option>
                                                                                        <option value="1" ${user.status eq 1?"selected":""}>ACTIVE NORMAL</option>
                                                                                        <option value="0" ${user.status eq 0?"selected":""}>INACTIVE</option>
                                                                                    </select>
                                                                                </div>
                                                                            </div>
                                                                            <div class="modal-footer">
                                                                                <input style="background-color: #28fe09; padding: 5px 10px; border-color: grey" type="submit" name="action" value="update" >
                                                                                <a style="text-decoration: none;border: 2px solid #fa0927; padding: 5px 12px; background-color: red; color: black"
                                                                                   href="http://localhost:8080/CarBooking/user?action=delete&userID=${user.userID}">Delete</a>
                                                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                                            </div>
                                                                        </form>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                            <!-- End- Modal-->
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <!-- /.container-fluid -->

                    </div>
                    <!-- End of Main Content -->

                    <!-- Footer -->
                    <footer class="sticky-footer bg-white">
                        <div class="container my-auto">
                            <div class="copyright text-center my-auto">
                                <span>Copyright &copy; Your Website 2020</span>
                            </div>
                        </div>
                    </footer>
                    <!-- End of Footer -->

                </div>
                <!-- End of Content Wrapper -->

            </div>
            <!-- End of Page Wrapper -->

            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fas fa-angle-up"></i>
            </a>

            <!-- Logout Modal-->
            <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                        </div>
                        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                        <div class="modal-footer">
                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                            <a class="btn btn-primary" href="login.html">Logout</a>
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
        <!-- Page level plugins -->
        <script src="${pageContext.request.contextPath}/admin/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/admin/vendor/datatables/dataTables.bootstrap4.min.js"></script>
        <!-- Page level custom scripts -->
        <script src="${pageContext.request.contextPath}/admin/js/demo/datatables-demo.js"></script>
    </body>
</html>
