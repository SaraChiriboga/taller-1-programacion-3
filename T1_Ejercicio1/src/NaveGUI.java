import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NaveGUI {
    private JTextField txtNaves;
    private JButton invertirButton;
    private JTextArea txtInvertido;
    private JButton limpiarButton;
    private JPanel GUIAlianzaRebelde;

    Nave alianzarebelde = new Nave();

    public NaveGUI() {
        invertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alianzarebelde.invNaves(txtNaves, txtInvertido);
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alianzarebelde.clear(txtInvertido);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("NaveGUI");
        frame.setContentPane(new NaveGUI().GUIAlianzaRebelde);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
