
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import model.ConectarBD;


@WebServlet(name = "login", urlPatterns = ("/login"))
public class login extends HttpServlet{
    protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = res.getWriter()){
            String user = req.getParameter("user");
            String passw = req.getParameter("passw");
            
            ConectarBD bd = new ConectarBD();
            
            
        }
    }
    
    
    
    
}
