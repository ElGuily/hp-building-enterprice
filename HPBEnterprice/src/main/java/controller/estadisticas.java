/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import model.ConectarBD;
import model.Empleado;
import model.GestorBD;

/**
 *
 * @author facun
 */
@WebServlet(name = "estadisticas", urlPatterns = ("/estadisticas"))

public class estadisticas extends HttpServlet{
        protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
           HttpSession sesion = req.getSession();
           String nombre = "";
           int dni = 0;
           String email = "";
           Object user1 = sesion.getAttribute("user_emp");
           Object password1 = sesion.getAttribute("passw_emp");
           double facturado = 0;
           String user = String.valueOf(user1);
           String password = String.valueOf(password1);
           GestorBD gbd = new GestorBD();
           ResultSet emp = gbd.obtenerEmpleado(user, password);
            try {
                while(emp.next()){
                   nombre =  emp.getString("nombre_empleado");
                   dni = emp.getInt("DNI_empleado");
                   email = emp.getString("email_empleado");
                   facturado = emp.getDouble("facturado");
                }
                
                Empleado empleado = new Empleado(facturado, nombre, user, password, dni, email);
                req.setAttribute("empleadoDatos", empleado);
                
                /* ESTO FUNCIONA -- HAY QUE HACER UN SELECT DE EMPLEADO Y DE AHI SACAR LOS DATOS*/
            } catch (SQLException ex) {
                Logger.getLogger(estadisticas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            req.getRequestDispatcher("estadisticasEmpleado.jsp").forward(req, res);
        }
        
     
       
    
}