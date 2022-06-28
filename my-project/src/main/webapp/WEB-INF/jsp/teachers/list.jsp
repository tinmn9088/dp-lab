<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u" %>
<%@ page import="java.util.List" %>
<%@ page import="by.vsu.models.Teacher" %>

<%
  String url = request.getContextPath();
%>

<!DOCTYPE html>
<html>
  <meta charset="utf-8">
  <head>
    <title>Список преподавателей</title>
    <link href="css/sort-table.css" rel="stylesheet">
  </head>
  <body>
    <u:header></u:header>

    <h1>Список преподавателей</h1>

    <a href="<%= url %>/teachers/edit"><button>Добавить преподавателя</button></a>

    <% List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers"); %>
    <table class="table_sort">
      <thead>
        <tr>
          <th>ФИО</th>
          <th>Уч. степень</th>
          <th>Дата рождения</th>
        </tr>
      </thead>
      <tbody>
        <% for (Teacher t : teachers) { %>
            <tr>
              <td><a href="<%= url %>/teachers/edit?id=<%= t.getId() %>"><%= String.format("%s %s %s", t.getLname(), t.getFname(), t.getPatronymic()) %></a></td>
              <td><%= t.getDegree() %></td>
              <td><%= t.getBirthdate() %></td>
            </tr>
          </a>
        <% } %>
      </tbody>
    </table>

      <script src="js/sort-table.js"></script>
  </body>
</html>