<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Motorbikes</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-dark-grey">

<div class="w3-container w3-center w3-padding-32">
    <div class="w3-card w3-black w3-padding-large w3-round-large" style="max-width: 600px; margin: auto;">
        <h2 class="w3-text-white">My Motorbikes</h2>

        <c:forEach var="bike" items="${motorbikes}">
            <div class="w3-panel w3-grey w3-round-large w3-padding-small">
                <h3>ID: ${bike.id}</h3>
                <p><strong>Make:</strong> ${bike.make}</p>
                <p><strong>Model:</strong> ${bike.model}</p>
                <a href="MotorbikeController?action=editMotorbike&id=${bike.id}" 
                   class="w3-button w3-round w3-dark-grey w3-border w3-border-white w3-margin-right">Edit</a>
                <a href="MotorbikeController?action=deleteMotorbike&id=${bike.id}" 
                   class="w3-button w3-round w3-red w3-border w3-border-white" 
                   onclick="return confirm('Are you sure you want to delete this motorbike?');">Delete</a>
            </div>
        </c:forEach>

        <div class="w3-container w3-padding-16">
            <h3 class="w3-text-white">Add a New Motorbike</h3>
            <form action="MotorbikeController" method="post">
                <input type="hidden" name="action" value="addMotorbike">
                <input class="w3-input w3-border w3-round w3-margin-bottom" type="text" name="make" placeholder="Make" required>
                <input class="w3-input w3-border w3-round w3-margin-bottom" type="text" name="model" placeholder="Model" required>
                <button type="submit" class="w3-button w3-round w3-dark-grey w3-border w3-border-white">Add Motorbike</button>
            </form>
        </div>

        <div class="w3-margin-top">
            <a href="dashboard.jsp" class="w3-button w3-round w3-yellow w3-border w3-border-black">Back to Dashboard</a>
        </div>
    </div>
</div>

</body>
</html>
