import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;

public class ListaHospitalSanMung {
    private JPanel PanelGeneral;
    private JTextField txtNombre;
    private JTextField txtPrioridad;
    private JButton agregarButton;
    private JTextArea txtResultado;
    private JButton atenderButton;

    private Hospital hospital;

    public ListaHospitalSanMung() {
        PriorityQueue<Pacientes> colaPrioridad = new PriorityQueue<>();
        hospital = new Hospital(colaPrioridad);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String nombre = txtNombre.getText();
                    int prioridad = Integer.parseInt(txtPrioridad.getText());
                    if (nombre.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Ingrese el nombre del paciente.");
                        return;
                    }
                    Pacientes pacientes = new Pacientes(nombre, prioridad);
                    hospital.encolar(pacientes);
                    txtResultado.setText(hospital.verLista());
                    txtNombre.setText("");
                    txtPrioridad.setText("");
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "La prioridad debe ser un número entero.");
                }
            }
        });
        atenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Se atiende al paciente
                    Pacientes atendido = hospital.atender();

                    // Verificamos de pacientes
                    if (atendido == null) {
                        JOptionPane.showMessageDialog(null, "No hay pacientes que atender.");
                    } else {
                        // SE MUESTRA AL PACIENTE ATENDIDO
                        txtResultado.setText(atendido.getNombre() + " ha sido atendido (Prioridad " + atendido.getPrioridad() + ").\n");
                        //Se muestra la nueva lista de pacientes para atender
                        txtResultado.append( hospital.verLista());
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No hay pacientes que atender.");
                }
            }
        });


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ListaHospitalSanMung");
        frame.setContentPane(new ListaHospitalSanMung().PanelGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
