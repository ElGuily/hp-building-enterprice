
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
