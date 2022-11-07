<%-- 
    Document   : registrarEmpleado
    Created on : 7 nov. 2022, 13:39:31
    Author     : ET36
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="components/nav-bar.jsp" %>
        <main class="main_signup">
            
            <form action="registrarEmpleado" method="POST" class="form_signup">
                <p>${error}</p>
                <label for="nombre">Nombre: </label>
                <input type="text" name="nombre">
                <label for="email">Email: </label>
                <input type="email" name="email">
                <label for="DNI">DNI: </label>
                <input type="number" name="DNI">
                <label for="username-emp">Username: </label>
                <input type="text" name="username-emp">
                <label for="password-emp">Password: </label>
                <input type="password" name="password-emp">
                <label for="password2-emp">Password: </label>
                <input type="password" name="password2-emp">
                <input type="submit" name="Login">               
            </form>           
        </main>
    </body>
</html>
