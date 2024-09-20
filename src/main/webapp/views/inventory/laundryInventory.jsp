<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Laundry Inventory</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
    <%@ include file="/allComponents/navbar.jsp" %>

    <div class="container mt-5">
        <h1 class="mb-4">Laundry Inventory</h1>

        <table class="table table-striped table-bordered">
            <thead class="thead-light">
                <tr>
                    <th scope="col">Item</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${laundryItems}">
                    <tr>
                        <td>${item.itemName}</td>
                        <td>${item.quantity}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/UpdateLaundryItemServlet?id=${item.id}" class="btn btn-sm btn-warning">Update</a>
                            <a href="${pageContext.request.contextPath}/DeleteLaundryItemServlet?id=${item.id}" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure?')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="${pageContext.request.contextPath}/views/inventory/addLaundryItem.jsp" class="btn btn-primary">Add Laundry Item</a>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>
