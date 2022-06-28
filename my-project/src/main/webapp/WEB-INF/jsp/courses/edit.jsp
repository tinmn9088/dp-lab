<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="by.vsu.models.Course" %>
<%@ page import="by.vsu.models.Teacher" %>

<%
    Course course = (Course) request.getAttribute("course");
    List<Teacher> teachers = (List<Teacher>) request.getAttribute("teachers");
    String url = request.getContextPath();
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
      <label>Название
        <input type="text" name="title" value="<%= (course != null && course.getTitle() != null) ? course.getTitle() : new String() %>" required>
      </label>
      <br>
      <br>

      <label>Учитель
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
      </label>
      <br>
      <br>

      <label>Специальность
        <input type="text" name="speciality" value="<%= (course != null && course.getSpeciality() != null) ? course.getSpeciality() : new String() %>">
      </label>
      <br>
      <br>

      <label>Семестр
        <input type="number" name="semester" min="1" value="<%= course != null ? course.getSemester() : 1 %>">
      </label>
      <br>
      <br>

      <label>Кол-во студентов
        <input type="number" name="numberOfStudents" min="0" value="<%= course != null ? course.getNumberOfStudents() : 0 %>">
      </label>
      <br>
      <br>

      <label>Лекц. часов
        <input type="number" name="hoursOfLectures" min="0" value="<%= course != null ? course.getHoursOfLectures() : 0 %>">
      </label>
      <br>
      <br>

      <label>Практ. часов
        <input type="number" name="hoursOfPractice" min="0" value="<%= course != null ? course.getHoursOfPractice() : 0 %>">
      </label>
      <br>
      <br>

      <label>Лаб. часов
        <input type="number" name="hoursOfLab" min="0" value="<%= course != null ? course.getHoursOfLaboratoryWork() : 0 %>">
      </label>
      <br>
      <br>

      <label>Экзамен
        <input type="checkbox" name="exam" <%= (course != null && course.isExam()) ? "checked" : "" %>>
      </label>
      <br>
      <br>

      <label>Контр. работ
        <input type="number" name="numberOfTests" min="0" value="<%= course != null ? course.getNumberOfTests() : 0 %>">
      </label>
      <br>
      <br>

      <button type="submit"><%= course != null ? "Сохранить" : "Создать" %></button>
      <%= course != null ? "<a href='" + url + "/courses/delete?id=" + course.getId() + "'><button type='button'>Удалить</button></a>" : "" %>
      <br>
      <br>
    </form>

    <a href="<%= url %>/courses"><button>Все курсы</button></a>

  </body>
</html>