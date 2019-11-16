<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>devSHOP category list</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style type="text/css">
        .fieldset-auto-width {
            display: inline-block;
        }
    </style>
</head>
<body bgcolor="#e9ebee">
<div class="w3-container" style="width:250px">
    <br>
    <a href="/"><img src="img/devshop_logo.png" alt="devSHOP_logo" width="200" /></a><br><br>
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
<br>
<fieldset class="fieldset-auto-width">
    <legend>About</legend>
    <p>This project was written in collaboration by three programmers:</p>
    Stanislaw Glegola <a href="https://www.linkedin.com/in/stanislawglegola/">Linkedin</a> <a href="https://github.com/StanislawGlegola">GitHub</a><br>
    Szymon Mantey <a href="https://www.linkedin.com/in/szymon-mantey-933974105/">Linkedin</a> <a href="https://github.com/vanndhall">GitHub</a><br>
    Michal Mataczynski <a href="https://www.linkedin.com/in/michalmataczynski/">Linkedin</a> <a href="https://github.com/matacz83">GitHub</a>
</fieldset>
</body>
</html>
