package it.epicode.esercizio15_04.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/blogPosts")
    @ResponseStatus(HttpStatus.OK)
    public List<Blog> findAll() {
        return blogService.findAll();
    }

    @GetMapping("/blogPosts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Blog findById(Long id) {
        return blogService.findById(id);
    }

    @PostMapping("/blogPosts")
    @ResponseStatus(HttpStatus.CREATED)
    public Blog create(@RequestBody Blog blog) {
        return blogService.create(blog);
    }

    @PutMapping("/blogPosts/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Blog update(Long id, Blog blog) {
        return blogService.update(id, blog);
    }

    @DeleteMapping("/blogPosts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id) {
        blogService.delete(id);
    }
}
