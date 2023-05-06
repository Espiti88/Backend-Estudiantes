package co.edu.unisabana.SIGA;

public class Estudiante {
    private int id;
    private String nombre;
    private int semestre;
    private String facultad;

    public Estudiante(int id, String nombre, int semestre, String facultad) {
        this.id = id;
        this.nombre = nombre;
        this.semestre = semestre;
        this.facultad = facultad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", semestre=" + semestre +
                ", facultad='" + facultad + '\'' +
                '}';
    }
}
