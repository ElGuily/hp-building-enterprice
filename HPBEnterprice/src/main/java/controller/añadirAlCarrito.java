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
import model.*;


/**
 *
 * @author facun
 */
@WebServlet(name = "agregarAlCarrito", urlPatterns = ("/agregarAlCarrito"))

public class añadirAlCarrito extends HttpServlet{
        protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
            //Agrega al carrito de usuario por cada PC seleccionada
            //Se creo un trigger, que luego de ejecutarse la compra (Se almacena el pedido en tabla Ventas), todo el carrito de ese usuario se vacia.
            Venta v = new Venta();
            String nombrePC = "";
            ArrayList<PCs> carrito = new ArrayList<PCs>();
            GestorBD gbd = new GestorBD();
            HttpSession ses = req.getSession();
            Enum_modelos m = null;
            int cant = 0;
            ResultSet pcs = gbd.obtenerPC(req.getParameter("botonAgregar"));
            double valorTotal = 0;
            Object user1 = ses.getAttribute("user_emp");
            String user = String.valueOf(user1);
            int total = 0;
            double comision = 0;
            
            
            if(pcs != null){
                try {
                while(pcs.next()){
                    String nombre = pcs.getString("nombre_pc");
                    String modelo_pc = pcs.getString("modelo");
                    double precio = pcs.getDouble("precio");
                    int cat = pcs.getInt("id_categoria");
                    ResultSet cantidad = gbd.comprobarCantidad(nombre, user);
                    if(cantidad.next()){
                        cant = cantidad.getInt("cant");
                    }
                    
                    //En el caso que esa PC ya exista en el carrito, en vez de crear otro producto, aumenta en 1 la cantidad del mismo. Asi como cambiar el precio por la cantidad que tenga.
                    if(cant>=1){
                        gbd.actualizarCantidadCarrito(nombre, user);
                        gbd.actualizarPrecioCarrito(cant +1, nombre, user);
                        
                    }else{
                        gbd.registrarCarrito(nombre, user, precio, comision);
                    }
                    
                    
                    
                }

                } catch (SQLException ex) {
                    Logger.getLogger(añadirAlCarrito.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            
            ResultSet rs = gbd.obtenerCarrito(user);
            try {
                while(rs.next()){
                    String nombreCompu = rs.getString("producto");
                    valorTotal = rs.getDouble("total");
                    ResultSet computadora = gbd.obtenerPC(nombreCompu);
                    
                    while(computadora.next()){
                            nombrePC = computadora.getString("nombre_pc");
                            String modelo_pc = computadora.getString("modelo");
                            int cantImp = computadora.getInt("cant_comp_importados");
                            int cat =computadora.getInt("id_categoria");
                            int all_in_one = computadora.getInt("all_in_one");
                            int refri = computadora.getInt("refri_liquid");
                            int rgb = computadora.getInt("rgb");
                            
                            
                            
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
                            if(cat==1){
                                PCs pc_gamer = new PC_Gamer(nombrePC, valorTotal, m, cantImp, rgb, refri);
                              
                                
                                comision = pc_gamer.calcularImpuesto(comision);
                                JOptionPane.showMessageDialog(null, comision);
                                v.añadirPC(pc_gamer);
                                JOptionPane.showMessageDialog(null, "Valor: "+ pc_gamer.getValor_PC());
                                
                                carrito.add(pc_gamer);
                                
                            }else if(cat==2){
                                PCs pc_diseño = new PC_Diseño(nombrePC, valorTotal, m, cantImp);
                                comision = pc_diseño.calcularImpuesto(comision);
                                v.añadirPC(pc_diseño);
                                carrito.add(pc_diseño);
                                
                            }else if(cat==3){
                                PCs pc_oficina = new PC_Oficina(nombrePC, valorTotal, m, cantImp, all_in_one);
                                comision = pc_oficina.calcularImpuesto(comision);
                             
                                v.añadirPC(pc_oficina);
                                carrito.add(pc_oficina);
                                
                            }
                        
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(añadirAlCarrito.class.getName()).log(Level.SEVERE, null, ex);
            }
            gbd.actualizarComision(comision, nombrePC, user);
            ses.setAttribute("carrito", v.getPCs());
            JOptionPane.showMessageDialog(null, v.getPCs());
            double totalPrecio = v.calcularTotal(user);
           
            ses.setAttribute("total", totalPrecio);
            
            req.getRequestDispatcher("carrito.jsp").forward(req, res);
           
        }
    
}