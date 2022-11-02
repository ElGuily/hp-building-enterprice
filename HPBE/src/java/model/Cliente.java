
package model;

public class Cliente extends Persona{
    private Direccion direccion;
    private int cantidad_compras;

    public Cliente(Direccion direccion, int cantidad_compras, int id_persona, String nombre, String usuario, String passw, int DNI, String email) {
        super(id_persona, nombre, usuario, passw, DNI, email);
        this.direccion = direccion;
        this.cantidad_compras = cantidad_compras;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public int getCantidad_compras() {
        return cantidad_compras;
    }

    public void setCantidad_compras(int cantidad_compras) {
        this.cantidad_compras = cantidad_compras;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cantidad_compras=" + cantidad_compras + '}';
    }
    
    
    
}
