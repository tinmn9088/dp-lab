<%@tag pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% 
    by.vsu.models.User user = (by.vsu.models.User) request.getSession().getAttribute("user");
%>

<div>
    <a href="teachers">Преподаватели</a>
    <a href="courses">Курсы</a>
    
    <a href="users">Пользователи</a>

    <span>|</span>
    <span><%= (user != null) ? String.format("%s %s", user.getLogin(), user.getRoles()) : "" %></span>
    <a href='<%= (user != null) ? "logout" : "login" %>'><button><%= (user != null) ? "Выйти" : "Войти" %></button></a>
</div>