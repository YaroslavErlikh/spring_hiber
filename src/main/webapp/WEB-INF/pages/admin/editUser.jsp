<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<h3>Edit user ${userEditing.username}</h3>

<form action="/admin/editUser" method="post">
    <input type="hidden" name="id" value="${userEditing.id}"/>
    <input type="text" name="username" value="${userEditing.username}"/>
    <input type="text" name="password" value="${userEditing.password}"/>
    <input type="text" name="email" value="${userEditing.email}"/>
    <input type="submit" value="Изменить"/>
</form>
</body>
</html>
