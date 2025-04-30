import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class torneoBudokaiGUI {
    private JTextField textField1;
    private JButton encolar;
    private JSpinner spinner1;
    private JTextArea textAreaNum;
    private JPanel pGeneral;
    private JPanel panelPeleadores;
    private JButton iniciarTorneoButton;
    TorneoBudokai cola=new TorneoBudokai();
    private ArrayList<JTextField> textoPeleadores = new ArrayList<>();


    private void camposPeleadores(int cantidad) {
        panelPeleadores.setLayout(new BoxLayout(panelPeleadores, BoxLayout.Y_AXIS));

        for (int i = 0; i < cantidad; i++) {
            JTextField field = new JTextField("Peleador " + (i + 1));
            textoPeleadores.add(field);
            panelPeleadores.add(field);
        }

        cola.mostrarCola(textAreaNum);
    }
    public torneoBudokaiGUI() {
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        encolar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField1.getText().trim(); // Utilizamos esto para obtener lo que aparece en el text field
                boolean added = false;


                if (!input.isEmpty()) {
                    try {
                        int valor = Integer.parseInt(input);
                        cola.encolar(String.valueOf(valor), textAreaNum);
                        textField1.setText(""); //Limpiamos el text field
                        camposPeleadores(valor);
                        added = true;
                    } catch (NumberFormatException ex) {
                        // Si es que no se pone un número válido en el campo de texto, mostramos un Message Dialog diciendole al usuario que no se puso un número valido.
                        JOptionPane.showMessageDialog(null, "El campo de texto no contiene un número válido.");
                    }
                }

                // Utilizamos esto en caso de que se use el valor del spinner en el UI.
                if (!added) {
                    try {
                        int valorSpinner = (Integer) spinner1.getValue();
                        if (valorSpinner != 0) {
                            cola.encolar(String.valueOf(String.valueOf(valorSpinner)), textAreaNum);
                            spinner1.setValue(0);
                            camposPeleadores(valorSpinner);
                            added = true;
                        }
                    } catch (Exception ex) {//Try y Catch para posibles errores utilizando el spinner
                        JOptionPane.showMessageDialog(null, "Error al leer el valor del spinner.");
                    }
                }

                // Si es que nada se ingresa aun, muestra otro message dialog 
                if (!added) {
                    JOptionPane.showMessageDialog(null, "No se detectó ningún número para añadir. Usa el campo de texto o el spinner.");
                }
            }
        });

        textAreaNum.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
        //Leí que si utilizamos changelistener, se va a poder utilizar el spinner para que funcione con el boton
        //cuando hago click derecho en el spinner no me da la opcion de utilizar un action listener
        spinner1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

            }
        });
        iniciarTorneoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder resultado = new StringBuilder();
                for (JTextField field : textoPeleadores) {
                    String nombre = field.getText().trim();
                    if (!nombre.isEmpty()) {
                        cola.encolar(nombre, textAreaNum);
                        resultado.append(nombre).append(" ha sido llamado a pelear\n");
                    }
                }
                textAreaNum.setText(resultado.toString());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("torneoBudokaiGUI");
        frame.setContentPane(new torneoBudokaiGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
