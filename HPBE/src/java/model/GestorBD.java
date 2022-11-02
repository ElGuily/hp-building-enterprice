package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ET36
 */
public class GestorBD {
    Connection conn = null;
    Statement stm = null;
    private ArrayList<String> comandos = new ArrayList<>();

    public boolean registrarCliente(Cliente c){
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call registrarCliente('"+c.getUsuario()+"','"+c.getEmail()+"', '"+c.getPassw()+"', "+c.getNombre()+")";
            JOptionPane.showMessageDialog(null, sql);
            this.stm.executeUpdate(sql);
        }catch(SQLException e){
            System.out.println("Error en la bd");
            JOptionPane.showMessageDialog(null, e );
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean registrarEmpleado(Empleado em){
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call registrarCliente('"+em.getUsuario()+"','"+em.getEmail()+"', '"+em.getPassw()+"', "+em.getNombre()+")";
            JOptionPane.showMessageDialog(null, sql);
            this.stm.executeUpdate(sql);
        }catch(SQLException e){
            System.out.println("Error en la bd");
            JOptionPane.showMessageDialog(null, e );
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean loginCliente(Cliente c){
         try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call loginCliente('"+c.getUsuario()+"','"+c.getPassw()+"')";
            JOptionPane.showMessageDialog(null, sql);
            this.stm.executeUpdate(sql);
            this.comandos.add(sql);
        }catch(SQLException e){
            System.out.println("Error en la bd");
            JOptionPane.showMessageDialog(null, e );
            e.printStackTrace();
            return false;
        }
         
        return true;
    }
    
    public boolean loginEmpleado(Empleado em){
         try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call loginEmpleado('"+em.getUsuario()+"','"+em.getPassw()+"')";
            JOptionPane.showMessageDialog(null, sql);
            this.stm.executeUpdate(sql);
            this.comandos.add(sql);
        }catch(SQLException e){
            System.out.println("Error en la bd");
            JOptionPane.showMessageDialog(null, e );
            e.printStackTrace();
            return false;
        }
         
        return true;
    }
   
}