<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notifications</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
    <%@ include file="/allComponents/navbar.jsp" %>
    
    <div class="container mt-5">
        <h1 class="mb-4">Notifications</h1>
        
        <!-- Notifications list -->
        <ul class="list-group">
            <c:forEach var="notification" items="${notifications}">
                <li class="list-group-item">
                    <strong>${notification.type}:</strong> ${notification.message}
                    <span class="text-muted float-end">${notification.timestamp}</span>
                </li>
            </c:forEach>
        </ul>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>
