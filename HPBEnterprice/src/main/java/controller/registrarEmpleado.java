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
import javax.swing.JOptionPane;
import model.*;
import model.ConectarBD;
import model.GestorBD;

/**
 *
 * @author ET36
 */
@WebServlet(name = "registrarEmpleado", urlPatterns = ("/registrarEmpleado"))
public class registrarEmpleado extends HttpServlet{
    @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
            try(PrintWriter out = res.getWriter()){
                
                String nombre = req.getParameter("nombre");          
                String email = req.getParameter("email");
                String DNIold = req.getParameter("DNI");
                int DNI = Integer.parseInt(DNIold);
                String username = req.getParameter("username-emp");
                String password = req.getParameter("password-emp");
                String password2 = req.getParameter("password2-emp");
                JOptionPane.showMessageDialog(null, nombre + " " + email + " " + DNI + " " + DNIold + " " + username + " "+ password + " "+ password2);
                ConectarBD cbd = new ConectarBD();
                GestorBD gbd = new GestorBD();
                
                if(password.equals(password2)){      
                    Empleado empleado = new Empleado(nombre, username, password, DNI, email);
                    gbd.registrarEmpleado(empleado);
                    
                    
                    
                    req.getRequestDispatcher("/index.jsp").forward(req, res);
                    
                }else{
                   
                    JOptionPane.showMessageDialog(null, "ERRO");
                    req.setAttribute("error", "Las contraseñas no coinciden");
                  
                    req.getRequestDispatcher("/signup.jsp").forward(req, res);
                }
                
  
            }
        }
    
}
