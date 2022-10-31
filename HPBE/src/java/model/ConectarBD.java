package model;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author ET36
 */
public class ConectarBD {
    public static Connection con;
    private static String bd= "HPBE";
    public static String usuario = "root";
    public static String passw = "";
    public static String url = "jdbc:mysql://localhost/"+bd;
    
    public static Connection abrir(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,usuario,passw);
            
        }catch(Exception e){
            System.out.println("Error en la conexion");
            e.printStackTrace();
        }
        return con;
    }
    
    public static void cerrar(){
        try{
            if(con!=null)
                con.close();   
            
        }catch(Exception e){
            System.out.println("Error no se logro cerrar conecion");
        }
    }
}