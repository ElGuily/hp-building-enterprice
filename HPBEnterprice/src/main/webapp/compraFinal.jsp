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
        <title>JSP Page</title>
    </head>
    <body>
       <%@include file="components/nav-bar.jsp" %>
       
       <main class="main_final">
           <h1>GRACIAS POR SU COMPRA</h1>
           <div>
               <h3>ID de venta: </h3>
               <p>${factura.id_venta}</p>
              
           </div>
               <c:forEach items="${carrito}" var="cart">
                   <div>
                       <p>${cart.nombre} ${cart.modelo} ${cart.valor_PC}</p>
                   </div>
               </c:forEach>
           <div>
               <h3>Total de la compra </h3>
                <p>$${total}</p>
           </div>
           <div>
               <h3>Direccion: </h3>
               <p>${direccion.localidad} ${direccion.calle} ${direccion.numero}</p>
           </div>     
          
       </main>
    </body>
    <style>
        .main_final{
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
    </style>
</html>
