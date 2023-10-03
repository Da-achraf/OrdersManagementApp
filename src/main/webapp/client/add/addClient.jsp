
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Client</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/client/add/addClient.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/shared/styles/styles.css">
</head>
<body>
    <%@include file="../../shared/navbar/navbar.jsp"%>
    <form class="form" method="post" action="${pageContext.request.contextPath}/client/add">
        <label for="name">
            Name
            <input id="name" type="text" name="name" required>
        </label>
        <label for="address">
            Address
            <input id="address" type="text" name="address" required>
        </label>
        <label for="phone">
            Phone
            <input id="phone" type="text" name="phone">
        </label>

        <input type="submit" value="Save">

    </form>
</body>
</html>
