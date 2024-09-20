<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Room Cleaning Form</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Room Cleaning Checklist</h1>

        <form action="${pageContext.request.contextPath}/SubmitRoomCleaningServlet" method="post">
            <input type="hidden" name="roomNumber" value="${param.roomNumber}">
            <input type="hidden" name="roomBoyId" value="${param.roomBoyId}">

            <!-- Forgotten Items -->
            <div class="mb-3">
                <label for="forgotten-items" class="form-label">Forgotten Items (if any):</label>
                <textarea class="form-control" id="forgotten-items" name="forgottenItems" rows="3"></textarea>
            </div>

            <!-- Check for Damages -->
            <div class="mb-3">
                <label for="damages" class="form-label">Check for Any Damages (if any):</label>
                <textarea class="form-control" id="damages" name="damages" rows="3"></textarea>
            </div>

            <!-- Cleaning Tasks -->
            <h3>Cleaning Tasks</h3>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="cleanBathroom" name="cleanBathroom">
                <label class="form-check-label" for="cleanBathroom">Clean the Bathroom</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="vacuumMopFloor" name="vacuumMopFloor">
                <label class="form-check-label" for="vacuumMopFloor">Vacuum or Mop the Floor</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="dustSurfaces" name="dustSurfaces">
                <label class="form-check-label" for="dustSurfaces">Dust Surfaces</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="cleanMirrorsWindows" name="cleanMirrorsWindows">
                <label class="form-check-label" for="cleanMirrorsWindows">Clean Mirrors and Windows</label>
            </div>

            <!-- Removed Linens -->
            <h3 class="mt-4">Removed Linens</h3>
            <div class="mb-3">
                <label for="removed-towels" class="form-label">Towels Removed:</label>
                <input type="number" class="form-control" id="removed-towels" name="removedTowels" min="0">
            </div>
            <div class="mb-3">
                <label for="removed-bedsheets" class="form-label">Bedsheets Removed:</label>
                <input type="number" class="form-control" id="removed-bedsheets" name="removedBedsheets" min="0">
            </div>
            <div class="mb-3">
                <label for="removed-pillowcases" class="form-label">Pillowcases Removed:</label>
                <input type="number" class="form-control" id="removed-pillowcases" name="removedPillowcases" min="0">
            </div>
            <div class="mb-3">
                <label for="removed-blankets" class="form-label">Blankets Removed:</label>
                <input type="number" class="form-control" id="removed-blankets" name="removedBlankets" min="0">
            </div>

            <!-- Replaced Linens -->
            <h3 class="mt-4">Replaced Linens</h3>
            <div class="mb-3">
                <label for="replaced-towels" class="form-label">Towels Replaced:</label>
                <input type="number" class="form-control" id="replaced-towels" name="replacedTowels" min="0">
            </div>
            <div class="mb-3">
                <label for="replaced-bedsheets" class="form-label">Bedsheets Replaced:</label>
                <input type="number" class="form-control" id="replaced-bedsheets" name="replacedBedsheets" min="0">
            </div>
            <div class="mb-3">
                <label for="replaced-pillowcases" class="form-label">Pillowcases Replaced:</label>
                <input type="number" class="form-control" id="replaced-pillowcases" name="replacedPillowcases" min="0">
            </div>
            <div class="mb-3">
                <label for="replaced-blankets" class="form-label">Blankets Replaced:</label>
                <input type="number" class="form-control" id="replaced-blankets" name="replacedBlankets" min="0">
            </div>

            <!-- Toiletries -->
            <h3 class="mt-4">Toiletries</h3>
            <div class="mb-3">
                <label for="soap" class="form-label">Soap Quantity:</label>
                <input type="number" class="form-control" id="soap" name="soap" min="0">
            </div>

            <!-- Empty Trash Bins -->
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="emptyTrashBins" name="emptyTrashBins">
                <label class="form-check-label" for="emptyTrashBins">Empty Trash Bins</label>
            </div>

            <!-- Submit button -->
            <button type="submit" class="btn btn-primary mt-4">Submit</button>
        </form>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>
