package co.edu.unisabana.SIGA;
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
        estudiantes.add(new Estudiante(4, "Valentina", 3, "Ingeniería"));
        estudiantes.add(new Estudiante(5, "Manuela", 3, "Ingeniería"));
        estudiantes.add(new Estudiante(6, "Diana", 3, "Medicina"));
        estudiantes.add(new Estudiante(7, "María Fernanda", 3, "EICEA"));
        estudiantes.add(new Estudiante(8, "Mateo", 3, "Medicina"));
        estudiantes.add(new Estudiante(9, "Pavel", 3, "Comunicación"));
        estudiantes.add(new Estudiante(10, "Turry", 3, "Comunicación"));
    }

    @GetMapping(path = "/")
    public String saludar() {
        return "Servidor de Estudiantes DANIEL SAAVEDRA";
    }
    //http://localhost:8080/

    @GetMapping(path = "/estudiantes/todos")
    public List<Estudiante> allEstudiantes(){
        return estudiantes;
    }
    //http://localhost:8080/estudiantes

    @RequestMapping(value = "/estudiantes/buscar", params = "facultad")
    public List<Estudiante> buscarFacultad(@RequestParam String facultad){
        return estudiantes.stream().filter((estudiante) -> estudiante.getFacultad().equals(facultad)).collect(Collectors.toList());
    }
    //http://localhost:8080/estudiantes?facultad=

    @PostMapping(path = "/estudiantes/crear")
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
}
