package it.epicode.esercizio15_04.blog;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    // metodo per trovare tutti i blog
    public List<Blog> findAll() {
        if (blogRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Nessun blog trovato");
        }
        return blogRepository.findAll();
    }

    // metodo per trovare un blog per id
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Blog non trovato"));
    }

    // metodo per creare un blog
    public Blog create(Blog blog) {
        return blogRepository.save(blog);
    }

    // metodo per modificare un blog
    public Blog update(Long id, Blog blog) {
        Blog blogToUpdate = findById(id);
        blogToUpdate.setCategoria(blog.getCategoria());
        blogToUpdate.setTitolo(blog.getTitolo());
        blogToUpdate.setContenuto(blog.getContenuto());
        blogToUpdate.setTempoDiLettura(blog.getTempoDiLettura());
        return blogRepository.save(blogToUpdate);
    }

    // metodo per eliminare un blog
    public void delete(Long id) {
        Blog blogToDelete = findById(id);
        blogRepository.delete(blogToDelete);
    }
}
