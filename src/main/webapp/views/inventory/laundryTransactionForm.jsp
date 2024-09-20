<!DOCTYPE html>
<html>
<head>
    <title>Linen Laundry Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <%@ include file="/allComponents/navbar.jsp" %>

    <div class="container mt-5">
        <h2>Linen Laundry Form</h2>
        <form action="${pageContext.request.contextPath}/LaundryTransactionServlet" method="post">
            <div class="mb-3">
                <label for="towel_quantity" class="form-label">Towel Quantity:</label>
                <input type="number" class="form-control" id="towel_quantity" name="towel_quantity" required>
            </div>
            <div class="mb-3">
                <label for="bedsheet_quantity" class="form-label">Bedsheet Quantity:</label>
                <input type="number" class="form-control" id="bedsheet_quantity" name="bedsheet_quantity" required>
            </div>
            <div class="mb-3">
                <label for="pillowcase_quantity" class="form-label">Pillowcase Quantity:</label>
                <input type="number" class="form-control" id="pillowcase_quantity" name="pillowcase_quantity" required>
            </div>
            <div class="mb-3">
                <label for="blanket_quantity" class="form-label">Blanket Quantity:</label>
                <input type="number" class="form-control" id="blanket_quantity" name="blanket_quantity" required>
            </div>
            <div class="mb-3">
                <label for="date" class="form-label">Date:</label>
                <input type="date" class="form-control" id="date" name="date" required>
            </div>
            <div class="mb-3">
                <label for="status" class="form-label">Status:</label>
                <select class="form-select" id="status" name="status" required>
                    <option value="Sent">Sent to Washer</option>
                    <option value="Returned">Returned from Washer</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
