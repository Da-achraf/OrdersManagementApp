<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Client</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/command/add/add.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/shared/styles/styles.css">
</head>
<body>
    <%@include file="../../shared/navbar/navbar.jsp"%>
    <form class="form" method="post" action="${pageContext.request.contextPath}/command/add">
        <label for="label">
            Label
            <input id="label" type="text" name="label" required>
        </label>
        <label for="date">
            Date
            <input id="date" type="date" name="date" required>
        </label>
        <span class="status-label">Status</span>
        <label>
            <input type="radio" name="status" checked value="Pending">
            <span class="status pending">Pending</span>
        </label>
        <label>
            <input type="radio" name="status" value="Delivered">
            <span class="status delivered">Delivered</span>
        </label>

        <label for="deliveryAddr">
            Delivery Address
            <input id="deliveryAddr" type="text" name="deliveryAddr" required>
        </label>

        <input type="hidden" name="clientId" value="${requestScope.clientId}">

        <input type="submit" value="Save">

    </form>
</body>
</html>
