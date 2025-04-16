import javax.swing.*;
import java.util.Stack;

public class Nave {
    public Stack<Integer> alianzaRebelde = new Stack<>();

    public void invNaves(JTextField input, JTextArea output){
        String naves = input.getText();
        String[] sep = naves.split(" ");

        for (int i = 0; i < sep.length; i++){
            alianzaRebelde.push(Integer.parseInt(sep[i]));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = alianzaRebelde.size() - 1; i > -1 ; i--){
            sb.append(alianzaRebelde.get(i)).append("\n");
        }

        output.setText(sb.toString());
    }

    public void clear(JTextArea output){
        output.setText("");
        alianzaRebelde.clear();
    }
}
