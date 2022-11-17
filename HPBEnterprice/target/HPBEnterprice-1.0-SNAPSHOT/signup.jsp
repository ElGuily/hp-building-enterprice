<%-- 
    Document   : login
    Created on : 4 nov 2022, 18:41:12
    Author     : facun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
        <link rel="stylesheet" href="styles/login.css"/>
    </head>
    <body>
        <p>${error}</p>
         <%@include file="components/nav-bar.jsp" %>
        <main class="mainLogin">
            <div class="boxcontent">
                <form action="login" method="POST" class="loginform signup" id="formulario">
                    <h1 class="title">Log In</h1>
                    <div class="inputs">
                        <div class="inputdiv">
                            <input type="text" name="username-login" id="user" autocomplete="off">
                            <label for="username-login">Username</label>
                        </div>
                        <div class="inputdiv">
                             <input type="password" name="password-login" id="password" autocomplete="off">
                            <label for="password-login">Password</label>                  
                        </div>
                        <div class="inputdiv" id="confirmPassw">
                             <input type="password" name="password2" id="password" autocomplete="off">
                            <label for="password-login">Repetir password</label>                  
                        </div>
                    </div>
                    <button class="send" name="Login">Ingresar</button>
                    <p>${error}</p>
                </form>
                <button class="switch-button">Sign Up</button>
                <svg class="wave" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320">
                    <path fill="#0066ff" fill-opacity="1"
                        d="M0,96L48,117.3C96,139,192,181,288,176C384,171,480,117,576,128C672,139,768,213,864,213.3C960,213,1056,139,1152,112C1248,85,1344,107,1392,117.3L1440,128L1440,320L1392,320C1344,320,1248,320,1152,320C1056,320,960,320,864,320C768,320,672,320,576,320C480,320,384,320,288,320C192,320,96,320,48,320L0,320Z">
                    </path>
                </svg>
            </div>            
        </main>
        
    </body>
    <script>
        const change = () =>{
            
            if ($(".loginform").hasClass("signup")) {
                $(".switch-button")
                    .css("left", 0)
                    .css("right", "50%")
                    .css("color", "rgb(0, 43, 136)")
                    .css("text-shadow", "0 0 5px rgb(0, 81, 255)")
                $(".wave").css("filter", "drop-shadow(0 0 5px rgb(0, 81, 255)) hue-rotate(135deg)")


                $(".switch-button").html("Log In")
                $(".title").html("Sign Up")
                
                $("#user").attr("name", "username")
                $("#password").attr("name", "password")
                $("#formulario").attr("action", "signup")
               $("#confirmPassw").show();
            } else {

                $(".switch-button").css("left", "50%").css("right", "0")

                .css("color", "rgb(136, 0, 0)")
                    .css("text-shadow", "0 0 5px rgb(255, 0, 0)")
                $(".wave").css("filter", "drop-shadow(0 0 5px rgb(0, 81, 255))")

                    .css("color", "rgb(136, 0, 0)")
                    .css("text-shadow", "0 0 5px rgb(255, 0, 0)")
                $(".switch-button").html("Sign Up")
                $(".title").html("Log In")
                
                $("#user").attr("name", "username-login")
                $("#password").attr("name", "password-login")
                $("#formulario").attr("action", "login")
               $("#confirmPassw").hide();
            }
        }
        
        change();
        $(".inputdiv").map((e) => {
            let input = $(".inputdiv")[e].children[0]
            let label = $(".inputdiv")[e].children[1]
            $(input).on("focus", () => {
                label.classList.add("onText")
            })
            $(input).on("blur", () => {
                if ($(input).val() == "") {

                    label.classList.remove("onText")
                }
            })
        })

        $(".switch-button").on("click", (e) => {
            
            $(".loginform").toggleClass("signup")
            change()
        })
        
        

</script>
</html>
