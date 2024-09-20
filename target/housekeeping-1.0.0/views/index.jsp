<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Management System</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
    <%@ include file="/allComponents/navbar.jsp" %>
    
    <div class="container mt-5 text-center">
        <h1 class="display-4">Welcome to ABC Hotel</h1>
        <p class="lead">Use the navigation bar to access different sections of the system.</p>
        
        <!-- Example buttons to navigate to main features -->
        <div class="mt-4">
            <a href="${pageContext.request.contextPath}/HousekeepingServlet" class="btn btn-primary btn-lg mx-2">Housekeeping</a>
            <a href="${pageContext.request.contextPath}/CloseBillServlet" class="btn btn-secondary btn-lg mx-2">Close Bill</a>
            <a href="${pageContext.request.contextPath}/NotificationsServlet" class="btn btn-success btn-lg mx-2">Notifications</a>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>


