import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cola {
    Queue<Esfera> esferas = new LinkedList<>();

    //metodos
    public void agregarEsfera(JTextField num, JTextField lugar, JTextArea encontrados){
        Esfera encontrada = new Esfera(Integer.parseInt(num.getText()), lugar.getText());
        esferas.add(encontrada);

        StringBuilder str = new StringBuilder();
        str.append(encontrados.getText())
                .append(String.valueOf("Esfera #" + encontrada.getEsfera()) + " encontrada en ")
                .append(encontrada.getLugar()).append("\n");

        encontrados.setText(str.toString());
    }

    public void limpiar(JTextArea encontrados){
        encontrados.setText("");
        esferas.clear();
    }

    public void invocar(JTextArea resultado) {
        List<Integer> numeros = new ArrayList<>();
        for (Esfera i : esferas) {
            numeros.add(i.getEsfera());
        }

        if (esferas.size() == 7) {
            boolean sherlong = true;
            for (int j = 1; j <= 7; j++) { // <- corregido: de 1 a 7
                if (!numeros.contains(j)) {
                    sherlong = false;
                    break;
                }
            }

            if (sherlong) {
                resultado.setText("Sherlong acaba de ser invocado!\n🟡 Las 7 Esferas han sido reunidas 🐉\n✨ ¡Pide tu deseo!");
            } else {
                JOptionPane.showMessageDialog(null, "Aún no puedes invocar a Sherlong!");
                limpiar(resultado);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Aún no puedes invocar a Sherlong!");
            limpiar(resultado);
        }
    }
}
