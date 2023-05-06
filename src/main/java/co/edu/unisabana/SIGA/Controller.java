package co.edu.unisabana.SIGA;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {
    List<Estudiante> estudiantes;
    public Controller (){
        this.estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante(1, "Carlos Andrés", 3, "Ingeniería"));
        estudiantes.add(new Estudiante(2, "Juan José", 3, "Medicina"));
        estudiantes.add(new Estudiante(3, "Laura Sofía", 3, "EICEA"));
    }

    @GetMapping(path = "/")
    public String saludar() {
        return "Servidor de Estudiantes DANIEL SAAVEDRA";
    }
    //http://localhost:8080/

    @GetMapping(path = "/estudiantes")
    public List<Estudiante> allEstudiantes(){
        return estudiantes;
    }
    //http://localhost:8080/estudiantes

    @RequestMapping(value = "/estudiantes", params = "facultad")
    public List<Estudiante> buscarFacultad(@RequestParam String facultad){
        return estudiantes.stream().filter((estudiante) -> estudiante.getFacultad().equals(facultad)).collect(Collectors.toList());
    }
    //http://localhost:8080/estudiantes?facultad=
}
