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
import model.ConectarBD;
import model.Enum_modelos;
import model.GestorBD;
import model.PC_Diseño;
import model.PC_Gamer;
import model.PC_Oficina;
import model.PCs;

/**
 *
 * @author facun
 */
@WebServlet(name = "agregarPC", urlPatterns = ("/agregarPC"))

public class agregarPC extends HttpServlet{
  
        protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
            try(PrintWriter out = res.getWriter()){
                
                //Obtiene los datos del formulario agregarPC el cual solo pueden usar los empleados.
                //Obtiene tambien los agregados de cada PC.
                double valor = 0;
                Enum_modelos m = null;
                double precio_pc = 0;
                String nombre_pc = req.getParameter("nombre-pc");
                String modelo_pc = req.getParameter("modelo-pc");
                String precio = req.getParameter("precio-pc");
                int rgb_class = 0;
                int all_class = 0;
                int refri_class= 0;
                double comision = 0;
                
                
                try{
                    precio_pc = Double.parseDouble(precio);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
                
                
                String cat = req.getParameter("categoria-pc");              
                int imps = Integer.parseInt(req.getParameter("importados"));
            
                
               
                
                if(m.Elite600.getNombre_modelo().equals(modelo_pc)){
                    m = m.Elite600;
                }else if(m.Elite800.getNombre_modelo().equals(modelo_pc)){
                     m = m.Elite800;
                }else if(m.HP2004.getNombre_modelo().equals(modelo_pc)){
                     m = m.HP2004;
                }else if(m.ProDesk400.getNombre_modelo().equals(modelo_pc)){
                     m = m.ProDesk400;
                }else if(m.ProOne.getNombre_modelo().equals(modelo_pc)){
                     m = m.ProOne;
                }else if(m.miniHPpro400.getNombre_modelo().equals(modelo_pc)){
                    m = m.miniHPpro400;
                }
                
                
                
               
                
                if(cat.equals("1")){
                    
                    String rgb_1 = req.getParameter("rgb_opt");        
                    String refri_1 = req.getParameter("refri_opt");
                   
                    if(refri_1 != null){
                        refri_class = 1;
                    }
                    if(rgb_1 != null){                 
                        rgb_class = 1;
                    }
                    
                    PCs gamer = new PC_Gamer(nombre_pc, precio_pc, m, rgb_class, refri_class);
                    valor = gamer.calcularPrecio();
                    gamer.setValor_PC(valor);
                    
                    
                }else if(cat.equals("3")){
                    String all_1 = req.getParameter("all_in_one_opt");
                    if(all_1 != null){
                        all_class = 1;
                    }
                 
                    PCs oficina = new PC_Oficina(nombre_pc, precio_pc, m, imps,  all_class);
                    valor = oficina.calcularPrecio();
                    oficina.setValor_PC(valor);
                }else if(cat.equals("2")){
                    PCs diseño = new PC_Diseño(nombre_pc, precio_pc, m);
                    valor = diseño.calcularPrecio();
                    diseño.setValor_PC(valor);
                }
               
                ConectarBD cbd = new ConectarBD();
                GestorBD gbd = new GestorBD();
           
               
                gbd.registrarPC(nombre_pc, cat, valor, modelo_pc, imps, rgb_class, all_class, refri_class);
                req.getRequestDispatcher("index.jsp").forward(req, res);
                
            }
        }
    
}