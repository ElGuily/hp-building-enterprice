/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author ET36
 */
public class Empleado extends Persona {
    
    private ArrayList<Venta> pedido;
    private double facturado;

    public Empleado( double facturado, String nombre, String usuario, String passw, int DNI, String email) {
        super(nombre, usuario, passw, DNI, email);
        
        this.facturado = facturado;
    }
    
    public Empleado(String nombre, String usuario, String passw, int DNI, String email){
         super(nombre, usuario, passw, DNI, email);
    }
    public Empleado(String nombre,String email, double facturado){
        super(nombre, email);

        this.facturado = facturado;
        
        
    }
    
    public Empleado(String usuario, String passw){
        super(usuario, passw);
    }
    public ArrayList<Venta> getPedido() {
        return pedido;
    }

    public void setPedido(ArrayList<Venta> pedido) {
        this.pedido = pedido;
    }

    public double getFacturado() {
        return facturado;
    }

    public void setFacturado(double facturado) {
        this.facturado += facturado;
    }

    @Override
    public String toString() {
        return "Pedidos: "+pedido.toString()+"\nFacturado: "+facturado;
    }

    
    
    
}
