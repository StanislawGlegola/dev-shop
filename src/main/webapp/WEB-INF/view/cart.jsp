<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<a href="/logout">Logout</a>
<h2>View Cart</h2>
<br>

<table>
    <tr>
        <th>Product name</th>
        <th>Product description</th>
        <th>Product price</th>
        <th>Product quantity</th>

    </tr>
</table>
<c:forEach var="orderedItem" items="${orderItems}">
    <tr>
        <td>${orderedItem.product.productName}</td>
        <td>${orderedItem.amount}</td>
    </tr>
</c:forEach>

</body>
</html>