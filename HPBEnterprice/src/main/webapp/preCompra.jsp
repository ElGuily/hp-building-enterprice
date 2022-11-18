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
        <title>Formulario preCompra - HPBE</title>
        <link rel="stylesheet" href="styles/preCompra.css"/>
        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
    </head>
    <body>
        <%@include file="components/nav-bar.jsp" %>
        
        <main class="main_preCompra">
             <form action="compraFinal" method="POST" class="form_preCompra">
                <h1>Datos de cliente</h1>
                <div class="inputdiv">                  
                    <input type="text" name="nombre_cliente">
                    <label for="nombre_cliente" required>Nombre</label>
                </div>
                <div class="inputdiv">
                    <input type="email" name="email_cliente">
                    <label for="email_cliente" required>Email: </label>
                </div>
                <div class="inputdiv">
                    <input type="text" name="DNI_cliente">
                    <label for="DNI_cliente" required>DNI: </label>
                </div>
                <div class="inputdiv">
                    <input type="text" name="localidad_cliente">
                    <label for="localidad_cliente" required>Localidad: </label>                   
                </div>
                <div class="inputdiv">
                    <input type="text" name="calle_cliente">
                    <label for="calle_cliente" required>Calle: </label>                    
                </div>
                <div class="inputdiv">
                    <input type="text" name="altura_cliente">
                    <label for="altura_cliente" required>Altura: </label>
                    
                </div>
                
                <button value="${total}" name="botonComprar" class="comprarButton">
                    Comprar
                </button>
            </form>
        </main>
       
    </body>
    <script>
    $(".inputdiv").map((e) => {
      let input = $(".inputdiv")[e].children[0];
      let label = $(".inputdiv")[e].children[1];
      $(input).on("focus", () => {
        label.classList.add("onText");
      });
      $(input).on("blur", () => {
        if ($(input).val() == "") {
          label.classList.remove("onText");
        }
      });
    });
    
    
    
    </script>
    <style>
    </style>
</html>
