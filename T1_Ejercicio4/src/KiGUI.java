import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KiGUI {
    private JTextField txtEntradaKI;
    private JPanel KiGUI;
    private JButton verificarButton;
    private JTextArea txtResult;

    Ki ki = new Ki();

    public KiGUI() {
        verificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int balance = ki.verificacion(txtEntradaKI);
                ki.balanceado(txtResult, balance);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("KiGUI");
        frame.setContentPane(new KiGUI().KiGUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
