<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<h3>Edit user ${userEditing.username}</h3>

<font color="red" size="14"><bold>${message}</bold></font>

<form action="/admin/editUser" method="post">
    <input type="hidden" name="id" value="${userEditing.id}"/>
    <input type="text" name="username" value="${userEditing.username}"/>
    <input type="password" name="password" value="${userEditing.password}"/>
    <input type="email" name="email" value="${userEditing.email}"/>
    <input type="submit" value="Изменить"/>
</form>
</body>
</html>
