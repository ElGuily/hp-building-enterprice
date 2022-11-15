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
import java.util.Calendar;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author ET36
 */
public class GestorBD {
    Connection conn = null;
    Statement stm = null;
    private ArrayList<String> comandos = new ArrayList<>();

    
    

    
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
     
     public void registrarCarrito(String nom, String usuario, double valor, double comision){
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call registrarCarrito('"+nom+"', '"+usuario+"', "+valor+", "+comision+")";
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
   
     
    public void aumentarPC(String nombre, int cant){
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call aumentarPC('"+nombre+"', "+cant+")";
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
   public void actualizarPrecioCarrito(int cant, String nombre, String usuario){
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call actualizarPrecioCarrito("+cant+", '"+nombre+"', '"+usuario+"')";
            this.stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, sql);
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex );
        }
    }
   
   public void actualizarComision(double comision, String nombre, String usuario){
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call actualizarComision("+comision+", '"+nombre+"', '"+usuario+"')";
            this.stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, sql);
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex );
        }
    }
   
   public double obtenerTotalComision(){
        
        double totalComisiones = 0;
        
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call obtenerTotalComision()";
            ResultSet pc = this.stm.executeQuery(sql);
            if(pc.next()){
                totalComisiones = pc.getDouble("total");
            }
            JOptionPane.showMessageDialog(null, sql);            
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,  "totalComision" +ex );
        }
        return totalComisiones;
    }
   
   
   public void registrarCliente(String email, String dni, String nombre, String direccion, String user){
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call registrarCliente('"+email+"', '"+dni+"', '"+nombre+"', '"+direccion+"', '"+user+"')";
            this.stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, sql);
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "registrarCliente" +ex );
        }
    }
   
   public void registrarVenta(String empleado, String usuario, double total){
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String fecharda = calcularFecha();
            String sql = "call registrarVenta('"+empleado+"', '"+usuario+"', "+total+", '"+fecharda+"')";
            this.stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, sql);
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "RegistrarVenta" + ex );
        }
    }
   
   public double contarCliente(String nombre){
        
        double clientesTotales = 0;
        
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call contarClientes('"+nombre+"')";
            ResultSet cant = this.stm.executeQuery(sql);
            if(cant.next()){
                clientesTotales = cant.getDouble("cant");
            }
            JOptionPane.showMessageDialog(null, sql);            
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ContarCliente" + ex );
        }
        return clientesTotales;
    }
   
   public double calcularCiberMonday(){
        
        double totalCiber = 0;
        
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call calcularCiberMonday()";
            ResultSet total = this.stm.executeQuery(sql);
            if(total.next()){
                totalCiber = total.getDouble("total");
            }
            JOptionPane.showMessageDialog(null, sql);            
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ContarCliente" + ex );
        }
        return totalCiber;
    }
   
   public ResultSet obtenerVentas(String user){
        ResultSet venta = null;
        try{
            this.conn = ConectarBD.abrir();
            this.stm = this.conn.createStatement();
            String sql = "call obtenerVentas('"+user+"')";
            venta = this.stm.executeQuery(sql);
            JOptionPane.showMessageDialog(null, sql);
        }catch(SQLException ex){
            System.out.println("Error en la bd");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ObtenerEmp" + ex );
        }
        return venta;
    }
   
    Calendar unaFecha;
        public String calcularFecha() {
            int numero = 0;
            Random aleatorio;
            aleatorio = new Random();

            unaFecha = Calendar.getInstance();
            unaFecha.set (2022, 12, aleatorio.nextInt(2)+1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           
            return sdf.format(unaFecha.getTime());
        }
        
    
   
   
   
}