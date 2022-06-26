<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="by.vsu.models.Teacher" %>
<!DOCTYPE html>
<html>
  <meta charset="utf-8">
  <head>
    <title>Список преподавателей</title>
  </head>
  <body>
    <h1>Список преподавателей</h1>

    <ul>
      <% List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers"); %>
      <% for (Teacher t : teachers) { %>
        <li><%= t %></li>
      <% } %>
    </ul>

  </body>
</html>