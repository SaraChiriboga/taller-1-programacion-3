import javax.swing.*;
import java.util.PriorityQueue;

public class Hospital {
    private PriorityQueue<Pacientes> atenderPacientes;//declaración de la lista de prioridad

    public Hospital(PriorityQueue<Pacientes> atenderPacientes) {//Constructor
        this.atenderPacientes = atenderPacientes;
    }

    public void encolar(Pacientes dato){//Metodo para agregar pacientes a la lista
        atenderPacientes.add(dato);
    }

    public Pacientes atender() throws Exception {
        if (atenderPacientes.isEmpty()){//Verificación de la lista si está vacia
            throw new Exception("No hay pacientes que atender! :)");
        }
        return atenderPacientes.poll();//se remueve el paciente que se atendio

    }
    //Funcion para ver la lista
    public String verLista() {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pacientes> copia = new PriorityQueue<>(atenderPacientes); // copia de la cola

        while (!copia.isEmpty()) {
            Pacientes p = copia.poll(); // saca en orden de prioridad
            sb.append(p.getNombre())
                    .append(" (Prioridad ")
                    .append(p.getPrioridad())
                    .append(")\n");
        }

        return sb.toString();
    }


}
