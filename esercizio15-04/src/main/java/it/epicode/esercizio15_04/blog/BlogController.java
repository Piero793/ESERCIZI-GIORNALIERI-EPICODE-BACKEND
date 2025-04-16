package it.epicode.esercizio15_04.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Blog> findAll() {
        return blogService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Blog findById(@PathVariable Long id) {
        return blogService.findById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Blog create(@RequestBody Blog blog) {
        return blogService.create(blog);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Blog update(@PathVariable Long id,@RequestBody Blog blog) {
        return blogService.update(id, blog);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        blogService.delete(id);
    }
}
