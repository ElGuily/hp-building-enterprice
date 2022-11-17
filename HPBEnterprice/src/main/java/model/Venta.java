package model;

import java.util.ArrayList;

// Clase para almacenar los pedidos de los usuarios


public class Venta {
    private int id_venta;
    private static int nro_venta;
    Cliente cliente;
    Empleado empleado;
    ArrayList<PCs> PCs;
    private double total;
    
    public Venta(Cliente cliente, Empleado empleado, double total){
        this.id_venta = ++nro_venta;
        this.cliente = cliente;
        this.empleado = empleado;
        this.PCs = new ArrayList<PCs>();
        this.total = total;
    }
    
    public Venta(){
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
    
    public double calcularTotal(String user){
        double total = 0;
        GestorBD gbd = new GestorBD();
        for(PCs pc: this.PCs){
            total += pc.valor_PC;
        }
        if(gbd.contarCliente(user)==1){
            total -= total*0.05;
            double totalConDescuento = total;
            return totalConDescuento;
            
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
