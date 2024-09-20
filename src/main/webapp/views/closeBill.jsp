<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Close Bill</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <%@ include file="/allComponents/navbar.jsp" %>

        <div class="container mt-4">
            <h1 class="mb-4">Close Bill for a Room</h1>

            <!-- Responsive table with Bootstrap classes -->
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thead class="thead-light">
                        <tr>
                            <th>Room Number</th>
                            <th>Customer Name</th>
                            <th>Check-In Date</th>
                            <th>Check-Out Date</th>
                            <th>Bill Status</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Loop through the open bookings and display each booking's details -->
                        <c:forEach var="booking" items="${openBookings}">
                            <tr>
                                <td>${booking.roomNumber}</td>
                                <td>${booking.customerName}</td>
                                <td>${booking.checkInDate}</td>
                                <td>${booking.checkOutDate}</td>
                                <td>${booking.billStatus}</td>
                                <td>
                                    <!-- Form to close the bill -->
                                    <form action="BillClosureServlet" method="post">
                                        <input type="hidden" name="roomNumber" value="${booking.roomNumber}">
                                        <button type="submit" class="btn btn-primary">Close Bill</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <!-- Bootstrap JS and dependencies -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
