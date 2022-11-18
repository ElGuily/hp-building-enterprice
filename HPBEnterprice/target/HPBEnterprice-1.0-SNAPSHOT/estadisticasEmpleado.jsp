<%-- 
    Document   : estadisticasEmpleado
    Created on : 10 nov 2022, 20:39:41
    Author     : facun
--%>

<%@page import="model.Cliente"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="controller.compraFinal"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="model.GestorBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles/estadisticas.css"/>
    </head>
    <body>
        <%@include file="components/nav-bar.jsp" %>
        
        <main class="main_signup">
            <div class="employee-stats">
              <img src="images/profile.svg" alt="" class="img-profile" />
              <div class="stats">
                <p class="name-profile">Nombre:${empleadoDatos.nombre}</p>
                <p class="dni-profile">DNI:${empleadoDatos.DNI}</p>
                <p class="email-profile">Email:${empleadoDatos.email}</p>
                <p class="facturado-profile">Facturado:${empleadoDatos.facturado}</p>
              </div>
            </div>
      
          <c:choose>
            <c:when test="${admin}">
                <%

                    GestorBD gbd = new GestorBD();

                    int cant = 0;
                    String nom = "";
                    ResultSet masVendida = gbd.PCmasVendida();
                    try {
                        while(masVendida.next()){
                            cant = masVendida.getInt("cantidad");
                            nom = masVendida.getString("nombre");
                        
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(compraFinal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    out.print("<div class='admin-view'>");
                    out.print("<h1 class='masVendido'> Producto mas vendido: " + nom + "</h1>");
                    out.print("<h2 class='cantidadTotal'> Cantidad:" + cant + "</h2>");

                    double comisiones = gbd.obtenerTotalComisionEnVenta();

                    out.print("<h1 class='totalComisiones'> Total de comisiones: "+ comisiones + "</h1>");

                    double totalCiber = gbd.calcularCiberMonday();

                    out.print("<h1 class='totalCiber'> Recaudado en el ciberMonday: "+ totalCiber + "</h1>");
                    out.print("</div>");
                %>
                
            </c:when>
        </c:choose>
          </main>
    </body>
</html>