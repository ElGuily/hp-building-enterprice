<%-- 
    Document   : agregarPC
    Created on : 7 nov 2022, 19:06:39
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
            
            <form action="agregarPC" method="POST" class="form_signup" enctype="multipart/form-data">
                <p>${error}</p>
                <label for="imagen-pc">Imagen: </label>
                <input type="file" name="imagen-pc">
                <label for="nombre-pc">Nombre PC: </label>
                <input type="text" name="nombre-pc">
                <label for="modelo-pc">Modelo PC: </label>
                <input type="text" name="modelo-pc">
                <label for="precio-pc">Precio: </label>
                <input type="number" name="precio-pc">
                <select id="categoria-select" name="categoria-pc">
                    <option value="Gamer">Gamer</option>
                    <option value="Diseño">Diseño</option>
                    <option value="Oficina">Oficina</option>
                </select>
                
                <label for="importados">Comp. Importados: </label>
                <input type="number" name="importados">
                <input type="submit" value="Next">
                      
            </form>           
        </main>
    </body>
</html>
