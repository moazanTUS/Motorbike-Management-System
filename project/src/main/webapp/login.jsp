<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-black">

<div class="w3-display-middle w3-card-4 w3-round-large w3-padding-large" style="max-width: 350px; background:linear-gradient(to right, #2a2a72, #009ffd);); color: white;">
    <h2 class="w3-center w3-text-white">Login</h2>
    
    <form action="UserController" method="post" class="w3-container">
        <input type="hidden" name="action" value="login">
        
        <label class="w3-text-white">User Name</label>
        <input type="text" name="email" class="w3-input w3-border w3-round w3-margin-bottom" placeholder="Enter your Username" required>
        
        <label class="w3-text-white">Password</label>
        <input type="password" name="password" class="w3-input w3-border w3-round w3-margin-bottom" placeholder="Enter your password" required>
        
        <button type="submit" class="w3-button w3-block w3-round-large w3-red w3-hover-green" style="margin-top: 15px;">
            Login
        </button>
    </form>
</div>

</body>
</html>
