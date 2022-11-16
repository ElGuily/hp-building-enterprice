<%-- 
    Document   : preCompra
    Created on : 15 nov 2022, 10:47:44
    Author     : facun
--%>

<%@page import="model.Cliente"%>
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
             <form action="compraFinal" method="POST" class="form_signup">
                <label for="nombre_cliente">Nombre: </label>
                <input type="text" name="nombre_cliente">
                <label for="email_cliente">Email: </label>
                <input type="email" name="email_cliente">
                <label for="DNI_cliente">DNI: </label>
                <input type="text" name="DNI_cliente">
                <label for="localidad_cliente">Localidad: </label>
                <input type="text" name="localidad_cliente">
                <label for="calle_cliente">Calle: </label>
                <input type="text" name="calle_cliente">
                <label for="altura_cliente">Altura: </label>
                <input type="text" name="altura_cliente">
                <button value="${total}" name="botonComprar">
                    Comprar
                </button>
            </form>
        </main>
       
    </body>
</html>
