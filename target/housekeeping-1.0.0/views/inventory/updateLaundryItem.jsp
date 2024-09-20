<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Laundry Item</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
    <%@ include file="/allComponents/navbar.jsp" %>

    <div class="container mt-5">
        <h2>Update Laundry Item</h2>

        <form action="${pageContext.request.contextPath}/UpdateLaundryItemServlet" method="post" class="needs-validation" novalidate>
            <!-- Hidden field for ID -->
            <input type="hidden" name="id" value="${item.id}">

            <!-- Item Name -->
            <div class="mb-3">
                <label for="itemName" class="form-label">Item Name:</label>
                <input type="text" class="form-control" id="itemName" name="itemName" value="${item.itemName}" required>
                <div class="invalid-feedback">
                    Please enter the item name.
                </div>
            </div>

            <!-- Quantity -->
            <div class="mb-3">
                <label for="quantity" class="form-label">Quantity:</label>
                <input type="number" class="form-control" id="quantity" name="quantity" value="${item.quantity}" required>
                <div class="invalid-feedback">
                    Please enter the quantity.
                </div>
            </div>

            <!-- Submit Button -->
            <button type="submit" class="btn btn-primary">Update Item</button>
        </form>
    </div>

    <!-- Bootstrap JS (for validation) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script>
        // Bootstrap form validation
        (function () {
            'use strict';
            var forms = document.querySelectorAll('.needs-validation');
            Array.prototype.slice.call(forms).forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        })();
    </script>
</body>
</html>
