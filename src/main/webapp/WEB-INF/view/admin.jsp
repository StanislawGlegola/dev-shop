<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>devSHOP admin view</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<style>
    table, th, td {
        text-align: center;
    }
</style>
<body bgcolor="#e9ebee">
<br>
<div class="w3-container" >
    <img src="http://fcchyby.home.pl/javapoz15/devshop_logo.png"; width="200" ><br><br>

<a href="/logout">Logout</a>

<h2>You are logged in as an administrator!</h2>
    <br>
    <h3>Add new product:</h3>

<form:form method="POST" action="/newProduct" modelAttribute="product">
    Product name:
    <form:label path="productName"></form:label>
    <form:input path="productName"/><br>

    Set amount of products:

    <form:label path="amount"></form:label>
    <form:input type="number" path="amount"/><br>
    Set price:
    <form:label path="price"></form:label>
    <form:input type="number" min="0.00" step="0.01" path="price"/><br>

    <p>Pick product category:</p>
    <table>
        <tr>
            <td>Laptop</td>
            <td>Phone</td>
            <td>Monitor</td>
            <td>Printer</td>
        </tr>
        <tr>
            <td><form:radiobutton path="category.id" value="1"/></td>
            <td><form:radiobutton path="category.id" value="2"/></td>
            <td><form:radiobutton path="category.id" value="3"/></td>
            <td><form:radiobutton path="category.id" value="4"/></td>
        </tr>
    </table>

    <p>Set product discription:</p>
    <form:textarea path="description" cols="50" rows="10"/>

    <br><br><br>
    <input type="submit" value="Send form">
    <input type="reset" value="Clear data">
</form:form>
</div>
</body>
</html>