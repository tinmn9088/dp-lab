<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="by.vsu.models.Course" %>
<!DOCTYPE html>
<html>
  <meta charset="utf-8">
  <head>
    <title>Список курсов</title>
  </head>
  <body>
    <h1>Список курсов</h1>

    <ul>
      <% List<Course> courses = (List<Course>) request.getAttribute("courses"); %>
      <% for (Course c : courses) { %>
        <a href="courses/edit?id=<%= c.getId() %>"><li><%= c.getTitle() + ", " + ((c.getTeacher() != null) ? String.format("%s %s %s, ", c.getTeacher().getLname(), c.getTeacher().getFname(), c.getTeacher().getPatronymic()) : ", ") + c.getSemester() + " семестр" %></li></a>
      <% } %>
    </ul>

  </body>
</html>