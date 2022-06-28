<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="by.vsu.models.User" %>
<!DOCTYPE html>
<html>
  <meta charset="utf-8">
  <head>
    <title>Список пользователей</title>
  </head>
  <body>
    <h1>Список пользователей</h1>

    <ul>
      <% List<User> users = (List<User>) request.getAttribute("users"); %>
      <% for (User u : users) { %>
        <a href="users/edit?id=<%= u.getId() %>">
          <li><%= String.format("%d %s", u.getId(), u.getLogin()) %></li>
        </a>
      <% } %>
    </ul>

  </body>
</html>