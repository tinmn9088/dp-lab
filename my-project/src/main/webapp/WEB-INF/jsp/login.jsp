<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
    String message = (String) request.getParameter("message");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Войти</title>
    </head>
    <body>
        <H1>Войти</H1>
        <%= (message != null) ? "<p style='color: red;''>" + message + "</p>" : "" %>
        <form method="post">
            <label>Логин
                <input type="text" name="login">
            </label>
            <br>
            <br>

            <label>Пароль
                <input type="password" name="password">
            </label>
            <br>
            <br>

            <button type="submit">Войти</button>
        </form>
    </body>
</html>