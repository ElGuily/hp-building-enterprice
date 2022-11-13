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
import model.Empleado;
import model.GestorBD;
import model.PCs;
import model.Venta;

/**
 *
 * @author facun
 */
@WebServlet(name = "compraFinal", urlPatterns = ("/compraFinal"))

public class compraFinal extends HttpServlet{
        protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
            HttpSession session = req.getSession();
            GestorBD gbd = new GestorBD();
            String username = (String)session.getAttribute("user_emp");
            String password = (String)session.getAttribute("passw_emp");
            Cliente c = new Cliente(username, password);
            Random rd = new Random();
        
            String total1 = req.getParameter("botonComprar");
        
            double total = Double.parseDouble(total1);
            int emp = gbd.totalEmpleados();
            
            
            int random = rd.nextInt(1, emp + 1);
            Empleado e = null;
           
            
            ResultSet empleado = gbd.obtenerEmpleadoAlAzar(random);
            try {
                while(empleado.next()){
                    String nombre = empleado.getString("nombre_empleado");
                    String email = empleado.getString("email_empleado");
                    e = new Empleado(nombre, email, total);
                }
            } catch (SQLException ex) {
                Logger.getLogger(compraFinal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Venta venta = new Venta(c, e);
            
            session.setAttribute("factura",  venta);
          
            gbd.actualizarFacturado(random, total);
           req.getRequestDispatcher("compraFinal.jsp").forward(req, res);
        }
    
}

