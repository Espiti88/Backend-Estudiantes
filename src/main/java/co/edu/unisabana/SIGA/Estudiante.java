package co.edu.unisabana.SIGA;

public class Estudiante {
    private int id;
    private String nombre;
    private int semestre;
    private String facultad;
    private String programa;

    public Estudiante()
    {
        super();
    }

    public Estudiante(String nombre, int semestre, String facultad, String programa) {
        this.nombre = nombre;
        this.semestre = semestre;
        this.facultad = facultad;
        this.programa = programa;
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

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }
}
