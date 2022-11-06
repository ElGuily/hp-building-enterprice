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
            <a href="/">
                <img src="images/icon.png" alt="icon" class="icon" />

            </a>
        </li>
        <li class="li_search">
            <input type="text" class="li_search_input" />
            <button class="li_search_button">

                <img src="images/search.svg" alt="search" class="li_search_img" />
            </button>
        </li>
        <c:choose>
            <c:when test="${activo}">
                <li class="li_profile">
                    <form action="logout" method="POST">
                        <input type="submit" value="Logout" />
                    </form>
                    
                </li>
            </c:when>
            <c:otherwise>
                <li class="li_profile">
                    <a class="li_a" href="login.jsp">LogIn</a>
                    <a class="li_a" href="signup.jsp">SignUp</a>
                </li>      
            </c:otherwise>
        </c:choose>
       
        
            
            
      
    </ul>
    
</nav>