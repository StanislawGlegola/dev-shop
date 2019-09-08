<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<a href="/login">Log in</a>
<hr>
<h3>Choose category:</h3><br>

<c:forEach var="category" items="${categories}">
   <table> <tr>
        <td>${category.categoryName}</td>
        <td><a href="/productList/${category.id}">Enter this category.</a></td>

    </tr>
   </table>
    <br>
</c:forEach>


</body>
</html>