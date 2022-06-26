<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="by.vsu.models.Course" %>

<%
    Course course = (Course) request.getAttribute("course");
%>

<!DOCTYPE html>
<html>
  <meta charset="utf-8">
  <head>
    <title><%= course != null ? "Изменение курса " + course.getId() : "Создание курса" %></title>
  </head>
  <body>
    <h1><%= course != null ? "Изменение курса " + course.getId() : "Создание курса" %></h1>

    <form method="post">
      <p>Название:</p>
      <input type="text" name="title" value="<%= course != null ? course.getTitle() : new String() %>">

      
    </form>

  </body>
</html>