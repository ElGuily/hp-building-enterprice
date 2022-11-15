
package model;

public class Direccion {
    private String calle;
    private int numero;
    private String localidad;

        public Direccion(String calle, int numero, String localidad) {
            this.calle = calle;
            this.numero = numero;
            this.localidad = localidad;
        }

        public String getCalle() {
            return calle;
        }

        public void setCalle(String calle) {
            this.calle = calle;
        }

        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        public String getLocalidad() {
            return localidad;
        }

        public void setLocalidad(String localidad) {
            this.localidad = localidad;
        }

        @Override
        public String toString() {
            return this.calle + " " + this.numero + " " + this.localidad;

    }
}
