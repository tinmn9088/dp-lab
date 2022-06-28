<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u" %>
<%@ page import="java.util.List" %>
<%@ page import="by.vsu.models.Course" %>
<!DOCTYPE html>
<html>
  <meta charset="utf-8">
  <head>
    <title>Список курсов</title>
    <link href="css/sort-table.css" rel="stylesheet">
  </head>
  <body>
    <u:header></u:header>

    <h1>Список курсов</h1>

    <a href="courses/edit"><button>Создать курс</button></a>

    <% List<Course> courses = (List<Course>) request.getAttribute("courses"); %>
    <table class="table_sort">
      <thead>
        <tr>
          <th>Название</th>
          <th>ФИО преп.</th>
          <th>Курс</th>
          <th>Семестр</th>
          <th>Часов</th>
        </tr>
      </thead>
      <tbody>
        <% for (Course c : courses) { %>
          <tr>
            <td><a href="courses/edit?id=<%= c.getId() %>"><%= c.getTitle() %></a></td>
            <td><%= (c.getTeacher() != null) ? String.format("%s %s %s", c.getTeacher().getLname(), c.getTeacher().getFname(), c.getTeacher().getPatronymic()) : "-" %></td>
            <td><%= c.getCourse() %></td>
            <td><%= c.getSemester() %></td>
            <td><%= c.getHours() %></td>
          </tr>
        <% } %>
      </tbody>
    </table>

    <script src="js/sort-table.js"></script>
  </body>
</html>