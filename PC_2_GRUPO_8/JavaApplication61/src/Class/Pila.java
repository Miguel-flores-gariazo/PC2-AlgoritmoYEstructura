
package Clases;


public class Pila {
 private Tarea tope;

    public void push(Tarea tarea) {
        tarea.setSiguiente(tope);
        tope = tarea;
    }

    public Tarea pop() {
        if (tope == null) return null;
        Tarea tarea = tope;
        tope = tope.getSiguiente();
        return tarea;
    }

    public void mostrarPila() {
        Tarea actual = tope;
        while (actual != null) {
            System.out.println(actual);
            actual = actual.getSiguiente();
        }
    }

    public Tarea peek() {
        return tope;
    }
}