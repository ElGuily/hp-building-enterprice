/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author ET36
 */
public abstract class PCs {
    private int id_pc;
    double valor_PC;
    private Enum_modelos modelo;
    private int componentes_imp;

    public PCs(int id_pc, double valor_PC, int componentes_imp) {
        this.id_pc = id_pc;
        this.valor_PC = valor_PC;
        this.componentes_imp = componentes_imp;
    }

    public PCs(int id_pc, double valor_PC) {
        this.id_pc = id_pc;
        this.valor_PC = valor_PC;
    }
    
    
    
    public abstract double calcularPrecio();
    
    
}
