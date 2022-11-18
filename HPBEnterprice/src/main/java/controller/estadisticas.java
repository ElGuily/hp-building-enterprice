/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import model.Empleado;
import model.GestorBD;

/**
 *
 * @author facun
 */
@WebServlet(name = "estadisticas", urlPatterns = ("/estadisticas"))

public class estadisticas extends HttpServlet{
        protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
            
           //Permite mostrarle a cada empleado sus estadisticas.
           HttpSession sesion = req.getSession();
           String nombre = "";
           String dni = "";
           String email = "";
           String user = String.valueOf(sesion.getAttribute("user_emp"));
           String password = String.valueOf(sesion.getAttribute("passw_emp"));
           double facturado = 0;
           GestorBD gbd = new GestorBD();
           
           ResultSet emp = gbd.obtenerEmpleado(user, password);
           
           
            try {
                while(emp.next()){
                   nombre =  emp.getString("nombre_empleado");
                   dni = emp.getString("DNI_empleado");
                   email = emp.getString("email_empleado");
                   facturado = emp.getDouble("facturado");
                }
                
                Empleado empleado = new Empleado(facturado, nombre, user, password, dni, email);
                req.setAttribute("empleadoDatos", empleado);
                
                
            } catch (SQLException ex) {
                Logger.getLogger(estadisticas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            double totalComision = gbd.obtenerTotalComisionEnVenta();    
       
           req.setAttribute("comision", totalComision);
            
            req.getRequestDispatcher("estadisticasEmpleado.jsp").forward(req, res);
        }
        
     
       
    
}