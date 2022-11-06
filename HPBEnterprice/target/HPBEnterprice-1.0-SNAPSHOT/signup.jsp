<%-- 
    Document   : login.jsp
    Created on : 2 nov. 2022, 08:42:31
    Author     : ET36
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
        <main class="main_signup">
            
            <form action="signup" method="POST" class="form_signup">
                <p>${error}</p>
                <label for="username">Username: </label>
                <input type="text" name="username">
                <label for="password">Password: </label>
                <input type="password" name="password">
                <label for="password2">Password: </label>
                <input type="password" name="password2">
                <input type="submit" name="Login">
            </form>
        </main>
        
    </body>
</html>
