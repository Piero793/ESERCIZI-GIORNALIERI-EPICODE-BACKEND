package it.epicode.esercizio15_04.blog;

import it.epicode.esercizio15_04.common.FackerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BlogRunner implements CommandLineRunner {
    @Autowired
    private BlogService blogService;
    @Autowired
    private FackerConfig fakerService;
    @Override
    public void run(String... args) throws Exception {

        // creazione di 10 blog
        for (int i = 0; i < 10; i++) {
            Blog blog = new Blog();
            blog.setCategoria(fakerService.faker().book().genre());
            blog.setTitolo(fakerService.faker().book().title());
            blog.setContenuto(fakerService.faker().lorem().paragraph());
            blog.setTempoDiLettura(fakerService.faker().number().numberBetween(1, 10));
            blogService.create(blog);
        }
    }
}
