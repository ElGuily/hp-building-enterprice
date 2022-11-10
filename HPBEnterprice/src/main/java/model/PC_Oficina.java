/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ET36
 */
public class PC_Oficina extends PCs {
    
    private int all_in_one;

    public PC_Oficina(String nombre, double valor_PC,  Enum_modelos modelo, int c_i, int all_in_one ) {
        super(nombre, valor_PC, modelo, c_i);
        this.all_in_one = all_in_one;
    }
    
    public PC_Oficina(String nombre, double valor_PC, Enum_modelos modelo, int c_i){
        super(nombre, valor_PC, modelo, c_i);
    }
    
    @Override
    public double calcularPrecio() {
        if(this.all_in_one==1){
            this.valor_PC+=5000;
        }
        return this.valor_PC;
    }
    
}
