/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import model.*;

/**
 *
 * @author facun
 */
@WebServlet(name = "compraFinal", urlPatterns = ("/compraFinal"))

public class compraFinal extends HttpServlet{

    /**
     *
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
            //Efectua la compra
            
            //Datos necesarios
            HttpSession session = req.getSession();
            GestorBD gbd = new GestorBD();
            Random rd = new Random();
            //Usuario
            String username = (String)session.getAttribute("user_emp");
            String password = (String)session.getAttribute("passw_emp");
            //Form previo a la compra.
            String nombre_cliente = req.getParameter("nombre_cliente");
            String email_cliente = req.getParameter("email_cliente");
            String DNI_cliente = req.getParameter("DNI_cliente");
            String localidad_cliente = req.getParameter("localidad_cliente");
            String calle_cliente = req.getParameter("calle_cliente");
            int altura_cliente = Integer.parseInt(req.getParameter("altura_cliente"));
            //Creacion de objetos
            Direccion direccion = new Direccion(calle_cliente, altura_cliente, localidad_cliente);
            Cliente cliente = new Cliente(direccion, nombre_cliente, username, password, DNI_cliente, email_cliente);
            session.setAttribute("direccion", direccion);
            
            double total = Double.parseDouble(req.getParameter("botonComprar"));
            //Empleado
            String nombre_empleado = "";
            String email_empleado = "";
            String DNI_empleado = "";
            String usuario_empleado = "";
            String passw_empleado = "";
            int emp = gbd.totalEmpleados(); //Permite obtener el total de empleado
            
            
            gbd.registrarCliente(cliente);
            
            int random = rd.nextInt(1, emp + 1); //Dependiendo el total de empelados se ejecuta un random.
           
           
            
            ResultSet empleado = gbd.obtenerEmpleadoAlAzar(random); //Obtiene el empelado aleatorio.
            try {
                if(empleado.next()){
                     
                    nombre_empleado = empleado.getString("nombre_empleado");
                    email_empleado = empleado.getString("email_empleado");
                    DNI_empleado = empleado.getString("DNI_empleado");
                    usuario_empleado = empleado.getString("user_empleado");
                    passw_empleado = empleado.getString("password_empleado");
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(compraFinal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
           
           Venta venta = new Venta(cliente, new Empleado(total, nombre_empleado, usuario_empleado, passw_empleado, DNI_empleado, email_empleado), total);
           double comisiones = gbd.obtenerTotalComision();           
           
          
           gbd.registrarVenta(nombre_empleado, username, total, comisiones); //Registra la venta
           
           session.setAttribute("factura",  venta);
           req.getRequestDispatcher("compraFinal.jsp").forward(req, res);
        }
    
}

