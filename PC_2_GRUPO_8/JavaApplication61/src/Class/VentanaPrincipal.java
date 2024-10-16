
package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// Clase VentanaPrincipal
class VentanaPrincipal {
    private GestorTareas gestor;
    private JFrame frame;
    private JTextArea tareaArea;
    private JTextField nombreField;
    private JTextField descripcionField;
    private JComboBox<Categoria> categoriaComboBox;
    private JComboBox<Prioridad> prioridadComboBox;

    public VentanaPrincipal(GestorTareas gestor) {
        this.gestor = gestor;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        frame = new JFrame("Lista de Pendientes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        tareaArea = new JTextArea();
        tareaArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(tareaArea);

        // Panel de entrada
        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new GridLayout(5, 2));

        panelEntrada.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        panelEntrada.add(nombreField);

        panelEntrada.add(new JLabel("Descripción:"));
        descripcionField = new JTextField();
        panelEntrada.add(descripcionField);

        panelEntrada.add(new JLabel("Categoría:"));
        categoriaComboBox = new JComboBox<>(new Categoria[]{
            new Categoria("Personal", "Tareas personales"),
            new Categoria("Trabajo", "Tareas laborales"),
            new Categoria("Estudio", "Tareas de estudio")
        });
        panelEntrada.add(categoriaComboBox);

        panelEntrada.add(new JLabel("Prioridad:"));
        prioridadComboBox = new JComboBox<>(new Prioridad[]{
            new Prioridad(1, "Alta"),
            new Prioridad(2, "Media"),
            new Prioridad(3, "Baja")
        });
        panelEntrada.add(prioridadComboBox);

        JButton btnAgregar = new JButton("Agregar Tarea");
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarTarea();
            }
        });

        JButton btnEliminar = new JButton("Eliminar Tarea");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarTarea();
            }
        });

        JButton btnMostrar = new JButton("Mostrar Tareas");
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTareas();
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnMostrar);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panelEntrada, BorderLayout.NORTH);
        frame.add(panelBotones, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void agregarTarea() {
        String nombre = nombreField.getText();
        String descripcion = descripcionField.getText();
        Categoria categoria = (Categoria) categoriaComboBox.getSelectedItem();
        Prioridad prioridad = (Prioridad) prioridadComboBox.getSelectedItem();

        if (!nombre.isEmpty() && !descripcion.isEmpty()) {
            Tarea tarea = new Tarea(nombre, descripcion, categoria, prioridad);
            gestor.agregarTarea(tarea);
            JOptionPane.showMessageDialog(frame, "Tarea agregada.");
        } else {
            JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.");
        }
    }

    private void eliminarTarea() {
        String nombre = JOptionPane.showInputDialog(frame, "Ingrese el nombre de la tarea a eliminar:");
        if (nombre != null) {
            gestor.eliminarTarea(nombre);
            JOptionPane.showMessageDialog(frame, "Tarea eliminada (si existía).");
        }
    }

    private void mostrarTareas() {
        tareaArea.setText(""); // Limpiar el área de texto
        StringBuilder sb = new StringBuilder();
        Tarea actual = gestor.lista.cabeza; // Acceso directo a la cabeza de la lista
        while (actual != null) {
            sb.append(actual).append("\n");
            actual = actual.getSiguiente();
        }
        tareaArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        new VentanaPrincipal(gestor);
    }
}
