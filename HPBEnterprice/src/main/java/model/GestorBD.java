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
    

    
    public void registrarUsuario(Cliente c){
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call registrarUsuario('"+c.getUsuario()+"','"+c.getPassw()+"')";
            this.stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, sql);
        }catch(SQLException e){
            System.out.println("Error en la bd");
            
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e );
        }
    }
    
    public int loginUsuario(String nombre, String passw){
         ResultSet rs = null;
         int valor = 0;
         try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "select loginUsuario('"+nombre+"','"+passw+"') as login";      
            rs = stm.executeQuery(sql);
            if(rs.next()){
                valor = rs.getInt("login");
                return valor;
            }
    
            
           
        }catch(SQLException e){
            System.out.println("Error en la bd");
            JOptionPane.showMessageDialog(null, e );
            e.printStackTrace();
            
        }
         
        return valor;
    }
    
    public int loginEmpleado(String nombre, String passw){
         ResultSet rs = null;
         int valor = 0;
         try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "select loginEmpleado('"+nombre+"','"+passw+"') as login";      
            rs = stm.executeQuery(sql);
            if(rs.next()){
                valor = rs.getInt("login");
                return valor;
            }
    
            
           
        }catch(SQLException e){
            System.out.println("Error en la bd");
            JOptionPane.showMessageDialog(null, e );
            e.printStackTrace();
            
        }
         
        return valor;
    }
    
    public void registrarEmpleado(Empleado e){
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call registrarEmpleado('"+e.getUsuario()+"','"+e.getEmail()+"', '"+e.getPassw()+"', "+e.getDNI()+", '"+e.getNombre()+"')";
            this.stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, sql);
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex );
        }
    }
    
    public ResultSet verCompu(int type){
        ArrayList<PCs> pcs = new ArrayList<PCs>();
        ResultSet pc = null;
        try{
            
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call verCompu("+type+");";
           pc = this.stm.executeQuery(sql);

           
            
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "error en ver compu / gestorBD" + ex );
        }
        
      return pc;
    }
    
    public void registrarPC(String nom, String cat, double precio, Enum_modelos modelo, int imp, boolean rgb, boolean all_in_one, boolean refri){
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call registrarPC('"+nom+"', '"+modelo+"', '"+cat+"', "+precio+", "+imp+", "+rgb+", "+all_in_one+","+refri+")";
            this.stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, sql);
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex );
        }
    }
    
  
   
}