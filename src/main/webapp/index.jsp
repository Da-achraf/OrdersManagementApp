<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <%-- Fonts --%>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <%--  Fonts  --%>
    <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@400;500;600;700&display=swap" rel="stylesheet">
    <%-- Font Awesome   --%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        body {
            font-family: 'Rubik', sans-serif;
        }

        .welcome {
            text-align: center;
                margin:5rem auto 2rem auto;
            color: darkslategrey;
        }

        .bg {
            display: block;
            margin: 0 auto;
        }

    </style>
</head>
<body>
    <%@include file="shared/navbar/navbar.jsp"%>
    <h3 class="welcome">Welcome to the Management Console</h3>
    <img class="bg" src="shared/bg.jpg" alt="background">
</body>
</html>