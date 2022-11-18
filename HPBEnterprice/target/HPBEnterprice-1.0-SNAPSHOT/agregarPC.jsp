<%--
    Document   : agregarPC
    Created on : 7 nov 2022, 19:06:39
    Author     : facun
--%>

<%@page import="model.Empleado"%>
<%@page import="model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css">
        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
        <title>agregarPC - HPBE</title>
        <link rel="stylesheet" href="styles/agregarPC.css"/>
    </head>
    <body>
        <%@include file="components/nav-bar.jsp" %>
        
        <main class="main_agregarPC">
            
            <form action="agregarPC" method="POST" class="form_agregarPC">
                <h1>Agregar Pc</h1>
                <div class="inputdiv">
                    
                    <input type="text" name="nombre-pc" id="nombre-pc">
                    <label for="nombre-pc">Nombre</label>
                </div>             
                
                <div class="inputdiv">
                    <input type="number" name="precio-pc" id="precio-pc">
                    <label for="precio-pc">Precio</label>
                    
                </div>
                
                
                <div class="inputdiv">
                    
                    <input type="number" name="importados" id="importados">
                    <label for="importados">Cant. Comp. Importados</label>
                </div>
                
                <label for="modelo-pc">Modelo</label>               
                <select id="modelo_pc" name="modelo-pc" class="select-model">                 
                    <option value="Elite600">Elite600</option>
                    <option value="ProOne">ProOne</option>
                    <option value="Elite800">Elite800</option>
                    <option value="ProDesk400">ProDesk400</option>
                    <option value="miniHPpro400">miniHPpro400</option>
                    <option value="HP2004">HP2004</option>
                </select>
                <label for="categoria-select">Categoria</label>
                <select id="categoria-select" name="categoria-pc" class="categoria-pc">
                    <option value="1">Gamer</option>
                    <option value="2">Diseño</option>
                    <option value="3">Oficina</option>
                </select>
                <div class="option-oficina hidden">
                    <input type="checkbox" name="all_in_one_opt" id="allinone">
                    <label for="allinone">All-in-one</label>
                </div>
                <div class="option-gamer">
                    <input type="checkbox" name="rgb_opt" id="rgb">
                    <label for="rgb">Rgb</label>
                    <input type="checkbox" name="refri_opt" id="refrigeracionliquida">
                    <label for="refrigeracionliquida">Refrigeracion Liquida</label>
                    
                </div>
                
                <input type="submit" value="Siguiente" class="nextbutton">

            </form>          
        </main>
    </body>
    
    <script>
        $('#categoria-select').on("change", () => {
            if ($("#categoria-select").val() == "1") {
                $(".option-oficina").addClass("hidden")
                $(".option-gamer").removeClass("hidden")
            }
            if ($("#categoria-select").val() == "2") {
                $(".option-gamer").addClass("hidden")
                $(".option-oficina").addClass("hidden")
            }
            if ($("#categoria-select").val() == "3") {
                $(".option-gamer").addClass("hidden")
                $(".option-oficina").removeClass("hidden")
            }
        })

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
     
</html>