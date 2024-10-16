
package Clases;

class ListaTareas {
    Tarea cabeza;

    public void agregarTarea(Tarea tarea) {
        tarea.setSiguiente(cabeza);
        cabeza = tarea;
    }

    public void eliminarTarea(String nombre) {
        Tarea actual = cabeza;
        Tarea anterior = null;
        while (actual != null && !actual.getNombre().equals(nombre)) {
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if (actual != null) {
            if (anterior != null) {
                anterior.setSiguiente(actual.getSiguiente());
            } else {
                cabeza = cabeza.getSiguiente();
            }
        }
    }

    public void mostrarTareas() {
        Tarea actual = cabeza;
        while (actual != null) {
            System.out.println(actual);
            actual = actual.getSiguiente();
        }
    }

    public Tarea buscarTarea(String nombre) {
        Tarea actual = cabeza;
        while (actual != null) {
            if (actual.getNombre().equals(nombre)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null; // No encontrada
    }

    public void listarPorCategoria(String categoria) {
        Tarea actual = cabeza;
        while (actual != null) {
            if (actual.getCategoria().getNombre().equals(categoria)) {
                System.out.println(actual);
            }
            actual = actual.getSiguiente();
        }
    }

    public void listarPorPrioridad(int nivel) {
        Tarea actual = cabeza;
        while (actual != null) {
            if (actual.getPrioridad().getNivel() == nivel) {
                System.out.println(actual);
            }
            actual = actual.getSiguiente();
        }
    }
}
