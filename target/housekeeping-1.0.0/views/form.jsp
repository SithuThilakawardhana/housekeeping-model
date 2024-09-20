<%-- 
    Document   : form
    Created on : Sep 6, 2024, 12:58:57 PM
    Author     : sithumini
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Room Cleaning Form</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Hotel Room Cleaning Form</h2>
        <form action="/submit" method="post">
            <!-- Forgotten Items -->
            <div class="form-group">
                <label for="forgotten-items">Forgotten Items (if any):</label>
                <textarea id="forgotten-items" name="forgottenItems" class="form-control" rows="3"></textarea>
            </div>

            <!-- Check for Damages -->
            <div class="form-group">
                <label for="damages">Check for Any Damages (if any):</label>
                <textarea id="damages" name="damages" class="form-control" rows="3"></textarea>
            </div>

            <!-- Cleaning Checklist -->
            <h3>Cleaning Tasks</h3>
            <div class="form-check">
                <input type="checkbox" id="clean-bathroom" name="cleanBathroom" class="form-check-input">
                <label for="clean-bathroom" class="form-check-label">Clean Bathroom</label>
            </div>

            <!-- Toiletries -->
            <div class="form-group">
                <label for="soap">Toiletries (Soap Quantity):</label>
                <input type="number" id="soap" name="soap" class="form-control" min="0">
            </div>

            <div class="form-check">
                <input type="checkbox" id="dust-surfaces" name="dustSurfaces" class="form-check-input">
                <label for="dust-surfaces" class="form-check-label">Dust Surfaces</label>
            </div>

            <div class="form-check">
                <input type="checkbox" id="vacuum-mop-floor" name="vacuumMopFloor" class="form-check-input">
                <label for="vacuum-mop-floor" class="form-check-label">Vacuum and Mop Floor</label>
            </div>

            <div class="form-check">
                <input type="checkbox" id="clean-mirrors-windows" name="cleanMirrorsWindows" class="form-check-input">
                <label for="clean-mirrors-windows" class="form-check-label">Clean Mirrors and Windows</label>
            </div>

            <div class="form-check">
                <input type="checkbox" id="change-linens" name="changeLinens" class="form-check-input">
                <label for="change-linens" class="form-check-label">Change Linens</label>
            </div>

            <!-- Removed Items -->
            <h3>Removed Items</h3>
            <div class="form-group">
                <label for="removed-towels">Towels Removed:</label>
                <input type="number" id="removed-towels" name="removedTowels" class="form-control" min="0">
            </div>

            <div class="form-group">
                <label for="removed-bedsheets">Bedsheets Removed:</label>
                <input type="number" id="removed-bedsheets" name="removedBedsheets" class="form-control" min="0">
            </div>

            <div class="form-group">
                <label for="removed-pillowcases">Pillowcases Removed:</label>
                <input type="number" id="removed-pillowcases" name="removedPillowcases" class="form-control" min="0">
            </div>

            <div class="form-group">
                <label for="removed-blankets">Blankets Removed:</label>
                <input type="number" id="removed-blankets" name="removedBlankets" class="form-control" min="0">
            </div>

            <!-- Replaced Items -->
            <h3>Replaced Items</h3>
            <div class="form-group">
                <label for="replaced-towels">Towels Replaced:</label>
                <input type="number" id="replaced-towels" name="replacedTowels" class="form-control" min="0">
            </div>

            <div class="form-group">
                <label for="replaced-bedsheets">Bedsheets Replaced:</label>
                <input type="number" id="replaced-bedsheets" name="replacedBedsheets" class="form-control" min="0">
            </div>

            <div class="form-group">
                <label for="replaced-pillowcases">Pillowcases Replaced:</label>
                <input type="number" id="replaced-pillowcases" name="replacedPillowcases" class="form-control" min="0">
            </div>

            <div class="form-group">
                <label for="replaced-blankets">Blankets Replaced:</label>
                <input type="number" id="replaced-blankets" name="replacedBlankets" class="form-control" min="0">
            </div>

            <!-- Trash -->
            <div class="form-check">
                <input type="checkbox" id="empty-trash-bins" name="emptyTrashBins" class="form-check-input">
                <label for="empty-trash-bins" class="form-check-label">Empty Trash Bins</label>
            </div>

            <br>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
