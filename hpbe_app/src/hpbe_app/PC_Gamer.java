/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hpbe_app;

/**
 *
 * @author ET36
 */
public class PC_Gamer extends PCs{
    // A la pc gamer se le puede añadir la opcion de que la misma tenga RGB (luces) y refrigeracion liquida, lo cual aumenta su valor.
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
    
    public PC_Gamer(String nombre,double valor_PC, Enum_modelos modelo, int RGB, int refrigeracion_liquida){
        super(nombre, valor_PC, modelo);
         this.RGB = RGB;
        this.refrigeracion_liquida = refrigeracion_liquida;

    }
    
    @Override
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
