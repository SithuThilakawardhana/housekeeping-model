<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Housekeeping Dashboard</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="/allComponents/navbar.jsp" %>
    
    <div class="container mt-4">
        <h1 class="mb-4">Housekeeping Dashboard</h1>

        <h2 class="mb-4">Manage Rooms</h2>

        <!-- Table for managing rooms -->
        <table class="table table-bordered table-hover">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Room Number</th>
                    <th scope="col">Status</th>
                    <th scope="col">Assign Room Boy</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="room" items="${listRooms}">
                    <tr>
                        <td>${room.roomNumber}</td>
                        <td>${room.status}</td>
                        <td>
                            <form action="AssignRoomBoyServlet" method="post">
                                <input type="hidden" name="roomNumber" value="${room.roomNumber}">
                                <div class="input-group">
                                    <select name="roomBoyId" class="custom-select">
                                        <option value="">Select Room Boy</option>
                                        <c:forEach var="roomBoy" items="${listRoomBoys}">
                                            <!-- Show all room boys if the room is Vacant, otherwise filter them -->
                                            <c:if test="${room.status eq 'Vacant' || (!assignedRoomBoys.contains(roomBoy.userId) || room.roomBoyId eq roomBoy.userId)}">
                                                <option value="${roomBoy.userId}" 
                                                    <c:if test="${room.roomBoyId eq roomBoy.userId}">
                                                        selected="selected"
                                                    </c:if>
                                                >${roomBoy.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                    <div class="input-group-append">
                                        <button type="submit" class="btn btn-primary">Assign Room Boy</button>
                                    </div>
                                </div>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>