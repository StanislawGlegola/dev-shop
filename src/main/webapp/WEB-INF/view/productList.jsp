<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
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
>
View products by categories
<br>
<br>
<br>

<table>
    <tr>
        <th>Product name</th>
        <th>Product description</th>
        <th>Product price</th>
        <th>Product quantity</th>

    </tr>
</table>
<c:forEach var="product" items="${products}">
    <table>
        <tr>
                <td>${product.productName}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>${product.amount}</td>
            <td><a href="/user/{user.username}/product/{product.id}"><button>Add to cart</button></a></td>
            </form>
        </tr>
    </table>
</c:forEach>

</body>
</html>