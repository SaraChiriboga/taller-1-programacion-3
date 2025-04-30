public class Pacientes implements Comparable<Pacientes> {
    public String nombre;//Nombre de los pacientes
    public int prioridad; //Prioridad de los pacientes, mientras sea menor el número mayor será su prioridad
//Constructor
    public Pacientes(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }
//Getters
    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }
//Comparación de datos
    @Override
    public int compareTo(Pacientes o) {
        return Integer.compare(this.prioridad, o.prioridad);
    }
}
