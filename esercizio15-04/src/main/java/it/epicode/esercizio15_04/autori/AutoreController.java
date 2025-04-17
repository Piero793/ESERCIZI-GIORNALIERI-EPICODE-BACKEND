package it.epicode.esercizio15_04.autori;

import jakarta.mail.MessagingException;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Page<Autore> findAll(@ParameterObject Pageable pageable) {
        return autoreService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Autore> findById(@PathVariable Long id) {
        Autore autore = autoreService.findById(id);
        return ResponseEntity.ok(autore);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> create(@RequestBody Autore autore) throws MessagingException {
        autoreService.create(autore);
        return ResponseEntity.status(HttpStatus.CREATED).body("Autore creato con successo! Email di conferma inviata.");
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Autore> update(@PathVariable Long id, @RequestBody Autore autore) {
        Autore updatedAutore = autoreService.update(id, autore);
        return ResponseEntity.ok(updatedAutore);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> delete(@PathVariable Long id) {
        autoreService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Autore eliminato con successo.");
    }
}