<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="by.vsu.models.Teacher" %>

<%
    Teacher teacher = (Teacher) request.getAttribute("teacher");
%>

<!DOCTYPE html>
<html>
  <meta charset="utf-8">
  <head>
    <title><%= teacher != null ? "Изменение преподавателя " + teacher.getId() : "Добавление преподавателя" %></title>
  </head>
  <body>
    <h1><%= teacher != null ? "Изменение преподавателя " + teacher.getId() : "Добавление преподавателя" %></h1>

    <form method="post">
      <label>Имя
        <input type="text" name="fname" value="<%= (teacher != null && teacher.getFname() != null) ? teacher.getFname() : new String() %>">
      </label>
      <br>
      <br>

      <label>Фамилия
        <input type="text" name="lname" value="<%= (teacher != null && teacher.getLname() != null) ? teacher.getLname() : new String() %>">
      </label>
      <br>
      <br>

      <label>Отчество
        <input type="text" name="patronymic" value="<%= (teacher != null && teacher.getPatronymic() != null) ? teacher.getPatronymic() : new String() %>">
      </label>
      <br>
      <br>

      <label>Степень
        <select name="degree">
          <option <%= (teacher != null && teacher.getDegree() != null && teacher.getDegree().equals("бакалавр")) ? "selected" : "" %>>бакалавр</option>
          <option <%= (teacher != null && teacher.getDegree() != null && teacher.getDegree().equals("магистр")) ? "selected" : "" %>>магистр</option>
          <option <%= (teacher != null && teacher.getDegree() != null && teacher.getDegree().equals("кандидат наук")) ? "selected" : "" %>>кандидат наук</option>
          <option <%= (teacher != null && teacher.getDegree() != null && teacher.getDegree().equals("доктор наук")) ? "selected" : "" %>>доктор наук</option>
        </select>
      </label>
      <br>
      <br>

      <label>Должность
        <input type="text" name="place" value="<%= (teacher != null && teacher.getPlace() != null) ? teacher.getPlace() : new String() %>">
      </label>
      <br>
      <br>

      <label>Пол
        <select name="gender">
          <option <%= (teacher != null && teacher.getGender() != null && teacher.getGender().equals("м")) ? "selected" : "" %>>м</option>
          <option <%= (teacher != null && teacher.getGender() != null && teacher.getGender().equals("ж")) ? "selected" : "" %>>ж</option>
        </select>
      </label>
      <br>
      <br>

      <label>Дата рождения
        <input type="date" name="birthdate" value="<%= (teacher != null && teacher.getBirthdate() != null) ? teacher.getBirthdate() : new String() %>">
      </label>
      <br>
      <br>

      <button type="submit"><%= teacher!= null ? "Сохранить" : "Создать" %></button>
      <%= teacher != null ? "<a href='../teachers/delete?id=" + teacher.getId() + "'><button type='button'>Удалить</button></a>" : "" %>
      <br>
      <br>
    </form>

    <a href="../teachers"><button>Все преподаватели</button></a>

  </body>
</html>