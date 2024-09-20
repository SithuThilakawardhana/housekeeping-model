<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Fresh Linen Item</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
    <%@ include file="/allComponents/navbar.jsp" %>

    <div class="container mt-5">
        <h2 class="mb-4">Add Fresh Linen Item</h2>
        <form action="${pageContext.request.contextPath}/AddFreshLinenItemServlet" method="post">
            <div class="mb-3">
                <label for="itemName" class="form-label">Item Name:</label>
                <input type="text" class="form-control" id="itemName" name="itemName" required>
            </div>
            <div class="mb-3">
                <label for="quantity" class="form-label">Quantity:</label>
                <input type="number" class="form-control" id="quantity" name="quantity" required>
            </div>
            <button type="submit" class="btn btn-primary">Add Item</button>
        </form>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>

