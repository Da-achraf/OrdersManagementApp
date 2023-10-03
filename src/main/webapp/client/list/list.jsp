<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Client List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/client/list/list.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/shared/styles/styles.css">
    <style>

    </style>
</head>
<body>
    <%@include file="../../shared/navbar/navbar.jsp"%>
    <div class="list-container">

        <a class="button" href="${pageContext.request.contextPath}/client/add_form">Add Client</a>

        <table>
            <thead>
                <th>Id</th>
                <th>Name</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Actions</th>
            </thead>
            <tbody>
            <c:forEach var="client" items="${requestScope.clients}">
            <tr>
                <td><c:out value="${client.id}"/></td>
                <td><a href="${pageContext.request.contextPath}/command/list?id=${client.id}"><span class="client-name"><c:out value="${client.name}"/></span></a><span class="command-count">${fn:length(client.commands)}</span></td>
                <td><c:out value="${client.address}"/></td>
                <td><c:out value="${client.phone}"/></td>
                            <td>
                                <a class="actions" href="${pageContext.request.contextPath}/client/update_form?id=${client.id}">
                                    <i class="fa fa-pen edit"></i>

                                </a>
                                <a class="actions" href="${pageContext.request.contextPath}/client/delete?id=${client.id}">
                                        <i class="fa fa-trash delete"></i>
                                </a>
                            </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/client/list/list.js"></script>

</body>
</html>

