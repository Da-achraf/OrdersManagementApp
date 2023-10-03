<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Commands List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/shared/styles/styles.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/command/list/list.css">
    <style>

    </style>
</head>
<body>
    <%@include file="../../shared/navbar/navbar.jsp"%>
    <div class="list-container">
            <c:set var="client" value="${requestScope.client}"/>
            <c:if test="${requestScope.client != null}">
                <a class="button" href="${pageContext.request.contextPath}/command/add_form?id=${client.id}">Add Command</a>
               <p class="owner">Mr(s) <span><c:out value="${client.name}"/></span>'s Commands</p>
            </c:if>

        <c:if test="${requestScope.client == null}">
            <p class="owner"><span>All</span> Commands</p>
        </c:if>

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
                <c:if test="${command.status == 'Pending'}">
                   <td><span class="status pending"><c:out value="${command.status}"/></span></td>
                </c:if>
                <c:if test="${command.status == 'Delivered'}">
                    <td><span class="status delivered"><c:out value="${command.status}"/></span></td>
                </c:if>
                <td><c:out value="${command.deliveryAddr}"/></td>
                <td>
                    <a class="actions" href="${pageContext.request.contextPath}/command/update_form?id=${command.id}">
                        <i class="fa fa-pen edit"></i>

                    </a>
                    <a class="actions" href="${pageContext.request.contextPath}/command/delete?id=${command.id}">
                            <i class="fa fa-trash delete"></i>
                    </a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <script type="text/javascript" src="${pageContext.request.contextPath}/command/list/command.js">
    </script>
</body>
</html>

