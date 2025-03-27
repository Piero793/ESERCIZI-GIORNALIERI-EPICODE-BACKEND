package it.epicode.classi;

import it.epicode.enums.Sesso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "persone")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 50)
    private String nome;

    @Column(length = 50)
    private String cognome;

    @Column(length = 100)
    private String email;

    @Column
    private LocalDate dataDiNascita;

    @Enumerated(EnumType.STRING)
    @Column
    private Sesso sesso;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Partecipazione> partecipazioni;


}

