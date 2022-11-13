<%-- 
    Document   : formCompra
    Created on : 12 nov 2022, 13:04:33
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
           <h1>Ha finalizado la compra!!</h1>
           <h2>Ticket: </h2>
           <p>${factura}</p>
       </main>
    </body>
</html>
