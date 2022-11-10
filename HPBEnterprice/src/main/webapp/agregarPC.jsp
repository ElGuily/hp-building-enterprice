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
        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="components/nav-bar.jsp" %>
        <main class="main_signup">

            <form action="agregarPC" method="POST" class="form_signup">

                <label for="nombre-pc">Nombre PC: </label>
                <input type="text" name="nombre-pc">
                <label for="modelo-pc">Modelo PC: </label>
                <input type="text" name="modelo-pc">

                <label for="precio-pc">Precio: </label>
                <input type="number" name="precio-pc">

                <select id="categoria-select" name="categoria-pc">
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

                <label for="importados">Comp. Importados: </label>
                <input type="number" name="importados">
                <input type="submit" value="Next">

            </form>          
        </main>
    </body>
    
    <script>
        $('#categoria-select').on("change", () => {
            if ($("#categoria-select").val() == "2") {
                $(".option-oficina").removeClass("hidden")
                $(".option-gamer").addClass("hidden")
            }
            if ($("#categoria-select").val() == "1") {
                $(".option-gamer").removeClass("hidden")
                $(".option-oficina").addClass("hidden")
            }
            if ($("#categoria-select").val() == "3") {
                $(".option-gamer").addClass("hidden")
                $(".option-oficina").addClass("hidden")
            }
        })
    </script>
     
</html>
