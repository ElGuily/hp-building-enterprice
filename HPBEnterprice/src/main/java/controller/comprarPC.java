/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import model.ConectarBD;
import model.GestorBD;
import model.*;

/**
 *
 * @author facun
 */
@WebServlet(name = "comprarPC", urlPatterns = ("/comprarPC"))

public class comprarPC extends HttpServlet{
    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
            ArrayList<PCs> pc_gamer = new ArrayList<PCs>();
            ArrayList<PCs> pc_diseño = new ArrayList<PCs>();
            ArrayList<PCs> pc_oficina = new ArrayList<PCs>();
          
         
            
            try(PrintWriter out = res.getWriter()){
                
                String type1 = req.getParameter("q");
             
                int type = Integer.parseInt(type1);
               
                ConectarBD cbd = new ConectarBD();
                GestorBD gbd = new GestorBD();
                
                ResultSet pc = gbd.verCompu(type);
         
                try{
            
                    while(pc.next()){
                        String nombre = pc.getString("nombre_pc");
                        String valor1 = pc.getString("precio");
                        double valor = Double.parseDouble(valor1);
                        String imps = pc.getString("cant_comp_importados");
                        int imp = Integer.parseInt(imps);
                        Enum_modelos m = null;
                        String modelo_pc = pc.getString("modelo");
                        int rgb = pc.getInt("rgb");
                        int refri = pc.getInt("refri_liquid");
                        int all = pc.getInt("all_in_one");
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
                        
                        if("1".equals(type1)){
                            JOptionPane.showMessageDialog(null, "Entro en gamer");
                            
                            
                            PCs gamer = new PC_Gamer(nombre, valor, m, imp, rgb, refri);
                            double valorPC = gamer.calcularPrecio();
                            gamer.setValor_PC(valorPC);
                            pc_gamer.add(gamer);
                            req.setAttribute("pc", pc_gamer);
  
                        }else if("2".equals(type1)){
                            JOptionPane.showMessageDialog(null, "Entro en diseño");
                            PCs diseño = new PC_Diseño(nombre, valor, m, imp);
                            double valorPC = diseño.calcularPrecio();
                            diseño.setValor_PC(valorPC);
                            pc_diseño.add(diseño);                         
                            req.setAttribute("pc", pc_diseño);
                            
                        }else if("3".equals(type1)){
                            JOptionPane.showMessageDialog(null, "Entro en oficin");
                            PCs oficina = new PC_Oficina(nombre, valor, m, imp, all);
                            double valorPC = oficina.calcularPrecio();
                            oficina.setValor_PC(valorPC);
                            pc_oficina.add(oficina);
                            
                            req.setAttribute("pc", pc_oficina);
                        }
                    }
                }catch(SQLException ex){
                    System.out.println("Error en la bd");
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "ajajaj" + ex );
                }
               
                req.getRequestDispatcher("comprarPC.jsp").forward(req, res);
                
                
                
            }
        }
    
}