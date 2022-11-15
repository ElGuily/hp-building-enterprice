/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 *
 * @author ET36
 */
public interface Importable {
    
    //Permite calcular el valor agregado dependiendo la cantidad de componenetes importados
    public abstract double calcularImpuesto(double comision);
}
