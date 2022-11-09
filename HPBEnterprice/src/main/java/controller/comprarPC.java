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
                
                String type = req.getParameter("q");
                
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
                        if("Gamer".equals(type)){
                            
                            PCs gamer = new PC_Gamer(nombre, valor, m.Elite600, imp);
                            pc_gamer.add(gamer);
                            double precio = gamer.calcularPrecio();
                            req.setAttribute("pc", pc_gamer);
                            req.setAttribute("precio", precio);
                        }else if("Diseño".equals(type)){
                           
                            PCs diseño = new PC_Diseño(nombre, valor, m.Elite600, imp);
                            pc_diseño.add(diseño);
                            diseño.calcularPrecio();
                            req.setAttribute("pc", pc_diseño);
                        }else if("Oficina".equals(type)){
                           
                            PCs oficina = new PC_Oficina(nombre, valor, m.Elite600, imp);
                            pc_oficina.add(oficina);
                            oficina.calcularPrecio();
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