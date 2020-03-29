<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
</head>
<body>
<h3>Delete User ${userDelete.username}</h3>

Удалить пользователя:
<br>
ID - ${userDelete.id}<br>
Username - ${userDelete.username}<br>
Password - ${userDelete.password}<br>
E-Mail - ${userDelete.email}<br>

<form action="/admin/deleteUser" method="post">
    <input type="hidden" name="id" value="${userDelete.id}"/>
    <input type="submit" value="Удалить"/>
</form>
</body>
</html>
