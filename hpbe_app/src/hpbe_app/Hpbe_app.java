package hpbe_app;

import static hpbe_app.ConectarBD.usuario;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hpbe_app {

    
    // Esta app utilice todas las clases de nuestra pagina web 
    public static void main(String[] args) {
        // Inicializo todas las variables que vos a utilizar
            String modelos = null;
            Enum_modelos m = null;
            String nombre_pc = "";
            int cantidad = 0;
            double precio = 0;
            int categoria = 0;
            int rgb = 0;
            int c_i = 0;
            int all_in_one = 0;
            int refri_liquid = 0;
            
            GestorBD bd = new GestorBD();
            Venta venta = new Venta();
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Registrar[1] Login[2] Cerrar[0]");
            int opc = 1;
            while(opc >=0 || opc <=2){
                opc = sc.nextInt();
                switch(opc){ //Simple Switch para decidir si se quiere registrar, se quiere logear o Cerrar.
                    case 1:
                        System.out.println("Ingrese su nombre: ");
                        String n = sc.next();
                        System.out.println("Ingrese su usuario: ");
                        String u = sc.next();
                        System.out.println("Ingrese su contraseña: ");
                        String p = sc.next();
                        System.out.println("Ingrese su DNI: ");
                        int d = sc.nextInt();
                        System.out.println("Ingrese su email: ");
                        String e = sc.next();
                        Empleado empleado = new Empleado(n, u, p, d, e);
                        bd.registrarEmpleado(empleado); // Metodo para registrar al empleado en la Base de Datos
                        break;
                    case 2:
                        System.out.println("Ingrese su usuario");
                        u = sc.next();
                        System.out.println("Ingrese su contraseña: ");
                        p = sc.next();
                        bd.loginEmpleado(u, p); // Metodo para logear con ayuda de la Base de Datos
                        break;
                    case 0:
                        System.out.println("Hasta luego!!");
                        break;
                    case default:
                        System.out.println("Has ingresado una opcion incorrecta.");   
                        break;
                }
            }
            System.out.println("Ingrese el nombre del cliente al que le hara la factura: ");
            String cliente = sc.next();
            
            ResultSet tabla_pc = bd.obtenerPC(nombre_pc); //Recorro toda la tabla PC para ir añadiendolo al array de pcs en Venta
            try {
                while(tabla_pc.next()){
                nombre_pc = tabla_pc.getString("nombre_pc");
                modelos = tabla_pc.getString("modelo");
                precio = tabla_pc.getInt("precio");
                categoria = tabla_pc.getInt("id_categoria");
                c_i = tabla_pc.getInt("cant_comp_importados");
                rgb = tabla_pc.getInt("rgb");
                all_in_one = tabla_pc.getInt("all_in_one");
                refri_liquid = tabla_pc.getInt("refri_liquid");
                
                switch(categoria){ // Este switch sirve para determinar que categoria de PC es dependiendo de un campo que esta en la Base de Datos
                case 1:
                    PC_Oficina pc_Oficina = new PC_Oficina(nombre_pc, precio, m.obtener_modelo(modelos), c_i, all_in_one);
                    precio = pc_Oficina.calcularPrecio();
                    venta.añadirPC(pc_Oficina);
                case 2:
                    PC_Gamer pc_Gamer = new PC_Gamer(nombre_pc, precio,  m.obtener_modelo(modelos), c_i, rgb, refri_liquid);
                    precio = pc_Gamer.calcularPrecio();
                    venta.añadirPC(pc_Gamer);
                case 3:
                    PC_Diseño pc_Diseño = new PC_Diseño(nombre_pc, precio,  m.obtener_modelo(modelos), c_i);
                    precio = pc_Diseño.calcularPrecio();
                    venta.añadirPC(pc_Diseño);
            }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Hpbe_app.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            System.out.println(venta.emitirFactura());
    }
}
