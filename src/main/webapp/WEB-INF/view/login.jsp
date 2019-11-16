<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<html>
<head>
    <title>devSHOP login page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style type="text/css">
        .fieldset-auto-width {
            display: inline-block;
        }
    </style>
</head>
<body bgcolor="#e9ebee">
<br>
<div class="w3-container" >
    <a href="/"><img src="/img/devshop_logo.png" width="200" /></a><br><br>

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

<fieldset class="fieldset-auto-width">
    <legend>Hint</legend>
    <p>Try log in as "<b>user</b>" with password "<b>user</b>", or login "<b>admin</b>" and password "<b>admin</b>".</p>
</fieldset>

</body>
</html>