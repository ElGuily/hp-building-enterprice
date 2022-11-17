/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;


/**
 *
 * @author ET36
 */
public enum Enum_modelos {
    //Modelos de PCs disponibles.
    
    Elite600("Elite600"), ProOne("ProOne"), Elite800("Elite800"), ProDesk400("ProDesk400"), miniHPpro400("miniHPpro400"), HP2004("HP2004"); 
    String nombre_modelo;

    private Enum_modelos(String nombre_modelo) {
        this.nombre_modelo = nombre_modelo;       
    }

    public String getNombre_modelo() {
        return nombre_modelo;
    }

    public void setNombre_modelo(String nombre_modelo) {
        this.nombre_modelo = nombre_modelo;
    }
    
    public Enum_modelos obtener_modelo(String modelo_pc){
     
        Enum_modelos m = null;
       
        if(Elite600.equals(modelo_pc)){
            m = Elite600;
       }else if(Elite800.equals(modelo_pc)){
            m = Elite800;
       }else if(HP2004.equals(modelo_pc)){
            m = HP2004;
       }else if(ProDesk400.equals(modelo_pc)){
            m = ProDesk400;
       }else if(ProOne.equals(modelo_pc)){
            m = ProOne;
       }else if(miniHPpro400.equals(modelo_pc)){
           m = miniHPpro400;
       }
        return m;
    }
    
    
    
    
    
}
