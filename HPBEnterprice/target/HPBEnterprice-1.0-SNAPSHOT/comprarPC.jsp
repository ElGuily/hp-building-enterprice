<%-- Document : comprarPC Created on : 8 nov 2022, 18:07:11 Author : facun --%>
<%@page import="model.Cliente"%> <%@page contentType="text/html"
pageEncoding="UTF-8"%> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Comprar pc</title>
    <link rel="stylesheet" type="text/css" href="styles/comprarPC.css" />
  </head>
  
  <body>
    <%@include file="components/nav-bar.jsp" %>

    <main class="main_stock">
      <c:forEach items="${pc}" var="pc">
        <div class="pc_stock">
          <p class="nombre">Nombre: ${pc.nombre}</p>
          <p class="modelo">Modelo: ${pc.modelo}</p>
          <p class="precio">Precio: <span>${pc.valor_PC}</span></p>

          <div class="buttons">
            <form action="agregarAlCarrito" method="POST" name="addForm">
              <button value="${pc.nombre}" name="botonAgregar" style="--bg:rgb(0, 198, 46);">Agregar</button>
            </form>

            <c:choose>
              <c:when test="${empleado || admin}">
                <form
                  action="eliminarPC"
                  method="POST"
                  value="${pc.nombre}"
                  name="deleteForm"
                >
                  <button value="${pc.nombre}" name="botonEliminar" style="--bg:red;">
                    Borrar
                  </button>
                </form>
              </c:when>
            </c:choose>
          </div>
        </div>
      </c:forEach>
    </main>
  </body>
</html>
