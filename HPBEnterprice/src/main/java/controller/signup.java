
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import model.*;
import model.ConectarBD;


@WebServlet(name = "signup", urlPatterns = ("/signup"))
    public class signup extends HttpServlet{
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
            try(PrintWriter out = res.getWriter()){
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                String password2 = req.getParameter("password2");
                
                ConectarBD cbd = new ConectarBD();
                GestorBD gbd = new GestorBD();
                JOptionPane.showMessageDialog(null, username + " " + password + " " + password2);
                if(password.equals(password2)){
                    
                    Cliente usuario = new Cliente(username, password);
                    gbd.registrarUsuario(usuario);
                    JOptionPane.showMessageDialog(null, "ERRO");
                    
                    req.getRequestDispatcher("/index.jsp").forward(req, res);
                    
                }else{
                   
                    JOptionPane.showMessageDialog(null, "ERRO");
                    req.setAttribute("error", "Las contraseñas no coinciden");
                  
                    req.getRequestDispatcher("/signup.jsp").forward(req, res);
                }
                
  
            }
        }
    }


    /*

    1. Aplicar interfaz

*/
    

