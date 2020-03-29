<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new User</title>
</head>
<body>
<h4>Добавить пользователя</h4>

<font color="red" size="14"><bold>${message}</bold></font>

<form action="/admin/addUser" method="post">
    <input type="text" name="username" placeholder="username" required/>
    <input type="password" name="password" placeholder="password" required/>
    <input type="email" name="email" placeholder="email" required/>
    <input type="submit" value="Добавить пользователя" />
</form>

</body>
</html>
