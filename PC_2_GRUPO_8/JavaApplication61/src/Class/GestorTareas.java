
package Clases;

public class GestorTareas {
    ListaTareas lista;
    private Pila pila;

    public GestorTareas() {
        lista = new ListaTareas();
        pila = new Pila();
    }

    public void agregarTarea(Tarea tarea) {
        lista.agregarTarea(tarea);
    }

    public void eliminarTarea(String nombre) {
        lista.eliminarTarea(nombre);
    }

    public void mostrarTareas() {
        lista.mostrarTareas();
    }

    public void crearPila() {
        Tarea actual = lista.cabeza; // Asumiendo que tienes acceso a la cabeza
        while (actual != null) {
            pila.push(actual);
            actual = actual.getSiguiente();
        }
    }

    public void vaciarTareas() {
        lista = new ListaTareas(); // Reiniciar la lista de tareas
    }
}
