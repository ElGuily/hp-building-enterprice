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
    private int RGB;
    private int refrigeracion_liquida;

    public PC_Gamer(String nombre ,double valor_PC,  Enum_modelos modelo, int c_i,int RGB, int refrigeracion_liquida) {
        super(nombre, valor_PC, modelo, c_i);
        this.RGB = RGB;
        this.refrigeracion_liquida = refrigeracion_liquida;
    }
    
    public PC_Gamer(String nombre, double valor_PC, Enum_modelos modelo, int c_i){
        super(nombre, valor_PC, modelo, c_i);
    }
    
    public PC_Gamer(String nombre,double valor_PC, Enum_modelos modelo ){
        super(nombre, valor_PC, modelo);
    }
    public double calcularPrecio(){
        int valorAgregado=0;
        
        if (this.RGB==1){
            valorAgregado+=1500;
        }
        if (this.refrigeracion_liquida==1){
            valorAgregado+=1500;
        }
        
        return this.valor_PC+valorAgregado;
    }
}
