package it.epicode.esercizio15_04.autori;

import it.epicode.esercizio15_04.email.EmailService;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AutoreService {

    @Autowired
    private AutoreRepository autoreRepository;

    @Autowired
    private EmailService emailService;

    public Page<Autore> findAll(Pageable pageable) {
        Page<Autore> autori = autoreRepository.findAll(pageable);
        if (autori.isEmpty()) {
            throw new EntityNotFoundException("Nessun autore trovato");
        }
        return autori;
    }

    public Autore findById(Long id) {
        return autoreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Autore non trovato"));
    }

    public Autore create(Autore autore) throws MessagingException {
        Autore savedAutore = autoreRepository.save(autore);

        // Invio email di conferma

            String subject = "Conferma registrazione autore";
            String body = "Ciao " + autore.getNome() + ",\n\n"
                    + "Il tuo account autore è stato creato con successo!\n\n"
                    + "Benvenuto nella piattaforma!";

            emailService.sendEmail(autore.getEmail(), subject, body);

        return savedAutore;
    }

    public Autore update(Long id, Autore autore) {
        Autore autoreToUpdate = findById(id);
        autoreToUpdate.setNome(autore.getNome());
        autoreToUpdate.setCognome(autore.getCognome());
        autoreToUpdate.setEmail(autore.getEmail());
        autoreToUpdate.setDataDiNascita(autore.getDataDiNascita());
        return autoreRepository.save(autoreToUpdate);
    }

    public void delete(Long id) {
        Autore autoreToDelete = findById(id);
        autoreRepository.delete(autoreToDelete);
    }
}
