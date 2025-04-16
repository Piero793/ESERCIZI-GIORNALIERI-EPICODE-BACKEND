package it.epicode.esercizio15_04.blog;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/blogPosts")
public class BlogController {

    @Autowired
    private BlogService blogService;

    // Trova tutti i blog con paginazione
    @GetMapping("/all")
    public ResponseEntity<Page<Blog>> findAll(@ParameterObject Pageable pageable) {
        Page<Blog> blogs = blogService.findAll(pageable);
        return ResponseEntity.ok(blogs);
    }

    // Trova un blog per ID
    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        return ResponseEntity.ok(blog);
    }

    // Crea un nuovo blog
    @PostMapping("/create")
    public ResponseEntity<Blog> create(@RequestBody BlogRequest blogRequest) {
        Blog blog = blogService.create(blogRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(blog);
    }

    // Modifica un blog esistente
    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> update(@PathVariable Long id, @RequestBody Blog blog) {
        Blog updatedBlog = blogService.update(id, blog);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedBlog);
    }

    // Elimina un blog per ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        blogService.delete(id);
        return ResponseEntity.noContent().build();
    }
}