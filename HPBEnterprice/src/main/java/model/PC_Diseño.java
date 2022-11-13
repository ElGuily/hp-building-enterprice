/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ET36
 */
public class PC_Diseño extends PCs {
    public PC_Diseño(String nombre, double valor_PC, Enum_modelos modelo, int c_i) {
        super(nombre, valor_PC, modelo, c_i);
    }
    
    public PC_Diseño(String nombre,double valor_PC, Enum_modelos modelo ){
        super(nombre, valor_PC, modelo);
    }
    
    public double calcularPrecio(){
        if (this.valor_PC == 0){
            this.valor_PC = 45000;
        }
        return this.valor_PC;
    }
    
    
}
