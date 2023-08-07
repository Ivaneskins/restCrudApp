<%--
  Created by IntelliJ IDEA.
  User: Ivaneskins
  Date: 07.08.2023
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1> All users </h1>

<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>

    </tr>
    <c:forEach var="ttt" items="${usersList}">
        <tr>
            <td>${ttt.id}</td>
            <td>${ttt.name}</td>
            <td>${ttt.email}</td>
<%--            <td>--%>
<%--                <a href="/edit/${film.id}">edit</a>--%>
<%--                <a href="/delete/${film.id}">delete</a>--%>
<%--            </td>--%>
        </tr>
    </c:forEach>

    <h3>${usersList}</h3>
    <h3>"${usersList}"</h3>
</table>



</body>
</html>
