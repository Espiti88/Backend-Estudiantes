package co.edu.unisabana.SIGA;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {
    List<Estudiante> estudiantes;
    int idRegistro = 1;
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
    public String saludar() {
        return "Servidor de Estudiantes DANIEL SAAVEDRA";
    }
    //http://localhost:8080/

    @GetMapping(path = "/estudiante/todos")
    public List<Estudiante> allEstudiantes(){
        return estudiantes;
    }
    //http://localhost:8080/estudiante

    @RequestMapping(value = "/estudiante/buscar", params = "facultad")
    public List<Estudiante> buscarFacultad(@RequestParam String facultad){
        return estudiantes.stream().filter((estudiante) -> estudiante.getFacultad().equals(facultad)).collect(Collectors.toList());
    }
    //http://localhost:8080/estudiante?facultad=

    @PostMapping(path = "/estudiante/crear")
    public String crearEstudiante(@RequestBody Estudiante estudiante){
        for(Estudiante estudianteX: estudiantes){
            if(estudianteX.getId() >= idRegistro){
                idRegistro += 1;
            }
        }
        estudiante.setId(idRegistro);
        idRegistro += 1;
        estudiantes.add(estudiante);
        return "¡Estudiante guardado!";
    }
    //http://localhost:8080/estudiante/crear
    //POSTMAN:
    //{
    //    "nombre": "Sandra",
    //    "semestre": 3,
    //    "facultad": "Medicina"
    //}

    @PutMapping(path = "/estudiante/actualizar/{codigo}")
    public String actualizarEstudiante(@PathVariable("codigo") int codigo, @RequestBody Estudiante estudiante){
        for(Estudiante estudiante1: estudiantes){
            if(estudiante1.getId() == codigo){
                estudiantes.remove(estudiante1);
                estudiantes.add(estudiante);
                return "¡Estudiante modificado!";
            }
        }
        return "¡No se encontró el estudiante!";
    }
    //http://localhost:8080/estudiante/actualizar/n
    //POSTMAN:
    //{
    //    "id": newId,
    //    "nombre": "Sandra",
    //    "semestre": 3,
    //    "facultad": "Medicina"
    //}

    @DeleteMapping(path = "/estudiante/eliminar/{id}")
    public ResponseEntity<String> eliminarEstudiante(@PathVariable int id) {
        Estudiante EliminacionEstudiante = null;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                EliminacionEstudiante = estudiante;
                break;
            }
        }
        if (EliminacionEstudiante != null) {
            estudiantes.remove(EliminacionEstudiante);
            return new ResponseEntity<>("¡Estudiante eliminado!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("¡No se encontró el estudiante!", HttpStatus.NOT_FOUND);
        }
    }
    //http://localhost:8080/estudiante/eliminar/n
}