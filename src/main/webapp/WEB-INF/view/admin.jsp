<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<title>Admin view</title>
<style>
    table, th, td {
        text-align: center;
    }
</style>
<body>

<a href="/logout">Logout</a>

<h2>You are logged in as an administrator!</h2>

<form:form method="POST" action="/newProduct" modelAttribute="product">
    Product name:
    <form:label path="productName"></form:label>
    <form:input path="productName"/><br>

    Set amount of products:

    <form:label path="amount"></form:label>
    <form:input type="number" path="amount"/><br>
    Set price:
    <form:label path="price"></form:label>
    <form:input path="price"/><br>

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
    </div>
</form:form>

</body>
</html>