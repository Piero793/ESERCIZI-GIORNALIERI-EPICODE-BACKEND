package it.epicode.esercizio15_04.autori;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AutoreController {
    @Autowired
    private AutoreService autoriService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Page<Autore> findAll(@ParameterObject Pageable pageable) {
        return autoriService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Autore findById(@PathVariable Long id) {
        return autoriService.findById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Autore create(@RequestBody Autore autore) {
        return autoriService.create(autore);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Autore update(@PathVariable Long id,@RequestBody Autore autore) {
        return autoriService.update(id, autore);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        autoriService.delete(id);
    }
}
