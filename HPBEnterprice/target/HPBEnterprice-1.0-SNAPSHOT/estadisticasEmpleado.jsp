<%-- 
    Document   : estadisticasEmpleado
    Created on : 10 nov 2022, 20:39:41
    Author     : facun
--%>

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
    </head>
    <body>
        <%@include file="components/nav-bar.jsp" %>
        <main class="main_signup">
            <div>
                
                <p>${empleadoDatos.nombre}</p>
                <p>${empleadoDatos.DNI}</p>
                <p>${empleadoDatos.email}</p>
                <p>${empleadoDatos.facturado}</p>
            </div>
                <c:choose>
                    <c:when test="${admin}">
                        <%
                            
                            GestorBD gbd = new GestorBD();
                            
                            int cant = 0;
                            String nom = "";
                            ResultSet masVendida = gbd.PCmasVendida();
                            JOptionPane.showMessageDialog(null, masVendida);
                            try {
                                while(masVendida.next()){
                                    cant = masVendida.getInt("cantidad");
                                    nom = masVendida.getString("nombre");
                                    JOptionPane.showMessageDialog(null, cant + nom);
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(compraFinal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            out.print("<div");
                            out.print("<h1> Producto mas vendido: " + nom + "</h1>");
                            out.print("<h2> Cantidad:" + cant + "</h2>");
                            out.print("</div");
                            double comisiones = gbd.obtenerTotalComision();
                            out.print("<div>");
                            out.print("<h1> Total de comisiones: "+ comisiones + "</h1>");
                            out.print("</div>");
                        %>
                    </c:when>
                </c:choose>
            
        </main>
    </body>
</html>
