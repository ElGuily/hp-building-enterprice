<%-- 
    Document   : login.jsp
    Created on : 2 nov. 2022, 08:42:31
    Author     : ET36
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HP Building Enterprice</title>
        <link rel="shortcut icon" href="favicon.png" type="image/x-icon" />
        <link rel="stylesheet" href="style.css"/>
    </head>
    <body class="mainbox">
        
        <%@include file="components/nav-bar.jsp" %>
        <main>
            <div class="landing">
              <div class="main_div">
                <h1 class="main_div_h1">Hewlett-Packets</h1>
                <h2 class="main_div_h2">Building Enterprise</h2>
              </div>
              <img src="images/computers.svg" alt="mainimg" class="main_img" />
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320" class="main_wave">
                <path
                  fill="#0099ff"
                  fill-opacity="1"
                  d="M0,32L48,58.7C96,85,192,139,288,176C384,213,480,235,576,240C672,245,768,235,864,202.7C960,171,1056,117,1152,101.3C1248,85,1344,107,1392,117.3L1440,128L1440,320L1392,320C1344,320,1248,320,1152,320C1056,320,960,320,864,320C768,320,672,320,576,320C480,320,384,320,288,320C192,320,96,320,48,320L0,320Z"
                ></path>
              </svg>
            </div>
            <div class="postLanding">
              <h3 class="postLanding__h3">Busca el computador de tus sueños</h3>
              <div class="postLanding__cajas">
                 
                  
                    <a href="${pageContext.request.contextPath}/comprarPC?q=1">
                        <div class="box">
                          <img src="images/gamer.png" alt="Gamer"  class="img" />

                          <span class="span">Gamer</span>

                        </div>
                    </a>
                      
                   <a href="${pageContext.request.contextPath}/comprarPC?q=2">
                        <div class="box">
                          <img src="images/diseño.png" alt="Diseño" class="img" />

                          <span class="span">Diseño</span>

                        </div>
                    </a>     
                        
                    <a href="${pageContext.request.contextPath}/comprarPC?q=3">
                        <div class="box">
                          <img src="images/oficina.png" alt="Oficina" class="img" />

                          <span class="span">Oficina</span>

                        </div>
                    </a>
                         
                        
                    
                        
                   
                  
                
                  
                  
                    
                  
                
               
                 
                      
                  
              </div>
            </div>
        </main>
        
        
        
        
        
        
        
    </body>
</html>
