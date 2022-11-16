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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import model.Cliente;
import model.ConectarBD;
import model.Direccion;
import model.Empleado;
import model.GestorBD;
import model.PCs;
import model.Persona;
import model.Venta;

/**
 *
 * @author facun
 */
@WebServlet(name = "compraFinal", urlPatterns = ("/compraFinal"))

public class compraFinal extends HttpServlet{
        protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
            //Efectua la compra
            HttpSession session = req.getSession();
            GestorBD gbd = new GestorBD();
            String username = (String)session.getAttribute("user_emp");
            String password = (String)session.getAttribute("passw_emp");
            Cliente c = new Cliente(username, password);
            Random rd = new Random();
            String nombre_cliente = req.getParameter("nombre_cliente");
            String email_cliente = req.getParameter("email_cliente");
            String DNI_cliente = req.getParameter("DNI_cliente");
            String localidad_cliente = req.getParameter("localidad_cliente");
            String calle_cliente = req.getParameter("calle_cliente");
            int altura_cliente = Integer.parseInt(req.getParameter("altura_cliente"));
            Direccion direccion = new Direccion(calle_cliente, altura_cliente, localidad_cliente);
            double total = Double.parseDouble(req.getParameter("botonComprar"));
            String nombre_empleado = "";
            String email_empleado = "";
            int emp = gbd.totalEmpleados(); //Permite obtener el total de empleado
            
            
            gbd.registrarCliente(email_cliente, DNI_cliente, nombre_cliente, direccion.toString(), username);
            
            int random = rd.nextInt(1, emp + 1); //Dependiendo el total de empelados se ejecuta un random.
           
           Empleado e = null;
            
            ResultSet empleado = gbd.obtenerEmpleadoAlAzar(random); //Obtiene el empelado aleatorio.
            try {
                if(empleado.next()){
                     
                    nombre_empleado = empleado.getString("nombre_empleado");
                    email_empleado = empleado.getString("email_empleado");
                   
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(compraFinal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             e = new Empleado(nombre_empleado, email_empleado, total);
             JOptionPane.showMessageDialog(null, e.getNombre());
            
            
            
          
            gbd.actualizarFacturado(random, total); //Actualiza lo ganado por el empleado.
            
           ResultSet cart = gbd.obtenerCarrito(username);
            try {
                while(cart.next()){
                    String nombre_prod = cart.getString("producto");
                    int cant = cart.getInt("cantidad");
                    JOptionPane.showMessageDialog(null, nombre_prod);
                    gbd.aumentarPC(nombre_prod, cant);
                }
            } catch (SQLException ex) {
                Logger.getLogger(compraFinal.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           Venta venta = new Venta(c, e, total);
           
           gbd.registrarVenta(nombre_empleado, username, total); //Registra la venta
           
           session.setAttribute("factura",  venta);
           req.getRequestDispatcher("compraFinal.jsp").forward(req, res);
        }
    
}

