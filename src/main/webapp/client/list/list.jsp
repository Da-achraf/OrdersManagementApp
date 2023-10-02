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

        <a class="btn-add-client" href="${pageContext.request.contextPath}/client/add_form">Add Client</a>

        <table>
            <thead>
                <th>Id</th>
                <th>Name</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Action</th>
            </thead>
            <tbody>
            <c:forEach var="client" items="${requestScope.clients}">
            <tr>
                <td><c:out value="${client.id}"/></td>
                <td><c:out value="${client.name}"/></td>
                <td><c:out value="${client.address}"/></td>
                <td><c:out value="${client.phone}"/></td>
                            <td>
                                <a class="actions" href="${pageContext.request.contextPath}/client/update_form?id=${client.id}">
                                    <i class="fa fa-pen edit"></i>
<%--                                    <span class="edit">Edit</span>--%>

                                </a>
                                <a class="actions" href="${pageContext.request.contextPath}/client/delete?id=${client.id}">
<%--                                    <span class="delete">Delete</span>--%>
                                        <i class="fa fa-trash delete"></i>
                                </a>
                                <a class="actions" href="${pageContext.request.contextPath}/command/list?id=${client.id}">
                                    <i class="fa fa-eye view"></i>
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

