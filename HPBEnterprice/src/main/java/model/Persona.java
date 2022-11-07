
package model;


public class Persona {
    private String nombre;
    private String usuario;
    private String passw;
    private int DNI;
    private String email;
    private boolean activo;

    public Persona(String nombre, String usuario, String passw, int DNI, String email) {
 
        this.nombre = nombre;
        this.usuario = usuario;
        this.passw = passw;
        this.DNI = DNI;
        this.email = email;
    }

    public Persona(String usuario, String passw) {
        this.usuario = usuario;
        this.passw = passw;
        
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
    @Override
    public String toString() {
        return  nombre + usuario + passw + DNI + email;
    }
    
    
}
