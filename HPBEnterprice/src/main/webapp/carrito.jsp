<!-- <%-- 
    Document   : carrito
    Created on : 11 nov 2022, 22:46:23
    Author     : facun
--%>

<%@page import="java.util.List"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="model.PCs"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="styles/carrito.css">
    <title>Carrito - HPBE</title>
    
</head>

<body>
    <%@include file="components/nav-bar.jsp" %>

    <main class="main_carrito">

         <c:forEach items="${carrito}" var="carrito">

            <div class="pcbox_carrito">

                <p class="pcbox_name">Nombre: ${carrito.nombre}</p>
                <p class="pcbox_precio">Precio: <span>${carrito.valor_PC}</span></p>
                <form action="eliminarDelCarrito" method="POST">
                    <button value="${carrito.nombre}" name="deleteCartButton">
                        Eliminar
                    </button>
                </form>
            </div>
            


        </c:forEach>

        <div class="next-carrito">

            <h1>Total de la compra: ${total}</h1>
            <a href="preCompra.jsp">
                <button name="botonComprar">
                    Siguiente
                </button>

            </a>
        </div>



    </main>

</body>

</html>