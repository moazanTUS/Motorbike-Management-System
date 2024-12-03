<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-black">

<div class="w3-display-middle w3-card w3-round-large w3-padding-large" style="max-width: 400px; background: linear-gradient(to right, #2a2a72, #009ffd); color: white;">
    <h2 class="w3-center w3-text-light-grey">Create Your Account</h2>
    <p class="w3-center w3-text-light-grey">Join us today for an amazing experience!</p>
    
    <form action="UserController" method="post" class="w3-container">
        <input type="hidden" name="action" value="register">
        
        <label class="w3-text-white"><b>Name</b></label>
        <input type="text" name="name" class="w3-input w3-border w3-round w3-margin-bottom" style="padding: 12px; border-color: #009ffd;" placeholder="Enter your name" required>
        
        <label class="w3-text-white"><b>Password</b></label>
        <input type="password" name="password" class="w3-input w3-border w3-round w3-margin-bottom" style="padding: 12px; border-color: #009ffd;" placeholder="Create a password" required>
        
        <button type="submit" class="w3-button w3-round-large w3-block" style="background-color: #ff6f61; padding: 12px; font-size: 16px; margin-top: 15px;">
            Register
        </button>
    </form>
</div>

</body>
</html>
