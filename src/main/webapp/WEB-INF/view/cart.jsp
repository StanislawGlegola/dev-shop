<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>devSHOP your cart</title>
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
<div class="w3-container">
    <br>
    <a href="/"><img src="/img/devshop_logo.png" width="200"/></a><br><br>
    <a href="/logout">Logout</a>
    <h2>Your Cart</h2>
    <br>

    <ul class="w3-ul">

        <table>
            <tr>
                <th>Product name</th>
                <th>Product description</th>
                <th>Product price</th>
                <th>Product quantity</th>
            </tr>

            <c:forEach var="orderedItem" items="${orderItems}">
            <tr>
                <td>${orderedItem.product.productName}</td>
                <td>${orderedItem.product.description}</td>
                <td>${orderedItem.product.price}</td>
                <td>${orderedItem.amount}</td>
                <td><li class="w3-blue" style="text-align:center; width:150px"><a href="/removeFromCart/${product.id}">Remove</a>
                </li></td>

            </tr>
            </c:forEach>
    </ul>
    </table>
    <br>
    <a href="/">Continue shopping</a> or Checkout
</div>
</body>
</html>