package it.epicode.esercizio15_04.blog;

import it.epicode.esercizio15_04.autori.Autore;
import it.epicode.esercizio15_04.autori.AutoreRepository;
import it.epicode.esercizio15_04.autori.AutoreService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private AutoreRepository autoreRepository;

    // Trova tutti i blog con paginazione
    public Page<Blog> findAll(Pageable pageable) {
        Page<Blog> blogs = blogRepository.findAll(pageable);
        if (blogs.isEmpty()) {
            throw new EntityNotFoundException("Nessun blog trovato");
        }
        return blogs;
    }

    // Trova un blog per ID
    public Blog findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Blog non trovato con ID: " + id));
    }

    // Crea un blog partendo dall'entità direttamente
    public Blog create(Blog blog) {
        return blogRepository.save(blog);
    }

    // Crea un blog partendo da BlogRequest (DTO)
    public Blog create(BlogRequest blogRequest) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogRequest, blog);

        // Recupera l'autore dal repository
        Autore autore = autoreRepository.findById(blogRequest.getAutoreId())
                .orElseThrow(() -> new EntityNotFoundException("Autore non trovato con ID: " + blogRequest.getAutoreId()));

        blog.setAutore(autore);
        return blogRepository.save(blog);
    }

    // Modifica un blog esistente
    public Blog update(Long id, Blog blog) {
        Blog blogToUpdate = findById(id);
        BeanUtils.copyProperties(blog, blogToUpdate, "id", "autore");
        return blogRepository.save(blogToUpdate);
    }

    // Elimina un blog per ID
    public void delete(Long id) {
        Blog blogToDelete = findById(id);
        blogRepository.delete(blogToDelete);
    }
}