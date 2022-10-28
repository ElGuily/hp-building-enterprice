/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author ET36
 */
public class PC_Diseño extends PCs {

    
    
    
    public PC_Diseño(int id_pc, Enum_modelos modelo, double valor_PC, int c_i) {
        super(id_pc, modelo, valor_PC, c_i);
    }
    
    public double calcularPrecio(){
        if (this.valor_PC == 0){
            this.valor_PC = 45000;
        }
        return this.valor_PC;
    }
    
    
}
