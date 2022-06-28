<%@tag pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% 
    by.vsu.models.User user = (by.vsu.models.User) request.getSession().getAttribute("user");
    String url = request.getContextPath();
%>

<div>
    <a href="<%= url %>/teachers">Преподаватели</a>
    <a href="<%= url %>/courses">Курсы</a>
    <a href="<%= url %>/users">Пользователи</a>

    <span>|</span>
    <span><%= (user != null) ? String.format("%s %s", user.getLogin(), user.getRoles()) : "" %></span>
    <a href='<%= url %>/<%= (user != null) ? "logout" : "login" %>'><button><%= (user != null) ? "Выйти" : "Войти" %></button></a>
</div>