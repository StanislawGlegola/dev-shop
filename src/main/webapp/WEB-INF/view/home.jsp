<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>devSHOP category list</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body bgcolor="#e9ebee">
<div class="w3-container" style="width:250px">
    <br>
    <img src="/img/devshop_logo.png"; width="200" /><br><br>
<a href="/admin">Admin panel</a> || <a href="/cart">Your cart</a>


    <h2>Category List</h2>
    <p>Pick one of our products from given categories:</p>
    <ul class="w3-ul" style="width:250px">
        <c:forEach var="category" items="${categories}">
            <li class="w3-blue" style="text-align:center"><a
                    href="/productList/${category.id}">${category.categoryName}</a></li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
