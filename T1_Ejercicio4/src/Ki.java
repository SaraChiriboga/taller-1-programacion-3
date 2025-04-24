import javax.swing.*;
import java.util.Stack;

public class Ki {
    public Stack<String> kiDB = new Stack<>();

    public int verificacion(JTextField input){
        String ki = ""; //vaciar cada que se presiona verificar
        int balance = 0;
        ki = input.getText();
        String[] kis = ki.split("");

        kiDB.clear();
        //agregar a la pila los elemenos de kis
        for (int i = 0; i < kis.length; i++){
            kiDB.push(kis[i].trim());
        }

        int tam = kiDB.size();
        int extremo = tam - 1;

        //verificacion de tamaño (si es par, existe la posibilidad de que este balanceado)
        if (tam % 2 == 0){
            //los extremos deben coincidir para estar balanceado
            for (int j = 0; j < tam; j++){
                if (inversoSimbolo(kiDB.get(j), kiDB.get(extremo)) || j > extremo){
                    balance = 1; //hay balance
                    extremo--;
                }else{
                    balance = 0; //no hay balance
                    break;
                }
            }
        }else{
            balance = 0; //no hay balance si la cantidad de elementos es impar
        }
        return balance;
    }

    public void balanceado(JTextArea result, int verif){
        if (verif == 1){
            result.setText("Balanceado!");
        }else {
            result.setText("Desbalanceado!");
        }
    }

    public boolean inversoSimbolo(String simb1, String simb2){
        boolean respuesta = false;
        if (simb1.equals("{")){
            if (simb2.equals("}")){
                respuesta = true;
            }else {
                respuesta = false;
            }
        } else if (simb1.equals("(")) {
            if (simb2.equals(")")){
                respuesta = true;
            }else {
                respuesta = false;
            }
        }else if (simb1.equals("[")) {
            if (simb2.equals("]")) {
                respuesta = true;
            } else {
                respuesta = false;
            }
        } else {
            respuesta = false;
        }
        return respuesta;
    }



}
