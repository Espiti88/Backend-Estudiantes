package co.edu.unisabana.SIGA;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    List<Estudiante> estudiantes = new ArrayList<>();

    @GetMapping(path = "/")
    public String saludar() {
        return "Servidor de Estudiantes";
    }

    @GetMapping(path = "/estudiante/todos")
    public List<Estudiante> allEstudiantes(){
        return estudiantes;
    }

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

    @PostMapping(path = "/estudiante/crear")
    public Respuesta crearEstudiante(@RequestBody Estudiante estudiante){
        estudiantes.add(estudiante);
        return new Respuesta("Estudiante agregado correctamente");
    }

    @PutMapping(path = "/estudiante/actualizar/{codigo}")
    public String actualizarEstudiante(@PathVariable("codigo") int codigo, @RequestBody Estudiante estudiante){
        for(Estudiante elEstudiante: estudiantes){
            if(elEstudiante.getId() == codigo){
                elEstudiante.setId(estudiante.getId());
                elEstudiante.setNombre(estudiante.getNombre());
                elEstudiante.setFacultad(estudiante.getFacultad());
                elEstudiante.setSemestre(estudiante.getSemestre());

                return "¡Estudiante modificado!";
            }
        }
        return "¡No se encontró el estudiante!";
    }

    @DeleteMapping(path = "/estudiante/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable int id) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                estudiantes.remove(estudiante);
                return "¡Estudiante eliminado!";
            }
        }
        return "¡No se encontró el estudiante!";
    }
}