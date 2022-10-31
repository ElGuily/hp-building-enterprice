
package main;


public class Persona {
    private int id_persona;
    private String nombre;
    private String usuario;
    private String passw;
    private int DNI;
    private String email;

    public Persona(int id_persona, String nombre, String usuario, String passw, int DNI, String email) {
        this.id_persona = id_persona;
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

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
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

    @Override
    public String toString() {
        return id_persona + nombre + usuario + passw + DNI + email;
    }
    
    
}
