<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u" %>
<%@ page import="java.util.List" %>
<%@ page import="by.vsu.models.User" %>
<!DOCTYPE html>
<html>
  <meta charset="utf-8">
  <head>
    <title>Список пользователей</title>
    <link href="css/sort-table.css" rel="stylesheet">
  </head>
  <body>
    <u:header></u:header>

    <h1>Список пользователей</h1>

    <a href="users/edit"><button>Добавить пользователя</button></a>
      
    <% List<User> users = (List<User>) request.getAttribute("users"); %>
    <table class="table_sort">
      <thead>
        <tr>
          <th>id</th>
          <th>Логин</th>
          <th>Роли</th>
        </tr>
      </thead>
      <tbody>
        <% for (User u : users) { %>
          <tr>
            <td><a href="users/edit?id=<%= u.getId() %>"><%= u.getId() %></a></td>
            <td><%= u.getLogin() %></td>
            <td><%= u.getRoles() %></td>
          </tr>
        <% } %>
      </tbody>
    </table>

    <script src="js/sort-table.js"></script>
  </body>
</html>