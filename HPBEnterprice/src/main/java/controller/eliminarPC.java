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
import javax.swing.JOptionPane;
import model.ConectarBD;
import model.GestorBD;

/**
 *
 * @author facun
 */
@WebServlet(name = "eliminarPC", urlPatterns = ("/eliminarPC"))

public class eliminarPC extends HttpServlet{
        protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
           String pc = req.getParameter("botonEliminar");
           ConectarBD cbd = new ConectarBD();
           GestorBD gbd = new GestorBD();
           
           gbd.eliminarPC(pc);
         
           req.getRequestDispatcher("index.jsp").forward(req, res);
          
                   
           
        }
    
}