/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ET36
 */
public abstract class PCs {
    private String nombre;
    double  valor_PC;
    private Enum_modelos modelo;
    private int componentes_imp;
    
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

    public PCs( double valor_PC) {
        
        this.valor_PC = valor_PC;
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
    
    
    
    
    
    public abstract double calcularPrecio();
    
    
}
