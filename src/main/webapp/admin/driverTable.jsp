<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Driver Tables</title>

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
                            <div class="card shadow mb-4">
                                <div class="card-header py-3 d-flex justify-content-between align-items-center">
                                    <h2 class="m-0 font-weight-bold text-primary">DRIVERS</h2>
                                    <div>
                                        <button type="button" class="ml-10 btn btn-primary float-right" data-toggle="modal" data-target="#add">
                                            Add Driver 
                                        </button>
                                        <a href="${pageContext.request.contextPath}/driver?action=show" style="margin-right: 10px" class="btn btn-primary float-right">Show All</a>
                                </div>

                                <div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">Add new Driver</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <form action="driver">
                                                <div class="modal-body">
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Driver ID</label>
                                                        <input type="text" name="driverID" class="add-driverID form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Driver ID" required>
                                                        <small id="id-error"></small>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Driver Name</label>
                                                        <input type="text" name="driverName" class="add-driverName form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Driver Name" required>
                                                        <small id="name-error"></small>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">DOB</label>
                                                        <input type="date" name="DOB" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter DOB" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Gender</label>
                                                        <select name="sex" class="form-control">
                                                            <option value="true" selected>MALE</option>
                                                            <option value="false">FEMALE</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Driver Picture</label>
                                                        <input type="text" name="driverPic" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Driver Picture" required>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Phone Number</label>
                                                        <input type="text" name="phoneNumber" class="add-number form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Phone Number" required>
                                                        <small id="phone-error"></small>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Status</label>
                                                        <select name="status" class="form-control">
                                                            <option value="1" selected>ACTIVE</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                    <button type="submit" name="action" value="add" class="btn btn-primary">Save</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>No</th>
                                                <th>Driver ID</th>
                                                <th>Driver Name</th>
                                                <th>DOB</th>
                                                <th>Gender</th>
                                                <th>Driver Picture</th>
                                                <th>Phone Number</th>
                                                <th>Status</th>
                                                <th>Modify</th>
                                                <th>Delete</th>
                                            </tr>
                                        </thead>
                                        <tbody id="content-data-update">
                                            <c:forEach items="${requestScope.LIST_ALL_DRIVER}" var="d" varStatus="counter">
                                                <tr>
                                                    <td>${counter.count}</td>
                                                    <td>${d.driverID}</td>
                                                    <td>${d.driverName}</td>
                                                    <td>${d.DOB}</td>
                                                    <td>${d.sex eq "true"? "MALE":"FEMALE"}</td>
                                                    <td><<img src="${d.driverPicture}" alt="alt"/></td>
                                                    <td>${d.phoneNumber}</td>
                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${d.status eq 0}">
                                                                INACTIVE
                                                            </c:when>
                                                            <c:when test="${d.status eq 1}">
                                                                ACTIVE
                                                            </c:when>
                                                            <c:when test="${d.status eq 2}">
                                                                ONGOING
                                                            </c:when>
                                                        </c:choose>
                                                    </td>
                                                    <td>
                                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modify-${d.driverID.trim()}">
                                                            <i class="fa fa-pen"></i>
                                                        </button>
                                                        <div class="modal fade" id="modify-${d.driverID.trim()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                            <div class="modal-dialog" role="document">
                                                                <div class="modal-content">
                                                                    <div class="modal-header">
                                                                        <h5 class="modal-title" id="exampleModalLabel">Modify Driver ${d.driverName}</h5>
                                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                            <span aria-hidden="true">&times;</span>
                                                                        </button>
                                                                    </div>
                                                                    <form action="driver">
                                                                        <div class="modal-body">
                                                                            <div class="modal-body">
                                                                                <div class="form-group">
                                                                                    <label for="exampleInputEmail1">Driver ID</label>
                                                                                    <input type="text" name="driverID" class="form-control" value="${d.driverID.trim()}" id="exampleInputEmail1" readonly placeholder="Enter Driver ID">
                                                                                </div>
                                                                                <div class="form-group">
                                                                                    <label for="exampleInputEmail1">Driver Name</label>
                                                                                    <input type="text" name="driverName" class="form-control" value="${d.driverName.trim()}" id="exampleInputEmail1" placeholder="Enter Driver Name">
                                                                                </div>
                                                                                <div class="form-group">
                                                                                    <label for="exampleInputEmail1">DOB</label>
                                                                                    <input type="date" name="DOB" class="form-control" value="${d.DOB}" id="exampleInputEmail1" placeholder="Enter DOB">
                                                                                </div>
                                                                                <div class="form-group">
                                                                                    <label for="exampleInputEmail1">Gender</label>
                                                                                    <select name="sex" class="form-control">
                                                                                        <option value="true" ${d.sex eq "1"?"selected":""}>MALE</option>
                                                                                        <option value="false" ${d.sex eq "0"?"selected":""}>FEMALE</option>
                                                                                    </select>
                                                                                </div>
                                                                                <div class="form-group">
                                                                                    <label for="exampleInputEmail1">Driver Picture</label>
                                                                                    <input type="text" name="driverPic" class="form-control" value="${d.driverPicture.trim()}" id="exampleInputEmail1" placeholder="Enter Driver Picture">
                                                                                </div>
                                                                                <div class="form-group">
                                                                                    <label for="exampleInputEmail1">Phone Number</label>
                                                                                    <input type="text" name="phoneNumber" class="form-control" value="${d.phoneNumber.trim()}" id="exampleInputEmail1" placeholder="Enter Phone Number">
                                                                                </div>
                                                                                <div class="form-group">
                                                                                    <label for="exampleInputEmail1">Status</label>
                                                                                    <select name="status" class="form-control">
                                                                                        <option value="0" ${d.status eq 0?"selected":""}>INACTIVE</option>
                                                                                        <option value="1" ${d.status eq 1?"selected":""}>ACTIVE</option>
                                                                                        <option value="2" ${d.status eq 2?"selected":""}>ONGOING</option>
                                                                                    </select>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                                            <button type="submit" name="action" value="update" class="update-button btn btn-primary">Save</button>
                                                                        </div>
                                                                    </form>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#delete-${d.driverID.trim()}">
                                                            <i class="fa fa-trash" aria-hidden="true"></i>
                                                        </button>
                                                        <div class="modal fade" id="delete-${d.driverID.trim()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                            <div class="modal-dialog" role="document">
                                                                <div class="modal-content">
                                                                    <div class="modal-header">
                                                                        <h5 class="modal-title" id="exampleModalLabel">Delete Driver ${d.driverName}</h5>
                                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                            <span aria-hidden="true">&times;</span>
                                                                        </button>
                                                                    </div>
                                                                    <form action="driver">
                                                                        <div class="modal-footer">
                                                                            <input type="hidden" name="driverID" value="${d.driverID.trim()}">
                                                                            <button type="submit" name="action" value="delete" class="btn btn-primary">
                                                                                Delete
                                                                            </button>
                                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                                        </div>
                                                                    </form>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </td>
                                                </tr>
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
                            <span>E-Transportation Website</span>
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
        <!--Modal show success and fail-->
        <!-- Button trigger modal -->
        <!--<button type="button" class="btn btn-primary show-success-modal" style="" data-toggle="modal" data-target="#showsuccess">click</button>-->

        <!-- Modal visibility: hidden; opacity: 0;-->
        <div class="modal fade" id="showsuccess" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-body">
                        <div class="text-center">
                            <i class="fa fa-check-circle" style="font-size:70px; color: greenyellow" aria-hidden="true"></i>
                        </div>
                        <h4 class="text-center font-weight-bold" style="margin-top: 20px">${requestScope.SUCCESS}</h4>
                        <button type="button" class="btn btn-secondary float-right" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="showerror" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-body">
                        <div class="text-center">
                            <i class="fa fa-ban" style="font-size:70px; color: red" aria-hidden="true"></i>
                        </div>
                        <h4 class="text-center font-weight-bold" style="margin-top: 20px">${requestScope.ERROR}</h4>
                        <button type="button" class="btn btn-secondary float-right" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <!--End Modal show success and fail-->
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
        <script type="text/javascript">
//            var id_error = document.getElementById("id-error");
//            var name_error = document.getElementById("name-error");
//            var phone_error = document.getElementById("phone-error");
//
//            let driverIDField = document.querySelector(".add-driverID");
//            let nameField = document.querySelector(".add-driverName");
//            let phoneField = document.querySelector(".add-number");

            
        </script>
        <script type="text/javascript">
//            $(document).ready(function (e) {
//                $(".add-driverID").keyup(function(){
//                    var driverID = $(this).val();
//                    $.ajax({
//                        url: "/ETrans/driver?action=isContain",
//                        type: "get",
//                        data: {
//                            driverId = driverID
//                        },
//                        success: function (data) {
//                            var id_error = $("#id-error");
//                            if(data.){
//                                id_error.text("DriverID is existed");
//                            }
//                            else{
//                                id_error.text("DriverID is OK");
//                            }
//                        },
//                        error: function (data) {
//                            console.log(data);
//                        }
//                    });
//                });
//            });
            <c:if test="${requestScope.SUCCESS != null}">
                $(document).ready(function (e) {
                    $("#showsuccess").modal('show');
                });
                <c:if test="${requestScope.SUCCESS != null}">
                    $.ajax({
                        url: "/ETrans/driver?action=driverUpdate",
                        type: "get",
                        success: function (data) {
                            var row = document.getElementById("content-data-update");
                            row.innerHTML = data;
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                        }
                    });
                </c:if>
                <c:if test="${requestScope.SUCCESS != null}">
                    const inputField = document.querySelectorAll("input[type=search]");
                    inputField.addEventListener('input', function (e) {
                        $.ajax({
                            url: "/ETrans/driver?action=search",
                            type: "get",
                            data: {
                                txt: e.target.value
                            },
                            success: function (data) {
                                var row = document.getElementById("content-data-update");
                                row.innerHTML = data;
                            },
                            error: function (jqXHR, textStatus, errorThrown) {
                            }
                        });
                    });
                </c:if>
            </c:if>
            <c:if test="${requestScope.ERROR != null}">
                $(document).ready(function () {
                    $("#showerror").modal('show');
                });
            </c:if>
            <c:if test="${requestScope.SUCCESS == null}">
                $(document).ready(function () {
                    $(".add-driverID").keyup(function(){
                        var driverID = $(this).val();
                        $.ajax({
                            url: "/ETrans/driver?action=isContain",
                            type: "get",
                            data: {
                                driverId = driverID
                            },
                            success: function (data) {
                                var id_error = $("#id-error");
                                if(data.){
                                    id_error.text("DriverID is existed");
                                }
                                else{
                                    id_error.text("DriverID is OK");
                                }
                            },
                            error: function (data) {
                                console.log(data);
                            }
                        });
                    });
                });
            </c:if>
        </script>
    </body>
</html>
