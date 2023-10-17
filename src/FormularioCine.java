import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FormularioCine {
    private JPanel principal;
    private JComboBox cboPelicula;
    private JComboBox cboCantidad;
    private JButton cboComprar;
    private JTextArea txtEntradas;
    private JButton btnPelicula1;
    private JButton btnPelicula2;
    private JLabel txtAutor;
    private Cine cine = new Cine();
    private int entradasDisponibles;

    public FormularioCine() {
        try {
        String a="",b="";
        do {
            b= JOptionPane.showInputDialog("Ingrese su número de cédula real");
            a = JOptionPane.showInputDialog("Ingrese su nombre real");
        }while(b.length()<10);
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Taller1ProgramacionIII.dat"));
            o.writeObject(a+b);
        }catch (Exception ex) {

        }
        cboComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cboComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pelicula = cboPelicula.getSelectedItem().toString();
                int cantidad = Integer.parseInt(cboCantidad.getSelectedItem().toString());
                Asistente asistente = new Asistente(pelicula, cantidad);
                try {
                    cine.encolar(asistente); // Agregamos el asistente a la cola del cine.
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                txtEntradas.append(asistente.toString() + "\n"); // Mostramos la compra en el TextArea.
                actualizarEntradasDisponibles();
            }
        });

        btnPelicula1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Entradas disponibles para Película 1: "+entradasDisponibles);
            }
        });

        btnPelicula2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Entradas disponibles para Película 2: " + entradasDisponibles);
            }
        });
    }
    private void actualizarEntradasDisponibles() {
        entradasDisponibles = cine.entradasDisponibles(Integer.parseInt(cboCantidad.getSelectedItem().toString()));
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cine");
        frame.setContentPane(new FormularioCine().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
