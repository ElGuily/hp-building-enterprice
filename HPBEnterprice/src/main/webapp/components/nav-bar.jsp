<%--
    Document   : nav-bar
    Created on : 5 nov 2022, 19:19:55
    Author     : facun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<link rel="stylesheet" href="style.css"/>
<nav class="navbar">
    <ul class="ul">
        <li class="li_icon">
            <a href="/HPBEnterprice">
                <img src="images/icon.png" alt="icon" class="icon" />

            </a>

        </li>
        <li class="li_admin">
            <c:choose>
                <c:when test="${admin}">
                    <form action="estadisticas" method="POST">

                        <button>
                            Ver Estadisticas
                        </button>
                    </form>  
                    <a class="li_a" href="registrarEmpleado.jsp">Registrar empleado</a>


                </c:when>
                <c:when test="${empleado}">
                    <form action="estadisticas" method="POST">

                        <button>
                            Ver Estadisticas
                        </button>
                    </form>

                    <a href="agregarPC.jsp" class="li_admin">Agregar PC</a>


                </c:when>
            </c:choose>
        </li>  

        <c:choose>
            <c:when test="${activo}">
                <li class="li_profile">
                    <form action="logout" method="POST">
                        <input type="submit" value="Logout" class="logout-button"/>


                    </form>          
                    <form action="agregarAlCarrito" method="POST">
                        <button class="carrito-button">
                            Ver carrito
                        </button>
                    </form>
                </li>
            </c:when>
            <c:otherwise>
                <li class="li_profile">
                    <a class="li_a" href="login.jsp" style="
                       background: rgb(0, 60, 255);">Log In</a>
                    <a class="li_a" href="signup.jsp" style="
                       background: rgb(255, 255, 255); color: black;">Sign Up</a>
                </li>    
            </c:otherwise>
        </c:choose>






    </ul>

</nav>
<style>
    
    .li_a{
        font-size: 20px;
        color: #fff;

        text-decoration: none;
        font-size: 20px;
        border-radius: 10px;
        padding: 10px;
        text-align: center;
        margin: 10px;
        transition: transform ease .3s;
        width: 50%;
    }


    .logout-button{
        font-size: 20px;
        color: #fff;

        text-decoration: none;
        font-size: 20px;
        border-radius: 10px;
        padding: 10px;
        text-align: center;
        margin: 5px;
        border: none;
        outline: none;
        background: #f00;
        width: 100px;
        transition: transform ease .3s;
    }

    .logout-button:hover, .li_a:hover, .carrito-button:hover{
        transform: scale(1.1);
    }
    .carrito-button{

        font-size: 20px;
        color: #fff;
        transition: transform ease .3s;
        text-decoration: none;
        font-size: 20px;
        border-radius: 10px;
        padding: 10px;
        text-align: center;
        margin: 5px;
        border: none;
        outline: none;
        background: #096;
        width: max-content;
        cursor: pointer;
    }
    
    
    .icon{
    height: 10vh;
    padding: 5px;
    filter: drop-shadow(0 0 5px rgb(0, 247, 255));
}

.li_a{
    font-size: 20px;
    color: #fff;
    text-shadow: 0 0 5px #000;
}

li.li_admin{
    margin-left:5px;
    display:flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    gap: 5px;

}
.li_admin button, .li_admin a{
    color: #fff;
    text-decoration: none;
    background: #348ec7;
    border:none;
    cursor: pointer;
    text-align: center;
    padding: 2px;
    width: max-content;
    font-size:20px;
    padding: 10px;
    margin: 5px;
    border-radius:10px;
    text-shadow: 0 0 5px #000;
    transition: transform ease .3s;
}
.li_admin button:hover, .li_admin a:hover{
    transform:scale(1.1);
    box-shadow:0 0 5px #348ec7;
}
</style>