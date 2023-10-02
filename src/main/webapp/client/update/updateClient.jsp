
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Client</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/shared/styles/form.css">
</head>
<body>
    <%@include file="../../shared/navbar/navbar.jsp"%>
    <form class="add-client-form" method="post" action="${pageContext.request.contextPath}/client/update">
        <label for="name">
            Name
            <input id="name" type="text" name="name" value="${requestScope.client.name}" required>
        </label>
        <label for="address">
            Address
            <input id="address" type="text" name="address" value="${requestScope.client.address}" required>
        </label>
        <label for="phone">
            Phone
            <input id="phone" type="text" name="phone" value="${requestScope.client.phone}">
        </label>

        <input type="hidden" name="id" value="${requestScope.client.id}">

        <input type="submit" value="Update">

    </form>
</body>
</html>
