<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        .button {
            display: block;
            width: 200px;
            padding: 10px;
            margin: 10px auto;
            text-align: center;
            text-decoration: none;
            color: white;
            border-radius: 5px;
            font-size: 16px;
        }
        .button-blue { background-color: #1e90ff; } 
        .button-teal { background-color: #20b2aa; }  
        .button-red { background-color: #dc143c; }  
    </style>
</head>
<body style="background-color: black; display: flex; align-items: center; justify-content: center; height: 100vh; margin: 0;">

<div style="text-align: center;">
    
    <a href="MotorbikeController?action=viewMyBikes" class="button button-blue">View My Motorbikes</a>
    <a href="MotorbikeController?action=viewAllBikes" class="button button-teal">View All Motorbikes</a>
    <a href="UserController?action=logout" class="button button-red">Logout</a>
</div>

</body>
</html>
