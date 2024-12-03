<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Motorbike</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-dark-grey">

<div class="w3-display-middle w3-card w3-round-large w3-light-grey w3-padding-large" style="max-width: 500px;">
    <h2 class="w3-center w3-text-dark-grey">Update Motorbike</h2>
    
    <form action="MotorbikeController" method="post" class="w3-container">
        <input type="hidden" name="action" value="updateMotorbike">
        <input type="hidden" name="id" value="${motorbikeId}">
        
        <label for="make" class="w3-text-dark-grey"><b>Make</b></label>
        <input type="text" id="make" name="make" value="${make}" class="w3-input w3-border w3-round w3-margin-bottom" required>

        <label for="model" class="w3-text-dark-grey"><b>Model</b></label>
        <input type="text" id="model" name="model" value="${model}" class="w3-input w3-border w3-round w3-margin-bottom" required>

        <button type="submit" class="w3-button w3-green w3-round-large w3-margin-top w3-block">Update Motorbike</button>
    </form>

    <!-- Cancel Button -->
    <div class="w3-center w3-margin-top">
        <a href="MotorbikeController?action=viewMyBikes" class="w3-button w3-red w3-round-large">Cancel</a>
    </div>
</div>

</body>
</html>
