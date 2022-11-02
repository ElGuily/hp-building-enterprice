package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ET36
 */
public class GestorBD {
    Connection conn = null;
    Statement stm = null;
    ResultSet rs;
    
    
//    public boolean registrar(int legajo, String nombre, String apellido, int promedio){
//        int resultUpdate = 0;
//        try{
//            conn = ConectarBD.abrir();
//            stm = conn.createStatement();
//            String sql = "INSERT INTO alumno values("+legajo+",'"+nombre+"', '"+apellido+"', "+promedio+")";
//            JOptionPane.showMessageDialog(null, sql);
//            stm.executeUpdate(sql); //error aca
//            
//            JOptionPane.showMessageDialog(null, resultUpdate);
//            
//            
//            
//            
//        }catch(Exception e){
//            System.out.println("Error en la bd");
//            JOptionPane.showMessageDialog(null, e );
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }

    public boolean registrarCliente(Cliente c){
        try{
            conn = ConectarBD.abrir();
            stm = conn.createStatement();
            String sql = "call registrarCliente('"+c.getUsuario()+"','"+c.getEmail()+"', '"+c.getPassw()+"', "+c.getNombre()+")";
            JOptionPane.showMessageDialog(null, sql);
            stm.executeUpdate(sql);
        }catch(Exception e){
            System.out.println("Error en la bd");
            JOptionPane.showMessageDialog(null, e );
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean registrarEmpleado(Cliente c){
        try{
            conn = ConectarBD.abrir();
            stm = conn.createStatement();
            String sql = "call registrarCliente('"+c.getUsuario()+"','"+c.getEmail()+"', '"+c.getPassw()+"', "+c.getNombre()+")";
            JOptionPane.showMessageDialog(null, sql);
            stm.executeUpdate(sql);
        }catch(Exception e){
            System.out.println("Error en la bd");
            JOptionPane.showMessageDialog(null, e );
            e.printStackTrace();
            return false;
        }
        return true;
    }
   
}