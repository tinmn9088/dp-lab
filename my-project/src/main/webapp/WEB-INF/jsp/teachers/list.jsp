<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u" %>
<%@ page import="java.util.List" %>
<%@ page import="by.vsu.models.Teacher" %>
<!DOCTYPE html>
<html>
  <meta charset="utf-8">
  <head>
    <title>Список преподавателей</title>
  </head>
  <body>
    <u:header></u:header>

    <h1>Список преподавателей</h1>

    <ul>
      <% List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers"); %>
      <% for (Teacher t : teachers) { %>
        <a href="teachers/edit?id=<%= t.getId() %>">
          <li><%= String.format("%s %s %s, %s", t.getLname(), t.getFname(), t.getPatronymic(), t.getDegree()) %></li>
        </a>
      <% } %>
    </ul>

  </body>
</html>