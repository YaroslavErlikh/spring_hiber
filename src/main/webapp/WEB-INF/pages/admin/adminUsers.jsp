<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h4>Users</h4>

<table border="2">

    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Пароль</th>
        <th>E-Mail</th>
        <th>Действия</th>
    </tr>

    <c:forEach items="${usersList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>

            <td>
                <form action="admin/editUser/${user.id}" method="get">
                    <input type="hidden" name="id" value="${user.id}"/>
                    <input type="submit" value="Редактировать" style="float: left"/>
                </form>
                <form action="admin/delete/${user.id}" method="get">
                    <input type="hidden" name="id" value="${user.id}"/>
                    <input type="submit" value="Удалить"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<form action="admin/add" method="get">
    <input type="submit" value="Добавить пользователя"/>
</form>


</body>
</html>
