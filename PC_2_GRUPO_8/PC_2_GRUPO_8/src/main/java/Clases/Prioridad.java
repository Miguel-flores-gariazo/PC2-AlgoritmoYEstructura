
package Clases;

public class Prioridad {
    private int nivel;
    private String nombre;

    public Prioridad(int nivel, String nombre) {
        this.nivel = nivel;
        this.nombre = nombre;
    }

    public int getNivel() { return nivel; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return nombre;
    }
}
