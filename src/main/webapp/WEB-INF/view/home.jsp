<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>


<c:forEach var="category" items="${categories}">
    <tr>
        <td>${category.categoryName}</td>
        <td><a href="/productList/${category.id}">Enter this category.</a></td>

    </tr><br>
</c:forEach>


</body>
</html>