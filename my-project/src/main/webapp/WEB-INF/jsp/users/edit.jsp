<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="by.vsu.models.User" %>

<%
    User user = (User) request.getAttribute("user");
%>

<!DOCTYPE html>
<html>
  <meta charset="utf-8">
  <head>
    <title><%= user != null ? "Изменение пользователя " + user.getId() : "Добавление пользователя" %></title>
  </head>
  <body>
    <h1><%= user != null ? "Изменение пользователя " + user.getId() : "Добавление пользователя" %></h1>

    <form method="post">
      <label>Логин
        <input type="text" name="login" value="<%= (user != null && user.getLogin() != null) ? user.getLogin() : new String() %>">
      </label>
      <br>
      <br>

      <label>Пароль
        <input type="password" name="password">
      </label>
      <br>
      <br>

      <label>Роли
        <input type="text" name="roles" value='<%= (user != null && user.getRoles() != null) ? String.join(",", user.getRoles()) : new String() %>'>
      </label>
      <br>
      <br>

      <button type="submit"><%= user!= null ? "Сохранить" : "Создать" %></button>
      <%= user != null ? "<a href='../users/delete?id=" + user.getId() + "'><button type='button'>Удалить</button></a>" : "" %>
      <br>
      <br>
    </form>

    <a href="../users"><button>Все пользователи</button></a>

  </body>
</html>