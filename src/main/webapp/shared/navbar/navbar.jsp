
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/shared/navbar/navbar.css">
    <%-- Font --%>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@400;500;600;700&display=swap" rel="stylesheet">
    <%-- Font Awesome   --%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
    <div class="nav-container">
        <a class="nav-item" href="${pageContext.request.contextPath}">Home</a>
        <div class="nav">
            <a class="nav-item" href="${pageContext.request.contextPath}/client/list">Clients</a>
            <a class="nav-item" href="${pageContext.request.contextPath}/command/list">Commands</a>
            <a class="nav-item" href="${pageContext.request.contextPath}/order-line/list">Order Lines</a>
            <a class="nav-item" href="${pageContext.request.contextPath}/product/list">Products</a>
        </div>
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/shared/navbar/navbar.js"></script>
</body>
</html>