<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="by.vsu.models.Course" %>
<%@ page import="by.vsu.models.Teacher" %>

<%
    Course course = (Course) request.getAttribute("course");
    List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
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
      <p>Учитель:</p>
      <select name="teacher">
        <% if (course != null && course.getTeacher() != null) { %>
          <option selected><%= String.format("%d. %s %s %s", course.getTeacher().getId(), course.getTeacher().getLname(), course.getTeacher().getFname(), course.getTeacher().getPatronymic()) %></option>
          <% teachers.remove(course.getTeacher()); %>
        <% } else { %>
          <option disabled selected value></option>
        <% } %>
        <% for (Teacher t : teachers) { %>
          <option><%= String.format("%d. %s %s %s", t.getId(), t.getLname(), t.getFname(), t.getPatronymic()) %></option>
        <% } %>
      </select>

      <p>Название:</p>
      <input type="text" name="title" value="<%= course != null ? course.getTitle() : new String() %>">
    </form>

  </body>
</html>