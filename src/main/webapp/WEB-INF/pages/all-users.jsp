<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1> All users </h1>

<br>

<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>
        <th>Operations</th>
    </tr>

    <br>

    <c:forEach var="user" items="${allUsers}">

        <c:url var="updateButton" value="/updateInfo">
            <c:param name="userId" value="${user.id}" />
        </c:url>

        <c:url var="deleteButton" value="/deleteInfo">
            <c:param name="userId" value="${user.id}" />
        </c:url>

        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>

            <td>
                <input type="button" value="Update"
                onclick="window.location.href = '${updateButton}'">

                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'">
            </td>

        </tr>
    </c:forEach>
</table>
<br>
<input type="button" value="Add"
       onclick="window.location.href = 'addMewUser'" />
</body>
</html>
