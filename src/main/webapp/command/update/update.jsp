<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Client</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/shared/styles/styles.css">
</head>
<body>
    <%@include file="../../shared/navbar/navbar.jsp"%>
    <form class="form" method="post" action="${pageContext.request.contextPath}/command/update">
        <label for="label">
            Label
            <input id="label" type="text" name="label" value="${requestScope.command.label}" required>
        </label>
        <label for="date">
            Date
            <input id="date" type="date" name="date" value="${requestScope.command.date}" required>
        </label>
        <span class="status-label">Status</span>
        <label>
            <c:choose>
                <c:when test="${requestScope.command.status == 'Pending'}">
                    <input type="radio" name="status" checked value="${requestScope.command.status}">
                    <span class="status pending">Pending</span>
                </c:when>
                <c:otherwise>
                    <input type="radio" name="status" value="Pending">
                    <span class="status pending">Pending</span>
                </c:otherwise>
            </c:choose>

        </label>
        <label>
            <c:choose>
                <c:when test="${requestScope.command.status == 'Delivered'}">
                    <input type="radio" name="status" checked value="${requestScope.command.status}">
                    <span class="status delivered">Delivered</span>

                </c:when>
                <c:otherwise>
                    <input type="radio" name="status" value="Delivered">
                    <span class="status delivered">Delivered</span>
                </c:otherwise>
            </c:choose>
        </label>
        <label for="deliveryAddr">
            Delivery Address
            <input id="deliveryAddr" type="text" name="deliveryAddr" value="${requestScope.command.deliveryAddr}" required>
        </label>

        <input type="hidden" name="commandId" value="${requestScope.command.id}">

        <input type="submit" value="Update">

    </form>
</body>
</html>
