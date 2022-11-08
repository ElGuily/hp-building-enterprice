/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ET36
 */
public class Empleado extends Persona {
    
    private ArrayList<Venta> pedido;
    private double facturado;

    public Empleado(ArrayList<Venta> pedido, double facturado, String nombre, String usuario, String passw, int DNI, String email) {
        super(nombre, usuario, passw, DNI, email);
        this.pedido = pedido;
        this.facturado = facturado;
    }
    
    public Empleado(String nombre, String usuario, String passw, int DNI, String email){
         super(nombre, usuario, passw, DNI, email);
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
        this.facturado = facturado;
    }

    @Override
    public String toString() {
        return "Pedidos: "+pedido.toString()+"\nFacturado: "+facturado;
    }
    
    
    
}