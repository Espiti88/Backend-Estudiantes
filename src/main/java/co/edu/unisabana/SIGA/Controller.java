package co.edu.unisabana.SIGA;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    List<Estudiante> estudiantes;
    int idRegistro = 1000;

    public Controller (){
        this.estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante(1, "Carlos Andrés", 3, "Ingeniería"));
        estudiantes.add(new Estudiante(2, "Juan José", 3, "Medicina"));
        estudiantes.add(new Estudiante(3, "Laura Sofía", 3, "EICEA"));
        estudiantes.add(new Estudiante(4, "Valentina", 3, "Comunicación"));
        estudiantes.add(new Estudiante(5, "Manuela", 3, "Ingeniería"));
        estudiantes.add(new Estudiante(6, "Diana", 3, "Medicina"));
        estudiantes.add(new Estudiante(7, "María Fernanda", 3, "EICEA"));
        estudiantes.add(new Estudiante(8, "Mateo", 3, "Comunicación"));
        estudiantes.add(new Estudiante(9, "Pavel", 3, "Ingeniería"));
        estudiantes.add(new Estudiante(10, "Turry", 3, "Medicina"));
    }

    @GetMapping(path = "/")
    public Respuesta saludar() {
        return new Respuesta("Servidor de Estudiantes DANIEL SAAVEDRA");
    }
    //http://localhost:8080/

    @GetMapping(path = "/estudiante/todos")
    public List<Estudiante> allEstudiantes(){
        return estudiantes;
    }
    //http://localhost:8080/estudiante/todos

    @GetMapping(path = "/estudiante/buscar")
    public List<Estudiante> buscarPorFacultad (@RequestParam String facultad, @RequestParam int size){
        List<Estudiante> BuscarFacultad = new ArrayList<>(size);
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getFacultad().equals(facultad)) {
                BuscarFacultad.add(estudiante);
            }
            if(BuscarFacultad.size() == size){
                break;
            }
        }
        return BuscarFacultad;
    }
    //http://localhost:8080/estudiante/buscar?facultad=Medicina&size=5

    @PostMapping(path = "/estudiante/crear")
    public Respuesta crearEstudiante(@RequestBody Estudiante estudiante){
        for(Estudiante estudianteX: estudiantes){
            if(estudianteX.getId() >= idRegistro){
                idRegistro += 1;
            }
        }
        estudiante.setId(idRegistro);
        idRegistro += 1;
        estudiantes.add(estudiante);
        return new Respuesta("¡Estudiante agregado!");
    }
    /*http://localhost:8080/estudiante/crear
    POSTMAN:
    {
        "nombre": "Sandra",
        "semestre": 3,
        "facultad": "Medicina"
    }*/

    @PutMapping(path = "/estudiante/actualizar/{codigo}")
    public Respuesta actualizarEstudiante(@PathVariable("codigo") int codigo, @RequestBody Estudiante estudiante){
        for(Estudiante estudiante1: estudiantes){
            if(estudiante1.getId() == codigo){
                estudiantes.remove(estudiante1);
                estudiantes.add(estudiante);
                return new Respuesta("¡Estudiante modificado!");
            }
        }
        return new Respuesta ("¡No se encontró el estudiante!");
    }
    /*http://localhost:8080/estudiante/actualizar/n
    POSTMAN:
    {
        "id": newId,
        "nombre": "Sandra",
        "semestre": 3,
        "facultad": "Medicina"
    }*/

    @DeleteMapping(path = "/estudiante/eliminar/{id}")
    public Respuesta eliminarEstudiante(@PathVariable int id) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                estudiantes.remove(estudiante);
                return new Respuesta("¡Estudiante eliminado!");
            }
        }
        return new Respuesta("¡No se encontró el estudiante!");
    }
    //http://localhost:8080/estudiante/eliminar/n
}