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
        if(m.Elite600.getNombre_modelo().equals(modelo_pc)){
            m = m.Elite600;
       }else if(m.Elite800.getNombre_modelo().equals(modelo_pc)){
            m = m.Elite800;
       }else if(m.HP2004.getNombre_modelo().equals(modelo_pc)){
            m = m.HP2004;
       }else if(m.ProDesk400.getNombre_modelo().equals(modelo_pc)){
            m = m.ProDesk400;
       }else if(m.ProOne.getNombre_modelo().equals(modelo_pc)){
            m = m.ProOne;
       }else if(m.miniHPpro400.getNombre_modelo().equals(modelo_pc)){
           m = m.miniHPpro400;
       }
        return m;
    }
    
    
    
    
    
}
