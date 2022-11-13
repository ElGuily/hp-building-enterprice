package model;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ET36
 */
public class Venta {
    private int id_venta;
    Cliente cliente;
    Empleado empleado;
    ArrayList<PCs> PCs;
    
    public Venta(Cliente c, Empleado e){
        
        this.cliente = c;
        this.empleado = e;
        this.PCs = new ArrayList<PCs>();
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
        factura += "Total: " + calcularTotal() + "\n";
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
    
    public double calcularTotal(){
        double total = 0;
        
        for(PCs pc: this.PCs){
            total += pc.calcularPrecio();
        }
        
        return total;
    }
}
