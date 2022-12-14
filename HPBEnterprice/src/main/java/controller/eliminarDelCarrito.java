/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ConectarBD;
import model.GestorBD;

/**
 *
 * @author facun
 */
@WebServlet(name = "eliminarDelCarrito", urlPatterns = ("/eliminarDelCarrito"))

public class eliminarDelCarrito extends HttpServlet{
        protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
           String pc = req.getParameter("deleteCartButton");
           ConectarBD cbd = new ConectarBD();
           GestorBD gbd = new GestorBD();
           
           gbd.eliminarDelCarrito(pc); //Ejecuta el store para eliminar producto del carrito.
         
           req.getRequestDispatcher("index.jsp").forward(req, res);
          
                   
           
        }
    
}