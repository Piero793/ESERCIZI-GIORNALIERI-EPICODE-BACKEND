package it.epicode.classi;

import it.epicode.enums.Stato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "partecipazioni")
public class Partecipazione  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Evento evento;

    @Enumerated(EnumType.STRING)
    @Column
    private Stato stato;


}

