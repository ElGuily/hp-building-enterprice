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
import model.ConectarBD;
import model.GestorBD;

/**
 *
 * @author facun
 */
@WebServlet(name = "agregarPC", urlPatterns = ("/agregarPC"))

public class agregarPC extends HttpServlet{
        protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
            try(PrintWriter out = res.getWriter()){
                String link_imagen = req.getParameter("imagen-pc");
                String nombre_pc = req.getParameter("nombre_pc");
                String modelo_pc = req.getParameter("modelo-pc");
                String precio = req.getParameter("precio-pc");
                int precio_pc = Integer.parseInt(precio);
                String cat = req.getParameter("categoria-pc");
                String comp_imp = req.getParameter("importados");
                
                ConectarBD cbd = new ConectarBD();
                GestorBD gbd = new GestorBD();
                
                
                
                
            }
        }
    
}