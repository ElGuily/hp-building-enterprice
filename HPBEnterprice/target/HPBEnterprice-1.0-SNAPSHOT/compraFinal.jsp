<%-- 
    Document   : formCompra
    Created on : 12 nov 2022, 13:04:33
    Author     : facun
--%>

<%@page import="model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>compra final - HPBE</title>
        <link rel="stylesheet" href="styles/factura.css"/>
    </head>
    <body>
       <%@include file="components/nav-bar.jsp" %>
       
       <main class="main_final">
           <h1>GRACIAS POR SU COMPRA</h1>
           <div class="factura">
               
                <div class="idventa">
                    <h3>ID de venta: ${factura.id_venta}</h3>
                    
                    <hr>
                </div>
                    <c:forEach items="${carrito}" var="cart">
                        <div class="producto">
                            <p>${cart.nombre} - ${cart.modelo} - $${cart.valor_PC}</p>
                        </div>
                    </c:forEach>
                <div class="precio">
                    <h3>Total de la compra </h3>
                     <p>$${total}</p>
                </div>
                <div class="dir">
                    <h3>Direccion: </h3>
                    <p>${direccion.localidad}, ${direccion.calle} ${direccion.numero}</p>
                </div>  
           </div>
                <a href="index.jsp" class="seguir">
                    Seguir comprando
                </a>
          
       </main>
    </body>
  
</html>
