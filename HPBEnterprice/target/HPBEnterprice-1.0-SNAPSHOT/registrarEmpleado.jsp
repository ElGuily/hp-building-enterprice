<%-- 
    Document   : registrarEmpleado
    Created on : 7 nov. 2022, 13:39:31
    Author     : ET36
--%>

<%@page import="model.Empleado"%>
<%@page import="model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Registrar Empleado - HPBE</title>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
    <link rel="stylesheet" href="styles/registrarEmpleado.css"/>
  </head>
  <body>
    <%@include file="components/nav-bar.jsp" %>

    <main class="main_signup">
      <form action="registrarEmpleado" method="POST" class="form_signup">
        <h1>Registrar Empleado</h1>
        <p>${error}</p>
        <div class="inputdiv">
            <input type="text" name="nombre" id="nombre" />
            <label for="nombre">Nombre</label>
        </div>
        <div class="inputdiv">
            <input type="email" name="email" id="email" />
            <label for="email">Email</label>
        </div>
        <div class="inputdiv">
            <input type="number" name="DNI" id="DNI" />
            <label for="DNI">DNI</label>
        </div>
        <div class="inputdiv">
            <input type="text" name="username-emp" id="username-emp" />
            <label for="username-emp">Username</label>
        </div>
        <div class="inputdiv">
            <input type="password" name="password-emp" id="password-emp" />
            <label for="password-emp">Password</label>
        </div>
        <div class="inputdiv">
            <input type="password" name="password2-emp" id="password2-emp" />
            <label for="password2-emp">Confirm Password</label>
        </div>
        <input type="submit" name="Login" class="submit" />
      </form>
    </main>
  </body>

  <script>
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
  <style>
      .main_signup {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
.main_signup .form_signup {
  box-shadow: 0 0 5px #000;
  padding: 20px;
  border-radius: 20px;
  width: 500px;
  height: 600px;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.main_signup .form_signup .inputdiv {
  border-radius: 10px;
  margin: 10px;
  width: 100%;
  height: 10px;
  padding: 20px;
  box-shadow: 0 0 5px #000;
  background: white;
  position: relative;
}
.main_signup .form_signup .inputdiv input {
  width: 100%;
  height: 100%;
  border: none;
  outline: none;
  position: absolute;
  top: 0;
  left: 0;
  background: transparent;
  font-size: 20px;
  padding: 5px;
}
.main_signup .form_signup .inputdiv label {
  position: absolute;
  left: 5px;
  top: 50%;
  transform: translateY(-50%);
  font-size: 20px;
  transition: 0.1s;
}
.main_signup .form_signup .inputdiv label.onText {
  top: 0;
  background: #ffffff;
  border-right: 1px solid #000;
  border-left: 1px solid #000;
  border-radius: 5px;
  -webkit-backdrop-filter: blur(5px);
  backdrop-filter: blur(5px);
  font-size: 10px;
  color: #000;
  padding: 2px;
}
.main_signup .form_signup .submit {
  width: 100%;
  font-size: 25px;
  color: #fff;
  background: #0099ff;
  border: none;
  outline: none;
  margin-top: 5px;
}
.main_signup .form_signup .submit:hover {
  box-shadow: 0 0 5px #0099ff;
}


  </style>
</html>
