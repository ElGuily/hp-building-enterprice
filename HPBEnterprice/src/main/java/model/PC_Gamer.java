/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ET36
 */
public class PC_Gamer extends PCs{
    private boolean RGB;
    private boolean refrigeracion_liquida;

    public PC_Gamer(String nombre,Enum_modelos modelo, double valor_PC, int c_i,boolean RGB, boolean refrigeracion_liquida) {
        super(nombre, valor_PC, modelo, c_i);
        this.RGB = RGB;
        this.refrigeracion_liquida = refrigeracion_liquida;
    }
    
    public PC_Gamer(String nombre, double valor_PC, Enum_modelos modelo, int c_i){
        super(nombre, valor_PC, modelo, c_i);
    }
    public double calcularPrecio(){
        int valorAgregado=0;
        
        if (this.RGB){
            valorAgregado+=1500;
        }
        if (this.refrigeracion_liquida){
            valorAgregado+=1500;
        }
        
        return this.valor_PC+valorAgregado;
    }
}
