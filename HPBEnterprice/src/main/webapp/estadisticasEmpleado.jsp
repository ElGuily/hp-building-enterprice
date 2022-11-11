<%-- 
    Document   : estadisticasEmpleado
    Created on : 10 nov 2022, 20:39:41
    Author     : facun
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
            <div>
                
                <p>${empleadoDatos.nombre}</p>
                <p>${empleadoDatos.DNI}</p>
                <p>${empleadoDatos.email}</p>
                <p>${empleadoDatos.facturado}</p>
            </div>
            
        </main>
    </body>
</html>
