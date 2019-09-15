<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="hidden" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="visable" uri="http://www.springframework.org/tags/form" %>
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
    <img src="/img/devshop_logo.png"; width="200" /><br><br>

<a href="/logout">Logout</a>

<h2>You are logged in as an administrator!</h2>
    <br>
    <h3>Manage product:</h3>

    <spring:url value="/product/edit" var="editProduct"/>
    <spring:url value="/newProduct" var="addProduct" />

<form:form method="POST" action="${edit ? editProduct : addProduct}" modelAttribute="product">

    <tr>
        <td><form:label path="id" readonly="${edit}" type="${edit ? '' : 'hidden'}">id</form:label></td>
        <td><form:input path="id" readonly="${edit}" type="${edit ? '' : 'hidden'}"/></td>
    </tr>

    </tr>

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