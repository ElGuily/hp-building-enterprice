/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hpbe_app;

/**
 *
 * @author ET36
 */

// Clase padre de las clases PC_Oficina, PC_Diseño, PC_Gamer

public abstract class PCs implements Importable{
    private String nombre;
    double  valor_PC;
    private Enum_modelos modelo;
    private int componentes_imp; // Permite almacenar la cantidad de productos importados que contiene la pc. Por los cuales se cobran impuestos.
    
    
    public PCs( String nombre, double valor_PC, Enum_modelos modelo, int componentes_imp) {
        this.nombre = nombre;
        this.valor_PC = valor_PC;
        this.modelo = modelo;
        this.componentes_imp = componentes_imp;
    }

    public PCs(double valor_PC, int componentes_imp) {
        
        this.valor_PC = valor_PC;
        this.componentes_imp = componentes_imp;
    } 

    public PCs(String nombre, double valor_PC, Enum_modelos modelo) {
        this.modelo = modelo;
        this.valor_PC = valor_PC;
        this.nombre = nombre;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValor_PC() {
        return valor_PC;
    }

    public void setValor_PC(double valor_PC) {
        this.valor_PC = valor_PC;
    }

    public Enum_modelos getModelo() {
        return modelo;
    }

    public void setModelo(Enum_modelos modelo) {
        this.modelo = modelo;
    }

    public int getComponentes_imp() {
        return componentes_imp;
    }

    public void setComponentes_imp(int componentes_imp) {
        this.componentes_imp = componentes_imp;
    }
    
   
    @Override
    public double calcularImpuesto(double comision){
        return comision = comision+ (this.componentes_imp*200);
    }
    
    
    public abstract double calcularPrecio();

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n"+
                "Precio:" + valor_PC + "\n"+
                "Modelo:" + modelo;
                
    }
    
    
    
}
