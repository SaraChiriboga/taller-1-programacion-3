import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EsferasGUI {
    private JPanel pGeneral;
    private JTextField txtNum;
    private JTextField txtLugar;
    private JButton agregarButton;
    private JButton limpiarButton;
    private JButton invocarButton;
    private JTextArea txtResultado;

    Cola esferasDelDragon = new Cola();

    public EsferasGUI() {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                esferasDelDragon.agregarEsfera(txtNum, txtLugar, txtResultado);
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                esferasDelDragon.limpiar(txtResultado);
            }
        });
        invocarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                esferasDelDragon.invocar(txtResultado);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cola de Esferas encontradas");
        frame.setContentPane(new EsferasGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
