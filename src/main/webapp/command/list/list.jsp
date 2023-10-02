<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Client List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/client/list/list.css">
    <style>

    </style>
</head>
<body>
    <%@include file="../../shared/navbar/navbar.jsp"%>
    <div class="list-container">

        <a class="btn-add-client" href="${pageContext.request.contextPath}/client/add_form">Add Command</a>

        <table>
            <thead>
                <th>Id</th>
                <th>Label</th>
                <th>Date</th>
                <th>Status</th>
                <th>Delivery Address</th>
                <th>Actions</th>
            </thead>
            <tbody>
            <c:forEach var="command" items="${requestScope.commands}">
            <tr>
                <td><c:out value="${command.id}"/></td>
                <td><c:out value="${command.label}"/></td>
                <td><c:out value="${command.date}"/></td>
                <td><c:out value="${command.status}"/></td>
                <td><c:out value="${command.deliveryAddr}"/></td>
                <td>
                    <a class="actions" href="${pageContext.request.contextPath}/client/update_form?id=${command.id}">
                        <i class="fa fa-pen edit"></i>

                    </a>
                    <a class="actions" href="${pageContext.request.contextPath}/command/delete?id=${command.id}">
                            <i class="fa fa-trash delete"></i>
                    </a>
                    <a class="actions" href="${pageContext.request.contextPath}/command/list?id=${command.id}">
                        <i class="fa fa-eye view"></i>
                    </a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>

