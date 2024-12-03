<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Motorbikes</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-dark-grey">

<!-- Centered Main Container -->
<div class="w3-container w3-center w3-padding-32">
    <div class="w3-card w3-black w3-padding-large w3-round-large" style="max-width: 600px; margin: auto;">
        <h2 class="w3-text-white">All Registered Motorbikes</h2>

        <c:forEach var="bike" items="${motorbikes}">
            <div class="w3-panel w3-grey w3-round-large w3-padding-small w3-margin-bottom">
                <p class="w3-text-white"> ${bike}</p>
            </div>
        </c:forEach>

        <div class="w3-margin-top">
            <a href="dashboard.jsp" class="w3-button w3-round w3-yellow w3-border w3-border-black">Back to Dashboard</a>
        </div>
    </div>
</div>

</body>
</html>
