<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>devSHOP product list</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
        }

        th, td {
            padding: 5px;
            text-align: left;
            width: 100px;
            height: 40px;
        }
    </style>
</head>
<body bgcolor="#e9ebee">
<div class="w3-container" >
<br>
<img src="http://fcchyby.home.pl/javapoz15/devshop_logo.png"; width="200" /><br><br>
<a href="/admin">Admin panel</a> || <a href="/cart">Your cart</a>

<h2>Product list by category</h2>

<br>

    <ul class="w3-ul" >
<table>

    <tr>
        <th>Product name</th>
        <th>Product description</th>
        <th>Product price</th>
        <th>Product quantity</th>

    </tr>

<c:forEach var="product" items="${products}">

        <tr>
                <td>${product.productName}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>${product.amount}</td>
            <td> <li class="w3-blue" style="text-align:center; width:150px"><a href="/user/{user.username}/product/{product.id}">Add to cart</a></li></td>
            </form>
        </tr>

</c:forEach>
        </ul>
</table>
<br>
<a href="/">Go back to category list</a>
</div>
</body>
</html>