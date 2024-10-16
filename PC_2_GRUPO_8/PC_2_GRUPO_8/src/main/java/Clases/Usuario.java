
package Clases;


public class Usuario {
    private String nombre;
    private GestorTareas gestor;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.gestor = new GestorTareas();
    }

    public void agregarTarea(Tarea tarea) {
        gestor.agregarTarea(tarea);
    }

    public void eliminarTarea(String nombre) {
        gestor.eliminarTarea(nombre);
    }

    public void mostrarTareas() {
        gestor.mostrarTareas();
    }

    public void buscarTarea(String nombre) {
        Tarea tarea = gestor.lista.buscarTarea(nombre);
        if (tarea != null) {
            System.out.println("Tarea encontrada: " + tarea);
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }

    public void listarTareasPorCategoria(String categoria) {
        gestor.lista.listarPorCategoria(categoria);
    }

    public void listarTareasPorPrioridad(int nivel) {
        gestor.lista.listarPorPrioridad(nivel);
    }
}

