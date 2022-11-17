
package model;

public class Cliente extends Persona{
    private Direccion direccion;

    public Cliente(Direccion direccion, String nombre, String usuario, String passw, String DNI, String email) {
        super( nombre, usuario, passw, DNI, email);
        this.direccion = direccion;
    }
    
    public Cliente(String usuario, String passw){
        super(usuario, passw);
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }


    @Override
    public String toString() {
        return "";
    }
    
    
    
}
