<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<html>
<head>
    <title>IntelliJ</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body bgcolor="#e9ebee">
<br>
<div class="w3-container" >
<img src="http://fcchyby.home.pl/javapoz15/devshop_logo.png"; width="160" ><br><br>



    <h3>Please login</h3>

    <form action="/login" method="POST" name="loginForm">

        <table>
            <tr>
                <td>Username:</td>
                <td><input name="username" type="text"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input name="password" type="password"/></td>
            </tr>
            <tr>
                <td colspan="2"><input name="submit" type="submit" value="submit"/></td>
            </tr>

        </table>
        <br><a href="/">Back to homepage</a><br>
    </form>
</div>

</body>
</html>