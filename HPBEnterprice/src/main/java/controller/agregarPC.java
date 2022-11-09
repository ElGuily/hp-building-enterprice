/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import model.ConectarBD;
import model.Enum_modelos;
import model.GestorBD;
import model.PCs;

/**
 *
 * @author facun
 */
@WebServlet(name = "agregarPC", urlPatterns = ("/agregarPC"))

public class agregarPC extends HttpServlet{
  
        protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
            try(PrintWriter out = res.getWriter()){
                Enum_modelos m = null;
                JOptionPane.showMessageDialog(null, "hola1");
                double precio_pc = 0;
                String nombre_pc = req.getParameter("nombre-pc");
                JOptionPane.showMessageDialog(null, nombre_pc);
                JOptionPane.showMessageDialog(null, "hola2");
                String modelo_pc = req.getParameter("modelo-pc");
                JOptionPane.showMessageDialog(null, "hola3");
                String precio = req.getParameter("precio-pc");
           
                
                try{
                    precio_pc = Double.parseDouble(precio);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
                
                
                String cat = req.getParameter("categoria-pc");
           
                String comp_imp = req.getParameter("importados");
         
                int imps = Integer.parseInt(comp_imp);
         
               
                ConectarBD cbd = new ConectarBD();
                GestorBD gbd = new GestorBD();
                
                gbd.registrarPC(nombre_pc, cat, precio_pc, m.HP2004, imps);
                req.getRequestDispatcher("index.jsp").forward(req, res);
                
            }
        }
    
}