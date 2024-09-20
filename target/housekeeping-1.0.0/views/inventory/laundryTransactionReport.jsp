<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Laundry Transactions Report</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <%@ include file="/allComponents/navbar.jsp" %>

    <div class="container-fluid mt-5">
        <div class="row">
            <div class="col-12">
                <h1 class="text-center mb-4">Laundry Transactions Report</h1>
                <div class="table-responsive">
                    <table class="table table-hover table-striped table-bordered">
                        <thead class="thead-dark">
                            <tr>
                                <th>Transaction ID</th>
                                <th>Towel Quantity</th>
                                <th>Bedsheet Quantity</th>
                                <th>Pillowcase Quantity</th>
                                <th>Blanket Quantity</th>
                                <th>Date</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="transaction" items="${transactions}">
                                <tr>
                                    <td>${transaction.transactionId}</td>
                                    <td>${transaction.towelQuantity}</td>
                                    <td>${transaction.bedsheetQuantity}</td>
                                    <td>${transaction.pillowcaseQuantity}</td>
                                    <td>${transaction.blanketQuantity}</td>
                                    <td>${transaction.date}</td>
                                    <td>
                                        <span class="badge badge-${transaction.status eq 'Sent' ? 'warning' : 'success'}">
                                            ${transaction.status}
                                        </span>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

