<%-- 
    Document   : comprarPC
    Created on : 8 nov 2022, 18:07:11
    Author     : facun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comprar pc</title>
        <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <style>
            .main_comprar{
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;              
            }
            
            .pc_div{
                height: 300px;
                width: 200px;
                border: 1px solid black;
                border-radius: 20px;
                display: flex;
                justify-content: center;
                align-items: center;
                margin: 20px;
                font-size: 22px;
                flex-direction: column;
            }
            
            
    </style>
    <body>
        <%@include file="components/nav-bar.jsp" %>
        
        <main class="main_comprar">
           
                <c:forEach items="${pc}" var="pc">
                   <div class="pc_div">
                       <p>${pc.nombre} ${pc.modelo}</p> 
                       <p>${precio}</p>


                   </div> 
               </c:forEach>
           
           
        </main>
    </body>
</html>
