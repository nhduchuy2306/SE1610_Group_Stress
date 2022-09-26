<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
    </a>
    <!-- Divider -->
    <hr class="sidebar-divider my-0">
    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
        <a class="nav-link" href="index.jsp">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span></a>
    </li>
    <!-- Divider -->
    <hr class="sidebar-divider">
    <!-- Heading -->
    <div class="sidebar-heading">
        Tables
    </div>
    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link" href="http://localhost:8080/CarBooking/user?action=viewUser">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>User</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="roleTable.jsp">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Role</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="orderTable.jsp">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Order</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="locationTable.jsp">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Location</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="routeTable.jsp">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Route</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="VehicleTypeController?action=show">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Vehicle Type</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="vehicleTable.jsp">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Vehicle</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="driverLicenseTable.jsp">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Driver License</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/admin/driver?action=show">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Driver</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="tripTable.jsp">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Trip</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="seatTable.jsp">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Seat</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="ticketTable.jsp">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Ticket</span></a>
    </li>
    <!-- Nav Item - Charts -->
    <li class="nav-item">
        <a class="nav-link" href="routeTable.jsp">
            <i class="fas fa-fw fa-chart-area"></i>
            <span>Charts</span></a>
    </li>
    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">
    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>
</ul>
