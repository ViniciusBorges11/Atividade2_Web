package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import model.Curso;
import repository.CursoRepository;



@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Curso cadastrar(@RequestBody Curso cliente) {
        return cursoRepository.save(cliente);
    }


    @GetMapping
    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Curso buscarPorId(@PathVariable Long id) {
        var cursoOptional = cursoRepository.findById(id);
        if (cursoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return cursoOptional.get();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirPorId(@PathVariable Long id) {
        var cursoOptional = cursoRepository.findById(id);
        if (cursoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        cursoRepository.delete(cursoOptional.get());
    }


    @PutMapping("/{id}")
    public Curso atualizarPorId(@PathVariable Long id, @RequestBody Curso curso) {
        var cursoOptional = cursoRepository.findById(id);
        if (cursoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        curso.setId(id);
        return cursoRepository.save(curso);
    }
   

    @GetMapping("/{professor}")
    public Curso buscarPorIdProfessor(@PathVariable Long professor) {
        var cursoOptional = cursoRepository.findById(professor);
        if (cursoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return cursoOptional.get();
    }

}
