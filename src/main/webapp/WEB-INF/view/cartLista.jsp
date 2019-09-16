<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
View Cart
<br>



<c:forEach var="orderedItem" items="${orderItems}">
    <tr>
        <td>${orderedItem.product.productName}</td>
        <td>${orderedItem.amount}</td>
    </tr>
</c:forEach>

</body>
</html>