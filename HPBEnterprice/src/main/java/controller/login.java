/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cliente;
import model.ConectarBD;
import model.Empleado;
import model.GestorBD;

/**
 *
 * @author facun
 */
@WebServlet(name = "login", urlPatterns = ("/login"))

public class login extends HttpServlet{
        protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
            try(PrintWriter out = res.getWriter()){
                
                //Se obtienen los datos proporicionados en el formulario de inicio de sesion.
                String username_login = req.getParameter("username-login");
                String password_login = req.getParameter("password-login");
                
                ConectarBD cbd = new ConectarBD();
                GestorBD gbd = new GestorBD();
                HttpSession session = req.getSession();
                
                //Se comprueba que ese usuario existe comparando con los datos obtenidos.
                if(gbd.loginUsuario(username_login, password_login)==1){
                    
                    //Este se ejecuta si el usuario logueado es un cliente "normal"
                    
                    Cliente user = new Cliente(username_login, password_login);
                    
                    session.setAttribute("user", user);
                    session.setAttribute("user_emp", username_login);
                    session.setAttribute("passw_emp", password_login);
                    session.setAttribute("activo", true);
                    req.getRequestDispatcher("/index.jsp").forward(req, res);
                    
                    
                }else if(gbd.loginEmpleado(username_login, password_login)==1){
                    
                    //Este se ejecuta si el usuario es registrado por el admin. Es decir un empleado.
                    if(username_login.equals("admin") && password_login.equals("admin")){
                        session.setAttribute("admin", true); //Guarda en una sesion que el usuario logueado es admin.
                    }else{
                        session.setAttribute("admin", false); 
                    }
                    session.setAttribute("empleado", true); //Guarda en una sesion que el usuario es un empleado.
                    session.setAttribute("activo", true); //Guarda en la sesion que el usuario esta logueado.
                    
                    Empleado user= new Empleado(username_login, password_login);
                    session.setAttribute("user_emp", username_login);
                    session.setAttribute("passw_emp", password_login);
                    session.setAttribute("user_empleado", user);
                    req.getRequestDispatcher("/index.jsp").forward(req, res);
                }else{
                    req.setAttribute("info", "El nombre de usuario o la contraseña son incorrectas");
                    req.getRequestDispatcher("/login.jsp").forward(req, res);
                }
                
            }
            
        }
    
}