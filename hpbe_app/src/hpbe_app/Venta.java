package hpbe_app;

import java.util.ArrayList;

// Clase para almacenar los pedidos de los usuarios


public class Venta {
    private int id_venta;
    private static int nro_venta;
    Cliente cliente;
    Empleado empleado;
    ArrayList<PCs> PCs;
    private double total;
    public Venta(Cliente c, Empleado e, double total){
        
        this.cliente = c;
        this.empleado = e;
        this.PCs = new ArrayList<PCs>();
        this.id_venta = ++this.nro_venta;
        this.total = total;
    }
    
    public Venta(){
        this.id_venta = ++this.nro_venta;
        this.PCs = new ArrayList<PCs>();
    }
    
    public String emitirFactura(){
        String factura = "";
        
        factura +="Factura n° " + this.id_venta + "\n";
        factura +="----------------------------- \n";
        factura +="PCs compradas: \n";
        for(PCs pc: this.PCs){
            factura += pc.toString();
        }
        
        factura += "----------------------------- \n";
        factura += "¡Gracias por su compra!";
        
        return factura;
    }
    
    public void añadirPC(PCs pc){
        
        this.PCs.add(pc);
        
    }
    
    public void eliminarPC(int position){
        
        this.PCs.remove(position-1);
        
    }
    
    public double calcularTotal(String user, GestorBD gbd){
        double total = 0;
        for(PCs pc: this.PCs){
            total += pc.valor_PC;
        }
        if(gbd.contarCliente(user)==1){
            return total -= total*0.05;
        }
        return total;
    }

    public ArrayList<PCs> getPCs() {
        return PCs;
    }

    public void setPCs(ArrayList<PCs> PCs) {
        this.PCs = PCs;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public static int getNro_venta() {
        return nro_venta;
    }

    public static void setNro_venta(int nro_venta) {
        Venta.nro_venta = nro_venta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    
    
    
}
