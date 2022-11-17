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

@WebServlet(name = "logout", urlPatterns = ("/logout"))
public class logout extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
            try(PrintWriter out = res.getWriter()){
             
                //Cierra la sesion del usuario.
                ConectarBD cbd = new ConectarBD();
                GestorBD gbd = new GestorBD();
                HttpSession session = req.getSession();
                Cliente usu = (Cliente)session.getAttribute("user");
                Empleado emp = (Empleado)session.getAttribute("user_empleado");
               
                session.removeAttribute("user");
                session.removeAttribute("user_empleado");
                session.setAttribute("activo", false);
                session.setAttribute("admin",false);
                session.setAttribute("empleado", false);
                
                req.getRequestDispatcher("index.jsp").forward(req, res);
                
            }
        }
}
