package co.edu.unisabana.SIGA;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class Controller {
    List<Estudiante> estudiantes;
    public Controller (){
        this.estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante(1, "Carlos", 3, "Ingeniería"));
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
}
