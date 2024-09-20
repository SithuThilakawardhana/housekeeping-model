<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Toiletries Item</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
    <%@ include file="/allComponents/navbar.jsp" %>

    <div class="container mt-5">
        <h2 class="mb-4">Delete Toiletries Item</h2>
        <form action="${pageContext.request.contextPath}/DeleteToiletriesItemServlet" method="post">
            <div class="mb-3">
                <label for="itemName" class="form-label">Item Name:</label>
                <input type="text" class="form-control" id="itemName" name="itemName" required>
            </div>
            <button type="submit" class="btn btn-danger">Delete Item</button>
        </form>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>

