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
                
                boolean rgb = false;
                boolean all = false;
                boolean refri = false;
                Enum_modelos m = null;
                double precio_pc = 0;
                String nombre_pc = req.getParameter("nombre-pc");
                String modelo_pc = req.getParameter("modelo-pc");
                String precio = req.getParameter("precio-pc");
           
                
                try{
                    precio_pc = Double.parseDouble(precio);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
                
                
                String cat = req.getParameter("categoria-pc");
                int cat1 = Integer.parseInt(cat);
                String comp_imp = req.getParameter("importados");
         
                int imps = Integer.parseInt(comp_imp);
                
                if(cat.equals("1")){
                   
                    String rgb_1 = req.getParameter("rgb_opt");        
                    String refri_1 = req.getParameter("refri_opt");
                    JOptionPane.showMessageDialog(null, rgb_1 + " "+ refri_1);
                    if(refri_1 != null){
                        JOptionPane.showMessageDialog(null, "cagamo refri");
                        refri = true;
                    }
                    if(rgb_1 != null){
                        JOptionPane.showMessageDialog(null, "cagamo rgb");
                        rgb = true;
                    }
                    
                    
                    
                }else if(cat.equals("2")){
                    String all_1 = req.getParameter("all_in_one_opt");
                    if(all_1 != null){
                        all = true;
                    }
                    JOptionPane.showMessageDialog(null, all);
                }
               
                ConectarBD cbd = new ConectarBD();
                GestorBD gbd = new GestorBD();
                
               
                gbd.registrarPC(nombre_pc, cat, precio_pc, modelo_pc, imps, rgb, all, refri);
                req.getRequestDispatcher("index.jsp").forward(req, res);
                
            }
        }
    
}