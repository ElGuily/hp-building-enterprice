/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import model.ConectarBD;
import model.GestorBD;
import model.PCs;

/**
 *
 * @author facun
 */
@WebServlet(name = "agregarAlCarrito", urlPatterns = ("/agregarAlCarrito"))

public class añadirAlCarrito extends HttpServlet{
        protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
            
            
            String pc = req.getParameter("botonAgregar");
            JOptionPane.showMessageDialog(null, pc);
         
            req.getRequestDispatcher("index.jsp").forward(req, res);
           
        }
    
}