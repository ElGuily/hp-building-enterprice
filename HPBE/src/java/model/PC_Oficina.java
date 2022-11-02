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
    
    private boolean all_in_one;

    public PC_Oficina(boolean all_in_one, int id_pc, double valor_PC, int componentes_imp) {
        super(id_pc, valor_PC);
        this.all_in_one = all_in_one;
    }
    
    @Override
    public double calcularPrecio() {
        if(this.all_in_one){
            this.valor_PC+=5000;
        }
        return this.valor_PC;
    }
    
}
