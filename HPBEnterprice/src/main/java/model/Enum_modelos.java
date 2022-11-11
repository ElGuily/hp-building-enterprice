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
    
    
    
    
    
}
