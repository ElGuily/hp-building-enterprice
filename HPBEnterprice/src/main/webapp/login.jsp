<%-- 
    Document   : login
    Created on : 4 nov 2022, 18:41:12
    Author     : facun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <p>${error}</p>
         <%@include file="components/nav-bar.jsp" %>
        <main class="main_login">
            <form action="login" method="POST" class="form_login">
                <label for="username-login">Username: </label>
                <input type="text" name="username-login">
                <label for="password-login">Password: </label>
                <input type="password" name="password-login">
                <input type="submit" name="Login">
                <p>${info}</p>
            </form>
        </main>
        
    </body>
</html>
