    package model;

import controller.compraFinal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            String sql = "call registrarEmpleado('"+e.getUsuario()+"','"+e.getEmail()+"', '"+e.getPassw()+"', "+e.getDNI()+", '"+e.getNombre()+"', 0)";
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
    
    public void registrarPC(String nom, String cat, double precio, String modelo, int imp, boolean rgb, boolean all_in_one, boolean refri){
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
    
    public void eliminarPC(String nombre){
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call eliminarPC('"+nombre+"')";
            this.stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, sql);
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "EliminarPC" + ex );
        }
    }
    
    public ResultSet obtenerEmpleado(String user, String passw){
        ResultSet emp = null;
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call obtenerEmpleado('"+user+"', '"+passw+"')";
            emp = this.stm.executeQuery(sql);
            JOptionPane.showMessageDialog(null, sql);
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ObtenerEmp" + ex );
        }
        return emp;
    }
    
     public ResultSet obtenerPC(String nombre){
        ResultSet pc = null;
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call obtenerPC('"+nombre+"')";
            pc = this.stm.executeQuery(sql);
            JOptionPane.showMessageDialog(null, sql);
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ObtenerPC" + ex );
        }
        return pc;
    }
     
     public void registrarCarrito(String nom, String usuario){
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call registrarCarrito('"+nom+"', '"+usuario+"')";
            this.stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, sql);
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex );
        }
    }
     
     public ResultSet obtenerCarrito(String usuario){
        ResultSet pc = null;
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call obtenerCarrito('"+usuario+"')";
            pc = this.stm.executeQuery(sql);
            JOptionPane.showMessageDialog(null, sql);
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ObtenerPC" + ex );
        }
        return pc;
    }
  
     public ResultSet obtenerEmpleadoAlAzar(int id){
        ResultSet pc = null;
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call obtenerEmpleadoAlAzar("+id+")";
            pc = this.stm.executeQuery(sql);
            JOptionPane.showMessageDialog(null, sql);
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ObtenerPC" + ex );
        }
        return pc;
    }
     
    public int totalEmpleados(){
        int cantidad = 0;
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call totalEmpleado()";
            ResultSet emp = this.stm.executeQuery(sql);
            JOptionPane.showMessageDialog(null, sql);
            try {
                while(emp.next()){
                    cantidad = emp.getInt("cant");
                }
            } catch (SQLException ex) {
                Logger.getLogger(compraFinal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ObtenerPC" + ex );
        }
        return cantidad;
    }
    
    public void actualizarFacturado(int id, double facturado){
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call actualizarFacturado("+id+", "+facturado+")";
            this.stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, sql);
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex );
        }
    }
     public void eliminarDelCarrito(String nombre){
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call eliminarDelCarrito('"+nombre+"')";
            this.stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, sql);
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "EliminarPC" + ex );
        }
    }
   
     
    public void aumentarPC(String nombre){
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call aumentarPC('"+nombre+"')";
            this.stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, sql);
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex );
        }
    }
    
    public ResultSet PCmasVendida(){
        
        ResultSet pc = null;
        
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call PCmasVendida()";
            pc = this.stm.executeQuery(sql);
            JOptionPane.showMessageDialog(null, sql);            
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,  ex );
        }
        return pc;
    }
    
    
    
    public void actualizarCantidadCarrito(String nombre, String usuario){
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call actualizarCantidadCarrito('"+nombre+"', '"+usuario+"')";
            this.stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, sql);
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex );
        }
    }
    
   public ResultSet comprobarCantidad(String nombre, String usuario){
        
        ResultSet pc = null;
        
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call comprobarCantidad('"+nombre+"', '"+usuario+"')";
            pc = this.stm.executeQuery(sql);
            JOptionPane.showMessageDialog(null, sql);            
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,  ex );
        }
        return pc;
    }
   
}