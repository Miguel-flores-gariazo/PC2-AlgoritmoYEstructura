
package Clases;

public class Tarea {
 private String nombre;
    private String descripcion;
    private Categoria categoria;
    private Prioridad prioridad;
    private Tarea siguiente;

    public Tarea(String nombre, String descripcion, Categoria categoria, Prioridad prioridad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.prioridad = prioridad;
        this.siguiente = null;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public Categoria getCategoria() { return categoria; }
    public Prioridad getPrioridad() { return prioridad; }
    public Tarea getSiguiente() { return siguiente; }
    public void setSiguiente(Tarea siguiente) { this.siguiente = siguiente; }

    @Override
    public String toString() {
        return nombre + " - " + descripcion + " [" + categoria + ", " + prioridad + "]";
    }
}