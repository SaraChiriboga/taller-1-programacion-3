import javax.swing.*;

public class TorneoBudokai {
    public Nodo frente;
    public Nodo finalCola;
    public int tamaño;

    //aqui seteamos el tamaño inicial, el frente y final vacío
    public TorneoBudokai (){
        frente = null;
        finalCola = null;
        tamaño = 0;
    }
    //luego implementamos el metodo para encolar

    public void encolar(String dato, JTextArea textArea){
        Nodo nuevoNodo = new Nodo(dato);

        if(estaVacia()){
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else{
            finalCola.siguiente=nuevoNodo;
            finalCola = nuevoNodo;
        }
        tamaño++;
        actualizarTextArea(textArea);
    }
    //metodo para desencolar
    public String desencolar(JTextArea textArea) {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La lista de peleadores esta vacía ");
            return null;
        }
        String dato = frente.dato;
        frente = frente.siguiente;
        tamaño--;
        if (frente == null) {
            finalCola = null;
        }
        actualizarTextArea(textArea);
        return dato;
    }

    //necesitamos un metodo para comprobar que la cola esta vacia

    public boolean estaVacia(){
        return frente == null;
    }

    //metodo para poder mostrar la cola en el JTEXTAREA

    public void mostrarCola(JTextArea textArea){
        if (estaVacia()){
            textArea.setText("La lista de peleadores está vacía ");
        } else {
            StringBuilder colaStr = new StringBuilder();
            Nodo actual = frente;
            while(actual != null){
                colaStr.append(actual.dato).append("\n");
                actual = actual.siguiente;
            }
            textArea.setText(colaStr.toString());

        }
    }

    //metodo para actualizar el JtextArea cada vez que cambiamos la cola

    private void actualizarTextArea (JTextArea textArea){
        mostrarCola(textArea);
    }
}