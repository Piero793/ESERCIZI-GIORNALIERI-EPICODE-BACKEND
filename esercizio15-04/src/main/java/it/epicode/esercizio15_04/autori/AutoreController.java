package it.epicode.esercizio15_04.autori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutoreController {
    @Autowired
    private AutoreService autoriService;

    @GetMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public List<Autore> findAll() {
        return autoriService.findAll();
    }

    @GetMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Autore findById(Long id) {
        return autoriService.findById(id);
    }

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Autore create(Autore autore) {
        return autoriService.create(autore);
    }

    @PutMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Autore update(Long id, Autore autore) {
        return autoriService.update(id, autore);
    }

    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id) {
        autoriService.delete(id);
    }
}
