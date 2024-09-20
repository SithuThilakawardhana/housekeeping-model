<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Styled Navbar</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">Hotel Management</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/CloseBillServlet">Close Bill</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/HousekeepingServlet">Housekeeping Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/NotificationsServlet">Notifications</a>
                    </li>

                    <!-- Inventory Dropdown -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="inventoryDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Inventory
                        </a>
                        <div class="dropdown-menu" aria-labelledby="inventoryDropdown">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/FreshLinenInventoryServlet">Fresh Linen Inventory</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/LaundryInventoryServlet">Laundry Inventory</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/ToiletriesInventoryServlet">Toiletries Inventory</a>
                            <!-- Link to the Laundry Transaction Report -->
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/LaundryTransactionReportServlet">Laundry Transactions Report</a>
                            <!-- Link to the Laundry Transaction Form -->
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/views/inventory/laundryTransactionForm.jsp">Submit Laundry Form</a>

                        </div>
                    </li>
                </ul>
            </div>
        </nav>

        <!-- Add your page content here -->

        <!-- Bootstrap JS and dependencies -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
